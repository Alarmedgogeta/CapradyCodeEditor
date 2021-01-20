//
// Generated by JTB 1.3.2
//

package syntaxtree;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Grammar production:
 * f0 -> "*"
 *       | "/"
 */
public class Op_high implements Node {
   public NodeChoice f0;

   public Op_high(NodeChoice n0) {
      f0 = n0;
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

