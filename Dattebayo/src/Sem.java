import java.util.ArrayList;

public class Sem {
	
	public ArrayList<Tupla> parse(ArrayList<Node> reglas){
		ArrayList<Tupla> tuplas = new ArrayList<Tupla>();
		ArrayList<Tupla> initVars = new ArrayList<Tupla>();
		ArrayList<Token> tokens = new ArrayList<Token>();
		
		try {
			for(int i = 0; i < reglas.size();i++) {
				tokens = reglas.get(i).getTokens();
				System.out.println("Contador: " + i);
				System.out.println("Regla: "+ reglas.get(i).getNombre());
				System.out.println("Tokens: "+ tokens.size());
				switch(reglas.get(i).getNombre().toString()) {
					case "INICIALIZACION":
						System.out.println("Tipo: " + tokens.get(0).getTipo() + ", Valor: " + tokens.get(0).getValor());
						System.out.println("Tipo: " + tokens.get(3).getTipo() + ", Valor: " + tokens.get(3).getValor()+"\n");
						switch(tokens.get(0).getValor().toString()) {
							case "Chidori":
								if(tokens.get(3).getTipo().toString().matches("ENTEROS")) {
									tuplas.add(new Tupla("=",tokens.get(3),tokens.get(1).getValor()));
									initVars.add(new Tupla("=",tokens.get(3),tokens.get(1).getValor()));
								}else {
									tuplas.add(new Tupla("ERROR_INI",reglas.get(i).getNombre()));
								}
								break;
							case "Rasengan":
								if(tokens.get(3).getTipo().toString().matches("FLOATS")) {
									tuplas.add(new Tupla("=",tokens.get(3),tokens.get(1).getValor()));
									initVars.add(new Tupla("=",tokens.get(3),tokens.get(1).getValor()));
								}else {
									tuplas.add(new Tupla("ERROR_INI",reglas.get(i).getNombre()));
								}
								break;
							case "Susanoo":
								if(tokens.get(3).getTipo().toString().matches("STRINGS")) {
									tuplas.add(new Tupla("=",tokens.get(3),tokens.get(1).getValor()));
									initVars.add(new Tupla("=",tokens.get(3),tokens.get(1).getValor()));
								}else {
									tuplas.add(new Tupla("ERROR_INI",reglas.get(i).getNombre()));
								}
								break;
							case "Chakra":
								if(tokens.get(3).getTipo().toString().matches("STRINGS")
										&& tokens.get(3).getValor().length()==3) {
									tuplas.add(new Tupla("=",tokens.get(3),tokens.get(1).getValor()));
									initVars.add(new Tupla("=",tokens.get(3),tokens.get(1).getValor()));
								}else {
									tuplas.add(new Tupla("ERROR_INI",reglas.get(i).getNombre()));
								}
								break;
							case "Shuriken":
								//System.out.println(tokens.get(3).getValor());
								if(tokens.get(3).getTipo().toString().matches("STRINGS") 
										&& (tokens.get(3).getValor().matches("\"Kurama\"")
												||tokens.get(3).getValor().matches("\"Gyuki\""))) {
									tuplas.add(new Tupla("=",tokens.get(3),tokens.get(1).getValor()));
									initVars.add(new Tupla("=",tokens.get(3),tokens.get(1).getValor()));
								}else {
									tuplas.add(new Tupla("ERROR_INI",reglas.get(i).getNombre()));
								}
								break;
							default:
								//return error
								tuplas.add(new Tupla("ERROR_INI",reglas.get(i).getNombre()));
								break;
						}
						break;
						
						
					case "FOR":
						System.out.println("Tipo: " + tokens.get(0).getTipo() + ", Valor: " + tokens.get(0).getValor());
						System.out.println("Tipo: " + tokens.get(3).getTipo() + ", Valor: " + tokens.get(3).getValor()+"\n");
						switch(tokens.get(0).getValor().toString()) {
							case "Chidori":
								if(tokens.get(3).getTipo().toString().matches("STRINGS")) {
									tuplas.add(new Tupla("+",tokens.get(3),tokens.get(1).getValor()));
									initVars.add(new Tupla("+",tokens.get(3),tokens.get(1).getValor()));
								}else {
									tuplas.add(new Tupla("ERROR_INI",reglas.get(i).getNombre()));
								}
								break;
							case "Rasengan":
								if(tokens.get(3).getTipo().toString().matches("ENTEROS")) {
									tuplas.add(new Tupla("+",tokens.get(3),tokens.get(1).getValor()));
									initVars.add(new Tupla("+",tokens.get(3),tokens.get(1).getValor()));
								}else {
									tuplas.add(new Tupla("ERROR_INI",reglas.get(i).getNombre()));
								}
								break;
							case "Susanoo":
								if(tokens.get(3).getTipo().toString().matches("STRINGS")) {
									tuplas.add(new Tupla("+",tokens.get(3),tokens.get(1).getValor()));
									initVars.add(new Tupla("+",tokens.get(3),tokens.get(1).getValor()));
								}else {
									tuplas.add(new Tupla("ERROR_INI",reglas.get(i).getNombre()));
								}
								break;
							case "Chakra":
								if(tokens.get(3).getTipo().toString().matches("STRINGS")
										&& tokens.get(3).getValor().length()==3) {
									tuplas.add(new Tupla("=",tokens.get(3),tokens.get(1).getValor()));
									initVars.add(new Tupla("=",tokens.get(3),tokens.get(1).getValor()));
								}else {
									tuplas.add(new Tupla("ERROR_INI",reglas.get(i).getNombre()));
								}
								break;
							case "Shuriken":
								//System.out.println(tokens.get(3).getValor());
								if(tokens.get(3).getTipo().toString().matches("STRINGS") 
										&& (tokens.get(3).getValor().matches("\"Kurama\"")
												||tokens.get(3).getValor().matches("\"Gyuki\""))) {
									tuplas.add(new Tupla("=",tokens.get(3),tokens.get(1).getValor()));
									initVars.add(new Tupla("=",tokens.get(3),tokens.get(1).getValor()));
								}else {
									tuplas.add(new Tupla("ERROR_INI",reglas.get(i).getNombre()));
								}
								break;
							default:
								//return error
								tuplas.add(new Tupla("ERROR_INI",reglas.get(i).getNombre()));
								break;
						}
						break;
						
					case "ASIGNACION":
						//System.out.println("Tipo: " + checkInit(tokens.get(0),initVars).getOperando1().getTipo().toString() + ", Valor: " + tokens.get(0).getValor());
						//System.out.println("Tipo: " + checkInit(tokens.get(2),initVars).getOperando1().getTipo().toString() + ", Valor: " + tokens.get(2).getValor()+"\n");
						//evaluar tipos y declaracion
						if(tokens.get(0).getTipo().toString().matches("IDENTIFICADORES") && tokens.get(2).getTipo().toString().matches("IDENTIFICADORES")) {
							if(checkInit(tokens.get(0),initVars).getOperando1().getTipo().toString().matches(checkInit(tokens.get(2),initVars).getOperando1().getTipo().toString())) {
								tuplas.add(new Tupla("=",tokens.get(2),tokens.get(0).getValor()));
							}else {
								tuplas.add(new Tupla("ERROR_ASIGN",reglas.get(i).getNombre()));
							}
						}else if(checkInit(tokens.get(0),initVars).getOperando1().getTipo().toString().matches(tokens.get(2).getTipo().toString())){
							tuplas.add(new Tupla("=",tokens.get(2),tokens.get(0).getValor()));
						}else {
							tuplas.add(new Tupla("ERROR_ASIGN",reglas.get(i).getNombre()));
						}
						break;
				}
			}
			return tuplas;
		}catch(Exception e) {
			//Manejar excepcion
			e.printStackTrace();
			tuplas.add(new Tupla("ERROR_INDEX",""));
			return tuplas;
		}
	}
	
	public Tupla checkInit(Token var,ArrayList<Tupla> initVars) {
		for(Tupla t : initVars) {
			if(var.getValor().matches(t.getVarTemp())) {
				return t;
			}
		}
		return null;
	}
}
