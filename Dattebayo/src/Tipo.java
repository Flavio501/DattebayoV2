
public enum Tipo {
    //ENTEROS("^\\d+$"),
    ENTEROS("\\d+"),
	TIPOS("\\b(Chidori|Rasengan|Susanoo|Chakra|Shuriken)\\b"),
	FLOATS("([0-9]*[.][0-9]+)"),
	//FLOATS("(\\d+\\.)?\\d+"),
	STRINGS("\"(.*?)\""),
    OPARIT("\\+|\\-|\\*|\\/"),
    OPLOG("(Neji|Sasori|Deidara|Gui|Lee|Gaara|Choji|Hidan)"),
    AGRUPADORES_APERTURA("[\\{|\\[|\\(]"),
    AGRUPADORES_CIERRE("[\\}|\\]|\\)]"),
    ASIGNACION("="),
    PALABRAS_RESERVADAS("\\b(Hokage|Byakugan|Sharingan|Rinnegan|Kamui|Tsukuyomi|Kurama|Gyuki|Genin|Jonin)\\b"),
    IDENTIFICADORES("_[A-Za-z|0-9]+"),
    TERMINADORES("\\;"),
    ERRORES("ERROR");

    public final String patron;

    Tipo(String s) {
        this.patron = s;
    }
    
    public String getPatron() {
    	return this.patron;
    }
}
