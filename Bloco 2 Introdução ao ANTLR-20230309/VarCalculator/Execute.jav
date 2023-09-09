import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("CheckReturnValue")
public class Execute extends VarCalculatorBaseVisitor<Double> {
	Map<String,Double> myMap = new HashMap();
/*
   @Override public Double visitProgram(VarCalculatorParser.ProgramContext ctx) {
     
      Double value = visit(ctx.expr());
      String key = visit(ctx.ID().getText);
      if (!myMap.containsKey(key))
          myMap.put(key,value);
      else
          myMap.put(myMap.get(key),value);


      return myMap.get(key);

   }
*/

   @Override public Double visitStatAssignment(VarCalculatorParser.StatAssignmentContext ctx) {
      Double value = visit(ctx.expr().Number());
      String key = visit(ctx.ID().getText());

     // Double res = visit(ctx.expr());
      System.out.printf("%s = %f ",key,value);
      System.out.println();
      return value;

   }

   @Override public Double visitStatExpr(VarCalculatorParser.StatExprContext ctx) {
      Double res = visit(ctx.expr());
      System.out.println("Result = " + res);
      return res;

   }
/*
   @Override public Double visitStatNone(VarCalculatorParser.StatNoneContext ctx) {
      Double res = null;
      return visitChildren(ctx);
      //return res;
   }
*/

   @Override public Double visitAssignment(VarCalculatorParser.AssignmentContext ctx) {
      Double value = visit(ctx.expr());
      String key = visit(ctx.ID().getText());
      if (!myMap.containsKey(key))
          myMap.put(key,value);
      else
          myMap.put(key,value);


      return myMap.get(key);

      //return res;
   }

   @Override public Double visitExprAddSub(VarCalculatorParser.ExprAddSubContext ctx) {
      Double res = null;
      Double n1 = visit(ctx.expr(0));
      Double n2 = visit(ctx.expr(1));
      switch(ctx.op.getText()){
           case "-":
                res = n1 - n2;
             break;
           default:
                res = n1 + n2;
        }
      return res;

   }

   @Override public Double visitExprUnario(VarCalculatorParser.ExprUnarioContext ctx) {
      switch(ctx.op.getText()){
         case "-":
                return -visit(ctx.expr());
          break;
         default:
                return visit(ctx.expr());
          break;
        }
      
   }

   @Override public Double visitExprNumb(VarCalculatorParser.ExprNumbContext ctx) {
      return Double.parseDouble(ctx.Number().getText());
   }

   @Override public Double visitExprParent(VarCalculatorParser.ExprParentContext ctx) {
       return visit(ctx.expr());

   }
/*
   @Override public Double visitExprId(VarCalculatorParser.ExprIdContext ctx) {
      return visit(ctx.ID().getText());
   }
*/
   @Override public Double visitExprMultDivMod(VarCalculatorParser.ExprMultDivModContext ctx) {
      Double res = null;
      Double n1 = visit(ctx.expr(0));
      Double n2 = visit(ctx.expr(1));
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
