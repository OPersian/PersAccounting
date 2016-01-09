/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persaccounting;

/**
 *
 * @author Olena
 */

public class Configs {    
    
    /*--------------------------navigation on scenes-------------------------*/ 
    public static final String ROOT_LAYOUT =    "/persaccounting/Views/RootLayout.fxml"; 
    // public static final String MAIN_PAGE =      "/persaccounting/Calculator/CalculatorFXML.fxml"; 
    public static final String MAIN_PAGE =      "/persaccounting/Views/MainPage.fxml"; // MainPage
    public static final String AUTHOR_INFO =    "/persaccounting/Views/AuthorInfo.fxml"; 
    public static final String CALCULATOR =     "/persaccounting/Calculator/CalculatorFXML.fxml"; 
    public static final String GRAPH_SETTINGS = "/persaccounting/Graphic/GraphSettings.fxml";
    public static final String GRAPH_DISPLAY =  "/persaccounting/Graphic/GraphDisplay.fxml";
    public static final String ACCOUNTING =     "/persaccounting/StockAccountung/MainAccounting.fxml";
    /*------------------------END navigation on scenes-----------------------*/    
    
    static String calculator_controller_path = 
            "/persaccounting/Calculator/CalculatorFXML.fxml";
    
    public static String calculator_default_style = 
            "/persaccounting/StaticFiles/default_style.css";
    public static String calculator_style_1 = 
            "/persaccounting/StaticFiles/style_1.css";
    public static String calculator_style_2 = 
            "/persaccounting/StaticFiles/style_2.css";   
    
    
}
