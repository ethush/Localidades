package com.digepo.localidades;

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
	
	static String localidad = "";
	
	static String vecindario = "";
    
    static String municipio = "";
	
	static String region = "";
    
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

    static String pais_doc1 = "";
    static String pais_doc2 = "";
    static String pais_doc3 = "";
    static String pais_doc4 = "";
    static String pais_doc5 = "";
    static String pais_doc6 = "";
    static String pais_doc7 = "";
    static String pais_doc8 = "";
    static String pais_doc9 = "";
    static String pais_doc10 = "";
    static String pais_doc11 = "";
    
    static String estado_doc1 = "";
    static String estado_doc2 = "";
    static String estado_doc3 = "";
    static String estado_doc4 = "";
    static String estado_doc5 = "";
    static String estado_doc6 = "";
    static String estado_doc7 = "";
    static String estado_doc8 = "";
    static String estado_doc9 = "";
    static String estado_doc10 = "";
    static String estado_doc11 = "";
    
    
    /*
     * URL to show pdf information from regions in order:
     * <String name="region1">Cañada</String>
     * <String name="region2">Costa</String>
     * <String name="region3">Istmo</String>
     * <String name="region4">Mixteca</String>
     * <String name="region5">Papaloapam</String>
     * <String name="region6">Sierra Norte</String>
     * <String name="region7">Sierra Sur</String>
     * <String name="region8">Valles centrales</String>
     * */
    
    static String canada_doc1 = "";
    static String canada_doc2 = "";
    static String canada_doc3 = "";
    static String canada_doc4 = "";
    static String canada_doc5 = "";
    static String canada_doc6 = "";
    static String canada_doc7 = "";
    static String canada_doc8 = "";
    static String canada_doc9 = "";
    static String canada_doc10 = "";
    static String canada_doc11 = "";

    static String costa_doc1 = "";
    static String costa_doc2 = "";
    static String costa_doc3 = "";
    static String costa_doc4 = "";
    static String costa_doc5 = "";
    static String costa_doc6 = "";
    static String costa_doc7 = "";
    static String costa_doc8 = "";
    static String costa_doc9 = "";
    static String costa_doc10 = "";
    static String costa_doc11 = "";
    
    static String istmo_doc1 = "";
    static String istmo_doc2 = "";
    static String istmo_doc3 = "";
    static String istmo_doc4 = "";
    static String istmo_doc5 = "";
    static String istmo_doc6 = "";
    static String istmo_doc7 = "";
    static String istmo_doc8 = "";
    static String istmo_doc9 = "";
    static String istmo_doc10 = "";
    static String istmo_doc11 = "";
    
    static String mixteca_doc1 = "";
    static String mixteca_doc2 = "";
    static String mixteca_doc3 = "";
    static String mixteca_doc4 = "";
    static String mixteca_doc5 = "";
    static String mixteca_doc6 = "";
    static String mixteca_doc7 = "";
    static String mixteca_doc8 = "";
    static String mixteca_doc9 = "";
    static String mixteca_doc10 = "";
    static String mixteca_doc11 = "";
    
    static String papaloapam_doc1 = "";
    static String papaloapam_doc2 = "";
    static String papaloapam_doc3 = "";
    static String papaloapam_doc4 = "";
    static String papaloapam_doc5 = "";
    static String papaloapam_doc6 = "";
    static String papaloapam_doc7 = "";
    static String papaloapam_doc8 = "";
    static String papaloapam_doc9 = "";
    static String papaloapam_doc10 = "";
    static String papaloapam_doc11 = "";
    
    static String sierra_norte_doc1 = "";
    static String sierra_norte_doc2 = "";
    static String sierra_norte_doc3 = "";
    static String sierra_norte_doc4 = "";
    static String sierra_norte_doc5 = "";
    static String sierra_norte_doc6 = "";
    static String sierra_norte_doc7 = "";
    static String sierra_norte_doc8 = "";
    static String sierra_norte_doc9 = "";
    static String sierra_norte_doc10 = "";
    static String sierra_norte_doc11 = "";
    
    static String sierra_sur_doc1 = "";
    static String sierra_sur_doc2 = "";
    static String sierra_sur_doc3 = "";
    static String sierra_sur_doc4 = "";
    static String sierra_sur_doc5 = "";
    static String sierra_sur_doc6 = "";
    static String sierra_sur_doc7 = "";
    static String sierra_sur_doc8 = "";
    static String sierra_sur_doc9 = "";
    static String sierra_sur_doc10 = "";
    static String sierra_sur_doc11 = "";
    
    static String valles_centrales_doc1 = "";
    static String valles_centrales_doc2 = "";
    static String valles_centrales_doc3 = "";
    static String valles_centrales_doc4 = "";
    static String valles_centrales_doc5 = "";
    static String valles_centrales_doc6 = "";
    static String valles_centrales_doc7 = "";
    static String valles_centrales_doc8 = "";
    static String valles_centrales_doc9 = "";
    static String valles_centrales_doc10 = "";
    static String valles_centrales_doc11 = "";
    
}
