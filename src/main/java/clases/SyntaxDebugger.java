/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import syntax.CapradyCode;
import syntax.ParseException;
import syntaxtree.Node;
import visitor.SyntaxTreeVisitor;

/**
 *
 * @author Alan Diaz Yañez
 */
public class SyntaxDebugger extends JPanel {

    private static SyntaxDebugger instance;

    private CapradyCode capradyCodeInstance;
    private final JTextPane txtPane;
    private final JScrollPane scrollView;

    private DefaultMutableTreeNode root;
    private JTree mainTree;

    public static SyntaxDebugger getInstance() {
        if (instance == null) {
            instance = new SyntaxDebugger();
        }
        return instance;
    }

    private SyntaxDebugger() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(getSize().width, 150));
        scrollView = new JScrollPane();
        setBackground(Color.blue);
        add(scrollView, BorderLayout.CENTER);
        txtPane = new JTextPane();
    }

    public boolean run(CapradyCode src) {
        Node jtb;
        SyntaxTreeVisitor visitor = new SyntaxTreeVisitor();
        //JTree mainTree = new JTree(raiz);
        DefaultTreeCellRenderer renderer;
        try {
            //-----------------------------------------
            jtb = src.Programa();
            System.out.println("Analisis lexico y sintactico exxitoso!!!");
            jtb.accept(visitor);
            root = visitor.getRoot();
            mainTree = new JTree(root);
            renderer = (DefaultTreeCellRenderer) mainTree.getCellRenderer();
            renderer.setClosedIcon(Helper.getMiddleSyntaxIcon());
            renderer.setOpenIcon(Helper.getRootSyntaxIcon());
            renderer.setLeafIcon(Helper.getFinalSyntaxIcon());
            scrollView.setViewportView(mainTree);
        } catch (ParseException ex) {
            String mensaje = "Syntax error:\n";
            mensaje += ex.toString() + "\n";
            txtPane.setText(mensaje);
            scrollView.setViewportView(txtPane);
            Logger.getLogger(SyntaxDebugger.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    private void mostrarArbol() {

    }
}
