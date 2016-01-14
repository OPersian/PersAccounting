/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persaccounting.Views;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import persaccounting.AppStockAccounting.Views.MainViewController;
import persaccounting.Auxiliaries.AlertManagement;
import persaccounting.Configs;
import persaccounting.Globals;
import persaccounting.ViewNavigation;

/**
 *
 * @author Olena
 */
public class RootLayoutController  {
    
    // TODO: refactor
    /*
    private String style1URL = getClass().
            getResource(Configs.calculator_style_1).toExternalForm();
    private String style2URL = getClass().
            getResource(Configs.calculator_style_2).toExternalForm();
    */
    private static ObservableList<String> styleSheets;
    
    @FXML private StackPane viewHolder;
    @FXML private MenuItem setDarkStyleMenu;
    @FXML private MenuItem setLightStyleMenu;
   
    public void setView(Node node) {
        viewHolder.getChildren().setAll(node);
    }

    @FXML
    private void showMainPage(ActionEvent event) {
        ViewNavigation.loadView(Configs.MAIN_PAGE);
    }

    @FXML
    private void launchCalculator(ActionEvent event) {
        ViewNavigation.loadView(Configs.CALCULATOR);        
    }

    @FXML
    private void launchGraph(ActionEvent event) {
        ViewNavigation.loadView(Configs.GRAPH_DISPLAY);
    }
    
    @FXML
    private void showAbout() {
        AlertManagement.displayAuthorAlert();
    }

    @FXML
    private void exit() {
        System.exit(0);  // Platform.exit();
    }

    @FXML
    private void showAuthor(ActionEvent event) {
        ViewNavigation.loadView(Configs.AUTHOR_INFO);
    }

    @FXML
    private void launchAccountingApp(ActionEvent event) {
        ViewNavigation.loadView(Configs.ACC_MAIN);
    }

    @FXML
    private void showViewSettings(ActionEvent event) {
        ViewNavigation.loadView(Configs.VIEW_SETTINGS);
    }

    @FXML
    private void handleStyleMenuAction(ActionEvent event) {
        String style1URL = getClass().
            getResource(Configs.calculator_style_1).toExternalForm();
        
        String style2URL = getClass().
            getResource(Configs.calculator_style_2).toExternalForm();        
        
        /*
        Main mainApp = new Main();
        Scene mainScene = mainApp.getPrimaryScene();
        // styleSheets = mainScene.getStylesheets();
        */
        
        MenuItem menu_clicked = (MenuItem)event.getSource();
        if (menu_clicked == setLightStyleMenu) {
            Globals.mainScene.remove(style2URL);
            Globals.mainScene.add(style1URL);
        } else if (menu_clicked == setDarkStyleMenu) {
            Globals.mainScene.remove(style1URL);
            Globals.mainScene.add(style2URL); // mainScene.getStylesheets().add(style2URL);
        }        
    }

    @FXML
    private void addItemMenu(ActionEvent event) {
        MainViewController accMainView = new MainViewController();
        accMainView.handleAdd();
    }

    @FXML
    private void editItemMenu(ActionEvent event) {
        MainViewController accMainView = new MainViewController();
        accMainView.handleEdit();
    }

    @FXML
    private void deleteItemMenu(ActionEvent event) {
        MainViewController accMainView = new MainViewController();
        accMainView.handleDelete();
    }
}
