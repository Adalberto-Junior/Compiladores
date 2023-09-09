@SuppressWarnings("CheckReturnValue")
public class Execute extends CalculatorBaseVisitor<Integer> {

   @Override public Integer visitStat(CalculatorParser.StatContext ctx) {
      Integer res = visit(ctx.expr());
      //return visitChildren(ctx);
      System.out.println("Result = " + res);
      return res;
   }

   @Override public Integer visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
      Integer res = null;	
      Integer n1 = visit(ctx.expr(0));
      Integer n2 = visit(ctx.expr(1));
     switch(ctx.op.getText()) {
	   case "+":
		    res = n1 + n2;
	     break;
	   case "-": 
		    res = n1 - n2;
	     break;
	   default:
		System.err.println("Operador invalid!");
	     break;
      }
      return res;
   }

   @Override public Integer visitExprUnario(CalculatorParser.ExprUnarioContext ctx) {
     switch(ctx.op.getText()) {
	   case "-": 
		    return -visit(ctx.expr()); 
	   default:
		    return visit(ctx.expr());
	     
      }
     
   }

   @Override public Integer visitExprParent(CalculatorParser.ExprParentContext ctx) {
      return visit(ctx.expr());
   }

   @Override public Integer visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
      return Integer.parseInt(ctx.Integer().getText());
   }

   @Override public Integer visitExprMultDivMod(CalculatorParser.ExprMultDivModContext ctx) {
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
	   case "%":
		   if (n2 != 0)
		      res = n1 % n2;
		   else
		      System.err.println("Err: Divide by zero!");
	      break;
	   default:
		System.err.println("Operador invalid!");
	     break;
      }
      return res;
   }
}






