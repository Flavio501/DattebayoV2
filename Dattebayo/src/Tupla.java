
public class Tupla {
	
	String operador;
	Token operando1;
	Token operando2;
	String varTemp;
	
	public Tupla(String op, Token opand1, Token opand2, String var) {
		this.operador = op;
		this.operando1 = opand1;
		this.operando2 = opand2;
		this.varTemp = var;
	}
	
	public Tupla(String op, Token opand1, String var) {
		this.operador = op;
		this.operando1 = opand1;
		this.operando2 = new Token();
		this.varTemp = var;
	}
	public Tupla(String op, String var) {
		this.operador = op;
		this.operando1 = new Token();
		this.operando2 = new Token();
		this.varTemp = var;
	}
	
	public String getOperador() {
		return this.operador;
	}
	
	public Token getOperando1() {
		return this.operando1;
	}
	
	public Token getOperando2() {
		return this.operando2;
	}
	
	public String getVarTemp() {
		return this.varTemp;
	}
}
