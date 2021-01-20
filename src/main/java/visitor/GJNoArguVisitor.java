//
// Generated by JTB 1.3.2
//

package visitor;
import syntaxtree.*;
import java.util.*;

/**
 * All GJ visitors with no argument must implement this interface.
 */

public interface GJNoArguVisitor<R> {

   //
   // GJ Auto class visitors with no argument
   //

   public R visit(NodeList n);
   public R visit(NodeListOptional n);
   public R visit(NodeOptional n);
   public R visit(NodeSequence n);
   public R visit(NodeToken n);

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
   public R visit(Tokens n);

   /**
    * f0 -> <MAIN>
    * f1 -> <KEY1>
    * f2 -> ( Sentencia() )*
    * f3 -> <KEY2>
    * f4 -> <EOF>
    */
   public R visit(Programa n);

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
   public R visit(Sentencia n);

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
   public R visit(Sent_if n);

   /**
    * f0 -> <WHILE>
    * f1 -> <PAR1>
    * f2 -> Exp()
    * f3 -> <PAR2>
    * f4 -> <KEY1>
    * f5 -> ( Sentencia() )*
    * f6 -> <KEY2>
    */
   public R visit(Sent_while n);

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
   public R visit(Sent_for n);

   /**
    * f0 -> Tipo()
    * f1 -> <ID>
    * f2 -> ( <ASIGNATION> Exp() ( <TERNARY> Exp() <ALTERNATIVE> Exp() )? )?
    */
   public R visit(Declaration n);

   /**
    * f0 -> <TYPEINT>
    *       | <TYPEFLOAT>
    */
   public R visit(Tipo n);

   /**
    * f0 -> <READ>
    * f1 -> <PAR1>
    * f2 -> <ID>
    * f3 -> <PAR2>
    */
   public R visit(Sent_read n);

   /**
    * f0 -> <WRITE>
    * f1 -> <PAR1>
    * f2 -> <STRING>
    * f3 -> ( Exp() )?
    * f4 -> <PAR2>
    */
   public R visit(Sent_write n);

   /**
    * f0 -> <ID>
    * f1 -> <ASIGNATION>
    * f2 -> Exp()
    * f3 -> ( <TERNARY> Exp() <ALTERNATIVE> Exp() )?
    */
   public R visit(Asignation n);

   /**
    * f0 -> Exp_simple()
    * f1 -> ( Op_comparation() Exp_simple() )?
    */
   public R visit(Exp n);

   /**
    * f0 -> <SMALLERTHEN>
    *       | <GREATERTHEN>
    *       | <SMALLEREQUALTHEN>
    *       | <GREATEREQUALTHEN>
    *       | <EQUALS>
    *       | <NOTEQUALS>
    */
   public R visit(Op_comparation n);

   /**
    * f0 -> Term()
    * f1 -> ( Op_low() Term() )*
    */
   public R visit(Exp_simple n);

   /**
    * f0 -> "+"
    *       | "-"
    */
   public R visit(Op_low n);

   /**
    * f0 -> Factor()
    * f1 -> ( Op_high() Factor() )*
    */
   public R visit(Term n);

   /**
    * f0 -> "*"
    *       | "/"
    */
   public R visit(Op_high n);

   /**
    * f0 -> <PAR1> Exp() <PAR2>
    *       | <FLOAT>
    *       | <INTEGER>
    *       | <ID>
    */
   public R visit(Factor n);

}

