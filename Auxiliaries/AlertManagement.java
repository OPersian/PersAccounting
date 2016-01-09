/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persaccounting.Auxiliaries;

import java.text.MessageFormat;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author Olena
 */


public class AlertManagement {    
    
    public static String error_title = "Sorry!";
    public static String error_body = "Error occurred while {0}";
    public static String error_details = "Error technical details: \n{0}";    

    public static void displayErrorAlert(String custom_body, String custom_details) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(error_title);
        alert.setHeaderText(MessageFormat.format(error_body, custom_body));
        alert.setContentText(MessageFormat.format(error_details, custom_details));
        alert.showAndWait();
    }
    
    // TODO: refactor as displayErrorAlert
    public static void displayPreventionAlert(String title, String body, String details) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(body);
        alert.setContentText(details);
        alert.showAndWait();
    }
    
    // author
    public static String info_title = "Info on author";
    public static String info_body = "Olena Persianova";
    public static String info_details = "Created by Olena Persianova."
            + "\nAll rigths reserved. \nJan 2016";
    
    public static void displayInfoAlert(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(info_title);
        alert.setHeaderText(info_body);
        alert.setContentText(info_details);
        alert.showAndWait();
    }    
}
