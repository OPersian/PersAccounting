/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persaccounting.Views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import persaccounting.Configs;
import persaccounting.Globals;
import persaccounting.Main;
import persaccounting.ViewNavigation;

/**
 * FXML Controller class
 *
 * @author Olena
 */
public class ViewSettingsController implements Initializable {
    
    private static Main mainApp;
    private Stage mainStage;
    
    @FXML private ToggleGroup radioGroupScalabiity;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void setResizable(ActionEvent event) {
        Globals.scalabilityOption = true;
        
        /*
        mainApp = new Main();
        mainStage = mainApp.getPrimaryStage();
        mainStage.setResizable(Globals.scalabilityOption);
        */
        
        /*
        mainApp = new Main();
        mainApp.initMainWindow();
        */
        
        // set currentSubViewName to view settings view:
        ViewNavigation.loadView(Configs.MAIN_PAGE); 
               
    }

    @FXML
    private void setNonResizable(ActionEvent event) {
        Globals.scalabilityOption = false;
        
        /*        
        mainApp = new Main();
        mainStage = mainApp.getPrimaryStage();
        mainStage.setResizable(Globals.scalabilityOption);
        */
        
        /*
        mainApp = new Main();
        mainApp.initMainWindow();
        */
        
        // set currentSubViewName to view settings view:
        ViewNavigation.loadView(Configs.MAIN_PAGE); 
    }
    
}
