/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persaccounting;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import persaccounting.Controllers.RootLayoutController;


/**
 *
 * @author User
 */
public class Main extends Application {
    
    public static String currentSubView;
    
    // load main scene:
    private Pane loadMainPane() throws IOException  {
        FXMLLoader loader = new FXMLLoader();  
        
        Pane mainPane = (Pane) loader.load(
            getClass().getResourceAsStream(
                Configs.ROOT_LAYOUT
            )
        );
        
        RootLayoutController mainController = loader.getController();
        ViewNavigation.setMainController(mainController);
        ViewNavigation.loadView(Configs.MAIN_PAGE);        
        return mainPane;
    }
    
    // create with styling
    private Scene createScene(Pane mainPane) {
        Scene scene = new Scene(
            mainPane
        );
        // styling:
        scene.getStylesheets().add(Configs.calculator_style_2); // default style
        Globals.mainScene = scene.getStylesheets();
            
        return scene;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        
        try {
            /*
            Parent root = FXMLLoader.load(getClass().
                    getResource(Configs.calculator_controller_path));

            Scene scene = new Scene(root);
            */
            
            /*
            AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().
                    getResource(Configs.calculator_controller_path));
            
            Scene scene = new Scene(root);  // ,300,250	
            */
            
            // stage.setScene(scene);
            stage.setScene(
                createScene(
                    loadMainPane()
                )
            );         
            
            stage.setTitle("PersAccounting");
            stage.setResizable(false);  // non-rezizable as required
            // styling:
            stage.initStyle(StageStyle.UTILITY);          
                        
            stage.show();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
