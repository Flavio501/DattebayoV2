import java.util.ArrayList;

public class Sem {
	
	public ArrayList<Tupla> parse(ArrayList<Node> reglas){
		ArrayList<Tupla> tuplas = new ArrayList<Tupla>();
		
		try {
			while(reglas.size()>0) {
				ArrayList<Token> tokens = reglas.get(0).getTokens();
				System.out.println("Reglas: " + reglas.size());
				System.out.println("Tokens: "+ tokens.size());
				switch(reglas.get(0).getNombre().toString()) {
					case "INICIALIZACION":
						switch(tokens.get(0).getValor().toString()) {
							case "Chidori":
								if(tokens.get(3).getTipo().toString().matches("ENTEROS")) {
									tuplas.add(new Tupla("=",tokens.get(3).getValor(),"",tokens.get(1).getValor()));
									//reglas.remove(0);
									break;
								}
							case "Rasengan":
								if(tokens.get(3).getTipo().toString().matches("FLOATS")) {
									tuplas.add(new Tupla("=",tokens.get(3).getValor(),"",tokens.get(1).getValor()));
									//reglas.remove(0);
									break;
								}
							case "Susanoo":
								if(tokens.get(3).getTipo().toString().matches("STRINGS")) {
									tuplas.add(new Tupla("=",tokens.get(3).getValor(),"",tokens.get(1).getValor()));
									//reglas.remove(0);
									break;
								}
							case "Chakra":
								//System.out.println(tokens.get(3).getValor());
								//System.out.println(tokens.get(3).getValor().length());
								if(tokens.get(3).getTipo().toString().matches("STRINGS")
										&& tokens.get(3).getValor().length()==3) {
									tuplas.add(new Tupla("=",tokens.get(3).getValor(),"",tokens.get(1).getValor()));
									//reglas.remove(0);
									break;
								}
							case "Shuriken":
								//System.out.println(tokens.get(3).getValor());
								if(tokens.get(3).getTipo().toString().matches("STRINGS") 
										&& (tokens.get(3).getValor().matches("\"Kurama\"")
												||tokens.get(3).getValor().matches("\"Gyuki\""))) {
									tuplas.add(new Tupla("=",tokens.get(3).getValor(),"",tokens.get(1).getValor()));
									//reglas.remove(0);
									break;
								}
							default:
								//return error
								System.out.println("Entrada: " + reglas.get(0).getEntrada());
								tuplas.add(new Tupla("ERROR_INI",reglas.get(0).getNombre(),String.valueOf(reglas.get(0).getEntrada()),""));
								break;
						}
				}
				reglas.remove(0);
			}
			return tuplas;
		}catch(Exception e) {
			//Manejar excepcion
			e.printStackTrace();
			return tuplas;
		}
	}
}
