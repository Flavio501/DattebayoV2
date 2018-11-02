import java.util.ArrayList;

public class Node {
	
	ArrayList<Token> tokens = new ArrayList<Token>();
	String nombre;
	String tipo;
	int entrada;
	
	public Node(ArrayList<Token> tok, String nom, String tip, int ent) {
		this.tokens = tok;
		this.nombre = nom;
		this.tipo = tip;
		this.entrada = ent;
	}
	
	public ArrayList<Token> getTokens(){
		return this.tokens;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	public int getEntrada() {
		return this.entrada;
	}
}
