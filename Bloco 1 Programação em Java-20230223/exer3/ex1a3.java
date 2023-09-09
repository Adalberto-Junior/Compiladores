import java.util.Scanner;
import java.util.Stack;

public class ex1a3 {
    public static void main (String[] args){
        
        Scanner sf = new Scanner(System.in);
        Stack<Double> rpnStack = new Stack<Double>();

        while (sf.hasNextLine()) {
            Scanner ss = new Scanner(sf.nextLine());
            while (ss.hasNext()) {
                
                if (ss. hasNextDouble()){
                    double numToPush = ss.nextDouble();
                    rpnStack.push(numToPush);
                    System.out.println(rpnStack);
                }
                else if(ss.hasNext("[-+*/]")){
                    String oper = ss.next();
                    if(rpnStack.size() >= 2){

                        double sec_oper = rpnStack.pop();
                        double first_oper = rpnStack.pop();
                        double soluction = 0;
                        int cnt = 0;

                        switch (oper) {
                            case "-":
                                    soluction = first_oper - sec_oper;
                                    cnt++;
                                break;
                            case "+":
                                    soluction = first_oper + sec_oper;
                                    cnt++;
                                break;
                            case "*":
                                    soluction = first_oper * sec_oper;
                                    cnt++;
                                break;
                            case "/":
                                    if (sec_oper != 0){
                                        soluction = first_oper / sec_oper;
                                        cnt++;
                                    }

                                break;
                            default:
                                    System.out.println("Operando invalido!");
                                break;     
                        }
                        if(cnt > 0){
                            rpnStack.push(soluction);
                            System.out.println(rpnStack);
                        }
                    }
                    else{
                        System.out.println("Erro sintáctico na expressão");
                    }
                }
                else{
                    System.out.println("Erro sintáctico na expressão");
                }
                
            }
        }
        sf.close();
    }
}
