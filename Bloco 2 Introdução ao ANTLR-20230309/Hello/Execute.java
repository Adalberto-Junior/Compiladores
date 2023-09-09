@SuppressWarnings("CheckReturnValue")
public class Execute extends HelloBaseVisitor<String> {

   @Override public String visitGreetings(HelloParser.GreetingsContext ctx) {
      String res = null;
      System.out.println("Olá" + " " +  ctx.ID());
      return visitChildren(ctx);
      
      //return res;
   }
}
