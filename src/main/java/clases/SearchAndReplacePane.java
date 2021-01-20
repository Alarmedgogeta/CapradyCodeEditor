package clases;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Alan Diaz Yañez
 */
public class SearchAndReplacePane extends JPanel {

    private static SearchAndReplacePane instance;

    private final JTextField txtSearch;
    private final JTextField txtReplace;
    private final JButton btnNextResult;
    private final JButton btnPrevResult;
    private final JButton btnReplace;
    private final JLabel lblMessage;

    public static SearchAndReplacePane getInstance() {
        if (instance == null) {
            instance = new SearchAndReplacePane();
        }
        return instance;
    }

    private SearchAndReplacePane() {
        this.txtSearch = new JTextField();
        this.txtReplace = new JTextField(); //Siguiente coincidencia Anterior coincidencia
        this.btnNextResult = new JButton("", Helper.getNextIcon());
        this.btnPrevResult = new JButton("", Helper.getPrevIcon());
        this.btnReplace = new JButton("Remplazar", Helper.getPasteIcon());
        this.lblMessage = new JLabel();
        initComponents();
    }

    private void initComponents() {
        setLayout(new FlowLayout(FlowLayout.LEFT));

        txtSearch.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent arg0) {
            }

            @Override
            public void keyPressed(KeyEvent arg0) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent arg0) {
                searchFirst();
            }
        });

        btnNextResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchNext();
            }
        });

        btnPrevResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchPrev();
            }
        });

        btnReplace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                replaceCurrent();
            }
        });
        txtSearch.setPreferredSize(new Dimension(100, 28));
        txtReplace.setPreferredSize(new Dimension(100, 28));
        add(txtSearch);
        add(btnPrevResult);
        add(btnNextResult);
        add(txtReplace);
        add(btnReplace);
        add(lblMessage);
        setVisible(false);
    }

    public void selectSearchAndReplace() {
        if(isVisible()){
            FilesEditorContainer.getInstance().cleanAllStringSearches();
        }
        setVisible(!SearchAndReplacePane.getInstance().isVisible());

    }

    private void searchFirst() {
        String message = FilesEditorContainer.getInstance().searchStringInDocument(txtSearch.getText());
        lblMessage.setText(message);
    }

    private void searchNext() {
        String message = FilesEditorContainer.getInstance().searchNextStringInDocument();
        lblMessage.setText(message);
    }

    private void searchPrev() {
        String message = FilesEditorContainer.getInstance().searchPrevStringInDocument();
        lblMessage.setText(message);
    }

    private void replaceCurrent() {
        System.out.println(txtReplace.getText());
        String message = FilesEditorContainer.getInstance().replaceCurrentStringInDocument(txtReplace.getText());
        lblMessage.setText(message);
    }

    private void replaceAll() {
        //String message = FilesEditorContainer.getInstance().replaceCurrentStringInDocument(txtReplace.getText());
        //lblMessage.setText(message);
    }

}
