package clases;

import editordetexto.Main;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultEditorKit;

/**
 *
 * @author Alan Diaz Yañez
 */
public class Helper {

    private static final String URL_NEXT_IMAGE          = "icons/next-icon.png";
    private static final String URL_PREV_IMAGE          = "icons/prev-icon.png";
    private static final String URL_NEW_FILE_IMAGE      = "icons/new-file-icon.png";
    private static final String URL_OPEN_FILE_IMAGE     = "icons/open-file-icon.png";
    private static final String URL_OPEN_FOLDER_IMAGE   = "icons/open-folder-icon.png";
    private static final String URL_SAVE_IMAGE          = "icons/save-icon.png";
    private static final String URL_SAVE_AS_IMAGE       = "icons/save-as-icon.png";
    private static final String URL_SAVE_ALL_IMAGE      = "icons/save-all-icon.png";
    private static final String URL_PRINT_IMAGE         = "icons/print-icon.png";
    private static final String URL_COPY_IMAGE          = "icons/copy-icon.png";
    private static final String URL_PASTE_IMAGE         = "icons/paste-icon.png";
    private static final String URL_CUT_IMAGE           = "icons/cut-icon.png";
    private static final String URL_RUN_LEXIC_IMAGE     = "icons/run-lexic-icon.png";
    private static final String URL_RUN_SYNTAX_IMAGE    = "icons/run-syntax-icon.png";
    private static final String URL_ROOT_SYNTAX_IMAGE   = "icons/root-syntax-icon.png";
    private static final String URL_MIDDLE_SYNTAX_IMAGE = "icons/middle-syntax-icon.png";
    private static final String URL_FINAL_SYNTAX_IMAGE  = "icons/final-syntax-icon.png";
    
    private static final URI URI_SUPPORT_WEB_PAGE = URI.create("https://alarmedgogeta.github.io/HelpAndSupportForCapradyCodeEditor/");
    //private static final String URL_COPY_IMAGE = "";

    private static final DefaultEditorKit.CopyAction copy = new DefaultEditorKit.CopyAction();
    private static final DefaultEditorKit.PasteAction paste = new DefaultEditorKit.PasteAction();
    private static final DefaultEditorKit.CutAction cut = new DefaultEditorKit.CutAction();

    public static void showAbout() {
        JOptionPane.showMessageDialog(null, "Este proyecto fue realizado por el estudiante Alan Diaz Yañez \n"
                + "de séptimo semestre de la carrera de ingenieria en sistemas \n"
                + "computacionales de la Universidad del Valle de México, para la \n"
                + "materia de Traductores impartida por el profesor \n"
                + "Armando Cruz Curz");
    }
    
    public static void undoAction(ActionEvent e){
        FilesEditorContainer.getInstance().getCurrentFileEditor().undoAction.actionPerformed(e);
    }
    
    public static void redoAction(ActionEvent e){
        FilesEditorContainer.getInstance().getCurrentFileEditor().redoAction.actionPerformed(e);
    }

    public static boolean openSupportWebpage() {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(URI_SUPPORT_WEB_PAGE);
                return true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error cargando la página web de suporte,favor de consultar \n"
                        + URI_SUPPORT_WEB_PAGE.getHost() + URI_SUPPORT_WEB_PAGE.getPath());
            }
        }
        return false;
    }

    public static File searchFile() {
        File f = null;
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Seleccione el archivo que desea abrir");
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            //JOptionPane.showMessageDialog(null, "Archivo seleccionado: " + fc.getSelectedFile().getAbsolutePath());
            f = fc.getSelectedFile();
        }
        return f;
    }

    public static String chooseDirectoryForSaveFile() {
        String dir = null;
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Seleccione el directorio donde desea guardar el archivo");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Solo archivos de texto", "jpg", "gif", "txt");
        fc.setFileFilter(filter);
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            fc.getSelectedFile();
            if (fc.getSelectedFile().exists()) {
                int remplazar = JOptionPane.showConfirmDialog(null, "Archivo ya existente, desea remplazarlo?");
                switch (remplazar) {
                    case 0:
                        //Si
                        dir = fc.getSelectedFile().getAbsolutePath();
                        break;
                    case 1:
                        //No
                        dir = chooseDirectoryForSaveFile();
                        break;
                    case 2:
                        //Cancelar
                        break;
                    default:
                        break;
                }
            } else {
                if (!fc.getSelectedFile().getName().endsWith(".txt")) {
                    fc.setSelectedFile(new File(fc.getSelectedFile().getAbsolutePath() + ".txt"));
                }
                dir = fc.getSelectedFile().getAbsolutePath();
                try {
                    fc.getSelectedFile().createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(FileEditor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return dir;
    }

    public static ImageIcon getNextIcon() {
        return new ImageIcon(Main.class.getClassLoader().getResource(URL_NEXT_IMAGE));
    }

    public static ImageIcon getPrevIcon() {
        return new ImageIcon(Main.class.getClassLoader().getResource(URL_PREV_IMAGE));
    }

    public static ImageIcon getNewFileIcon() {
        return new ImageIcon(Main.class.getClassLoader().getResource(URL_NEW_FILE_IMAGE));
    }

    public static ImageIcon getOpenFileIcon() {
        return new ImageIcon(Main.class.getClassLoader().getResource(URL_OPEN_FILE_IMAGE));
    }

    public static ImageIcon getOpenFolderIcon() {
        return new ImageIcon(Main.class.getClassLoader().getResource(URL_OPEN_FOLDER_IMAGE));
    }

    public static ImageIcon getSaveIcon() {
        return new ImageIcon(Main.class.getClassLoader().getResource(URL_SAVE_IMAGE));
    }

    public static ImageIcon getSaveAsIcon() {
        return new ImageIcon(Main.class.getClassLoader().getResource(URL_SAVE_AS_IMAGE));
    }

    public static ImageIcon getSaveAllIcon() {
        return new ImageIcon(Main.class.getClassLoader().getResource(URL_SAVE_ALL_IMAGE));
    }

    public static ImageIcon getPrintIcon() {
        return new ImageIcon(Main.class.getClassLoader().getResource(URL_PRINT_IMAGE));
    }

    public static ImageIcon getCopyIcon() {
        return new ImageIcon(Main.class.getClassLoader().getResource(URL_COPY_IMAGE));
    }

    public static ImageIcon getPasteIcon() {
        return new ImageIcon(Main.class.getClassLoader().getResource(URL_PASTE_IMAGE));
    }

    public static ImageIcon getCutIcon() {
        return new ImageIcon(Main.class.getClassLoader().getResource(URL_CUT_IMAGE));
    }

    public static ImageIcon getRunLexicIcon() {
        return new ImageIcon(Main.class.getClassLoader().getResource(URL_RUN_LEXIC_IMAGE));
    }

    public static ImageIcon getRunSyntaxIcon() {
        return new ImageIcon(Main.class.getClassLoader().getResource(URL_RUN_SYNTAX_IMAGE));
    }

    public static ImageIcon getRootSyntaxIcon() {
        return new ImageIcon(Main.class.getClassLoader().getResource(URL_ROOT_SYNTAX_IMAGE));
    }

    public static ImageIcon getMiddleSyntaxIcon() {
        return new ImageIcon(Main.class.getClassLoader().getResource(URL_MIDDLE_SYNTAX_IMAGE));
    }

    public static ImageIcon getFinalSyntaxIcon() {
        return new ImageIcon(Main.class.getClassLoader().getResource(URL_FINAL_SYNTAX_IMAGE));
    }

    public static void copySelected(ActionEvent e) {
        copy.actionPerformed(e);
    }

    public static void pasteSelected(ActionEvent e) {
        paste.actionPerformed(e);
    }

    public static void cutSelected(ActionEvent e) {
        cut.actionPerformed(e);
    }

    public static void runLexicAnalizer() {
        FileEditor currentFileEditor = FilesEditorContainer.getInstance().getCurrentFileEditor();
        if (!currentFileEditor.isSaved) {
            currentFileEditor.save();
        } 
        File currentFile = currentFileEditor.getFile();
        CapradyCodeDebugger.getInstance().runLexicDebbuger(currentFile);
    }
    
    public static void runDebbuger(){
        FileEditor currentFileEditor = FilesEditorContainer.getInstance().getCurrentFileEditor();
        if (!currentFileEditor.isSaved) {
            currentFileEditor.save();
        } 
        File currentFile = currentFileEditor.getFile();
        CapradyCodeDebugger.getInstance().runDebbuger(currentFile);
    }
}
