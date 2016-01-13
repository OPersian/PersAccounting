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
    public static final String VIEW_SETTINGS =    "/persaccounting/Views/ViewSettings.fxml"; 
    public static final String CALCULATOR =     "/persaccounting/AppCalculator/CalculatorFXML.fxml"; 
    public static final String GRAPH_DISPLAY =  "/persaccounting/AppGraphic/GraphDisplay.fxml";
    public static final String ACC_EDIT_VIEW =  "/persaccounting/AppStockAccounting/Views/EditView.fxml";
    public static final String ACC_MAIN =       "/persaccounting/AppStockAccounting/Views/MainView.fxml";    
    
    /*------------------------END navigation on scenes-----------------------*/    

    
    /*--------------------------------styling--------------------------------*/     
    // general styling
    public static final String default_style = 
            "/persaccounting/StaticFiles/CSS/default_style.css";

    // graph styling
    public static final String graph_style_1 = 
            "/persaccounting/StaticFiles/CSS/graph_style_1.css";
    public static final String graph_style_2 = 
            "/persaccounting/StaticFiles/CSS/graph_style_2.css";   
    
    // calc styling
    public static final String calculator_style_1 = 
            "/persaccounting/StaticFiles/CSS/calc_style_1.css";
    public static final String calculator_style_2 = 
            "/persaccounting/StaticFiles/CSS/calc_style_2.css"; 
    
    // acc styling
    // TODO 
    
    /*----------------------------END styling--------------------------------*/  

    
    /*----------------------------db connection------------------------------*/  
    // refer to: http://www.tutorialspoint.com/jdbc/jdbc-sample-code.htm
    
    // JDBC driver name and database URL
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    public static final String DB_URL = "jdbc:mysql://localhost:3306/persaccounting";

    //  Database credentials
    public static final String USER = "admin";  // TODO: consider "root"
    public static final String PASS = "admin";
    /*-------------------------END db connection-----------------------------*/  
   
}
