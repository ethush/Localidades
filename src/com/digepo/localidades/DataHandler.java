package com.digepo.localidades;

import android.graphics.drawable.Drawable;

/*
 * Advice: the url to view pdf data uses a google docs emmbed and the abuse of bandwidth
 * doesn't show properly the document, the url is used in this way
 * http://docs.google.com/gview?embedded=true&url=http://dl.dropboxusercontent.com/u/44789330/grafico_pdf.pdf
 * in order to use this url to your own server change 
 * http://docs.google.com/gview?embedded=true&url=http://**yourhost/route/to/your/pdf.pdf
 * */

public class DataHandler {
	/*
	 * Important: This info is used to remote query to GoogleMaps API to get 
	 * name location and info
	 * */
	static Double latitude = null, longitude = null;
	//if uses Genymotion emulator
	//static String _HOST = "http://10.0.3.2/";
	//static String _HOST = "http://durmanriegossolucionesagricolas.com.mx";
	static String _HOST = "http://www.gioax.com.mx";
	//if uses android emulator also in ahrdware device
	//static String _HOST = "http://10.0.2.2/";
	static String _ROOT = "digepo_SIG";
	static String _SCRIPT = "data.php";
	
	/*
	 * Basic data information lo show in some screens and info manipulation
	 * */
	static String localidad = "";
	static String vecindario = "";
    static String municipio = "";
	static String region = "";
	
    
    /*If needed show image*/
    static Drawable graph1 = null;
    static Drawable graph2 = null;
    static Drawable graph3 = null;
    static Drawable graph4 = null;
    static Drawable graph5 = null;
    static Drawable graph6 = null;
    static Drawable graph7 = null;
    static Drawable graph8 = null;
    static Drawable graph9 = null;
    static Drawable graph10 = null;
    
    /* If needed show web url views
     * For generic use and avoid modify the code change the url string inserver side
     * temporaly will be store in this class for easy access and debug, to deplyment please
     * please use return complete url in server side.*/
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
    
    /*
     * URL to show pdf information from regions in order:
     * <string name="region1">Cañada</string>
     * <string name="region2">Costa</string>
     * <string name="region3">Istmo</string>
     * <string name="region4">Mixteca</string>
     * <string name="region5">Papaloapam</string>
     * <string name="region6">Sierra Norte</string>
     * <string name="region7">Sierra Sur</string>
     * <string name="region8">Valles centrales</string>
     * */
    
    static String region1 = "";
    static String region2 = "";
    static String region3 = "";
    static String region4 = "";
    static String region5 = "";
    static String region6 = "";
    static String region7 = "";
    static String region8 = "";
    
    /*
     * Static urls to general documents info by State,
     * */
    static String url_state = "";
    
}
