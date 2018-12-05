import java.util.ArrayList;

public class Sem {
	
	public ArrayList<Tupla> parse(ArrayList<Node> reglas){
		ArrayList<Tupla> tuplas = new ArrayList<Tupla>();
		ArrayList<Token> tokens = new ArrayList<Token>();
		
		try {
			for(int i = 0; i < reglas.size();i++) {
				tokens = reglas.get(i).getTokens();
				System.out.println("Contador: " + i);
				System.out.println("Tokens: "+ tokens.size());
				System.out.println("Tipo: " + tokens.get(0).getTipo() + ", Valor: " + tokens.get(0).getValor());
				System.out.println("Tipo: " + tokens.get(3).getTipo() + ", Valor: " + tokens.get(3).getValor());
				switch(reglas.get(i).getNombre().toString()) {
					case "INICIALIZACION":
						switch(tokens.get(0).getValor().toString()) {
							case "Chidori":
								if(tokens.get(3).getTipo().toString().matches("ENTEROS")) {
									tuplas.add(new Tupla("=",tokens.get(3).getValor(),"",tokens.get(1).getValor()));
								}else {
									tuplas.add(new Tupla("ERROR_INI",reglas.get(i).getNombre(),String.valueOf(i),""));
								}
								break;
							case "Rasengan":
								if(tokens.get(3).getTipo().toString().matches("FLOATS")) {
									tuplas.add(new Tupla("=",tokens.get(3).getValor(),"",tokens.get(1).getValor()));
								}else {
									tuplas.add(new Tupla("ERROR_INI",reglas.get(i).getNombre(),String.valueOf(i),""));
								}
								break;
							case "Susanoo":
								if(tokens.get(3).getTipo().toString().matches("STRINGS")) {
									tuplas.add(new Tupla("=",tokens.get(3).getValor(),"",tokens.get(1).getValor()));
								}else {
									tuplas.add(new Tupla("ERROR_INI",reglas.get(i).getNombre(),String.valueOf(i),""));
								}
								break;
							case "Chakra":
								if(tokens.get(3).getTipo().toString().matches("STRINGS")
										&& tokens.get(3).getValor().length()==3) {
									tuplas.add(new Tupla("=",tokens.get(3).getValor(),"",tokens.get(1).getValor()));
								}else {
									tuplas.add(new Tupla("ERROR_INI",reglas.get(i).getNombre(),String.valueOf(i),""));
								}
								break;
							case "Shuriken":
								//System.out.println(tokens.get(3).getValor());
								if(tokens.get(3).getTipo().toString().matches("STRINGS") 
										&& (tokens.get(3).getValor().matches("\"Kurama\"")
												||tokens.get(3).getValor().matches("\"Gyuki\""))) {
									tuplas.add(new Tupla("=",tokens.get(3).getValor(),"",tokens.get(1).getValor()));
								}else {
									tuplas.add(new Tupla("ERROR_INI",reglas.get(i).getNombre(),String.valueOf(i),""));
								}
								break;
							default:
								//return error
								tuplas.add(new Tupla("ERROR_INI",reglas.get(0).getNombre(),String.valueOf(reglas.get(0).getEntrada()),""));
								break;
						}
						break;
					case "ASIGNACION":
						//evaluar tipos y declaracion
						break;
				}
			}
			return tuplas;
		}catch(Exception e) {
			//Manejar excepcion
			e.printStackTrace();
			tuplas.add(new Tupla("ERROR_INDEX","","",""));
			return tuplas;
		}
	}
}
