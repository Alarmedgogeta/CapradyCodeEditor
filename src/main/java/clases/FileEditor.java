package clases;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.StyledDocument;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

/**
 *
 * @author Alan Diaz Yañez
 */
public class FileEditor extends JScrollPane {

    private final JTextPane txtPane;
    private final TextLineNumber lineNum;
    private File file;
    public boolean isSaved = false;
    public boolean isSearched;
    private PrintWriter writer;
    private String strSearch;
    private int currentMatchIndex = -1;
    private int[] matchesIndexes;
    private final Highlighter hilit = new DefaultHighlighter();
    private final Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.ORANGE);
    private StyledDocument doc;

    //undo helpers
    protected UndoAction undoAction;
    protected RedoAction redoAction;
    protected UndoManager undo = new UndoManager();

    public FileEditor() {
        super(new JTextPane(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        txtPane = (JTextPane) getViewport().getComponent(0);
        lineNum = new TextLineNumber(txtPane);
        setRowHeaderView(lineNum);
        isSaved = false;
        initComponents();
    }

    public FileEditor(File file) {
        super(new JTextPane(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        txtPane = (JTextPane) getViewport().getComponent(0);
        lineNum = new TextLineNumber(txtPane);
        setRowHeaderView(lineNum);

        this.file = file;

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
            doc = txtPane.getStyledDocument();
            String lineText = reader.readLine();
            while (lineText != null) {
                doc.insertString(doc.getLength(), lineText + "\n", null);
                lineText = reader.readLine();
            }
            isSaved = true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileEditor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileEditor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadLocationException ex) {
            Logger.getLogger(FileEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
    }

    private void initComponents() {
        txtPane.setHighlighter(hilit);
        txtPane.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent arg0) {
                isSaved = false;
            }

            @Override
            public void keyPressed(KeyEvent arg0) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent arg0) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                if (strSearch != null) {
                    reSearch();
                }
            }
        });
        undoAction = new UndoAction();
        redoAction = new RedoAction();
        txtPane.getDocument().addUndoableEditListener(undo);
        setPreferredSize(getSize());
    }

    public void save() {
        if (file == null) {
            String filePath = Helper.chooseDirectoryForSaveFile();
            if (filePath != null) {
                this.file = new File(filePath);
            } else {
                return;
            }
        }
        writeTextIntoFile();
    }

    public void saveAs() {
        String newFilePath = Helper.chooseDirectoryForSaveFile();
        if (newFilePath != null) {
            this.file = new File(newFilePath);
        } else {
            return;
        }
        writeTextIntoFile();
    }

    private void writeTextIntoFile() {
        try {
            writer = new PrintWriter(file);
            writer.print(txtPane.getText());
            writer.close();
            isSaved = true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileEditor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteTextSelected() {
        txtPane.replaceSelection("");
    }

    public void selectAllText() {
        txtPane.selectAll();
    }

    public void printFileByPrinter() {
        if (!isSaved) {
            save();
        }
        try {
            //this.file.
            Desktop.getDesktop().print(this.file);
        } catch (IOException ex) {
            Logger.getLogger(FileEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String searchStringInDocument(String strSearch) {
        txtPane.getHighlighter().removeAllHighlights();
        String message;
        if (strSearch.length() > 0) {
            this.strSearch = strSearch;
            isSearched = true;
            String content = txtPane.getText().replaceAll("\n", "");
            int count = (content.length() - content.replaceAll(strSearch, "").length()) / strSearch.length();
            currentMatchIndex = content.indexOf(strSearch);
            if (count > 0) {
                matchesIndexes = new int[count];
                message = "1 de " + count + " coincidencias";
                int nextIndex = currentMatchIndex + strSearch.length();
                matchesIndexes[0] = currentMatchIndex;
                for (int i = 1; i < count; i++) {
                    matchesIndexes[i] = content.indexOf(strSearch, nextIndex);
                    nextIndex = matchesIndexes[i] + strSearch.length();
                }
                currentMatchIndex = 0;
                selectMatchIndex();
            } else {
                matchesIndexes = null;
                message = "0 de 0 coincidencias";
            }
        } else {
            message = "";
        }
        return message;
    }

    public String searchNextStringInDocument() {
        String message;
        if (matchesIndexes == null) {
            message = "0 de 0 coincidencias";
        } else {
            if (currentMatchIndex < (matchesIndexes.length - 1)) {
                currentMatchIndex += 1;
            } else {
                currentMatchIndex = 0;
            }
            selectMatchIndex();
            message = (currentMatchIndex + 1) + " de " + matchesIndexes.length + " coincidencias";
        }
        return message;
    }

    public String searchPrevStringInDocument() {
        String message;
        if (matchesIndexes == null) {
            message = "0 de 0 coincidencias";
        } else {
            if (currentMatchIndex > 0) {
                currentMatchIndex -= 1;
            } else {
                currentMatchIndex = matchesIndexes.length - 1;
            }
            selectMatchIndex();
            message = (currentMatchIndex + 1) + " de " + matchesIndexes.length + " coincidencias";
        }
        return message;
    }

    private void selectMatchIndex() {
        try {
            txtPane.getHighlighter().removeAllHighlights();
            txtPane.getHighlighter().addHighlight(matchesIndexes[currentMatchIndex], matchesIndexes[currentMatchIndex] + strSearch.length(),
                    painter);
        } catch (BadLocationException ex) {
            Logger.getLogger(FileEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String replaceStringInDocument(String strReplace) {
        txtPane.getHighlighter().removeAllHighlights();
        if (!strSearch.equals("") && currentMatchIndex != -1) {
            System.out.println(strReplace);
            txtPane.setSelectionStart(matchesIndexes[currentMatchIndex]);
            txtPane.setSelectionEnd(matchesIndexes[currentMatchIndex] + strSearch.length());
            txtPane.replaceSelection(strReplace);
            //strContenido.replaceFirst("", strReplace);
        }
        return reSearch();

    }

    private String reSearch() {
        String message = "";
        String content = txtPane.getText().replaceAll("\n", "");
        int count = (content.length() - content.replaceAll(strSearch, "").length()) / strSearch.length();
        if (count > 0) {
            matchesIndexes = new int[count];
            if (count == currentMatchIndex) {
                currentMatchIndex = 0;
            }
            message = (currentMatchIndex + 1) + " de " + count + " coincidencias";
            int nextIndex = 0;
            for (int i = 0; i < count; i++) {
                matchesIndexes[i] = content.indexOf(strSearch, nextIndex);
                nextIndex = matchesIndexes[i] + strSearch.length();
            }
            selectMatchIndex();
        } else {
            matchesIndexes = null;
            currentMatchIndex = -1;
            message = "0 de 0 coincidencias";
        }
        return message;
    }

    public void cleanSearch() {
        txtPane.getHighlighter().removeAllHighlights();
        strSearch = null;
        matchesIndexes = null;
        currentMatchIndex = -1;
    }

    public String getFileName() {
        return this.file.getName();
    }

    public String getFilePath() {
        return this.file.getPath();
    }

    public File getFile() {
        return this.file;
    }
//This one listens for edits that can be undone.

    protected class MyUndoableEditListener
            implements UndoableEditListener {

        public void undoableEditHappened(UndoableEditEvent e) {
            //Remember the edit and update the menus.
            undo.addEdit(e.getEdit());
            undoAction.updateUndoState();
            redoAction.updateRedoState();
        }
    }

    class UndoAction extends AbstractAction {

        public UndoAction() {
            super("Undo");
            setEnabled(false);
        }

        public void actionPerformed(ActionEvent e) {
            try {
                undo.undo();
            } catch (CannotUndoException ex) {
                System.out.println("Unable to undo: " + ex);
                ex.printStackTrace();
            }
            updateUndoState();
            redoAction.updateRedoState();
        }

        protected void updateUndoState() {
            if (undo.canUndo()) {
                setEnabled(true);
                putValue(Action.NAME, undo.getUndoPresentationName());
            } else {
                setEnabled(false);
                putValue(Action.NAME, "Undo");
            }
        }
    }

    class RedoAction extends AbstractAction {

        public RedoAction() {
            super("Redo");
            setEnabled(false);
        }

        public void actionPerformed(ActionEvent e) {
            try {
                undo.redo();
            } catch (CannotRedoException ex) {
                System.out.println("Unable to redo: " + ex);
                ex.printStackTrace();
            }
            updateRedoState();
            undoAction.updateUndoState();
        }

        protected void updateRedoState() {
            if (undo.canRedo()) {
                setEnabled(true);
                putValue(Action.NAME, undo.getRedoPresentationName());
            } else {
                setEnabled(false);
                putValue(Action.NAME, "Redo");
            }
        }
    }
}
