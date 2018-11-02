
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
    
    public ArrayList<Node> parse(ArrayList<Token> tokens){
		ArrayList<Node> reglas = new ArrayList<Node>();
		ArrayList<Token> usedTokens; //= new ArrayList<Token>();
		try {
			while(tokens.size() > 0) {
				//Asignacion
				if(tokens.get(0).getTipo().toString() == "IDENTIFICADORES"
		    			&& tokens.get(1).getTipo().toString() == "ASIGNACION"
		    			&& (tokens.get(2).getTipo().toString() == "ENTEROS" 
		    				|| tokens.get(2).getTipo().toString() == "STRINGS")
		    			&& tokens.get(3).getTipo().toString() == "TERMINADORES"){
					usedTokens = new ArrayList<Token>();
					usedTokens.add(tokens.get(0));
					usedTokens.add(tokens.get(1));
					usedTokens.add(tokens.get(2));
					usedTokens.add(tokens.get(3));
					tokens.remove(3);
		    		tokens.remove(2);
		    		tokens.remove(1);
		    		tokens.remove(0);
		    		
					reglas.add(new Node(usedTokens,"ASIGNACION","SIMPLE",reglas.size()+1));
		    		//<if> → byakugan(<operacion_logica>){<statement>};
					
				//If
				}else if(tokens.get(0).getTipo().toString() == "PALABRAS_RESERVADAS"
						&& tokens.get(0).getValor() == "Byakugan"
						&& tokens.get(1).getTipo().toString() == "AGRUPADORES_APERTURA"
						&& tokens.get(1).getValor() == "(") {
					//reglas.add("IF");
		    		tokens.remove(3);
		    		tokens.remove(2);
		    		tokens.remove(1);
		    		tokens.remove(0);
		    		
		    	//OPERACION ARITMETICA
		    	}else if(tokens.get(0).getTipo().toString() == "ENTEROS"
			    		&& tokens.get(1).getTipo().toString() ==  "OPARIT"
			    	    && tokens.get(2).getTipo().toString() ==  "ENTEROS"
			    	    && tokens.get(3).getTipo().toString() == "TERMINADORES"){	    		
		    		usedTokens = new ArrayList<Token>();
					usedTokens.add(tokens.get(0));
					usedTokens.add(tokens.get(1));
					usedTokens.add(tokens.get(2));
					usedTokens.add(tokens.get(3));
					tokens.remove(3);
		    		tokens.remove(2);
		    		tokens.remove(1);
		    		tokens.remove(0);
		    		
		    		reglas.add(new Node(usedTokens,"OP_ARIT","SIMPLE",reglas.size()+1));
		    		
				//OPERACION LOGICA
			    }else if(tokens.get(0).getTipo().toString() == "IDENTIFICADORES"
				    		&& tokens.get(1).getTipo().toString() ==  "OPLOG"
				    		&& tokens.get(2).getTipo().toString() == "IDENTIFICADORES"
				    	    && tokens.get(3).getTipo().toString() == "TERMINADORES"){
			    	usedTokens = new ArrayList<Token>();
					usedTokens.add(tokens.get(0));
					usedTokens.add(tokens.get(1));
					usedTokens.add(tokens.get(2));
					usedTokens.add(tokens.get(3));
					tokens.remove(3);
		    		tokens.remove(2);
		    		tokens.remove(1);
		    		tokens.remove(0);
		    		
		    		reglas.add(new Node(usedTokens,"OPERACION_LOGICA","SIMPLE",reglas.size()+1));
		    		
		    	//ERROR
				}else {
					
					usedTokens = new ArrayList<Token>();
					reglas.add(new Node(usedTokens,"ERROR","SIMPLE",reglas.size()+1));
					
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
			usedTokens = new ArrayList<Token>();
			reglas.add(new Node(usedTokens,"ERROR","SIMPLE",reglas.size()+1));
			
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
