import java.util.*;

public class calcVar{
	public static void main (String[] args){
		Scanner in = new Scanner(System.in);
		Map<String,Double> varNMap = new HashMap();
		
		while (in.hasNextLine()) {
			Scanner sec_in = new Scanner(in.nextLine());
			double numero1 = 0;
			double numero2 = 0;
			double resultado = 0;
			int cnt = 0;
			int op = 0;
			while (sec_in.hasNext()) {
				
				if (sec_in.hasNext("[A-Za-z]")){
					String variavel = sec_in.next();
					if (!varNMap.containsKey(variavel))
						varNMap.put(variavel, 0); //ver com o professor
					else
						if (sec_in.hasNext())  //pensar nissso ainda
						//ainda não averiguado

					if (cnt == 0){
						numero1 = sec_in.nextDouble();
						cnt++;
					}
					else{
						numero2 = sec_in.nextDouble();
						cnt = 0;
					}
				}
				else if(sec_in.hasNext("[-+/*]")){
					String operador = "";
					if (op == 0){
						operador = sec_in.next();
						op++;
					}
					else{
						switch (operador){
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
								   System.out.println("OPerador Invalido");
								break;
						}
						System.out.println(resultado);
						op = 0;
					}

				}
				else{
					System.out.println("Erro sintáctico na expressão");
				}
				
			}
			
		}
		in.close();
		
	}


}
