//
// Generated by JTB 1.3.2
//
package visitor;

import syntaxtree.*;
import java.util.*;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Provides default methods which visit each node in the tree in depth-first
 * order. Your visitors may extend this class.
 */
public class SyntaxTreeVisitor implements Visitor {
    //
    // Auto class visitors--probably don't need to be overridden.
    //

    //Aqui empiezan mis modificaciones
    //private int nivel;
    private DefaultMutableTreeNode root;

    public DefaultMutableTreeNode getRoot() {
        return root;
    }

    /*private void imprimirNivel() {
        for (int i = 0; i < nivel; i++) {
            System.out.print("\t");
        }
    }

    private void imprimirNodo(String nombre) {
        imprimirNivel();
        System.out.println(nombre);
    }*/
    public void visit(NodeList n, DefaultMutableTreeNode parent) {
        for (Enumeration<Node> e = n.elements(); e.hasMoreElements();) {
            e.nextElement().accept(this, parent);
        }
    }

    public void visit(NodeListOptional n, DefaultMutableTreeNode parent) {
        if (n.present()) {
            for (Enumeration<Node> e = n.elements(); e.hasMoreElements();) {
                e.nextElement().accept(this, parent);
            }
        }
    }

    public void visit(NodeOptional n, DefaultMutableTreeNode parent) {
        if (n.present()) {
            n.node.accept(this, parent);
        }
    }

    public void visit(NodeSequence n, DefaultMutableTreeNode parent) {
        for (Enumeration<Node> e = n.elements(); e.hasMoreElements();) {
            e.nextElement().accept(this, parent);
        }
    }

    public void visit(NodeToken n, DefaultMutableTreeNode parent) {
        if (!n.toString().equals(";")) {
            DefaultMutableTreeNode children = new DefaultMutableTreeNode(n.toString(), true);
            parent.add(children);
        }
    }

    //Aqui terminan mis modificaciones
    public void visit(NodeList n) {
        for (Enumeration<Node> e = n.elements(); e.hasMoreElements();) {
            e.nextElement().accept(this);
        }
    }

    public void visit(NodeListOptional n) {
        if (n.present()) {
            for (Enumeration<Node> e = n.elements(); e.hasMoreElements();) {
                e.nextElement().accept(this);
            }
        }
    }

    public void visit(NodeOptional n) {
        if (n.present()) {
            n.node.accept(this);
        }
    }

    public void visit(NodeSequence n) {
        for (Enumeration<Node> e = n.elements(); e.hasMoreElements();) {
            e.nextElement().accept(this);
        }
    }

    public void visit(NodeToken n) {
    }

    //
    // User-generated visitor methods below
    //
    /**
     * f0 -> <IF>
     * | <ELSE>
     * | <ELSEIF>
     * | <SWITCH>
     * | <CASE>
     * | <FOR>
     * | <FOREACH>
     * | <WHILE>
     * | <MAIN>
     * | <TYPEINT>
     * | <TYPEFLOAT>
     * | <READ>
     * | <WRITE>
     * | <PLUS>
     * | <LESS>
     * | <MULTIPLY>
     * | <EXPONENT>
     * | <DIVIDE>
     * | <GREATERTHEN>
     * | <SMALLERTHEN>
     * | <GREATEREQUALTHEN>
     * | <SMALLEREQUALTHEN>
     * | <EQUALS>
     * | <ASIGNATION>
     * | <TERNARY>
     * | <ALTERNATIVE>
     * | <SEMICOLON>
     * | <COMMA>
     * | <KEY1>
     * | <KEY2>
     * | <PAR1>
     * | <PAR2>
     * | <INTEGER>
     * | <FLOAT>
     * | <STRING>
     * | <COMMENT1>
     * | <COMMENTM>
     * | <ID>
     */
    public void visit(Tokens n) {
        n.f0.accept(this);
    }

    public void visit(Tokens n, DefaultMutableTreeNode parent) {
        DefaultMutableTreeNode children = new DefaultMutableTreeNode(n.f0.toString(), true);
        parent.add(children);
        n.f0.accept(this, children);
    }

    /**
     * f0 -> <MAIN>
     * f1 -> <KEY1>
     * f2 -> ( Sentencia() )* f3 -> <KEY2>
     * f4 -> <EOF>
     */
    public void visit(Programa n) {
        DefaultMutableTreeNode children;
        //nivel = 0;
        n.f0.accept(this);
        root = new DefaultMutableTreeNode("MAIN", true);
        n.f1.accept(this, root);
        //children = new DefaultMutableTreeNode("KEY1", true);
        //root.add(children);
        n.f2.accept(this, root);
        n.f3.accept(this, root);
        //children = new DefaultMutableTreeNode("KEY2", true);
        //root.add(children);
        n.f4.accept(this);
    }

    public void visit(Programa n, DefaultMutableTreeNode parent) {
        n.f0.accept(this);
        root = new DefaultMutableTreeNode("MAIN", true);
        n.f1.accept(this, root);
        n.f2.accept(this, root);
        n.f3.accept(this, root);
        n.f4.accept(this);
    }

    /**
     * f0 -> Sent_if() | Sent_while() | Sent_for() | Declaration() <SEMICOLON>
     * | Sent_read() <SEMICOLON>
     * | Sent_write() <SEMICOLON>
     * | Asignation() <SEMICOLON>
     * | <COMMENT1>
     * | <COMMENTM>
     */
    public void visit(Sentencia n) {
        n.f0.accept(this);
    }

    public void visit(Sentencia n, DefaultMutableTreeNode parent) {
        /*DefaultMutableTreeNode children = new DefaultMutableTreeNode("Sentencia", true);
        parent.add(children);
        n.f0.accept(this, children);*/
        n.f0.accept(this, parent);
    }

    /**
     * f0 -> <IF>
     * f1 -> <PAR1>
     * f2 -> Exp() f3 -> <PAR2>
     * f4 -> <KEY1>
     * f5 -> ( Sentencia() )* f6 -> <KEY2>
     * f7 -> ( <ELSEIF> <PAR1> Exp() <PAR2> <KEY1> ( Sentencia() )* <KEY2> )? f8
     * -> ( <ELSE> <KEY1> ( Sentencia() )* <KEY2> )?
     */
    public void visit(Sent_if n) {
        n.f0.accept(this);
        //imprimirNodo("->IF: " + n.f0.toString());
        n.f1.accept(this);
        //imprimirNodo("->PAR1: " + n.f1.toString());
        //nivel++;
        n.f2.accept(this);
        //nivel--;
        n.f3.accept(this);
        //imprimirNodo("->PAR2: " + n.f3.toString());
        n.f4.accept(this);
        //imprimirNodo("->KEY1: " + n.f4.toString());
        //nivel++;
        n.f5.accept(this);
        //nivel--;
        n.f6.accept(this);
        //imprimirNodo("->KEY2: " + n.f6.toString());
        if (n.f7.present()) {
            //imprimirNodo("->ELSEIF: " + n.f7.toString());
            //imprimirNodo("->PAR1: (");
            //nivel++;
        }
        n.f7.accept(this);
        if (n.f7.present()) {
            //nivel--;
            //imprimirNodo("->KEY2: }");
        }
        if (n.f8.present()) {
            //imprimirNodo("->ELSE: sino");
            //imprimirNodo("->KEY1: {");
            //nivel++;
        }
        n.f8.accept(this);
        if (n.f8.present()) {
            //nivel--;
            //imprimirNodo("->KEY2: }");
        }
    }

    public void visit(Sent_if n, DefaultMutableTreeNode parent) {
        DefaultMutableTreeNode children = new DefaultMutableTreeNode("Sent_if", true);
        parent.add(children);
        n.f0.accept(this, children);
        n.f1.accept(this, children);
        n.f2.accept(this, children);
        n.f3.accept(this, children);
        n.f4.accept(this, children);
        n.f5.accept(this, children);
        n.f6.accept(this, children);
        n.f7.accept(this, children);
        n.f8.accept(this, children);
    }

    /**
     * f0 -> <WHILE>
     * f1 -> <PAR1>
     * f2 -> Exp() f3 -> <PAR2>
     * f4 -> <KEY1>
     * f5 -> ( Sentencia() )* f6 -> <KEY2>
     */
    public void visit(Sent_while n) {
        n.f0.accept(this);
        //imprimirNodo("->WHILE: " + n.f0.toString());
        n.f1.accept(this);
        //imprimirNodo("->PAR1: " + n.f1.toString());
        //nivel++;
        n.f2.accept(this);
        //nivel--;
        n.f3.accept(this);
        //imprimirNodo("->PAR2: " + n.f3.toString());
        n.f4.accept(this);
        //imprimirNodo("->KEY1: " + n.f4.toString());
        //nivel++;
        n.f5.accept(this);
        //nivel--;
        n.f6.accept(this);
        //imprimirNodo("->KEY2: " + n.f6.toString());
    }

    public void visit(Sent_while n, DefaultMutableTreeNode parent) {
        DefaultMutableTreeNode children = new DefaultMutableTreeNode("Sent_while", true);
        parent.add(children);
        n.f0.accept(this, children);
        n.f1.accept(this, children);
        n.f2.accept(this, children);
        n.f3.accept(this, children);
        n.f4.accept(this, children);
        n.f5.accept(this, children);
        n.f6.accept(this, children);
    }

    /**
     * f0 -> <FOR>
     * f1 -> <PAR1>
     * f2 -> Asignation() f3 -> <SEMICOLON>
     * f4 -> Exp() f5 -> <SEMICOLON>
     * f6 -> Asignation() f7 -> <SEMICOLON>
     * f8 -> <PAR2>
     * f9 -> <KEY1>
     * f10 -> ( Sentencia() )* f11 -> <KEY2>
     */
    public void visit(Sent_for n) {
        n.f0.accept(this);
        //imprimirNodo("->FOR: " + n.f0.toString());
        n.f1.accept(this);
        //imprimirNodo("->PAR1: " + n.f1.toString());
        //nivel++;
        n.f2.accept(this);
        //nivel--;
        n.f3.accept(this);
        //imprimirNodo("->SEMICOLON: " + n.f3.toString());
        //nivel++;
        n.f4.accept(this);
        //nivel--;
        n.f5.accept(this);
        //imprimirNodo("->SEMICOLON: " + n.f5.toString());
        //nivel++;
        n.f6.accept(this);
        //nivel--;
        n.f7.accept(this);
        //imprimirNodo("->SEMICOLON: " + n.f7.toString());
        n.f8.accept(this);
        //imprimirNodo("->PAR2: " + n.f8.toString());
        n.f9.accept(this);
        //imprimirNodo("->KEY1: " + n.f9.toString());
        //nivel++;
        n.f10.accept(this);
        //nivel--;
        n.f11.accept(this);
        //imprimirNodo("->KEY2: " + n.f11.toString());
    }

    public void visit(Sent_for n, DefaultMutableTreeNode parent) {
        DefaultMutableTreeNode children = new DefaultMutableTreeNode("Sent_for", true);
        parent.add(children);
        n.f0.accept(this, children);
        n.f1.accept(this, children);
        n.f2.accept(this, children);
        n.f3.accept(this, children);
        n.f4.accept(this, children);
        n.f5.accept(this, children);
        n.f6.accept(this, children);
        n.f7.accept(this, children);
        n.f8.accept(this, children);
        n.f9.accept(this, children);
        n.f10.accept(this, children);
        n.f11.accept(this, children);
    }

    /**
     * f0 -> Tipo() f1 -> <ID>
     * f2 -> ( <ASIGNATION> Exp() ( <TERNARY> Exp() <ALTERNATIVE> Exp() )? )?
     */
    public void visit(Declaration n) {
        n.f0.accept(this);
        n.f1.accept(this);
        //imprimirNodo("->ID: " + n.f1.toString());
        if (n.f2.present()) {
            //imprimirNodo("->ASIGNATION: =");
            //nivel++;
        }
        n.f2.accept(this);
        if (n.f2.present()) {
            //nivel--;
        }
    }

    public void visit(Declaration n, DefaultMutableTreeNode parent) {
        DefaultMutableTreeNode children = new DefaultMutableTreeNode("Declaration", true);
        parent.add(children);
        n.f0.accept(this, children);
        n.f1.accept(this, children);
        n.f2.accept(this, children);
    }

    /**
     * f0 -> <TYPEINT>
     * | <TYPEFLOAT>
     */
    public void visit(Tipo n) {
        n.f0.accept(this);
        //imprimirNodo("->Tipo(): " + n.f0.choice.toString());
    }

    public void visit(Tipo n, DefaultMutableTreeNode parent) {
        DefaultMutableTreeNode children = new DefaultMutableTreeNode("Tipo", true);
        parent.add(children);
        n.f0.accept(this, children);
    }

    /**
     * f0 -> <READ>
     * f1 -> <PAR1>
     * f2 -> <ID>
     * f3 -> <PAR2>
     */
    public void visit(Sent_read n) {
        n.f0.accept(this);
        //imprimirNodo("->READ: " + n.f0.toString());
        n.f1.accept(this);
        //imprimirNodo("->PAR1: " + n.f1.toString());
        n.f2.accept(this);
        //imprimirNodo("->ID: " + n.f2.toString());
        n.f3.accept(this);
        //imprimirNodo("->PAR2: " + n.f3.toString());
    }

    public void visit(Sent_read n, DefaultMutableTreeNode parent) {
        DefaultMutableTreeNode children = new DefaultMutableTreeNode("Sent_read", true);
        parent.add(children);
        n.f0.accept(this, children);
        n.f1.accept(this, children);
        n.f2.accept(this, children);
        n.f3.accept(this, children);
    }

    /**
     * f0 -> <WRITE>
     * f1 -> <PAR1>
     * f2 -> <STRING>
     * f3 -> ( Exp() )? f4 -> <PAR2>
     */
    public void visit(Sent_write n) {
        n.f0.accept(this);
        //imprimirNodo("->WRITE: " + n.f0.toString());
        n.f1.accept(this);
        //imprimirNodo("->PAR1: " + n.f1.toString());
        n.f2.accept(this);
        //imprimirNodo("->STRING: " + n.f2.toString());
        if (n.f3.present()) {
            //nivel++;
        }
        n.f3.accept(this);
        if (n.f3.present()) {
            //nivel--;
        }
        n.f4.accept(this);
        //imprimirNodo("->PAR2: " + n.f4.toString());
    }

    public void visit(Sent_write n, DefaultMutableTreeNode parent) {
        DefaultMutableTreeNode children = new DefaultMutableTreeNode("Sent_write", true);
        parent.add(children);
        n.f0.accept(this, children);
        n.f1.accept(this, children);
        n.f2.accept(this, children);
        n.f3.accept(this, children);
        n.f4.accept(this, children);
    }

    /**
     * f0 -> <ID>
     * f1 -> <ASIGNATION>
     * f2 -> Exp() f3 -> ( <TERNARY> Exp() <ALTERNATIVE> Exp() )?
     */
    public void visit(Asignation n) {
        n.f0.accept(this);
        //imprimirNodo("->ID: " + n.f0.toString());
        n.f1.accept(this);
        //imprimirNodo("->ASIGNATION: " + n.f1.toString());
        //nivel++;
        n.f2.accept(this);
        //nivel--;
        if (n.f3.present()) {
            //imprimirNodo("->TERNARY");
            //nivel++;
        }
        n.f3.accept(this);
        if (n.f3.present()) {
            //nivel--;
        }
    }

    public void visit(Asignation n, DefaultMutableTreeNode parent) {
        DefaultMutableTreeNode children = new DefaultMutableTreeNode("Asignation", true);
        parent.add(children);
        n.f0.accept(this, children);
        n.f1.accept(this, children);
        n.f2.accept(this, children);
        n.f3.accept(this, children);
    }

    /**
     * f0 -> Exp_simple() f1 -> ( Op_comparation() Exp_simple() )?
     */
    public void visit(Exp n) {
        //imprimirNodo("->Exp: ");
        //nivel++;
        n.f0.accept(this);
        //nivel--;
        if (n.f1.present()) {
            //nivel++;
        }
        n.f1.accept(this);
        if (n.f1.present()) {
            //nivel--;
        }
    }

    public void visit(Exp n, DefaultMutableTreeNode parent) {
        DefaultMutableTreeNode children = new DefaultMutableTreeNode("Exp", true);
        parent.add(children);
        n.f0.accept(this, children);
        n.f1.accept(this, children);
    }

    /**
     * f0 -> <SMALLERTHEN>
     * | <GREATERTHEN>
     * | <SMALLEREQUALTHEN>
     * | <GREATEREQUALTHEN>
     * | <EQUALS>
     * | <NOTEQUALS>
     */
    public void visit(Op_comparation n) {
        n.f0.accept(this);
        //imprimirNodo("->Op_comparation(): ");
        //nivel++;
        String strNodo = "";
        switch (n.f0.which) {
            case 0:
                strNodo = "->SMALLERTHEN: ";
                break;
            case 1:
                strNodo = "->GREATERTHEN: ";
                break;
            case 2:
                strNodo = "->SMALLEREQUALTHEN: ";
                break;
            case 3:
                strNodo = "->GREATEREQUALTHEN: ";
                break;
            case 4:
                strNodo = "->EQUALS: ";
                break;
            case 5:
                strNodo = "->NOTEQUALS: ";
                break;
        }
        //imprimirNodo(strNodo + n.f0.choice.toString());
        //nivel--;
    }

    public void visit(Op_comparation n, DefaultMutableTreeNode parent) {
        DefaultMutableTreeNode children = new DefaultMutableTreeNode("Op_comparation", true);
        parent.add(children);
        n.f0.accept(this, children);
    }

    /**
     * f0 -> Term() f1 -> ( Op_low() Term() )*
     */
    public void visit(Exp_simple n) {
        //imprimirNodo("->Exp_simple(): ");
        //nivel++;
        n.f0.accept(this);
        n.f1.accept(this);
        //nivel--;
    }

    public void visit(Exp_simple n, DefaultMutableTreeNode parent) {
        DefaultMutableTreeNode children = new DefaultMutableTreeNode("Exp_simple", true);
        parent.add(children);
        n.f0.accept(this, children);
        n.f1.accept(this, children);
    }

    /**
     * f0 -> "+" | "-"
     */
    public void visit(Op_low n) {
        n.f0.accept(this);
        //imprimirNodo("->Op_low(): " + n.f0.choice.toString());
    }

    public void visit(Op_low n, DefaultMutableTreeNode parent) {
        DefaultMutableTreeNode children = new DefaultMutableTreeNode("Op_low", true);
        parent.add(children);
        n.f0.accept(this, children);
    }

    /**
     * f0 -> Factor() f1 -> ( Op_high() Factor() )*
     */
    public void visit(Term n) {
        //imprimirNodo("->Term(): ");
        //nivel++;
        n.f0.accept(this);
        n.f1.accept(this);
        //nivel--;
    }

    public void visit(Term n, DefaultMutableTreeNode parent) {
        DefaultMutableTreeNode children = new DefaultMutableTreeNode("Term", true);
        parent.add(children);
        n.f0.accept(this, children);
        n.f1.accept(this, children);
    }

    /**
     * f0 -> "*" | "/"
     */
    public void visit(Op_high n) {
        n.f0.accept(this);
        //imprimirNodo("->Op_high(): " + n.f0.choice.toString());
    }

    public void visit(Op_high n, DefaultMutableTreeNode parent) {
        DefaultMutableTreeNode children = new DefaultMutableTreeNode("Op_high", true);
        parent.add(children);
        n.f0.accept(this, children);
    }

    /**
     * f0 -> <PAR1> Exp() <PAR2>
     * | <FLOAT>
     * | <INTEGER>
     * | <ID>
     */
    public void visit(Factor n) {
        //imprimirNodo("->Factor(): ");
        //nivel++;
        if (n.f0.which == 0) {
            //imprimirNodo("->PAR1");
        }
        if (n.f0.which == 1) {
            //imprimirNodo("->FLOAT: " + n.f0.choice.toString());
        }
        if (n.f0.which == 2) {
            //imprimirNodo("->INTEGER: " + n.f0.choice.toString());
        }
        if (n.f0.which == 3) {
            //imprimirNodo("->ID: " + n.f0.choice.toString());
        }
        n.f0.accept(this);
        if (n.f0.which == 0) {
            //imprimirNodo("->PAR2");
        }
        //nivel--;
    }

    public void visit(Factor n, DefaultMutableTreeNode parent) {
        DefaultMutableTreeNode children = new DefaultMutableTreeNode("Factor", true);
        parent.add(children);
        n.f0.accept(this, children);
    }

}
