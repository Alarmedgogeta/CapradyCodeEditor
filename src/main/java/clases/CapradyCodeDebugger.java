package clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTabbedPane;
import lexic.CapradyCode;

/**
 *
 * @author Alan Diaz Yañez
 */
public class CapradyCodeDebugger extends JTabbedPane {

    private static CapradyCodeDebugger instance;

    private CapradyCode capradyCodeLexicInstance;
    private syntax.CapradyCode capradyCodeSyntaxInstance;
    private final LexicDebugger lexic;
    private final SyntaxDebugger syntax;

    public static CapradyCodeDebugger getInstance() {
        if (instance == null) {
            instance = new CapradyCodeDebugger();
        }
        return instance;
    }

    private CapradyCodeDebugger() {
        lexic = LexicDebugger.getInstance();
        syntax = SyntaxDebugger.getInstance();
    }

    private void initComponents() {
        initLexicDebugger();
        initSintaxDebugger();
    }

    private void initLexicDebugger() {
        //
    }

    private void initSintaxDebugger() {
        //
    }

    public void runLexicDebbuger(File src) {
        removeAll();
        addTab("Analizador Léxico", lexic);
        try {
            capradyCodeLexicInstance = new CapradyCode(new BufferedReader(new FileReader(src)));
            capradyCodeSyntaxInstance = new syntax.CapradyCode(new BufferedReader(new FileReader(src)));
            lexic.run(capradyCodeLexicInstance);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CapradyCodeDebugger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void runDebbuger(File src) {
        removeAll();
        addTab("Analizador Léxico", lexic);
        try {
            capradyCodeLexicInstance = new CapradyCode(new BufferedReader(new FileReader(src)));
            capradyCodeSyntaxInstance = new syntax.CapradyCode(new BufferedReader(new FileReader(src)));
            if (lexic.run(capradyCodeLexicInstance)) {
                addTab("Analizador Sintáctico", syntax);
                syntax.run(capradyCodeSyntaxInstance);
            } else {
                //
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CapradyCodeDebugger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
