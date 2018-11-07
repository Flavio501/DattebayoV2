
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
				//Main
				if(tokens.get(0).getTipo().toString() == "TIPOS"
						&& tokens.get(0).getValor().matches("Chidori")
						&& tokens.get(1).getTipo().toString() == "PALABRAS_RESERVADAS"
						&& tokens.get(1).getValor().matches("Hokage")
						&& tokens.get(2).getTipo().toString() == "AGRUPADORES_APERTURA"
						&& tokens.get(2).getValor().matches("\\(")
			    		&& tokens.get(3).getTipo().toString() == "AGRUPADORES_CIERRE"
						&& tokens.get(3).getValor().matches("\\)")
						&& tokens.get(4).getTipo().toString() == "AGRUPADORES_APERTURA"
						&& tokens.get(4).getValor().matches("\\{")) {
					usedTokens = new ArrayList<Token>();
					usedTokens.add(tokens.get(0));
					usedTokens.add(tokens.get(1));
					usedTokens.add(tokens.get(2));
					usedTokens.add(tokens.get(3));
					usedTokens.add(tokens.get(4));
					tokens.remove(4);
					tokens.remove(3);
		    		tokens.remove(2);
		    		tokens.remove(1);
		    		tokens.remove(0);
		    		
					reglas.add(new Node(usedTokens,"MAIN","COMPLEJO",reglas.size()+1));
					
				//FOR
				}else if(tokens.get(0).getTipo().toString() == "PALABRAS_RESERVADAS"
						&& tokens.get(0).getValor().matches("Kamui")
			    	    && tokens.get(1).getTipo().toString() ==  "AGRUPADORES_APERTURA"
			    	    && tokens.get(1).getValor().matches("\\(")
			    	    && tokens.get(2).getTipo().toString() == "IDENTIFICADORES"
		    			&& tokens.get(3).getTipo().toString() == "ASIGNACION"
		    			&& tokens.get(4).getTipo().toString() == "ENTEROS"
		    			&& tokens.get(5).getTipo().toString() == "TERMINADORES"
		    			&& tokens.get(6).getTipo().toString() == "IDENTIFICADORES"
				    	&& tokens.get(7).getTipo().toString() == "OPLOG"
				    	&& (tokens.get(8).getTipo().toString() == "ENTEROS"
				    			|| tokens.get(8).getTipo().toString() == "STRINGS" 
				    			|| tokens.get(8).getTipo().toString() == "IDENTIFICADORES")
				    	&& tokens.get(9).getTipo().toString() == "TERMINADORES"
				    	&& tokens.get(10).getTipo().toString() == "IDENTIFICADORES"
				    	&& tokens.get(11).getTipo().toString() == "OPARIT"
				    	&& tokens.get(11).getValor().matches("\\+")
				    	&& tokens.get(12).getTipo().toString() == "OPARIT"
		    			&& tokens.get(12).getValor().matches("\\+")
				    	&& tokens.get(13).getTipo().toString() == "AGRUPADORES_CIERRE"
						&& tokens.get(13).getValor().matches("\\)")
						&& tokens.get(14).getTipo().toString() == "AGRUPADORES_APERTURA"
						&& tokens.get(14).getValor().matches("\\{") ) {
			    	
					usedTokens = new ArrayList<Token>();
					usedTokens.add(tokens.get(0));
					usedTokens.add(tokens.get(1));
					usedTokens.add(tokens.get(2));
					usedTokens.add(tokens.get(3));
					usedTokens.add(tokens.get(4));
					usedTokens.add(tokens.get(5));
					usedTokens.add(tokens.get(6));
					usedTokens.add(tokens.get(7));
					usedTokens.add(tokens.get(8));
					usedTokens.add(tokens.get(9));
					usedTokens.add(tokens.get(10));
					usedTokens.add(tokens.get(11));
					usedTokens.add(tokens.get(12));
					usedTokens.add(tokens.get(13));
					usedTokens.add(tokens.get(14));
					tokens.remove(14);
					tokens.remove(13);
					tokens.remove(12);
					tokens.remove(11);
					tokens.remove(10);
					tokens.remove(9);
					tokens.remove(8);
					tokens.remove(7);
					tokens.remove(6);
					tokens.remove(5);
					tokens.remove(4);
					tokens.remove(3);
					tokens.remove(2);
					tokens.remove(1);
					tokens.remove(0);

					reglas.add(new Node(usedTokens,"FOR","COMPLEJO",reglas.size()+1));
					
				//INCREMENTO
				}else if(tokens.get(0).getTipo().toString() == "IDENTIFICADORES"
				    	&& tokens.get(1).getTipo().toString() == "OPARIT"
				    	&& tokens.get(1).getValor().matches("\\+")
				    	&& tokens.get(2).getTipo().toString() == "OPARIT"
		    			&& tokens.get(2).getValor().matches("\\+")
		    			&& tokens.get(3).getTipo().toString() == "TERMINADORES") {
					
					usedTokens = new ArrayList<Token>();
					usedTokens.add(tokens.get(0));
					usedTokens.add(tokens.get(1));
					usedTokens.add(tokens.get(2));
					usedTokens.add(tokens.get(3));
					tokens.remove(3);
					tokens.remove(2);
					tokens.remove(1);
					tokens.remove(0);
					
					reglas.add(new Node(usedTokens,"INCREMENTO","SIMPLE",reglas.size()+1));
					
				//DECREMENTO
				}else if(tokens.get(0).getTipo().toString() == "IDENTIFICADORES"
				    	&& tokens.get(1).getTipo().toString() == "OPARIT"
				    	&& tokens.get(1).getValor().matches("\\-")
				    	&& tokens.get(2).getTipo().toString() == "OPARIT"
		    			&& tokens.get(2).getValor().matches("\\-")
		    			&& tokens.get(3).getTipo().toString() == "TERMINADORES") {
					
					usedTokens = new ArrayList<Token>();
					usedTokens.add(tokens.get(0));
					usedTokens.add(tokens.get(1));
					usedTokens.add(tokens.get(2));
					usedTokens.add(tokens.get(3));
					tokens.remove(3);
					tokens.remove(2);
					tokens.remove(1);
					tokens.remove(0);
					
					reglas.add(new Node(usedTokens,"DECREMENTO","SIMPLE",reglas.size()+1));
					
				//Asignacion
				}else if(tokens.get(0).getTipo().toString() == "IDENTIFICADORES"
		    			&& tokens.get(1).getTipo().toString() == "ASIGNACION"
		    			&& (tokens.get(2).getTipo().toString() == "ENTEROS" 
		    				|| tokens.get(2).getTipo().toString() == "STRINGS"
		    				|| tokens.get(2).getTipo().toString() == "IDENTIFICADORES")
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
					
				//Declaracion
				}else if(tokens.get(0).getTipo().toString() == "TIPOS"
						&& tokens.get(1).getTipo().toString() == "IDENTIFICADORES"
		    			&& tokens.get(2).getTipo().toString() == "ASIGNACION"
		    			&& (tokens.get(3).getTipo().toString() == "ENTEROS" 
		    				|| tokens.get(3).getTipo().toString() == "STRINGS"
    						|| tokens.get(3).getTipo().toString() == "FLOATS"
		    				|| tokens.get(3).getTipo().toString() == "IDENTIFICADORES")
		    			&& tokens.get(4).getTipo().toString() == "TERMINADORES"){
					usedTokens = new ArrayList<Token>();
					usedTokens.add(tokens.get(0));
					usedTokens.add(tokens.get(1));
					usedTokens.add(tokens.get(2));
					usedTokens.add(tokens.get(3));
					usedTokens.add(tokens.get(4));
					tokens.remove(4);
					tokens.remove(3);
		    		tokens.remove(2);
		    		tokens.remove(1);
		    		tokens.remove(0);
		    		
					reglas.add(new Node(usedTokens,"DECLARACION","SIMPLE",reglas.size()+1));
					
				//If
				}else if(tokens.get(0).getTipo().toString() == "PALABRAS_RESERVADAS"
						&& tokens.get(0).getValor().matches("Byakugan")
						&& tokens.get(1).getTipo().toString() == "AGRUPADORES_APERTURA"
						&& tokens.get(1).getValor().matches("\\(")
						&& (tokens.get(2).getTipo().toString() == "IDENTIFICADORES"
							|| tokens.get(2).getTipo().toString() == "ENTEROS")
			    		&& tokens.get(3).getTipo().toString() ==  "OPLOG"
			    		&& (tokens.get(4).getTipo().toString() == "IDENTIFICADORES"
			    			|| tokens.get(4).getTipo().toString() == "ENTEROS")
			    		&& tokens.get(5).getTipo().toString() == "AGRUPADORES_CIERRE"
						&& tokens.get(5).getValor().matches("\\)")
						&& tokens.get(6).getTipo().toString() == "AGRUPADORES_APERTURA"
						&& tokens.get(6).getValor().matches("\\{")) {
					
					usedTokens = new ArrayList<Token>();
					usedTokens.add(tokens.get(0));
					usedTokens.add(tokens.get(1));
					usedTokens.add(tokens.get(2));
					usedTokens.add(tokens.get(3));
					usedTokens.add(tokens.get(4));
					usedTokens.add(tokens.get(5));
					usedTokens.add(tokens.get(6));
					tokens.remove(6);
					tokens.remove(5);
					tokens.remove(4);
					tokens.remove(3);
		    		tokens.remove(2);
		    		tokens.remove(1);
		    		tokens.remove(0);
		    		
		    		reglas.add(new Node(usedTokens,"IF","COMPLEJO",reglas.size()+1));
		    		
		    		//While
				}else if(tokens.get(0).getTipo().toString() == "PALABRAS_RESERVADAS"
						&& tokens.get(0).getValor().matches("Tsukuyomi")
						&& tokens.get(1).getTipo().toString() == "AGRUPADORES_APERTURA"
						&& tokens.get(1).getValor().matches("\\(")
						&& (tokens.get(2).getTipo().toString() == "IDENTIFICADORES"
							|| tokens.get(2).getTipo().toString() == "ENTEROS")
			    		&& tokens.get(3).getTipo().toString() ==  "OPLOG"
			    		&& (tokens.get(4).getTipo().toString() == "IDENTIFICADORES"
			    			|| tokens.get(4).getTipo().toString() == "ENTEROS")
			    		&& tokens.get(5).getTipo().toString() == "AGRUPADORES_CIERRE"
						&& tokens.get(5).getValor().matches("\\)")
						&& tokens.get(6).getTipo().toString() == "AGRUPADORES_APERTURA"
						&& tokens.get(6).getValor().matches("\\{")) {
					
					usedTokens = new ArrayList<Token>();
					usedTokens.add(tokens.get(0));
					usedTokens.add(tokens.get(1));
					usedTokens.add(tokens.get(2));
					usedTokens.add(tokens.get(3));
					usedTokens.add(tokens.get(4));
					usedTokens.add(tokens.get(5));
					usedTokens.add(tokens.get(6));
					tokens.remove(6);
					tokens.remove(5);
					tokens.remove(4);
					tokens.remove(3);
		    		tokens.remove(2);
		    		tokens.remove(1);
		    		tokens.remove(0);
		    		
		    		reglas.add(new Node(usedTokens,"WHILE","COMPLEJO",reglas.size()+1));
		    		
		    		//Else
				}else if(tokens.get(0).getTipo().toString() == "PALABRAS_RESERVADAS"
						&& tokens.get(0).getValor().matches("Rinnegan")
						&& tokens.get(1).getTipo().toString() == "AGRUPADORES_APERTURA"
						&& tokens.get(1).getValor().matches("\\{")) {
					
					usedTokens = new ArrayList<Token>();
					usedTokens.add(tokens.get(0));
					usedTokens.add(tokens.get(1));
		    		tokens.remove(1);
		    		tokens.remove(0);
		    		
		    		reglas.add(new Node(usedTokens,"ELSE","COMPLEJO",reglas.size()+1));
		    		
		    		//Else if
				}else if(tokens.get(0).getTipo().toString() == "PALABRAS_RESERVADAS"
						&& tokens.get(0).getValor().matches("Sharingan")
						&& tokens.get(1).getTipo().toString() == "AGRUPADORES_APERTURA"
						&& tokens.get(1).getValor().matches("\\(")
						&& (tokens.get(2).getTipo().toString() == "IDENTIFICADORES"
							|| tokens.get(2).getTipo().toString() == "ENTEROS")
			    		&& tokens.get(3).getTipo().toString() ==  "OPLOG"
			    		&& (tokens.get(4).getTipo().toString() == "IDENTIFICADORES"
			    			|| tokens.get(4).getTipo().toString() == "ENTEROS")
			    		&& tokens.get(5).getTipo().toString() == "AGRUPADORES_CIERRE"
						&& tokens.get(5).getValor().matches("\\)")
						&& tokens.get(6).getTipo().toString() == "AGRUPADORES_APERTURA"
						&& tokens.get(6).getValor().matches("\\{")) {
					
					usedTokens = new ArrayList<Token>();
					usedTokens.add(tokens.get(0));
					usedTokens.add(tokens.get(1));
					usedTokens.add(tokens.get(2));
					usedTokens.add(tokens.get(3));
					usedTokens.add(tokens.get(4));
					usedTokens.add(tokens.get(5));
					usedTokens.add(tokens.get(6));
					tokens.remove(6);
					tokens.remove(5);
					tokens.remove(4);
					tokens.remove(3);
		    		tokens.remove(2);
		    		tokens.remove(1);
		    		tokens.remove(0);
		    		
		    		reglas.add(new Node(usedTokens,"ELSE_IF","COMPLEJO",reglas.size()+1));
		    		
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
			    }else if((tokens.get(0).getTipo().toString() == "IDENTIFICADORES"
			    				|| tokens.get(0).getTipo().toString() == "ENTEROS")
				    		&& tokens.get(1).getTipo().toString() ==  "OPLOG"
				    		&& (tokens.get(2).getTipo().toString() == "IDENTIFICADORES"
				    			|| tokens.get(2).getTipo().toString() == "ENTEROS")
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
		    		
		    	// Llave de cierre
			    }else if(tokens.get(0).getTipo().toString() == "AGRUPADORES_CIERRE"
			    		&& tokens.get(0).getValor().matches("}")){
			    	usedTokens = new ArrayList<Token>();
					usedTokens.add(tokens.get(0));
					tokens.remove(0);
		    		
		    		reglas.add(new Node(usedTokens,"AGRUPADOR_CIERRE","COMPLEJO",reglas.size()+1));
			    
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
