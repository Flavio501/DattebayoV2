import java.util.ArrayList;
import java.util.StringTokenizer;

public class Lex {
	//String input;
	
	public Lex() {
		
	}
	
	public ArrayList<Token> parse(String input) {
        ArrayList<Token> tokens = new ArrayList<Token>();
        StringTokenizer st = new StringTokenizer(input,"\t\n\r\f()[]{}+/-*; ",true);
        
        while (st.hasMoreTokens()) {
            String palabra = st.nextToken();
            boolean matched = false;

            int cont = 0;
            for (Tipo tokenTipo : Tipo.values()) {
            	
                if (palabra.matches(tokenTipo.patron)) {
                    Token tk = new Token();
                    tk.setTipo(tokenTipo);
                    tk.setValor(palabra);
                    tk.setEntrada(cont);
                    tokens.add(tk);
                    matched = true;
                    cont++;
                }
            }
            if (!matched && palabra.trim().length() != 0) {
            	Token tk = new Token();
                tk.setTipo(Tipo.ERRORES);
                tk.setValor(palabra);
                tk.setEntrada(cont);
                tokens.add(tk);
                cont++;
            }
        }
        return tokens;
    }
}
