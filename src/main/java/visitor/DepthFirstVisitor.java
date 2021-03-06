//
// Generated by JTB 1.3.2
//

package visitor;
import syntaxtree.*;
import java.util.*;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Provides default methods which visit each node in the tree in depth-first
 * order.  Your visitors may extend this class.
 */
public class DepthFirstVisitor implements Visitor {
   //
   // Auto class visitors--probably don't need to be overridden.
   //
   public void visit(NodeList n) {
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); )
         e.nextElement().accept(this);
   }

   public void visit(NodeListOptional n) {
      if ( n.present() )
         for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); )
            e.nextElement().accept(this);
   }

   public void visit(NodeOptional n) {
      if ( n.present() )
         n.node.accept(this);
   }

   public void visit(NodeSequence n) {
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); )
         e.nextElement().accept(this);
   }

   public void visit(NodeToken n) { }

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> <IF>
    *       | <ELSE>
    *       | <ELSEIF>
    *       | <SWITCH>
    *       | <CASE>
    *       | <FOR>
    *       | <FOREACH>
    *       | <WHILE>
    *       | <MAIN>
    *       | <TYPEINT>
    *       | <TYPEFLOAT>
    *       | <READ>
    *       | <WRITE>
    *       | <PLUS>
    *       | <LESS>
    *       | <MULTIPLY>
    *       | <EXPONENT>
    *       | <DIVIDE>
    *       | <GREATERTHEN>
    *       | <SMALLERTHEN>
    *       | <GREATEREQUALTHEN>
    *       | <SMALLEREQUALTHEN>
    *       | <EQUALS>
    *       | <ASIGNATION>
    *       | <TERNARY>
    *       | <ALTERNATIVE>
    *       | <SEMICOLON>
    *       | <COMMA>
    *       | <KEY1>
    *       | <KEY2>
    *       | <PAR1>
    *       | <PAR2>
    *       | <INTEGER>
    *       | <FLOAT>
    *       | <STRING>
    *       | <COMMENT1>
    *       | <COMMENTM>
    *       | <ID>
    */
   public void visit(Tokens n) {
      n.f0.accept(this);
   }

   /**
    * f0 -> <MAIN>
    * f1 -> <KEY1>
    * f2 -> ( Sentencia() )*
    * f3 -> <KEY2>
    * f4 -> <EOF>
    */
   public void visit(Programa n) {
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
   }

   /**
    * f0 -> Sent_if()
    *       | Sent_while()
    *       | Sent_for()
    *       | Declaration() <SEMICOLON>
    *       | Sent_read() <SEMICOLON>
    *       | Sent_write() <SEMICOLON>
    *       | Asignation() <SEMICOLON>
    *       | <COMMENT1>
    *       | <COMMENTM>
    */
   public void visit(Sentencia n) {
      n.f0.accept(this);
   }

   /**
    * f0 -> <IF>
    * f1 -> <PAR1>
    * f2 -> Exp()
    * f3 -> <PAR2>
    * f4 -> <KEY1>
    * f5 -> ( Sentencia() )*
    * f6 -> <KEY2>
    * f7 -> ( <ELSEIF> <PAR1> Exp() <PAR2> <KEY1> ( Sentencia() )* <KEY2> )?
    * f8 -> ( <ELSE> <KEY1> ( Sentencia() )* <KEY2> )?
    */
   public void visit(Sent_if n) {
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
      n.f6.accept(this);
      n.f7.accept(this);
      n.f8.accept(this);
   }

   /**
    * f0 -> <WHILE>
    * f1 -> <PAR1>
    * f2 -> Exp()
    * f3 -> <PAR2>
    * f4 -> <KEY1>
    * f5 -> ( Sentencia() )*
    * f6 -> <KEY2>
    */
   public void visit(Sent_while n) {
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
      n.f6.accept(this);
   }

   /**
    * f0 -> <FOR>
    * f1 -> <PAR1>
    * f2 -> Asignation()
    * f3 -> <SEMICOLON>
    * f4 -> Exp()
    * f5 -> <SEMICOLON>
    * f6 -> Asignation()
    * f7 -> <SEMICOLON>
    * f8 -> <PAR2>
    * f9 -> <KEY1>
    * f10 -> ( Sentencia() )*
    * f11 -> <KEY2>
    */
   public void visit(Sent_for n) {
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
      n.f5.accept(this);
      n.f6.accept(this);
      n.f7.accept(this);
      n.f8.accept(this);
      n.f9.accept(this);
      n.f10.accept(this);
      n.f11.accept(this);
   }

   /**
    * f0 -> Tipo()
    * f1 -> <ID>
    * f2 -> ( <ASIGNATION> Exp() ( <TERNARY> Exp() <ALTERNATIVE> Exp() )? )?
    */
   public void visit(Declaration n) {
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
   }

   /**
    * f0 -> <TYPEINT>
    *       | <TYPEFLOAT>
    */
   public void visit(Tipo n) {
      n.f0.accept(this);
   }

   /**
    * f0 -> <READ>
    * f1 -> <PAR1>
    * f2 -> <ID>
    * f3 -> <PAR2>
    */
   public void visit(Sent_read n) {
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
   }

   /**
    * f0 -> <WRITE>
    * f1 -> <PAR1>
    * f2 -> <STRING>
    * f3 -> ( Exp() )?
    * f4 -> <PAR2>
    */
   public void visit(Sent_write n) {
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
      n.f4.accept(this);
   }

   /**
    * f0 -> <ID>
    * f1 -> <ASIGNATION>
    * f2 -> Exp()
    * f3 -> ( <TERNARY> Exp() <ALTERNATIVE> Exp() )?
    */
   public void visit(Asignation n) {
      n.f0.accept(this);
      n.f1.accept(this);
      n.f2.accept(this);
      n.f3.accept(this);
   }

   /**
    * f0 -> Exp_simple()
    * f1 -> ( Op_comparation() Exp_simple() )?
    */
   public void visit(Exp n) {
      n.f0.accept(this);
      n.f1.accept(this);
   }

   /**
    * f0 -> <SMALLERTHEN>
    *       | <GREATERTHEN>
    *       | <SMALLEREQUALTHEN>
    *       | <GREATEREQUALTHEN>
    *       | <EQUALS>
    *       | <NOTEQUALS>
    */
   public void visit(Op_comparation n) {
      n.f0.accept(this);
   }

   /**
    * f0 -> Term()
    * f1 -> ( Op_low() Term() )*
    */
   public void visit(Exp_simple n) {
      n.f0.accept(this);
      n.f1.accept(this);
   }

   /**
    * f0 -> "+"
    *       | "-"
    */
   public void visit(Op_low n) {
      n.f0.accept(this);
   }

   /**
    * f0 -> Factor()
    * f1 -> ( Op_high() Factor() )*
    */
   public void visit(Term n) {
      n.f0.accept(this);
      n.f1.accept(this);
   }

   /**
    * f0 -> "*"
    *       | "/"
    */
   public void visit(Op_high n) {
      n.f0.accept(this);
   }

   /**
    * f0 -> <PAR1> Exp() <PAR2>
    *       | <FLOAT>
    *       | <INTEGER>
    *       | <ID>
    */
   public void visit(Factor n) {
      n.f0.accept(this);
   }

    @Override
    public void visit(NodeList n, DefaultMutableTreeNode parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(NodeListOptional n, DefaultMutableTreeNode parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(NodeOptional n, DefaultMutableTreeNode parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(NodeSequence n, DefaultMutableTreeNode parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(NodeToken n, DefaultMutableTreeNode parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(Tokens n, DefaultMutableTreeNode parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(Programa n, DefaultMutableTreeNode parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(Sentencia n, DefaultMutableTreeNode parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(Sent_if n, DefaultMutableTreeNode parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(Sent_while n, DefaultMutableTreeNode parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(Sent_for n, DefaultMutableTreeNode parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(Declaration n, DefaultMutableTreeNode parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(Tipo n, DefaultMutableTreeNode parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(Sent_read n, DefaultMutableTreeNode parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(Sent_write n, DefaultMutableTreeNode parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(Asignation n, DefaultMutableTreeNode parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(Exp n, DefaultMutableTreeNode parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(Op_comparation n, DefaultMutableTreeNode parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(Exp_simple n, DefaultMutableTreeNode parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(Op_low n, DefaultMutableTreeNode parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(Term n, DefaultMutableTreeNode parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(Op_high n, DefaultMutableTreeNode parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visit(Factor n, DefaultMutableTreeNode parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
