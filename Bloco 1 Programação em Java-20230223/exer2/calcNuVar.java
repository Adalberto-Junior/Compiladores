import java.util.*;

public class calcNuVar{
	public static void main (String[] args){
		Scanner in = new Scanner(System.in);
		//double numero[] = new double[];
		ArrayList<Double> number = new ArrayList<>();
		ArrayList<String> op = new ArrayList<>();
		Map<String,Double> varMap = new HashMap<>();
		while (in.hasNextLine()) {
			Scanner sec_in = new Scanner(in.nextLine());
			double resultado = 0;
			while (sec_in.hasNext()) {
				if (sec_in.hasNextDouble()){
					 double value = sec_in.nextDouble();
					 //System.out.println(value);
					 number.add(value);
					 //System.out.println(number);
					//System.out.println(number.size());
					if(number.size() > 1){
					    if(op.size() > 0){
						switch (op.get(0)){
							case "+":
								resultado = number.get(0) + number.get(1);
						     	break;
							case "-":
								resultado = number.get(0) - number.get(1);
						     	break;
							case "*":
								resultado = number.get(0) * number.get(1);
						    	 break;
							case "/":
								  if (number.get(1) != 0)
							       		resultado = number.get(0) / number.get(1);
							  	else
									System.err.println("Numero dois não pode ser igual a zero");
						      	  break;
							default:
							  	 System.err.println("OPerador Invalido");
							  break;
						   }
							System.out.println("Result = " +  resultado);
							number.clear();
							op.clear();
					}
					else{
						System.err.println("Miss the operand! Try again!----> <number>  <op>  <number>");
						number.clear();
						op.clear();
					}
				  }

				}
				else if(sec_in.hasNext("[-+/*]")){
					//String operador = "";
					op.add(sec_in.next());
				}
				else if(sec_in.hasNext("^[a-zA-Z_]")){
					String  key = sec_in.next();
					 if(!varMap.containsKey(key)){
						if(sec_in.hasNext("=")){
							String temp = sec_in.next();
							if(sec_in.hasNextDouble()){
							  double nu = sec_in.nextDouble();
							  varMap.put(key,nu);
							}
							if (sec_in.hasNext("[-+/*]")){
							 	String nw_op = sec_in.next();
							 	if(sec_in.hasNextDouble()){
							   	  double n2 = sec_in.nextDouble();
								  double n1 = varMap.get(key);
								  varMap.put(key, result(nw_op,n1,n2));
								}
							}
							System.out.println("Result = " + varMap.get(key));
						}
					 }
					 else{
					     if(sec_in.hasNext("=")){
                                                        String temp = sec_in.next();
                                                        if(sec_in.hasNextDouble()){
                                                          double nu = sec_in.nextDouble();
                                                          varMap.put(key,nu);
                                                        }
						//	else if(sec_in.hasNext("^[a-zA-Z_]")){
						//	     String newKey = sec_in.next();
							     
						//	}
                                                        if (sec_in.hasNext("[-+/*]")){
                                                                String nw_op = sec_in.next();
                                                                if(sec_in.hasNextDouble()){
                                                                  double n2 = sec_in.nextDouble();
                                                                  double n1 = varMap.get(key);
                                                                  varMap.put(key, result(nw_op,n1,n2));
                                                                }
                                                        }
                                                        System.out.println("Result = " + varMap.get(key));
                                                }

					}					    

				}
				else{
					System.err.println("Erro sintáctico na expressão");
					break;
				}
			}
		}
		in.close();
		/*
			System.out.println("Claculadora Númerica: <número> <operador> <número> ,");
			String oper = in.nextLine();
			
			String operador[] = oper.split(" ");
			double numero1 = Double.parseDouble(operador[0]);
			double numero2 = Double.parseDouble(operador[2]);
			double resultado = 0;
			String op = operador[1];
			try{	
				switch (op){
					case "+":
						resultado = numero1 + numero2;
					break;
					case "-":
						resultado = numero1 - numero2;
					break;
					case "*":
						resultado = numero1 * numero2;
					break;
					case "/":
						if (numero2 != 0)
							resultado = numero1 / numero2;
						else
							System.out.println("Numero dois não pode ser igual a zero");
					break;
					default:
						System.out.println("OPerador não disponivel");
					break;

				}
				System.out.println(resultado);
			}catch(Exception e){
				System.out.println(e);
			}
			in.close();
	*/
	}
   public static double result(String op, double n1, double n2){
	double resultado = 0;
	switch (op){
		case "+":
			resultado = n1 + n2;
	     	break;
		case "-":
			resultado = n1 - n2;
	     	break;
		case "*":
			resultado = n1 * n2;
	    	 break;
		case "/":
			  if (n2 != 0)
		       		resultado = n1 / n2;
		  	else
				System.err.println("Numero dois não pode ser igual a zero");
	      	  break;
		default:
		  	 System.err.println("OPerador Invalido");
		  break;
	 }
	 return resultado;
     }
}
