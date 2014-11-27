package com.digepo.sego;

/*
 * Advice: the url to view pdf data uses a google docs emmbed and the abuse of bandwidth
 * doesn't show properly the document, the url is used in this way
 * http://docs.google.com/gview?embedded=true&url=http://dl.dropboxusercontent.com/u/44789330/grafico_pdf.pdf
 * in order to use this url to your own server change 
 * http://docs.google.com/gview?embedded=true&url=http://**yourhost/route/to/your/pdf.pdf
 * */

/**
 * Clase DataHandler. Almacena las rutas de datos del municipio que se desea consultar
 * @see  {@link MyUtils}
 */
public class DataHandler {
		
	
	static Double latitude = null, longitude = null;
	
	/*
	 * Basic data information lo show in some screens and info manipulation
	 * */
	static String id = "";
	static String localidad = "";
	
	static String vecindario = "";
    
    static String municipio = "";
	
	static String region = "";
    
	/* DOC que retornan la url de pdf en caso de existir - pendiente de actualizacion*/
    static String doc1 = "";
    static String doc2 = "";
    static String doc3 = "";
    static String doc4 = "";
    static String doc5 = "";
    static String doc6 = "";
    static String doc7 = "";
    static String doc8 = "";
    static String doc9 = "";
    static String doc10 = "";
    static String doc11 = "";

    
}
