import java.util.*;

public class calcNumb{
	public static void main (String[] args){
		Scanner in = new Scanner(System.in);
		//double numero[] = new double[];
		ArrayList<Double> number = new ArrayList<>();
		ArrayList<String> op = new ArrayList<>();
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
				else{
					System.err.println("Erro sintáctico na expressão");
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
}
