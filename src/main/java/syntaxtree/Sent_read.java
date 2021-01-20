//
// Generated by JTB 1.3.2
//

package syntaxtree;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Grammar production:
 * f0 -> <READ>
 * f1 -> <PAR1>
 * f2 -> <ID>
 * f3 -> <PAR2>
 */
public class Sent_read implements Node {
   public NodeToken f0;
   public NodeToken f1;
   public NodeToken f2;
   public NodeToken f3;

   public Sent_read(NodeToken n0, NodeToken n1, NodeToken n2, NodeToken n3) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
      f3 = n3;
   }

   public Sent_read(NodeToken n0) {
      f0 = new NodeToken("leer");
      f1 = new NodeToken("(");
      f2 = n0;
      f3 = new NodeToken(")");
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

