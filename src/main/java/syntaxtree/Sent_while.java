//
// Generated by JTB 1.3.2
//

package syntaxtree;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Grammar production:
 * f0 -> <WHILE>
 * f1 -> <PAR1>
 * f2 -> Exp()
 * f3 -> <PAR2>
 * f4 -> <KEY1>
 * f5 -> ( Sentencia() )*
 * f6 -> <KEY2>
 */
public class Sent_while implements Node {
   public NodeToken f0;
   public NodeToken f1;
   public Exp f2;
   public NodeToken f3;
   public NodeToken f4;
   public NodeListOptional f5;
   public NodeToken f6;

   public Sent_while(NodeToken n0, NodeToken n1, Exp n2, NodeToken n3, NodeToken n4, NodeListOptional n5, NodeToken n6) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
      f3 = n3;
      f4 = n4;
      f5 = n5;
      f6 = n6;
   }

   public Sent_while(Exp n0, NodeListOptional n1) {
      f0 = new NodeToken("mientras");
      f1 = new NodeToken("(");
      f2 = n0;
      f3 = new NodeToken(")");
      f4 = new NodeToken("{");
      f5 = n1;
      f6 = new NodeToken("}");
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

