/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persaccounting;

import persaccounting.Views.RootLayoutController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;

/**
 *
 * @author Olena
 */
public class ViewNavigation {
    
    private static RootLayoutController mainController;
    
    public static void setMainController(RootLayoutController mainController){
        ViewNavigation.mainController = mainController;
    }
    
    // load sub-view
    public static void loadView(String fxml) {
        try {
            mainController.setView(
                FXMLLoader.load(
                    ViewNavigation.class.getResource(
                        fxml
                    )
                )         
            );
            Globals.currentSubViewName = fxml;
            System.out.println(Globals.currentSubViewName); // debug
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }    
}
