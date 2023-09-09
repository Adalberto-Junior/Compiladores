import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("CheckReturnValue")
public class Execute extends CFRBaseVisitor<String> {
   Map<String, String> myMap = new HashMap();

   @Override
   public String visitProgram(CFRParser.ProgramContext ctx) {
      String res = null;
      return visitChildren(ctx);
      // return res;
   }

   @Override
   public String visitStatAssignment(CFRParser.StatAssignmentContext ctx) {
      String key = visit(ctx.assignment());
      System.out.println("Result = " + myMap.get(key));
      // System.out.println();
      return key;

   }

   @Override
   public String visitStatPrint(CFRParser.StatPrintContext ctx) {
      String res = visit(ctx.expr());
      System.out.println("Result = " + res);
      // return visitChildren(ctx);
      return res;
   }

   @Override
   public String visitAssignment(CFRParser.AssignmentContext ctx) {
      String value = visit(ctx.expr());
      String key = ctx.ID().getText();
      myMap.put(key, value);
      return key;
   }

   @Override
   public String visitPrint(CFRParser.PrintContext ctx) {
      String res = visit(ctx.expr());
   }

   @Override public String visitExprAddSub(CFRParser.ExprAddSubContext ctx) {
      Double res = null;
      String Fraction= null;
      String n1 = visit(ctx.expr(0));
      String n2 = visit(ctx.expr(1));
      String fraN1[] = n1.split("/");
      String fraN2[] = n2.split("/");

      switch(ctx.op.getText()){
           case "-":
               try{
                   if(fraN1.length > 1){
		      if(fraN2.length > 1){
                        Double numerator1   = Double.parseDouble(fraN1[0]);
                        Double denominator1 = Double.parseDouble(fraN1[1]);
                        Double numerator2   = Double.parseDouble(fraN2[0]);
                        Double denominator2 = Double.parseDouble(fraN2[1]);
                      
                          if(denominator1 == denominator2){
                             res = numerator1 - numerator2;
			                   Fraction= String.valueOf(res) + "/" + fraN1[1];
			   }else{
                               Double newNumerator1 = numerator1 * denominator2;
			       Double newNumerator2 = numerator2 * denominator1;
			       Double fracDenominator = denominator1 * denominator2;
			       res = newNumerator1 - newNumerator2;
			       Fraction= String.valueOf(res) + "/" + String.valueOf(fracDenominator); 
                             }                           
   			}else{
                              Double numerator1   = Double.parseDouble(fraN1[0]);
   	                      Double denominator1 = Double.parseDouble(fraN1[1]);
        	              Double numerator2   = Double.parseDouble(fraN2[0]);
                              Double newNumerator2 = numerator2 * denominator1;
                  	      res = numerator1 - newNumerator2;
                              Fraction= String.valueOf(res) + "/" + fraN1[1];
			  }
		    }else if(fraN2.length > 1){
                              Double numerator1   = Double.parseDouble(fraN1[0]);
                              Double numerator2   = Double.parseDouble(fraN2[0]);
                              Double denominator2 = Double.parseDouble(fraN2[1]);
                              Double newNumerator1 = numerator1 * denominator2;
                              res = newNumerator1 - numerator2;
                              Fraction= String.valueOf(res) + "/" + fraN2[1];
		    }else{
                   	res = Double.parseDouble(n1) - Double.parseDouble(n2);
			            Fraction= String.valueOf(res) + "/" + "1"; //Parei aquiii! Agora é fazer a mesma coisa mas agora com o map, ver os Exception. Basta criar uma variavel para receber o myMap.get(n1) e dpois fazer tudo igaul, desde o String.split("/");
            }
                }catch(Exception a){
                   try{
                     // res = myMap.get(n1) - Double.parseDouble(n2);
			///Ver isso aqui! Talvez seja necessario criar nova variavel ou não quem sabe!
			   String newN1 = myMap.get(n1);
			   String fraN1[] = newN1.split("/");
			 if(fraN1.length > 1){
                     		 if(fraN2.length > 1){
                        	Double numerator1   = Double.parseDouble(fraN1[0]);
                        	Double denominator1 = Double.parseDouble(fraN1[1]);
                        	Double numerator2   = Double.parseDouble(fraN2[0]);
                        	Double denominator2 = Double.parseDouble(fraN2[1]);

                          	if(denominator1 == denominator2){
                             	res = numerator1 - numerator2;
                             	Fraction= String.valueOf(res) + "/" + fraN1[1];
                           	}else{
                               		Double newNumerator1 = numerator1 * denominator2;
                               		Double newNumerator2 = numerator2 * denominator1;
                               		Double fracDenominator = denominator1 * denominator2;
                               		res = newNumerator1 - newNumerator2;
                               		Fraction= String.valueOf(res) + "/" + String.valueOf(fracDenominator);
                            	 }
                       	 }else{
                              Double numerator1   = Double.parseDouble(fraN1[0]);
                              Double denominator1 = Double.parseDouble(fraN1[1]);
                              Double numerator2   = Double.parseDouble(fraN2[0]);
                              Double newNumerator2 = numerator2 * denominator1;
                              res = numerator1 - newNumerator2;
                              Fraction= String.valueOf(res) + "/" + fraN1[1];
                          }
                    }else if(fraN2.length > 1){
                              Double numerator1   = Double.parseDouble(fraN1[0]);
                              Double numerator2   = Double.parseDouble(fraN2[0]);
                              Double denominator2 = Double.parseDouble(fraN2[1]);
                              Double newNumerator1 = numerator1 * denominator2;
                              res = newNumerator1 - numerator2;
                              Fraction= String.valueOf(res) + "/" + fraN2[1];
                    }else{
                        res = Double.parseDouble(n1) - Double.parseDouble(n2);
                        Fraction= String.valueOf(res) + "/" + "1";
                    }

                   }catch(Exception b){
                     try{
                       // res = Double.parseDouble(n1) - myMap.get(n2);
                        String newN2 = myMap.get(n2);
                        String fraN2[] = newN2.split("/");
                         if(fraN1.length > 1){
                                 if(fraN2.length > 1){
                                Double numerator1   = Double.parseDouble(fraN1[0]);
                                Double denominator1 = Double.parseDouble(fraN1[1]);
                                Double numerator2   = Double.parseDouble(fraN2[0]);
                                Double denominator2 = Double.parseDouble(fraN2[1]);

                                if(denominator1 == denominator2){
                                res = numerator1 - numerator2;
                                Fraction= String.valueOf(res) + "/" + fraN1[1];
                                }else{
                                        Double newNumerator1 = numerator1 * denominator2;
                                        Double newNumerator2 = numerator2 * denominator1;
                                        Double fracDenominator = denominator1 * denominator2;
                                        res = newNumerator1 - newNumerator2;
                                        Fraction= String.valueOf(res) + "/" + String.valueOf(fracDenominator);
                                 }
                         }else{
                              Double numerator1   = Double.parseDouble(fraN1[0]);
                              Double denominator1 = Double.parseDouble(fraN1[1]);
                              Double numerator2   = Double.parseDouble(fraN2[0]);
                              Double newNumerator2 = numerator2 * denominator1;
                              res = numerator1 - newNumerator2;
                              Fraction= String.valueOf(res) + "/" + fraN1[1];
                          }
                    }else if(fraN2.length > 1){
                              Double numerator1   = Double.parseDouble(fraN1[0]);
                              Double numerator2   = Double.parseDouble(fraN2[0]);
                              Double denominator2 = Double.parseDouble(fraN2[1]);
                              Double newNumerator1 = numerator1 * denominator2;
                              res = newNumerator1 - numerator2;
                              Fraction= String.valueOf(res) + "/" + fraN2[1];
                    }else{
                        res = Double.parseDouble(n1) - Double.parseDouble(n2);
                        Fraction= String.valueOf(res) + "/" + "1";
                    }

                      }catch(Exception c){
                        try{
                          // res = myMap.get(n1) - myMap.get(n2);
                           String newN1 = myMap.get(n1);
                           String fraN1[] = newN1.split("/");
                           String newN2 = myMap.get(n2);
                           String fraN2[] = newN2.split("/");
                         if(fraN1.length > 1){
                                 if(fraN2.length > 1){
                                Double numerator1   = Double.parseDouble(fraN1[0]);
                                Double denominator1 = Double.parseDouble(fraN1[1]);
                                Double numerator2   = Double.parseDouble(fraN2[0]);
                                Double denominator2 = Double.parseDouble(fraN2[1]);

                                if(denominator1 == denominator2){
                                res = numerator1 - numerator2;
                                Fraction= String.valueOf(res) + "/" + fraN1[1];
                                }else{
                                        Double newNumerator1 = numerator1 * denominator2;
                                        Double newNumerator2 = numerator2 * denominator1;
                                        Double fracDenominator = denominator1 * denominator2;
                                        res = newNumerator1 - newNumerator2;
                                        Fraction= String.valueOf(res) + "/" + String.valueOf(fracDenominator);
                                 }
                         }else{
                              Double numerator1   = Double.parseDouble(fraN1[0]);
                              Double denominator1 = Double.parseDouble(fraN1[1]);
                              Double numerator2   = Double.parseDouble(fraN2[0]);
                              Double newNumerator2 = numerator2 * denominator1;
                              res = numerator1 - newNumerator2;
                              Fraction= String.valueOf(res) + "/" + fraN1[1];
                          }
                    }else if(fraN2.length > 1){
                              Double numerator1   = Double.parseDouble(fraN1[0]);
                              Double numerator2   = Double.parseDouble(fraN2[0]);
                              Double denominator2 = Double.parseDouble(fraN2[1]);
                              Double newNumerator1 = numerator1 * denominator2;
                              res = newNumerator1 - numerator2;
                              Fraction= String.valueOf(res) + "/" + fraN2[1];
                    }else{
                        res = Double.parseDouble(n1) - Double.parseDouble(n2);
                        Fraction= String.valueOf(res) + "/" + "1";


                          }catch(Exception d){
                           System.out.println("Erro no input!");
                          }
                      }
                   }
                }
             break;
           default:
               try{
                     if(fraN1.length > 1){
                        if(fraN2.length > 1){
                              Double numerator1   = Double.parseDouble(fraN1[0]);
                              Double denominator1 = Double.parseDouble(fraN1[1]);
                              Double numerator2   = Double.parseDouble(fraN2[0]);
                              Double denominator2 = Double.parseDouble(fraN2[1]);
                              
                              if(denominator1 == denominator2){
                                    res = numerator1 + numerator2;
                                    Fraction= String.valueOf(res) + "/" + fraN1[1];
                                 }else{
                                       Double newNumerator1 = numerator1 * denominator2;
                                       Double newNumerator2 = numerator2 * denominator1;
                                       Double fracDenominator = denominator1 * denominator2;
                                       res = newNumerator1 + newNumerator2;
                                       Fraction= String.valueOf(res) + "/" + String.valueOf(fracDenominator); 
                                    }                           
                        }else{
                              Double numerator1   = Double.parseDouble(fraN1[0]);
                              Double denominator1 = Double.parseDouble(fraN1[1]);
                              Double numerator2   = Double.parseDouble(fraN2[0]);
                              Double newNumerator2 = numerator2 * denominator1;
                              res = numerator1 + newNumerator2;
                              Fraction= String.valueOf(res) + "/" + fraN1[1];
                           }
                     }else if(fraN2.length > 1){
                           Double numerator1   = Double.parseDouble(fraN1[0]);
                           Double numerator2   = Double.parseDouble(fraN2[0]);
                           Double denominator2 = Double.parseDouble(fraN2[1]);
                           Double newNumerator1 = numerator1 * denominator2;
                           res = newNumerator1 + numerator2;
                           Fraction= String.valueOf(res) + "/" + fraN2[1];
                        }else{
                              res = Double.parseDouble(n1) + Double.parseDouble(n2);
                              Fraction= String.valueOf(res) + "/" + "1"; 
                           }
               }catch(Exception a){
                  try{
                     String newN1 = myMap.get(n1);
                     String fraN1[] = newN1.split("/");
                     if(fraN1.length > 1){
                        if(fraN2.length > 1){
                           Double numerator1   = Double.parseDouble(fraN1[0]);
                           Double denominator1 = Double.parseDouble(fraN1[1]);
                           Double numerator2   = Double.parseDouble(fraN2[0]);
                           Double denominator2 = Double.parseDouble(fraN2[1]);

                           if(denominator1 == denominator2){
                              res = numerator1 + numerator2;
                              Fraction= String.valueOf(res) + "/" + fraN1[1];
                           }else{
                                    Double newNumerator1 = numerator1 * denominator2;
                                    Double newNumerator2 = numerator2 * denominator1;
                                    Double fracDenominator = denominator1 * denominator2;
                                    res = newNumerator1 + newNumerator2;
                                    Fraction= String.valueOf(res) + "/" + String.valueOf(fracDenominator);
                              }
                        }else{
                           Double numerator1   = Double.parseDouble(fraN1[0]);
                           Double denominator1 = Double.parseDouble(fraN1[1]);
                           Double numerator2   = Double.parseDouble(fraN2[0]);
                           Double newNumerator2 = numerator2 * denominator1;
                           res = numerator1 + newNumerator2;
                           Fraction= String.valueOf(res) + "/" + fraN1[1];
                        }
                     }else if(fraN2.length > 1){
                              Double numerator1   = Double.parseDouble(fraN1[0]);
                              Double numerator2   = Double.parseDouble(fraN2[0]);
                              Double denominator2 = Double.parseDouble(fraN2[1]);
                              Double newNumerator1 = numerator1 * denominator2;
                              res = newNumerator1 + numerator2;
                              Fraction= String.valueOf(res) + "/" + fraN2[1];
                     }else{
                        res = Double.parseDouble(n1) + Double.parseDouble(n2);
                        Fraction= String.valueOf(res) + "/" + "1";
                     }
                  }catch(Exception b){
                     try{
                // res = Double.parseDouble(n1) - myMap.get(n2);
                        String newN2 = myMap.get(n2);
                        String fraN2[] = newN2.split("/");
                        if(fraN1.length > 1){
                              if(fraN2.length > 1){
                                    Double numerator1   = Double.parseDouble(fraN1[0]);
                                    Double denominator1 = Double.parseDouble(fraN1[1]);
                                    Double numerator2   = Double.parseDouble(fraN2[0]);
                                    Double denominator2 = Double.parseDouble(fraN2[1]);

                                    if(denominator1 == denominator2){
                                       res = numerator1 + numerator2;
                                       Fraction= String.valueOf(res) + "/" + fraN1[1];
                                    }else{
                                             Double newNumerator1 = numerator1 * denominator2;
                                             Double newNumerator2 = numerator2 * denominator1;
                                             Double fracDenominator = denominator1 * denominator2;
                                             res = newNumerator1 + newNumerator2;
                                             Fraction= String.valueOf(res) + "/" + String.valueOf(fracDenominator);
                                    }
                              }else{
                                 Double numerator1   = Double.parseDouble(fraN1[0]);
                                 Double denominator1 = Double.parseDouble(fraN1[1]);
                                 Double numerator2   = Double.parseDouble(fraN2[0]);
                                 Double newNumerator2 = numerator2 * denominator1;
                                 res = numerator1 + newNumerator2;
                                 Fraction= String.valueOf(res) + "/" + fraN1[1];
                              }
                        }else if(fraN2.length > 1){
                                 Double numerator1   = Double.parseDouble(fraN1[0]);
                                 Double numerator2   = Double.parseDouble(fraN2[0]);
                                 Double denominator2 = Double.parseDouble(fraN2[1]);
                                 Double newNumerator1 = numerator1 * denominator2;
                                 res = newNumerator1 + numerator2;
                                 Fraction= String.valueOf(res) + "/" + fraN2[1];
                        }else{
                           res = Double.parseDouble(n1) + Double.parseDouble(n2);
                           Fraction= String.valueOf(res) + "/" + "1";
                           }
               }catch(Exception c){
                 try{
                   // res = myMap.get(n1) - myMap.get(n2);
                    String newN1 = myMap.get(n1);
                    String fraN1[] = newN1.split("/");
                    String newN2 = myMap.get(n2);
                    String fraN2[] = newN2.split("/");
                  if(fraN1.length > 1){
                        if(fraN2.length > 1){
                              Double numerator1   = Double.parseDouble(fraN1[0]);
                              Double denominator1 = Double.parseDouble(fraN1[1]);
                              Double numerator2   = Double.parseDouble(fraN2[0]);
                              Double denominator2 = Double.parseDouble(fraN2[1]);

                              if(denominator1 == denominator2){
                                 res = numerator1 + numerator2;
                                 Fraction= String.valueOf(res) + "/" + fraN1[1];
                              }else{
                                       Double newNumerator1 = numerator1 * denominator2;
                                       Double newNumerator2 = numerator2 * denominator1;
                                       Double fracDenominator = denominator1 * denominator2;
                                       res = newNumerator1 + newNumerator2;
                                       Fraction= String.valueOf(res) + "/" + String.valueOf(fracDenominator);
                              }
                        }else{
                           Double numerator1   = Double.parseDouble(fraN1[0]);
                           Double denominator1 = Double.parseDouble(fraN1[1]);
                           Double numerator2   = Double.parseDouble(fraN2[0]);
                           Double newNumerator2 = numerator2 * denominator1;
                           res = numerator1 + newNumerator2;
                           Fraction= String.valueOf(res) + "/" + fraN1[1];
                        }
                  }else if(fraN2.length > 1){
                           Double numerator1   = Double.parseDouble(fraN1[0]);
                           Double numerator2   = Double.parseDouble(fraN2[0]);
                           Double denominator2 = Double.parseDouble(fraN2[1]);
                           Double newNumerator1 = numerator1 * denominator2;
                           res = newNumerator1 + numerator2;
                           Fraction= String.valueOf(res) + "/" + fraN2[1];
                  }else{
                     res = Double.parseDouble(n1) + Double.parseDouble(n2);
                     Fraction= String.valueOf(res) + "/" + "1";
                  }
               }catch(Exception d){
                    System.out.println("Erro no input!");
               }
               }
            }
         }
         break;
      }
      return String.valueOf(res);
   }

   @Override
   public String visitExprPow(CFRParser.ExprPowContext ctx) {
      String res = null;
      return visitChildren(ctx);
      // return res;
   }

   @Override
   public String visitExprUnario(CFRParser.ExprUnarioContext ctx) {
      String exprVar = visit(ctx.expr());
      switch (ctx.op.getText()) {
         case "-":
            if (myMap.containsKey(exprVar)) // é uma ID;
               return String.valueOf(-Double.parseDouble(myMap.get(exprVar)));
            else
               return String.valueOf(-Double.parseDouble(exprVar));
            // break;
         default:
            if (myMap.containsKey(exprVar)) // é uma ID;
               return myMap.get(exprVar);
            else
               return exprVar;
            // break;
      }

   }

   @Override
   public String visitExprNumb(CFRParser.ExprNumbContext ctx) {
      return ctx.Number().getText();
   }

   @Override
   public String visitExprParent(CFRParser.ExprParentContext ctx) {
      return visit(ctx.expr());
   }

   @Override
   public String visitExprId(CFRParser.ExprIdContext ctx) {
      return ctx.ID().getText();
   }

   @Override
   public String visitExprReduce(CFRParser.ExprReduceContext ctx) {
      String res = null;
      return visitChildren(ctx);
      // return res;
   }

   @Override
   public String visitExprFraction(CFRParser.ExprFractionContext ctx) {
      //String res = null;
      return ctx.Fraction().getText();
      // return res;
   }

   @Override
   public String visitExprMultDivMod(CFRParser.ExprMultDivModContext ctx) {
      Double res = null;
      String Fraction = null;
      String n1 = visit(ctx.expr(0));
      String n2 = visit(ctx.expr(1));
      String fraN1[] = n1.split("/");
      String fraN2[] = n2.split("/");

      switch (ctx.op.getText()) {
         case ":":
            try {
               if (fraN1.length > 1) {
                  if (fraN2.length > 1) {
                     Double numerator1   = Double.parseDouble(fraN1[0]);
                     Double denominator1 = Double.parseDouble(fraN1[1]);
                     Double numerator2   = Double.parseDouble(fraN2[0]);
                     Double denominator2 = Double.parseDouble(fraN2[1]);

                     Double newNumerator = numerator1 * denominator2;
                     Double newDenominator = numerator2 * denominator1;
         
                     if (newDenominator != 0)
                        Fraction = String.valueOf(newNumerator) + "/" + String.valueOf(newDenominator);
                     else
                        Fraction = null;
                  } else {
                     Double numerator1   = Double.parseDouble(fraN1[0]);
                     Double denominator1 = Double.parseDouble(fraN1[1]);
                     Double numerator2   = Double.parseDouble(fraN2[0]);
                     Double denominator2 = 1.0;

                     Double newNumerator = numerator1 * denominator2;
                     Double newDenominator = numerator2 * denominator1;
         
                     if (newDenominator != 0)
                        Fraction = String.valueOf(newNumerator) + "/" + String.valueOf(newDenominator);
                     else
                        Fraction = null;
                  }
               } else if (fraN2.length > 1) {
                     Double numerator1   = Double.parseDouble(fraN1[0]);
                     Double denominator1 = 1.0;
                     Double numerator2   = Double.parseDouble(fraN2[0]);
                     Double denominator2 = Double.parseDouble(fraN2[1]);

                     Double newNumerator = numerator1 * denominator2;
                     Double newDenominator = numerator2 * denominator1;
                    
                     if (newDenominator != 0)
                        Fraction = String.valueOf(newNumerator) + "/" + String.valueOf(newDenominator);
                     else
                        Fraction = null;
               } else {
                  if (Double.parseDouble(n2) != 0){
                     res = Double.parseDouble(n1) / Double.parseDouble(n2);
                     Fraction = String.valueOf(res) + "/" + "1";
                  }else{
                     Fraction = null;
                  } 
               }
            } catch (Exception a) {
               try {
                  // res = myMap.get(n1) - Double.parseDouble(n2);
                  /// Ver isso aqui! Talvez seja necessario criar nova variavel ou não quem sabe!
                  String newN1 = myMap.get(n1);
                  String fraN1_[] = newN1.split("/");
                  if (fraN1_.length > 1) {
                     if (fraN2.length > 1) {
                        Double numerator1   = Double.parseDouble(fraN1_[0]);
                        Double denominator1 = Double.parseDouble(fraN1_[1]);
                        Double numerator2   = Double.parseDouble(fraN2[0]);
                        Double denominator2 = Double.parseDouble(fraN2[1]);
   
                        Double newNumerator = numerator1 * denominator2;
                        Double newDenominator = numerator2 * denominator1;
                        // Double fracDenominator = denominator1 * denominator2;
                        // res = newNumerator1 - newNumerator2;
                        if (newDenominator != 0)
                           Fraction = String.valueOf(newNumerator) + "/" + String.valueOf(newDenominator);
                        else
                           Fraction = null;
                     } else {
                        Double numerator1   = Double.parseDouble(fraN1_[0]);
                        Double denominator1 = Double.parseDouble(fraN1_[1]);
                        Double numerator2   = Double.parseDouble(fraN2[0]);
                        Double denominator2 = 1.0;
   
                        Double newNumerator = numerator1 * denominator2;
                        Double newDenominator = numerator2 * denominator1;
            
                        if (newDenominator != 0)
                           Fraction = String.valueOf(newNumerator) + "/" + String.valueOf(newDenominator);
                        else
                           Fraction = null;
                     }
                  } else if (fraN2.length > 1) {
                        Double numerator1   = Double.parseDouble(fraN1_[0]);
                        Double denominator1 = 1.0;
                        Double numerator2   = Double.parseDouble(fraN2[0]);
                        Double denominator2 = Double.parseDouble(fraN2[1]);
   
                        Double newNumerator = numerator1 * denominator2;
                        Double newDenominator = numerator2 * denominator1;
                       
                        if (newDenominator != 0)
                           Fraction = String.valueOf(newNumerator) + "/" + String.valueOf(newDenominator);
                        else
                           Fraction = null;
                  } else {
                     if (Double.parseDouble(n2) != 0){
                        res = Double.parseDouble(newN1) / Double.parseDouble(n2);
                        Fraction = String.valueOf(res) + "/" + "1";
                     }else{
                        Fraction = null;
                     } 
                  }
               } catch (Exception b) {
                  try {
                     // res = Double.parseDouble(n1) - myMap.get(n2);
                     String newN2 = myMap.get(n2);
                     String fraN2_[] = newN2.split("/");
                     if (fraN1.length > 1) {
                        if (fraN2_.length > 1) {
                           Double numerator1   = Double.parseDouble(fraN1[0]);
                           Double denominator1 = Double.parseDouble(fraN1[1]);
                           Double numerator2   = Double.parseDouble(fraN2_[0]);
                           Double denominator2 = Double.parseDouble(fraN2_[1]);
      
                           Double newNumerator = numerator1 * denominator2;
                           Double newDenominator = numerator2 * denominator1;
                           // Double fracDenominator = denominator1 * denominator2;
                           // res = newNumerator1 - newNumerator2;
                           if (newDenominator != 0)
                              Fraction = String.valueOf(newNumerator) + "/" + String.valueOf(newDenominator);
                           else
                              Fraction = null;
                        } else {
                           Double numerator1   = Double.parseDouble(fraN1[0]);
                           Double denominator1 = Double.parseDouble(fraN1[1]);
                           Double numerator2   = Double.parseDouble(fraN2_[0]);
                           Double denominator2 = 1.0;
      
                           Double newNumerator = numerator1 * denominator2;
                           Double newDenominator = numerator2 * denominator1;
               
                           if (newDenominator != 0)
                              Fraction = String.valueOf(newNumerator) + "/" + String.valueOf(newDenominator);
                           else
                              Fraction = null;
                        }
                     } else if (fraN2_.length > 1) {
                           Double numerator1   = Double.parseDouble(fraN1[0]);
                           Double denominator1 = 1.0;
                           Double numerator2   = Double.parseDouble(fraN2_[0]);
                           Double denominator2 = Double.parseDouble(fraN2_[1]);
      
                           Double newNumerator = numerator1 * denominator2;
                           Double newDenominator = numerator2 * denominator1;
                          
                           if (newDenominator != 0)
                              Fraction = String.valueOf(newNumerator) + "/" + String.valueOf(newDenominator);
                           else
                              Fraction = null;
                     } else {
                        if (Double.parseDouble(newN2) != 0){
                           res = Double.parseDouble(n1) / Double.parseDouble(newN2);
                           Fraction = String.valueOf(res) + "/" + "1";
                        }else{
                           Fraction = null;
                        } 
                     }

                  } catch (Exception c) {
                     try {
                        // res = myMap.get(n1) - myMap.get(n2);
                        String newN1 = myMap.get(n1);
                        String fraN1_[] = newN1.split("/");
                        String newN2 = myMap.get(n2);
                        String fraN2_[] = newN2.split("/");
                        if (fraN1_.length > 1) {
                           if (fraN2_.length > 1) {
                              Double numerator1   = Double.parseDouble(fraN1_[0]);
                              Double denominator1 = Double.parseDouble(fraN1_[1]);
                              Double numerator2   = Double.parseDouble(fraN2_[0]);
                              Double denominator2 = Double.parseDouble(fraN2_[1]);
         
                              Double newNumerator = numerator1 * denominator2;
                              Double newDenominator = numerator2 * denominator1;
                              // Double fracDenominator = denominator1 * denominator2;
                              // res = newNumerator1 - newNumerator2;
                              if (newDenominator != 0)
                                 Fraction = String.valueOf(newNumerator) + "/" + String.valueOf(newDenominator);
                              else
                                 Fraction = null;
                           } else {
                              Double numerator1   = Double.parseDouble(fraN1_[0]);
                              Double denominator1 = Double.parseDouble(fraN1_[1]);
                              Double numerator2   = Double.parseDouble(fraN2_[0]);
                              Double denominator2 = 1.0;
         
                              Double newNumerator = numerator1 * denominator2;
                              Double newDenominator = numerator2 * denominator1;
                  
                              if (newDenominator != 0)
                                 Fraction = String.valueOf(newNumerator) + "/" + String.valueOf(newDenominator);
                              else
                                 Fraction = null;
                           }
                        } else if (fraN2_.length > 1) {
                              Double numerator1   = Double.parseDouble(fraN1_[0]);
                              Double denominator1 = 1.0;
                              Double numerator2   = Double.parseDouble(fraN2_[0]);
                              Double denominator2 = Double.parseDouble(fraN2_[1]);
         
                              Double newNumerator = numerator1 * denominator2;
                              Double newDenominator = numerator2 * denominator1;
                             
                              if (newDenominator != 0)
                                 Fraction = String.valueOf(newNumerator) + "/" + String.valueOf(newDenominator);
                              else
                                 Fraction = null;
                        } else {
                           if (Double.parseDouble(newN2) != 0){
                              res = Double.parseDouble(newN1) / Double.parseDouble(newN2);
                              Fraction = String.valueOf(res) + "/" + "1";
                           }else{
                              Fraction = null;
                           } 
                        }

                     } catch (Exception d) {
                        System.out.println("Erro no input!");
                     }
                  }
               }
            }
            break;
         case "%":
         try {
            if (fraN1.length > 1) {
               if (fraN2.length > 1) {
                  Double numerator1   = Double.parseDouble(fraN1[0]);
                  Double denominator1 = Double.parseDouble(fraN1[1]);
                  Double numerator2   = Double.parseDouble(fraN2[0]);
                  Double denominator2 = Double.parseDouble(fraN2[1]);

                  Double newNumerator = numerator1 * denominator2;
                  Double newDenominator = numerator2 * denominator1;
      
                  if (newDenominator != 0)
                     Fraction = String.valueOf(newNumerator) + "/" + String.valueOf(newDenominator);
                  else
                     Fraction = null;
               } else {
                  Double numerator1   = Double.parseDouble(fraN1[0]);
                  Double denominator1 = Double.parseDouble(fraN1[1]);
                  Double numerator2   = Double.parseDouble(fraN2[0]);
                  Double denominator2 = 1.0;

                  Double newNumerator = numerator1 * denominator2;
                  Double newDenominator = numerator2 * denominator1;
      
                  if (newDenominator != 0)
                     Fraction = String.valueOf(newNumerator) + "/" + String.valueOf(newDenominator);
                  else
                     Fraction = null;
               }
            } else if (fraN2.length > 1) {
                  Double numerator1   = Double.parseDouble(fraN1[0]);
                  Double denominator1 = 1.0;
                  Double numerator2   = Double.parseDouble(fraN2[0]);
                  Double denominator2 = Double.parseDouble(fraN2[1]);

                  Double newNumerator = numerator1 * denominator2;
                  Double newDenominator = numerator2 * denominator1;
                 
                  if (newDenominator != 0)
                     Fraction = String.valueOf(newNumerator) + "/" + String.valueOf(newDenominator);
                  else
                     Fraction = null;
            } else {
               if (Double.parseDouble(n2) != 0){
                  res = Double.parseDouble(n1) % Double.parseDouble(n2);
                  Fraction = String.valueOf(res) + "/" + "1";
               }else{
                  Fraction = null;
               } 
            }
         } catch (Exception a) {
            try {
               
               String newN1 = myMap.get(n1);
               String fraN1_[] = newN1.split("/");
               if (fraN1_.length > 1) {
                  if (fraN2.length > 1) {
                     Double numerator1   = Double.parseDouble(fraN1_[0]);
                     Double denominator1 = Double.parseDouble(fraN1_[1]);
                     Double numerator2   = Double.parseDouble(fraN2[0]);
                     Double denominator2 = Double.parseDouble(fraN2[1]);

                     Double newNumerator = numerator1 * denominator2;
                     Double newDenominator = numerator2 * denominator1;
                     
                     if (newDenominator != 0)
                        Fraction = String.valueOf(newNumerator) + "/" + String.valueOf(newDenominator);
                     else
                        Fraction = null;
                  } else {
                     Double numerator1   = Double.parseDouble(fraN1_[0]);
                     Double denominator1 = Double.parseDouble(fraN1_[1]);
                     Double numerator2   = Double.parseDouble(fraN2[0]);
                     Double denominator2 = 1.0;

                     Double newNumerator = numerator1 * denominator2;
                     Double newDenominator = numerator2 * denominator1;
         
                     if (newDenominator != 0)
                        Fraction = String.valueOf(newNumerator) + "/" + String.valueOf(newDenominator);
                     else
                        Fraction = null;
                  }
               } else if (fraN2.length > 1) {
                     Double numerator1   = Double.parseDouble(fraN1_[0]);
                     Double denominator1 = 1.0;
                     Double numerator2   = Double.parseDouble(fraN2[0]);
                     Double denominator2 = Double.parseDouble(fraN2[1]);

                     Double newNumerator = numerator1 * denominator2;
                     Double newDenominator = numerator2 * denominator1;
                    
                     if (newDenominator != 0)
                        Fraction = String.valueOf(newNumerator) + "/" + String.valueOf(newDenominator);
                     else
                        Fraction = null;
               } else {
                  if (Double.parseDouble(n2) != 0){
                     res = Double.parseDouble(newN1) % Double.parseDouble(n2);
                     Fraction = String.valueOf(res) + "/" + "1";
                  }else{
                     Fraction = null;
                  } 
               }
            } catch (Exception b) {
               try {
              
                  String newN2 = myMap.get(n2);
                  String fraN2_[] = newN2.split("/");
                  if (fraN1.length > 1) {
                     if (fraN2_.length > 1) {
                        Double numerator1   = Double.parseDouble(fraN1[0]);
                        Double denominator1 = Double.parseDouble(fraN1[1]);
                        Double numerator2   = Double.parseDouble(fraN2_[0]);
                        Double denominator2 = Double.parseDouble(fraN2_[1]);
   
                        Double newNumerator = numerator1 * denominator2;
                        Double newDenominator = numerator2 * denominator1;
                        // Double fracDenominator = denominator1 * denominator2;
                        // res = newNumerator1 - newNumerator2;
                        if (newDenominator != 0)
                           Fraction = String.valueOf(newNumerator) + "/" + String.valueOf(newDenominator);
                        else
                           Fraction = null;
                     } else {
                        Double numerator1   = Double.parseDouble(fraN1[0]);
                        Double denominator1 = Double.parseDouble(fraN1[1]);
                        Double numerator2   = Double.parseDouble(fraN2_[0]);
                        Double denominator2 = 1.0;
   
                        Double newNumerator = numerator1 * denominator2;
                        Double newDenominator = numerator2 * denominator1;
            
                        if (newDenominator != 0)
                           Fraction = String.valueOf(newNumerator) + "/" + String.valueOf(newDenominator);
                        else
                           Fraction = null;
                     }
                  } else if (fraN2_.length > 1) {
                        Double numerator1   = Double.parseDouble(fraN1[0]);
                        Double denominator1 = 1.0;
                        Double numerator2   = Double.parseDouble(fraN2_[0]);
                        Double denominator2 = Double.parseDouble(fraN2_[1]);
   
                        Double newNumerator = numerator1 * denominator2;
                        Double newDenominator = numerator2 * denominator1;
                       
                        if (newDenominator != 0)
                           Fraction = String.valueOf(newNumerator) + "/" + String.valueOf(newDenominator);
                        else
                           Fraction = null;
                  } else {
                     if (Double.parseDouble(newN2) != 0){
                        res = Double.parseDouble(n1) % Double.parseDouble(newN2);
                        Fraction = String.valueOf(res) + "/" + "1";
                     }else{
                        Fraction = null;
                     } 
                  }

               } catch (Exception c) {
                  try {
                    
                     String newN1 = myMap.get(n1);
                     String fraN1_[] = newN1.split("/");
                     String newN2 = myMap.get(n2);
                     String fraN2_[] = newN2.split("/");
                     if (fraN1_.length > 1) {
                        if (fraN2_.length > 1) {
                           Double numerator1   = Double.parseDouble(fraN1_[0]);
                           Double denominator1 = Double.parseDouble(fraN1_[1]);
                           Double numerator2   = Double.parseDouble(fraN2_[0]);
                           Double denominator2 = Double.parseDouble(fraN2_[1]);
      
                           Double newNumerator = numerator1 * denominator2;
                           Double newDenominator = numerator2 * denominator1;
                          
                           if (newDenominator != 0)
                              Fraction = String.valueOf(newNumerator) + "/" + String.valueOf(newDenominator);
                           else
                              Fraction = null;
                        } else {
                           Double numerator1   = Double.parseDouble(fraN1_[0]);
                           Double denominator1 = Double.parseDouble(fraN1_[1]);
                           Double numerator2   = Double.parseDouble(fraN2_[0]);
                           Double denominator2 = 1.0;
      
                           Double newNumerator = numerator1 * denominator2;
                           Double newDenominator = numerator2 * denominator1;
               
                           if (newDenominator != 0)
                              Fraction = String.valueOf(newNumerator) + "/" + String.valueOf(newDenominator);
                           else
                              Fraction = null;
                        }
                     } else if (fraN2_.length > 1) {
                           Double numerator1   = Double.parseDouble(fraN1_[0]);
                           Double denominator1 = 1.0;
                           Double numerator2   = Double.parseDouble(fraN2_[0]);
                           Double denominator2 = Double.parseDouble(fraN2_[1]);
      
                           Double newNumerator = numerator1 * denominator2;
                           Double newDenominator = numerator2 * denominator1;
                          
                           if (newDenominator != 0)
                              Fraction = String.valueOf(newNumerator) + "/" + String.valueOf(newDenominator);
                           else
                              Fraction = null;
                     } else {
                        if (Double.parseDouble(newN2) != 0){
                           res = Double.parseDouble(newN1) % Double.parseDouble(newN2);
                           Fraction = String.valueOf(res) + "/" + "1";
                        }else{
                           Fraction = null;
                        } 
                     }

                  } catch (Exception d) {
                     System.out.println("Erro no input!");
                  }
               }
            }
         }
            break;
         default:
         try {
            if (fraN1.length > 1) {
               if (fraN2.length > 1) {
                  Double numerator1   = Double.parseDouble(fraN1[0]);
                  Double denominator1 = Double.parseDouble(fraN1[1]);
                  Double numerator2   = Double.parseDouble(fraN2[0]);
                  Double denominator2 = Double.parseDouble(fraN2[1]);

                  Double newNumerator = numerator1 * numerator2;
                  Double newDenominator = denominator1 * denominator2;
      
                  if (newDenominator != 0)
                     Fraction = String.valueOf(newNumerator) + "/" + String.valueOf(newDenominator);
                  else
                     Fraction = null;
               } else {
                  Double numerator1   = Double.parseDouble(fraN1[0]);
                  Double denominator1 = Double.parseDouble(fraN1[1]);
                  Double numerator2   = Double.parseDouble(fraN2[0]);
                  Double denominator2 = 1.0;

                  Double newNumerator = numerator1 * numerator2;
                  Double newDenominator = denominator2 * denominator1;
      
                  if (newDenominator != 0)
                     Fraction = String.valueOf(newNumerator) + "/" + String.valueOf(newDenominator);
                  else
                     Fraction = null;
               }
            } else if (fraN2.length > 1) {
                  Double numerator1   = Double.parseDouble(fraN1[0]);
                  Double denominator1 = 1.0;
                  Double numerator2   = Double.parseDouble(fraN2[0]);
                  Double denominator2 = Double.parseDouble(fraN2[1]);

                  Double newNumerator = numerator1 * numerator2;
                  Double newDenominator = denominator2 * denominator1;
                 
                  if (newDenominator != 0)
                     Fraction = String.valueOf(newNumerator) + "/" + String.valueOf(newDenominator);
                  else
                     Fraction = null;
            } else {
               if (Double.parseDouble(n2) != 0){
                  res = Double.parseDouble(n1) * Double.parseDouble(n2);
                  Fraction = String.valueOf(res) + "/" + "1";
               }else{
                  Fraction = null;
               } 
            }
         } catch (Exception a) {
            try {
               // res = myMap.get(n1) - Double.parseDouble(n2);
               /// Ver isso aqui! Talvez seja necessario criar nova variavel ou não quem sabe!
               String newN1 = myMap.get(n1);
               String fraN1_[] = newN1.split("/");
               if (fraN1_.length > 1) {
                  if (fraN2.length > 1) {
                     Double numerator1   = Double.parseDouble(fraN1_[0]);
                     Double denominator1 = Double.parseDouble(fraN1_[1]);
                     Double numerator2   = Double.parseDouble(fraN2[0]);
                     Double denominator2 = Double.parseDouble(fraN2[1]);

                     Double newNumerator = numerator1 * numerator2;
                     Double newDenominator = denominator2 * denominator1;
                     // Double fracDenominator = denominator1 * denominator2;
                     // res = newNumerator1 - newNumerator2;
                     if (newDenominator != 0)
                        Fraction = String.valueOf(newNumerator) + "/" + String.valueOf(newDenominator);
                     else
                        Fraction = null;
                  } else {
                     Double numerator1   = Double.parseDouble(fraN1_[0]);
                     Double denominator1 = Double.parseDouble(fraN1_[1]);
                     Double numerator2   = Double.parseDouble(fraN2[0]);
                     Double denominator2 = 1.0;

                     Double newNumerator = numerator1 * numerator2;
                     Double newDenominator = denominator2 * denominator1;
         
                     if (newDenominator != 0)
                        Fraction = String.valueOf(newNumerator) + "/" + String.valueOf(newDenominator);
                     else
                        Fraction = null;
                  }
               } else if (fraN2.length > 1) {
                     Double numerator1   = Double.parseDouble(fraN1_[0]);
                     Double denominator1 = 1.0;
                     Double numerator2   = Double.parseDouble(fraN2[0]);
                     Double denominator2 = Double.parseDouble(fraN2[1]);

                     Double newNumerator = numerator1 * numerator2;
                     Double newDenominator =  denominator2 * denominator1;
                    
                     if (newDenominator != 0)
                        Fraction = String.valueOf(newNumerator) + "/" + String.valueOf(newDenominator);
                     else
                        Fraction = null;
               } else {
                  if (Double.parseDouble(n2) != 0){
                     res = Double.parseDouble(newN1) * Double.parseDouble(n2);
                     Fraction = String.valueOf(res) + "/" + "1";
                  }else{
                     Fraction = null;
                  } 
               }
            } catch (Exception b) {
               try {
                  // res = Double.parseDouble(n1) - myMap.get(n2);
                  String newN2 = myMap.get(n2);
                  String fraN2_[] = newN2.split("/");
                  if (fraN1.length > 1) {
                     if (fraN2_.length > 1) {
                        Double numerator1   = Double.parseDouble(fraN1[0]);
                        Double denominator1 = Double.parseDouble(fraN1[1]);
                        Double numerator2   = Double.parseDouble(fraN2_[0]);
                        Double denominator2 = Double.parseDouble(fraN2_[1]);
   
                        Double newNumerator = numerator1 * numerator2;
                        Double newDenominator = denominator2 * denominator1;
                        // Double fracDenominator = denominator1 * denominator2;
                        // res = newNumerator1 - newNumerator2;
                        if (newDenominator != 0)
                           Fraction = String.valueOf(newNumerator) + "/" + String.valueOf(newDenominator);
                        else
                           Fraction = null;
                     } else {
                        Double numerator1   = Double.parseDouble(fraN1[0]);
                        Double denominator1 = Double.parseDouble(fraN1[1]);
                        Double numerator2   = Double.parseDouble(fraN2_[0]);
                        Double denominator2 = 1.0;
   
                        Double newNumerator = numerator1 * numerator2;
                        Double newDenominator = denominator2 * denominator1;
            
                        if (newDenominator != 0)
                           Fraction = String.valueOf(newNumerator) + "/" + String.valueOf(newDenominator);
                        else
                           Fraction = null;
                     }
                  } else if (fraN2_.length > 1) {
                        Double numerator1   = Double.parseDouble(fraN1[0]);
                        Double denominator1 = 1.0;
                        Double numerator2   = Double.parseDouble(fraN2_[0]);
                        Double denominator2 = Double.parseDouble(fraN2_[1]);
   
                        Double newNumerator = numerator1 * numerator2;
                        Double newDenominator = denominator2 * denominator1;
                       
                        if (newDenominator != 0)
                           Fraction = String.valueOf(newNumerator) + "/" + String.valueOf(newDenominator);
                        else
                           Fraction = null;
                  } else {
                     if (Double.parseDouble(newN2) != 0){
                        res = Double.parseDouble(n1) * Double.parseDouble(newN2);
                        Fraction = String.valueOf(res) + "/" + "1";
                     }else{
                        Fraction = null;
                     } 
                  }

               } catch (Exception c) {
                  try {
                     // res = myMap.get(n1) - myMap.get(n2);
                     String newN1 = myMap.get(n1);
                     String fraN1_[] = newN1.split("/");
                     String newN2 = myMap.get(n2);
                     String fraN2_[] = newN2.split("/");
                     if (fraN1_.length > 1) {
                        if (fraN2_.length > 1) {
                           Double numerator1   = Double.parseDouble(fraN1_[0]);
                           Double denominator1 = Double.parseDouble(fraN1_[1]);
                           Double numerator2   = Double.parseDouble(fraN2_[0]);
                           Double denominator2 = Double.parseDouble(fraN2_[1]);
      
                           Double newNumerator = numerator1 * numerator2;
                           Double newDenominator = denominator2 * denominator1;
                           // Double fracDenominator = denominator1 * denominator2;
                           // res = newNumerator1 - newNumerator2;
                           if (newDenominator != 0)
                              Fraction = String.valueOf(newNumerator) + "/" + String.valueOf(newDenominator);
                           else
                              Fraction = null;
                        } else {
                           Double numerator1   = Double.parseDouble(fraN1_[0]);
                           Double denominator1 = Double.parseDouble(fraN1_[1]);
                           Double numerator2   = Double.parseDouble(fraN2_[0]);
                           Double denominator2 = 1.0;
      
                           Double newNumerator = numerator1 * numerator2;
                           Double newDenominator = denominator2 * denominator1;
               
                           if (newDenominator != 0)
                              Fraction = String.valueOf(newNumerator) + "/" + String.valueOf(newDenominator);
                           else
                              Fraction = null;
                        }
                     } else if (fraN2_.length > 1) {
                           Double numerator1   = Double.parseDouble(fraN1_[0]);
                           Double denominator1 = 1.0;
                           Double numerator2   = Double.parseDouble(fraN2_[0]);
                           Double denominator2 = Double.parseDouble(fraN2_[1]);
      
                           Double newNumerator = numerator1 * numerator2;
                           Double newDenominator = denominator2 * denominator1;
                          
                           if (newDenominator != 0)
                              Fraction = String.valueOf(newNumerator) + "/" + String.valueOf(newDenominator);
                           else
                              Fraction = null;
                     } else {
                        if (Double.parseDouble(newN2) != 0){
                           res = Double.parseDouble(newN1) * Double.parseDouble(newN2);
                           Fraction = String.valueOf(res) + "/" + "1";
                        }else{
                           Fraction = null;
                        } 
                     }

                  } catch (Exception d) {
                     System.out.println("Erro no input!");
                  }
               }
            }
         }
      }
      return String.valueOf(res);

   }
}
