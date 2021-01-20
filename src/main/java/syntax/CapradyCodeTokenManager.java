package syntax;
/* Generated By:JavaCC: Do not edit this line. CapradyCodeTokenManager.java */
import syntaxtree.*;
import java.util.Vector;

/** Token Manager. */
public class CapradyCodeTokenManager implements CapradyCodeConstants
{

  /** Debug output. */
  public  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x3ffeL) != 0L)
         {
            jjmatchedKind = 41;
            return 4;
         }
         if ((active0 & 0x40000L) != 0L)
            return 15;
         if ((active0 & 0xc000L) != 0L)
            return 23;
         return -1;
      case 1:
         if ((active0 & 0xeL) != 0L)
            return 4;
         if ((active0 & 0x3ff0L) != 0L)
         {
            if (jjmatchedPos != 1)
            {
               jjmatchedKind = 41;
               jjmatchedPos = 1;
            }
            return 4;
         }
         return -1;
      case 2:
         if ((active0 & 0x3ffcL) != 0L)
         {
            jjmatchedKind = 41;
            jjmatchedPos = 2;
            return 4;
         }
         return -1;
      case 3:
         if ((active0 & 0x11acL) != 0L)
            return 4;
         if ((active0 & 0x2e50L) != 0L)
         {
            if (jjmatchedPos != 3)
            {
               jjmatchedKind = 41;
               jjmatchedPos = 3;
            }
            return 4;
         }
         return -1;
      case 4:
         if ((active0 & 0x2f50L) != 0L)
         {
            jjmatchedKind = 41;
            jjmatchedPos = 4;
            return 4;
         }
         return -1;
      case 5:
         if ((active0 & 0x410L) != 0L)
            return 4;
         if ((active0 & 0x2b40L) != 0L)
         {
            jjmatchedKind = 41;
            jjmatchedPos = 5;
            return 4;
         }
         return -1;
      case 6:
         if ((active0 & 0x2b40L) != 0L)
         {
            jjmatchedKind = 41;
            jjmatchedPos = 6;
            return 4;
         }
         return -1;
      case 7:
         if ((active0 & 0x2b00L) != 0L)
            return 4;
         if ((active0 & 0x40L) != 0L)
         {
            jjmatchedKind = 41;
            jjmatchedPos = 7;
            return 4;
         }
         return -1;
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 33:
         return jjMoveStringLiteralDfa1_0(0x1000000L);
      case 40:
         return jjStopAtPos(0, 32);
      case 41:
         return jjStopAtPos(0, 33);
      case 42:
         jjmatchedKind = 16;
         return jjMoveStringLiteralDfa1_0(0x20000L);
      case 43:
         return jjStartNfaWithStates_0(0, 14, 23);
      case 44:
         return jjStopAtPos(0, 29);
      case 45:
         return jjStartNfaWithStates_0(0, 15, 23);
      case 47:
         return jjStartNfaWithStates_0(0, 18, 15);
      case 58:
         return jjStopAtPos(0, 27);
      case 59:
         return jjStopAtPos(0, 28);
      case 60:
         jjmatchedKind = 20;
         return jjMoveStringLiteralDfa1_0(0x400000L);
      case 61:
         jjmatchedKind = 25;
         return jjMoveStringLiteralDfa1_0(0x800000L);
      case 62:
         jjmatchedKind = 19;
         return jjMoveStringLiteralDfa1_0(0x200000L);
      case 63:
         return jjStopAtPos(0, 26);
      case 99:
         return jjMoveStringLiteralDfa1_0(0x20L);
      case 101:
         return jjMoveStringLiteralDfa1_0(0x2400L);
      case 102:
         return jjMoveStringLiteralDfa1_0(0x800L);
      case 108:
         return jjMoveStringLiteralDfa1_0(0x1000L);
      case 109:
         return jjMoveStringLiteralDfa1_0(0x200L);
      case 112:
         return jjMoveStringLiteralDfa1_0(0x1c0L);
      case 115:
         return jjMoveStringLiteralDfa1_0(0x1eL);
      case 123:
         return jjStopAtPos(0, 30);
      case 125:
         return jjStopAtPos(0, 31);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
private int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 42:
         if ((active0 & 0x20000L) != 0L)
            return jjStopAtPos(1, 17);
         break;
      case 61:
         if ((active0 & 0x200000L) != 0L)
            return jjStopAtPos(1, 21);
         else if ((active0 & 0x400000L) != 0L)
            return jjStopAtPos(1, 22);
         else if ((active0 & 0x800000L) != 0L)
            return jjStopAtPos(1, 23);
         else if ((active0 & 0x1000000L) != 0L)
            return jjStopAtPos(1, 24);
         break;
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x1a0L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x1000L);
      case 105:
         if ((active0 & 0x2L) != 0L)
         {
            jjmatchedKind = 1;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_0(active0, 0x20cL);
      case 108:
         return jjMoveStringLiteralDfa2_0(active0, 0x800L);
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0x400L);
      case 114:
         return jjMoveStringLiteralDfa2_0(active0, 0x40L);
      case 115:
         return jjMoveStringLiteralDfa2_0(active0, 0x2000L);
      case 119:
         return jjMoveStringLiteralDfa2_0(active0, 0x10L);
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
private int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 99:
         return jjMoveStringLiteralDfa3_0(active0, 0x2000L);
      case 101:
         return jjMoveStringLiteralDfa3_0(active0, 0x1200L);
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0x50L);
      case 110:
         return jjMoveStringLiteralDfa3_0(active0, 0xcL);
      case 111:
         return jjMoveStringLiteralDfa3_0(active0, 0x800L);
      case 114:
         return jjMoveStringLiteralDfa3_0(active0, 0x180L);
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x20L);
      case 116:
         return jjMoveStringLiteralDfa3_0(active0, 0x400L);
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
private int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 97:
         if ((active0 & 0x80L) != 0L)
         {
            jjmatchedKind = 7;
            jjmatchedPos = 3;
         }
         return jjMoveStringLiteralDfa4_0(active0, 0x100L);
      case 101:
         return jjMoveStringLiteralDfa4_0(active0, 0x400L);
      case 110:
         return jjMoveStringLiteralDfa4_0(active0, 0x240L);
      case 111:
         if ((active0 & 0x4L) != 0L)
         {
            jjmatchedKind = 2;
            jjmatchedPos = 3;
         }
         else if ((active0 & 0x20L) != 0L)
            return jjStartNfaWithStates_0(3, 5, 4);
         return jjMoveStringLiteralDfa4_0(active0, 0x8L);
      case 114:
         if ((active0 & 0x1000L) != 0L)
            return jjStartNfaWithStates_0(3, 12, 4);
         return jjMoveStringLiteralDfa4_0(active0, 0x2000L);
      case 116:
         return jjMoveStringLiteralDfa4_0(active0, 0x810L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
private int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 32:
         return jjMoveStringLiteralDfa5_0(active0, 0x8L);
      case 97:
         return jjMoveStringLiteralDfa5_0(active0, 0x800L);
      case 99:
         return jjMoveStringLiteralDfa5_0(active0, 0x150L);
      case 105:
         return jjMoveStringLiteralDfa5_0(active0, 0x2000L);
      case 114:
         return jjMoveStringLiteralDfa5_0(active0, 0x400L);
      case 116:
         return jjMoveStringLiteralDfa5_0(active0, 0x200L);
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
private int jjMoveStringLiteralDfa5_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa6_0(active0, 0x100L);
      case 98:
         return jjMoveStringLiteralDfa6_0(active0, 0x2000L);
      case 104:
         if ((active0 & 0x10L) != 0L)
            return jjStartNfaWithStates_0(5, 4, 4);
         break;
      case 105:
         return jjMoveStringLiteralDfa6_0(active0, 0x40L);
      case 110:
         return jjMoveStringLiteralDfa6_0(active0, 0x800L);
      case 111:
         if ((active0 & 0x400L) != 0L)
            return jjStartNfaWithStates_0(5, 10, 4);
         break;
      case 114:
         return jjMoveStringLiteralDfa6_0(active0, 0x200L);
      case 115:
         return jjMoveStringLiteralDfa6_0(active0, 0x8L);
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
private int jjMoveStringLiteralDfa6_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0);
      return 6;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa7_0(active0, 0x200L);
      case 100:
         return jjMoveStringLiteralDfa7_0(active0, 0x100L);
      case 105:
         if ((active0 & 0x8L) != 0L)
            return jjStopAtPos(6, 3);
         return jjMoveStringLiteralDfa7_0(active0, 0x2000L);
      case 112:
         return jjMoveStringLiteralDfa7_0(active0, 0x40L);
      case 116:
         return jjMoveStringLiteralDfa7_0(active0, 0x800L);
      default :
         break;
   }
   return jjStartNfa_0(5, active0);
}
private int jjMoveStringLiteralDfa7_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0);
      return 7;
   }
   switch(curChar)
   {
      case 97:
         if ((active0 & 0x100L) != 0L)
            return jjStartNfaWithStates_0(7, 8, 4);
         return jjMoveStringLiteralDfa8_0(active0, 0x40L);
      case 101:
         if ((active0 & 0x800L) != 0L)
            return jjStartNfaWithStates_0(7, 11, 4);
         break;
      case 114:
         if ((active0 & 0x2000L) != 0L)
            return jjStartNfaWithStates_0(7, 13, 4);
         break;
      case 115:
         if ((active0 & 0x200L) != 0L)
            return jjStartNfaWithStates_0(7, 9, 4);
         break;
      default :
         break;
   }
   return jjStartNfa_0(6, active0);
}
private int jjMoveStringLiteralDfa8_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(6, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(7, active0);
      return 8;
   }
   switch(curChar)
   {
      case 108:
         if ((active0 & 0x40L) != 0L)
            return jjStartNfaWithStates_0(8, 6, 4);
         break;
      default :
         break;
   }
   return jjStartNfa_0(7, active0);
}
private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static final long[] jjbitVec0 = {
   0xfffffffffffffffeL, 0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static final long[] jjbitVec2 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 23;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 36)
                        kind = 36;
                     jjCheckNAddStates(0, 2);
                  }
                  else if ((0x280000000000L & l) != 0L)
                     jjCheckNAddTwoStates(6, 7);
                  else if (curChar == 47)
                     jjAddStates(3, 4);
                  else if (curChar == 34)
                     jjCheckNAddTwoStates(1, 2);
                  break;
               case 15:
                  if (curChar == 42)
                     jjstateSet[jjnewStateCnt++] = 21;
                  if (curChar == 42)
                     jjstateSet[jjnewStateCnt++] = 12;
                  break;
               case 23:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(7, 8);
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 36)
                        kind = 36;
                     jjCheckNAdd(6);
                  }
                  break;
               case 1:
                  if ((0xfffffffbffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(1, 2);
                  break;
               case 2:
                  if (curChar == 34 && kind > 38)
                     kind = 38;
                  break;
               case 4:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 41)
                     kind = 41;
                  jjstateSet[jjnewStateCnt++] = 4;
                  break;
               case 5:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAddTwoStates(6, 7);
                  break;
               case 6:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 36)
                     kind = 36;
                  jjCheckNAdd(6);
                  break;
               case 7:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(7, 8);
                  break;
               case 8:
                  if (curChar == 46)
                     jjCheckNAdd(9);
                  break;
               case 9:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 37)
                     kind = 37;
                  jjCheckNAdd(9);
                  break;
               case 10:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 36)
                     kind = 36;
                  jjCheckNAddStates(0, 2);
                  break;
               case 11:
                  if (curChar == 47)
                     jjAddStates(3, 4);
                  break;
               case 12:
                  if (curChar == 42)
                     jjCheckNAddTwoStates(13, 14);
                  break;
               case 13:
                  if ((0xfffffffffffffbffL & l) != 0L)
                     jjCheckNAddTwoStates(13, 14);
                  break;
               case 14:
                  if (curChar == 10 && kind > 39)
                     kind = 39;
                  break;
               case 16:
                  if (curChar == 42)
                     jjCheckNAddTwoStates(17, 20);
                  break;
               case 17:
                  if ((0xffff7bffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(17, 20);
                  break;
               case 18:
                  if (curChar == 47 && kind > 40)
                     kind = 40;
                  break;
               case 19:
                  if (curChar == 42)
                     jjstateSet[jjnewStateCnt++] = 18;
                  break;
               case 20:
                  if (curChar == 42)
                     jjstateSet[jjnewStateCnt++] = 19;
                  break;
               case 21:
                  if (curChar == 42)
                     jjstateSet[jjnewStateCnt++] = 16;
                  break;
               case 22:
                  if (curChar == 42)
                     jjstateSet[jjnewStateCnt++] = 21;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
               case 4:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 41)
                     kind = 41;
                  jjCheckNAdd(4);
                  break;
               case 1:
                  jjAddStates(5, 6);
                  break;
               case 13:
                  jjAddStates(7, 8);
                  break;
               case 17:
                  jjAddStates(9, 10);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int hiByte = (int)(curChar >> 8);
         int i1 = hiByte >> 6;
         long l1 = 1L << (hiByte & 077);
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 1:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjAddStates(5, 6);
                  break;
               case 13:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjAddStates(7, 8);
                  break;
               case 17:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjAddStates(9, 10);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 23 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   6, 7, 8, 15, 22, 1, 2, 13, 14, 17, 20, 
};
private static final boolean jjCanMove_0(int hiByte, int i1, int i2, long l1, long l2)
{
   switch(hiByte)
   {
      case 0:
         return ((jjbitVec2[i2] & l2) != 0L);
      default :
         if ((jjbitVec0[i1] & l1) != 0L)
            return true;
         return false;
   }
}

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", "\163\151", "\163\151\156\157", "\163\151\156\157\40\163\151", 
"\163\167\151\164\143\150", "\143\141\163\157", "\160\162\151\156\143\151\160\141\154", 
"\160\141\162\141", "\160\141\162\141\143\141\144\141", "\155\151\145\156\164\162\141\163", 
"\145\156\164\145\162\157", "\146\154\157\164\141\156\164\145", "\154\145\145\162", 
"\145\163\143\162\151\142\151\162", "\53", "\55", "\52", "\52\52", "\57", "\76", "\74", "\76\75", "\74\75", 
"\75\75", "\41\75", "\75", "\77", "\72", "\73", "\54", "\173", "\175", "\50", "\51", 
null, null, null, null, null, null, null, null, null, null, null, null, };

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};
static final long[] jjtoToken = {
   0x3f3ffffffffL, 
};
static final long[] jjtoSkip = {
   0x3c0000000000L, 
};
protected JavaCharStream input_stream;
private final int[] jjrounds = new int[23];
private final int[] jjstateSet = new int[46];
protected char curChar;
/** Constructor. */
public CapradyCodeTokenManager(JavaCharStream stream){
   if (JavaCharStream.staticFlag)
      throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
   input_stream = stream;
}

/** Constructor. */
public CapradyCodeTokenManager(JavaCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}

/** Reinitialise parser. */
public void ReInit(JavaCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 23; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise parser. */
public void ReInit(JavaCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
public void SwitchTo(int lexState)
{
   if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

/** Get the next Token. */
public Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   try { input_stream.backup(0);
      while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

}
