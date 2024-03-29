import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("CheckReturnValue")
public class Execute extends VarCalculatorBaseVisitor<Integer> {

   Map<String,Integer> myMap = new HashMap();
   @Override public Integer visitStatAssignment(VarCalculatorParser.StatAssignmentContext ctx) {
      Integer value = visit(ctx.expr());
      String key = visit(ctx.ID().getText);
      if (!myMap.containsKey(key))
          myMap.put(key,value);
      else
	  myMap.put(myMap.get(key),value);
 

      return myMap.get(key);
      //return res;
   }

   @Override public Integer visitStatExpr(VarCalculatorParser.StatExprContext ctx) {
      Integer res = visit(ctx.expr());
      System.out.println("Result = " + res);
      return res;
   }

   @Override public Integer visitStatNone(VarCalculatorParser.StatNoneContext ctx) {
      Integer res = visit(ctx.NEWLINE().getText());
      return res;
   }

   @Override public Integer visitAssignment(VarCalculatorParser.AssignmentContext ctx) {
      Integer res = visit(ctx.assignment());
      return res;
   }

   @Override public Integer visitExprAddSub(VarCalculatorParser.ExprAddSubContext ctx) {
      Integer res = null;
      Integer n1 = visit(ctx.expr(0));
      Integer n2 = visit(ctx.expr(1));
      switch(ctx.op.getText()){
	   case "-":
		res = n1 - n2;
	   break;
	   default:
		res = n1 + n2;
	}
      return res;
   }

   @Override public Integer visitExprUnario(VarCalculatorParser.ExprUnarioContext ctx) {
      //Integer res = null;
      switch(ctx.op.getText()){
	 case "-":
		return -visit(ctx.expr());
	  break;
	 default:
		return visit(ctx.expr());
	  break;
	}
      return res;
   }

   @Override public Integer visitExprParent(VarCalculatorParser.ExprParentContext ctx) {
      return visit(ctx.expr());
   }

   @Override public Integer visitExprInteger(VarCalculatorParser.ExprIntegerContext ctx) {
      return Integer.parseInt(ctx.Integer().getText());
   }

   @Override public Integer visitExprId(VarCalculatorParser.ExprIdContext ctx) {
      //Integer res = null;
      //return visitChildren(ctx);
      return visit(ctx.ID().getText());
   }

   @Override public Integer visitExprMultDivMod(VarCalculatorParser.ExprMultDivModContext ctx) {
      Integer res = null;
      Integer n1 = visit(ctx.expr(0));
      Integer n2 = visit(ctx.expr(1));
     switch(ctx.op.getText()) {
           case "*":
                    res = n1 * n2;
             break;
           case "/":
                   if (n2 != 0)
                       res = n1 / n2;
                   else
                      System.err.println("Err: Divide by zero!");
             break;
           default:
		if (n2 != 0)
                      res = n1 % n2;
                   else
                      System.err.println("Err: Divide by zero!");
             break;
      }
      return res;
   }

}
