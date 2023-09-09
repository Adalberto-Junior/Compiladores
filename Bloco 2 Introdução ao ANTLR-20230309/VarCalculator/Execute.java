import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("CheckReturnValue")
public class Execute extends VarCalculatorBaseVisitor<String> {
    Map<String,Double> myMap = new HashMap();

   @Override public String visitProgram(VarCalculatorParser.ProgramContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitStatAssignment(VarCalculatorParser.StatAssignmentContext ctx) {
      //Double value = Double.parseDouble(visit(ctx.expr()));
     // String key = ctx.ID().getText();
      
      String key = visit(ctx.assignment());
      System.out.println("Result = " + myMap.get(key));
      //System.out.println();
      return key;
   }

   @Override public String visitStatExpr(VarCalculatorParser.StatExprContext ctx) {
      
      String res = visit(ctx.expr());
      if(myMap.containsKey(res))
        System.out.println("Result = " + myMap.get(res));
      else
        System.out.println("Result = " + res);

      return res;

   }

   @Override public String visitStatNone(VarCalculatorParser.StatNoneContext ctx) {
      String res = null;
      return visitChildren(ctx);
      //return res;
   }

   @Override public String visitAssignment(VarCalculatorParser.AssignmentContext ctx) {
      //String res = null;
     // return visitChildren(ctx);
      //return res;
      Double value = Double.parseDouble(visit(ctx.expr()));
      String key = ctx.ID().getText();

      myMap.put(key,value);
      return key;
   }

   @Override public String visitExprAddSub(VarCalculatorParser.ExprAddSubContext ctx) {
      Double res = null;
      String n1 = visit(ctx.expr(0));
      String n2 = visit(ctx.expr(1));

      switch(ctx.op.getText()){
           case "-":
               try{
                   res = Double.parseDouble(n1) - Double.parseDouble(n2);
                }catch(Exception a){
                   try{
                      res = myMap.get(n1) - Double.parseDouble(n2);
                   }catch(Exception b){
                     try{
                        res = Double.parseDouble(n1) - myMap.get(n2);
                      }catch(Exception c){
                        try{
                           res = myMap.get(n1) - myMap.get(n2);

                          }catch(Exception d){
                           System.out.println("Erro no input!");
                          }
                      }
                   }
                }
             break;
           default:
                try{
                   res = Double.parseDouble(n1) + Double.parseDouble(n2);
                }catch(Exception a){
                   try{
                      res = myMap.get(n1) + Double.parseDouble(n2);
                   }catch(Exception b){
                     try{
                        res = Double.parseDouble(n1) + myMap.get(n2);
                      }catch(Exception c){
                        try{
                           res = myMap.get(n1) +  myMap.get(n2);
                          }catch(Exception d){
                           System.out.println("Erro no input!");
                          }
                      }
                   }
                }
        }
      return String.valueOf(res);
   }

   @Override public String visitExprUnario(VarCalculatorParser.ExprUnarioContext ctx) {
      //String res = null;
      //return visitChildren(ctx);
      //return res;
      String exprVar = visit(ctx.expr());
      switch(ctx.op.getText()){
         case "-":
                if(myMap.containsKey(exprVar)) // é uma ID; 
               	   return String.valueOf(-myMap.get(exprVar));
                else
                   return String.valueOf(-Double.parseDouble(exprVar));
          //break;
         default:
                 if(myMap.containsKey(exprVar)) // é uma ID; 
                   return String.valueOf(myMap.get(exprVar));
                else
                   return String.valueOf(exprVar);
         // break;
        }
   }

   @Override public String visitExprNumb(VarCalculatorParser.ExprNumbContext ctx) {
      return ctx.Number().getText();
   }

   @Override public String visitExprParent(VarCalculatorParser.ExprParentContext ctx) {
      return visit(ctx.expr());
   }

   @Override public String visitExprId(VarCalculatorParser.ExprIdContext ctx) {
      return ctx.ID().getText();
   }

   @Override public String visitExprMultDivMod(VarCalculatorParser.ExprMultDivModContext ctx) {
      Double res = null;
      String n1 = visit(ctx.expr(0));
      String n2 = visit(ctx.expr(1));
     
      switch(ctx.op.getText()){
           case "%":
               try{

                   if(Double.parseDouble(n2) != 0)
                      res = Double.parseDouble(n1) % Double.parseDouble(n2);
                   else
                      System.out.println("ERR: Divide by zero!");

                }catch(Exception a){

                   try{
                      if(Double.parseDouble(n2) != 0)
                         res = myMap.get(n1) % Double.parseDouble(n2);
                      else
                         System.out.println("ERR: Divide by zero!");
                  
                   }catch(Exception b){

                     try{

                        if(myMap.get(n2) != 0)
                           res = Double.parseDouble(n1) % myMap.get(n2);
                        else
                           System.out.println("ERR: Divide by zero!");
                        
                      }catch(Exception c){

                        try{

                           if(myMap.get(n2) != 0)
                              res = myMap.get(n1) % myMap.get(n2);
                           else
                              System.out.println("ERR: Divide by zero!");

                          }catch(Exception d){
                           System.out.println("Erro no input!");
                          }
                      }
                   }
                }
             break;
           case "/":
               try{

                   if(Double.parseDouble(n2) != 0)
                      res = Double.parseDouble(n1) / Double.parseDouble(n2);
                   else
                      System.out.println("ERR: Divide by zero!");

                }catch(Exception a){

                   try{
                      if(Double.parseDouble(n2) != 0)
                         res = myMap.get(n1) / Double.parseDouble(n2);
                      else
                         System.out.println("ERR: Divide by zero!");

                   }catch(Exception b){

                     try{

                        if(myMap.get(n2) != 0)
                           res = Double.parseDouble(n1) / myMap.get(n2);
                        else
                           System.out.println("ERR: Divide by zero!");

                      }catch(Exception c){

                        try{

                           if(myMap.get(n2) != 0)
                              res = myMap.get(n1) / myMap.get(n2);
                           else
                              System.out.println("ERR: Divide by zero!");

                          }catch(Exception d){
                           System.out.println("Erro no input!");
                          }
                      }
                   }
                }
             break;
           default:
                try{
                   res = Double.parseDouble(n1) * Double.parseDouble(n2);
                }catch(Exception a){
                   try{
                      res = myMap.get(n1) * Double.parseDouble(n2);
                   }catch(Exception b){
                     try{
                        res = Double.parseDouble(n1) * myMap.get(n2);
                      }catch(Exception c){
                        try{
                           res = myMap.get(n1) *  myMap.get(n2);
                          }catch(Exception d){
                           System.out.println("Erro no input!");
                          }
                      }
                   }
                }
        }
      return String.valueOf(res);
   }
}
