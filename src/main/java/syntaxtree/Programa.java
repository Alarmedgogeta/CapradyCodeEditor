//
// Generated by JTB 1.3.2
//

package syntaxtree;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Grammar production:
 * f0 -> <MAIN>
 * f1 -> <KEY1>
 * f2 -> ( Sentencia() )*
 * f3 -> <KEY2>
 * f4 -> <EOF>
 */
public class Programa implements Node {
   public NodeToken f0;
   public NodeToken f1;
   public NodeListOptional f2;
   public NodeToken f3;
   public NodeToken f4;

   public Programa(NodeToken n0, NodeToken n1, NodeListOptional n2, NodeToken n3, NodeToken n4) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
      f3 = n3;
      f4 = n4;
   }

   public Programa(NodeListOptional n0) {
      f0 = new NodeToken("principal");
      f1 = new NodeToken("{");
      f2 = n0;
      f3 = new NodeToken("}");
      f4 = new NodeToken("");
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

