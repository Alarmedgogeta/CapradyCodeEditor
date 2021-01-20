package clases;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @author Alan Diaz Yañez
 */
public class Editor extends JFrame {

    private static Editor instance;

    private final Dimension minSize = new Dimension(620, 460);
    private Font typografy;

    //private static String languaje = "MX";
    private final JPanel mainPane = new JPanel(new GridBagLayout());
    private final ToolMenuBar toolBar = ToolMenuBar.getInstance();
    private final ProjectTreeViewer explorer = ProjectTreeViewer.getInstance();
    private final IconToolBar iconToolBar = IconToolBar.getInstance();
    private final FilesEditorContainer filesContainer = FilesEditorContainer.getInstance();
    private final CapradyCodeDebugger debugger = CapradyCodeDebugger.getInstance();
    private final SearchAndReplacePane searchAndReplacePanel = SearchAndReplacePane.getInstance();
    private final GridBagConstraints gbc = new GridBagConstraints();

    public static Editor getInstance() {
        if (Editor.instance == null) {
            Editor.instance = new Editor();
        }
        return Editor.instance;
    }

    private Editor() {
        super("Caprady Code Editor");
        initComponents();
    }

    private void initComponents() {
        //setBounds(500, 300, 550, 400);
        setSize(minSize);
        setMinimumSize(minSize);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initMainPane();
        initToolBar();
        initIconToolBar();
        initExplorer();
        initFilesContainer();
        initDebugger();
        initSearchAndReplace();
        //System.out.println(toolBar.getPreferredSize());
        setVisible(true);
    }

    private void initMainPane() {
        add(mainPane);
    }

    private void initToolBar() {

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 0.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        mainPane.add(toolBar, gbc);
    }
    
    private void initIconToolBar(){
        
    }
    
    private void initExplorer(){

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 3;
        gbc.weightx = 0.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.VERTICAL;
        
        //gbc.
        
        JPanel leftPanel = new JPanel();
        //leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setLayout(new BorderLayout());
        
        leftPanel.add(iconToolBar, BorderLayout.WEST);
        leftPanel.add(explorer, BorderLayout.CENTER);
        
        leftPanel.setMinimumSize(new Dimension(200, 400));
        //leftPanel.setPreferredSize(new Dimension(200, 400));
        
        mainPane.add(leftPanel, gbc);
    }

    private void initFilesContainer(){

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;

        mainPane.add(filesContainer, gbc);
    }
    
    private void initDebugger(){

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 0.0;
        gbc.fill = GridBagConstraints.BOTH;

        mainPane.add(debugger, gbc);
    }
    
    private void initSearchAndReplace(){

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 0.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        mainPane.add(searchAndReplacePanel, gbc);
    }
}
