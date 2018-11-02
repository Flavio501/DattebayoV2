
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import javax.swing.table.DefaultTableModel;

public class Sint {
	//ArrayList<Token> Tokens;
	
    public Sint() {
        //this.Tokens = misTokens;
    }
    
    public ArrayList<String> parse(ArrayList<Token> tokens){
		ArrayList<String> reglas = new ArrayList<String>();
		try {
			while(tokens.size() > 0) {
				if(tokens.get(0).getTipo().toString() == "IDENTIFICADORES"
		    			&& tokens.get(1).getTipo().toString() == "ASIGNACION"
		    			&& (tokens.get(2).getTipo().toString() == "ENTEROS" 
		    				|| tokens.get(2).getTipo().toString() == "STRINGS")
		    			&& tokens.get(3).getTipo().toString() == "TERMINADORES"){
					reglas.add("ASIGNACION");
		    		tokens.remove(3);
		    		tokens.remove(2);
		    		tokens.remove(1);
		    		tokens.remove(0);
		    		//<if> → byakugan(<operacion_logica>){<statement>};
				}else if(tokens.get(0).getTipo().toString() == "PALABRAS_RESERVADAS"
						&& tokens.get(0).getValor() == "Byakugan"
						&& tokens.get(1).getTipo().toString() == "AGRUPADORES_APERTURA"
						&& tokens.get(1).getValor() == "(") {
					reglas.add("IF");
		    		tokens.remove(3);
		    		tokens.remove(2);
		    		tokens.remove(1);
		    		tokens.remove(0);
		    		//Sint.parse(tokens);
		    	}else if(tokens.get(0).getTipo().toString() == "ENTEROS"
			    		&& tokens.get(1).getTipo().toString() ==  "OPARIT"
			    	    && tokens.get(2).getTipo().toString() ==  "ENTEROS"
			    	    && tokens.get(3).getTipo().toString() == "TERMINADORES"){
		    		reglas.add("OP_ARIT");
				    tokens.remove(3);
				    tokens.remove(2);
				    tokens.remove(1);
				    tokens.remove(0);
			    }else if(tokens.get(0).getTipo().toString() == "IDENTIFICADORES"
				    		&& tokens.get(1).getTipo().toString() ==  "OPLOG"
				    		&& tokens.get(2).getTipo().toString() == "IDENTIFICADORES"
				    	    && tokens.get(3).getTipo().toString() == "TERMINADORES"){
			    	reglas.add("OPERACION_LOGICA");
			    	//reglas.add Nodo con lista de tokens usados y nombre del nodo
					tokens.remove(3);
					tokens.remove(2);
					tokens.remove(1);
					tokens.remove(0);
				}else {
			 		reglas.add("Error");
					int cont= 0;
					while(tokens.get(cont).getTipo().toString() != "TERMINADORES" && cont < tokens.size()-1) {
						cont++;
					}
					for(int i = cont;cont>=0;cont--) {
						tokens.remove(cont);
					}
				}
			}
			return reglas;
		}catch(IndexOutOfBoundsException e) {
			reglas.add("Error");
			int cont= 0;
			while(tokens.get(cont).getTipo().toString() != "TERMINADORES" && cont < tokens.size()-1) {
				cont++;
			}
			for(int i = cont;cont>=0;cont--) {
				tokens.remove(cont);
			}
			return reglas;	
		}
    }

}
