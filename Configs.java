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
    public static final String MAIN_PAGE =      "/persaccounting/Views/MainPage.fxml";
    public static final String AUTHOR_INFO =    "/persaccounting/Views/AuthorInfo.fxml"; 
    public static final String CALCULATOR =     "/persaccounting/AppCalculator/CalculatorFXML.fxml"; 
    public static final String GRAPH_DISPLAY =  "/persaccounting/AppGraphic/GraphDisplay.fxml";
    public static final String ACCOUNTING =     "/persaccounting/AppStockAccountung/MainAccounting.fxml";
    /*------------------------END navigation on scenes-----------------------*/    

    /*--------------------------------styling--------------------------------*/     
    // graph styling
    public static String graph_default_style = 
            "/persaccounting/StaticFiles/CSS/graph_default_style.css";
    public static String graph_style_1 = 
            "/persaccounting/StaticFiles/CSS/graph_style_1.css";
    public static String graph_style_2 = 
            "/persaccounting/StaticFiles/CSS/graph_style_2.css";   
    
    // calc styling
    public static String calculator_default_style = 
            "/persaccounting/StaticFiles/CSS/calc_default_style.css";
    public static String calculator_style_1 = 
            "/persaccounting/StaticFiles/CSS/calc_style_1.css";
    public static String calculator_style_2 = 
            "/persaccounting/StaticFiles/CSS/calc_style_2.css";   
    /*----------------------------END styling--------------------------------*/  
    
}
