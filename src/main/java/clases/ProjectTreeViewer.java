package clases;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
//import javax.swing.Default;

/**
 *
 * @author Alan Diaz Yañez
 */
public class ProjectTreeViewer extends JScrollPane {

    private static ProjectTreeViewer instance;

    private final JPanel mainPanel;
    private DefaultMutableTreeNode root = new DefaultMutableTreeNode("projecto");
    private JTree mainTree = new JTree(root);
    private final Dimension minSize = new Dimension(200, 200);
    private final Dimension maxSize = new Dimension(150, 2000);
    private MouseListener ml;

    public static ProjectTreeViewer getInstance() {
        if (ProjectTreeViewer.instance == null) {
            ProjectTreeViewer.instance = new ProjectTreeViewer();
        }
        return ProjectTreeViewer.instance;
    }

    private ProjectTreeViewer() {
        super();
        mainPanel = new JPanel();
        initComponents();
    }

    private void initComponents() {
        setViewportView(mainPanel);
        /*ml = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("mousePressed");
                int selRow = mainTree.getRowForLocation(e.getX(), e.getY());
                TreePath selPath = mainTree.getPathForLocation(e.getX(), e.getY());
                if (selRow != -1) {
                    System.out.println("selRow: " +selRow);
                    if (e.getClickCount() == 1) {
                        System.out.println("clickcount: 1");
                        //mySingleClick(selRow, selPath);
                    } else if (e.getClickCount() == 2) {
                        System.out.println("clickcount: 2");
                        fileSelectedAction();
                    }
                }
            }
        };
        mainTree.addMouseListener(ml);*/
        //mainPanel.setMaximumSize(maxSize);
    }

    public void searchProject() {
        JButton open = new JButton();
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Seleccione el directorio del proyecto");
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (fc.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
            this.root = new DefaultMutableTreeNode(fc.getSelectedFile().getName());
            walkProject(this.root, fc.getSelectedFile());
            this.mainTree = new JTree(root);
            mainTree.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    System.out.println("hola");
                    if (mainTree.getSelectionCount() > 0) {
                        System.out.println("si hay seleccion");
                        if (evt.getClickCount() == 2) {
                            fileSelectedAction();
                        }
                    }
                }
            });
            setViewportView(mainTree);
            Editor.getInstance().repaint();
            System.out.println(getSize());
        }

    }

    private void walkProject(DefaultMutableTreeNode parent, File file) {
        File[] children = file.listFiles();
        DefaultMutableTreeNode child;
        for (File f : children) {
            if (f.isDirectory()) {
                child = new DefaultMutableTreeNode(f.getName(), true);
                walkProject(child, f);
            } else {
                child = new FileMutableTreeNode(f.getPath());
                //child.
            }
            parent.add(child);
        }
    }

    private void fileSelectedAction() {
        System.out.println("fileSelectedAction");
        DefaultMutableTreeNode nodeSelected = (DefaultMutableTreeNode) mainTree.getSelectionPath().getLastPathComponent();
        if (nodeSelected.isLeaf()) {
            FileMutableTreeNode fileSelected = (FileMutableTreeNode) nodeSelected;
            fileSelected.openFile();
        }
    }
}
