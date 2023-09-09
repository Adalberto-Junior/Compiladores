@SuppressWarnings("CheckReturnValue")
public class Execute extends SuffixCalculatorBaseVisitor<Double> {

   @Override public Double visitStat(SuffixCalculatorParser.StatContext ctx) {
      Double res = visit(ctx.expr());
      System.out.println("Result =  " + res);
      return res;
   }

   @Override public Double visitExprNumber(SuffixCalculatorParser.ExprNumberContext ctx) {
      return Double.parseDouble(ctx.Number().getText());
      //return number;
   }

   @Override public Double visitExprSuffix(SuffixCalculatorParser.ExprSuffixContext ctx) {
      Double res = null;
      Double n1 = visit(ctx.expr(0));
      Double n2 = visit(ctx.expr(1));
      
      switch(ctx.op.getText()){
	   case "*":
		   res = n1 * n2;
		break;
	   case "/":
		   if(n2 != 0){
			res = n1 / n2;
		   }
		   else
			System.err.println("Erro: Divisão por zerro");
	
		break;

	   case "+":
		   res = n1 + n2;
		break;

	   case "-":
		   res = n1 - n2;
		break;
	   default:
		  System.err.println("OPeração invalida!");
		break;
	}		      
      return res;
   }
}
