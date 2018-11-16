
public class Tupla {
	
	String operador;
	String operando1;
	String operando2;
	String varTemp;
	
	public Tupla(String op, String opand1, String opand2, String var) {
		this.operador = op;
		this.operando1 = opand1;
		this.operando2 = opand2;
		this.varTemp = var;
	}
	
	public String getOperador() {
		return this.operador;
	}
	
	public String getOperando1() {
		return this.operando1;
	}
	
	public String getOperando2() {
		return this.operando2;
	}
	
	public String getVarTemp() {
		return this.varTemp;
	}
}
