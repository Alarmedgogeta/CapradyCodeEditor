//
// Generated by JTB 1.3.2
//

package syntaxtree;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Grammar production:
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
public class Sent_for implements Node {
   public NodeToken f0;
   public NodeToken f1;
   public Asignation f2;
   public NodeToken f3;
   public Exp f4;
   public NodeToken f5;
   public Asignation f6;
   public NodeToken f7;
   public NodeToken f8;
   public NodeToken f9;
   public NodeListOptional f10;
   public NodeToken f11;

   public Sent_for(NodeToken n0, NodeToken n1, Asignation n2, NodeToken n3, Exp n4, NodeToken n5, Asignation n6, NodeToken n7, NodeToken n8, NodeToken n9, NodeListOptional n10, NodeToken n11) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
      f3 = n3;
      f4 = n4;
      f5 = n5;
      f6 = n6;
      f7 = n7;
      f8 = n8;
      f9 = n9;
      f10 = n10;
      f11 = n11;
   }

   public Sent_for(Asignation n0, Exp n1, Asignation n2, NodeListOptional n3) {
      f0 = new NodeToken("para");
      f1 = new NodeToken("(");
      f2 = n0;
      f3 = new NodeToken(";");
      f4 = n1;
      f5 = new NodeToken(";");
      f6 = n2;
      f7 = new NodeToken(";");
      f8 = new NodeToken(")");
      f9 = new NodeToken("{");
      f10 = n3;
      f11 = new NodeToken("}");
   }

   public void accept(visitor.Visitor v) {
      v.visit(this);
   }
   public void accept(visitor.Visitor v, DefaultMutableTreeNode parent) {
      v.visit(this, parent);
   }
   public <R,A> R accept(visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <R> R accept(visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
}

