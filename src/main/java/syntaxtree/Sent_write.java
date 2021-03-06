//
// Generated by JTB 1.3.2
//

package syntaxtree;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Grammar production:
 * f0 -> <WRITE>
 * f1 -> <PAR1>
 * f2 -> <STRING>
 * f3 -> ( Exp() )?
 * f4 -> <PAR2>
 */
public class Sent_write implements Node {
   public NodeToken f0;
   public NodeToken f1;
   public NodeToken f2;
   public NodeOptional f3;
   public NodeToken f4;

   public Sent_write(NodeToken n0, NodeToken n1, NodeToken n2, NodeOptional n3, NodeToken n4) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
      f3 = n3;
      f4 = n4;
   }

   public Sent_write(NodeOptional n0) {
      f0 = new NodeToken("escribir");
      f1 = new NodeToken("(");
      f2 = new NodeToken("\"");
      f3 = n0;
      f4 = new NodeToken(")");
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

