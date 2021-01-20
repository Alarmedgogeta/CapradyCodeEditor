/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
import lexic.CapradyCode;
import lexic.ParseException;
import lexic.TokenMgrError;

/**
 *
 * @author Alan Diaz Yañez
 */
public class LexicDebugger extends JPanel {

    private static LexicDebugger instance;

    private CapradyCode capradyCodeInstance;
    private final JTextPane txtPane;
    private final JScrollPane scrollView;
    private final ArrayList<String> listTokens;

    public static LexicDebugger getInstance() {
        if (instance == null) {
            instance = new LexicDebugger();
        }
        return instance;
    }

    private LexicDebugger() {
        listTokens = new ArrayList<>();
        setLayout(new BorderLayout());
        //setMinimumSize(new Dimension(getSize().width, 100));
        setPreferredSize(new Dimension(getSize().width, 100));
        txtPane = new JTextPane();
        txtPane.setEditable(false);
        scrollView = new JScrollPane();
        scrollView.setViewportView(txtPane);
        //txtPane.setMinimumSize(getSize());
        setBackground(Color.blue);
        add(scrollView, BorderLayout.CENTER);
    }

    public boolean run(CapradyCode src) {
        txtPane.setText("");
        listTokens.clear();
        StyledDocument doc = null;
        try {
            doc = txtPane.getStyledDocument();
            src.ProbarLexico(listTokens);
            doc.insertString(doc.getLength(), "Analisis lexico exitoso\n", null);
            imprimirTokens();
            return true;
        } catch (BadLocationException | TokenMgrError | ParseException ex) {
            try {
                imprimirTokens();
                doc.insertString(doc.getLength(), "Error lexico: " + ex.toString() + "\n", null);
            } catch (BadLocationException ex1) {
                Logger.getLogger(CapradyCodeDebugger.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    private void imprimirTokens() {
        StyledDocument doc = null;
        String mensaje = "Tokens encontrados: \n";
        for (String token : listTokens) {
            mensaje += "\t-> " + token + ".\n";
        }
        mensaje += "\n";
        try {
            doc = txtPane.getStyledDocument();
            doc.insertString(doc.getLength(), mensaje, null);
        } catch (BadLocationException ex) {
            Logger.getLogger(CapradyCodeDebugger.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
