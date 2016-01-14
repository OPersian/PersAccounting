/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persaccounting;

import java.io.IOException;
import java.util.Map;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import persaccounting.Views.RootLayoutController;

/**
 *
 * @author Olena
 */
public class Main extends Application { 

    private Stage stage;
    private Scene scene;
    private Pane mainPane;

    /**
     * Returns the main stage. 
     * Needed for Accounting application (EditView modal dialog).
     * @return
     */
    public Stage getPrimaryStage() {
        return stage;
    }
    
    public Scene getPrimaryScene() {
        return scene;
    }    
    
    // create scene with styling:
    private Scene createScene(Pane mainPane) {
        Scene scene = new Scene(
            mainPane
        );
        
        // get default style from configs mapper:
        Mapper mapper = new Mapper();
        // System.out.println(mapper.scene_style_mapper); // debug
        Map<String, String> current_scene_style_mapper = 
                mapper.scene_style_mapper.get(Globals.currentSubViewName);
        System.out.println(current_scene_style_mapper); // debug
        String current_default_style = 
                current_scene_style_mapper.get(Mapper.default_style);
        // String current_default_style = (String) current_default_style_obj;
        
        // styling:
        scene.getStylesheets().add(current_default_style); // default style
        Globals.mainScene = scene.getStylesheets();
            
        return scene;
    }

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

    /**
     * Initializes the root layout.
     */
    public void initMainWindow(){
        try {
            mainPane = loadMainPane();            
            CheckBox chbDefineResizability = new CheckBox("Resizable");
            chbDefineResizability.setLayoutX(600); // 10
            chbDefineResizability.setLayoutY(50); // 50         
            // chbDefineResizability.setAlignment(Pos.CENTER_RIGHT);
            mainPane.getChildren().addAll(chbDefineResizability);            
            
            scene = createScene(mainPane);
            stage.setScene(scene);         
            
            stage.setTitle("PersAccounting");
            
            // non-rezizable by default:
            stage.setResizable(Globals.scalabilityOption);
            
            /*
            CheckBox chb = new CheckBox("Resizable");
            VBox layout1 = new VBox();
            layout1.getChildren().addAll(chb);
            */
            
            // styling:
            stage.initStyle(StageStyle.UTILITY);
            // bidirectional binding to change resizability option:
            chbDefineResizability.selectedProperty().
                    bindBidirectional(stage.resizableProperty());
                        
            stage.show();            
        } catch (IOException e) {
            e.printStackTrace();
        }    
    }    
    
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;       
        initMainWindow();
    }  
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
