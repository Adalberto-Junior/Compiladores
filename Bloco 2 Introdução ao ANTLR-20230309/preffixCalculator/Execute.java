@SuppressWarnings("CheckReturnValue")
public class Execute extends PreffixCalculatorBaseVisitor<Double> {


   @Override public Double visitStat(PreffixCalculatorParser.StatContext ctx) {
	 Double res = visit(ctx.expr());
      	 System.out.println("Result =  " + res);
      	 return res;

   }


   @Override public Double visitExprNumber(PreffixCalculatorParser.ExprNumberContext ctx) {
   
	  return Double.parseDouble(ctx.Number().getText());
      
   }

   @Override public Double visitExprPreffix(PreffixCalculatorParser.ExprPreffixContext ctx) {
   
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
