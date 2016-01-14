/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persaccounting.AppStockAccounting.Views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import persaccounting.AppStockAccounting.Entity.Commodity;
import persaccounting.AppStockAccounting.Model.DataModel;
import persaccounting.AppStockAccounting.Utils.SummaryCalculations;
import persaccounting.Auxiliaries.AlertManagement;
import persaccounting.Configs;
import persaccounting.Main;
import persaccounting.ViewNavigation;

/**
 * FXML Controller class
 *
 * @author Olena
 */
public class MainViewController implements Initializable {

    @FXML private TableView<Commodity> commoditiesTable;
    @FXML private TableColumn<Commodity, String> commodityNameColumn;
    @FXML private TableColumn<Commodity, String> commodityDescriptionColumn;
    @FXML private TableColumn<Commodity, Double> commodityQuantityInStockColumn;
    @FXML private TableColumn<Commodity, Double> commodityPriceWithoutTaxColumn;
    @FXML private TextField totalSumWithoutTaxField;
    @FXML private TextField totalTaxSumField;
    @FXML private TextField totalSumTaxInclField;

    private static Main mainApp;
    private static DataModel model;
    private static TableViewSelectionModel<Commodity> sM;
    private static final String FORMAT_EL = "%5.2f"; // TODO: add destination

    /**
     * Initializes the controller class. This method is automatically called
     * after the FXML file has been loaded.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model = DataModel.GetInstance();
        System.out.println("The next DataModel obj is found (if any): \n" + model); // debug
        model.load();
        
        // Initialize commodities table of four columns:     
        commodityNameColumn.setCellValueFactory(new PropertyValueFactory<>("commodityName"));
        commodityDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("commodityDescription"));
        commodityQuantityInStockColumn.setCellValueFactory(new PropertyValueFactory<>("commodityQuantityInStock"));
        commodityPriceWithoutTaxColumn.setCellValueFactory(new PropertyValueFactory<>("commodityPriceWithoutTax"));         
        
        // Initialize and populate commodities table of four (?) columns:
        /*
        commodityNameColumn.setCellValueFactory(cellData -> cellData.getValue().commodityNameProperty());
        commodityDescriptionColumn.setCellValueFactory(cellData -> cellData.getValue().commodityNameDescription());
        */
        // commodityQuantityInStockColumn.setCellValueFactory(cellData -> cellData.getValue().commodityQuantityInStockProperty());
        // commodityPriceWithoutTaxColumn.setCellValueFactory(cellData -> cellData.getValue().commodityPriceWithoutTaxProperty()); 
        
        // TODO: implement (not required):
        // averageColumn.setCellValueFactory(cellData -> cellData.getValue().calculateTotalValue().asObject());
        
        sM = commoditiesTable.getSelectionModel(); // TODO: consider: usage cases   
        
        model.clear(); // TODO: find other decision (SQL query GET_ALL is still duplicated!)
        model.load();
        
        /*  non-recommended approach is below; refer to:
            https://docs.oracle.com/javafx/2/api/javafx/scene/control/ListView.html 
        */
        commoditiesTable.getItems().setAll(model.getCache());
        
        totalSumWithoutTaxField.setText(String.format(FORMAT_EL, SummaryCalculations.calculate_total_sum_without_tax(model.getCache())));
        totalTaxSumField.setText(String.format(FORMAT_EL, SummaryCalculations.calculate_total_tax_sum(model.getCache())));
        totalSumTaxInclField.setText(String.format(FORMAT_EL, SummaryCalculations.calculate_total_sum_tax_included(model.getCache())));
    }
    
    // TODO: consider; for editing etc
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
        commoditiesTable.setItems(model.getCache());
        // model.clear();
    }

    /**
     * Opens a dialog to edit details for the specified commodity. If the user
     * clicks OK, the changes are saved into the provided commodity object and true
     * is returned.
     * 
     * @param commodity: the commodity object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    
    // TODO: refactor with regard to sub-view! OPersian's note; 
    public boolean showCommodityChangeDialog(String viewName, String windowTitle, Commodity commodity) {
        try {            
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(viewName));
            AnchorPane page = (AnchorPane) loader.load();
            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle(windowTitle);
            dialogStage.setResizable(false);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            // dialogStage.initOwner(mainApp.getPrimaryStage()); // TODO: refactor: set icon in other way
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);            
            
            // Set the commodity into the controller.
            ChangeViewController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setCommodity(commodity);
            
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
            
            return controller.isOkClicked();
            
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /*
     * @FXML private void handleOpen() { model.clear(); model.load(); }
     */

    @FXML
    public void handleAdd() {  // not private!
        Commodity tempCommodity = new Commodity();
        boolean okClicked = showCommodityChangeDialog(Configs.ACC_ADD_VIEW, "Add Item", tempCommodity);
        try {
            if (okClicked) {
                model.add(tempCommodity);
                totalSumWithoutTaxField.setText(String.format(FORMAT_EL, SummaryCalculations.calculate_total_sum_without_tax(model.getCache())));
                totalTaxSumField.setText(String.format(FORMAT_EL, SummaryCalculations.calculate_total_tax_sum(model.getCache())));
                totalSumTaxInclField.setText(String.format(FORMAT_EL, SummaryCalculations.calculate_total_sum_tax_included(model.getCache())));

                ViewNavigation.loadView(Configs.ACC_MAIN); // instant table reload
            }
        }
        catch (Exception e) {
            ViewNavigation.loadView(Configs.ACC_MAIN); // TODO: refactor; 'kostul''        
            e.printStackTrace();
        }
    }

    @FXML
    public void handleDelete() {  // not private!
        int selectedIndex = sM.getSelectedIndex();
        if (selectedIndex >= 0) {
            // commoditiesTable.getItems().remove(selectedIndex);
            model.delete(selectedIndex);
            totalSumWithoutTaxField.setText(String.format(FORMAT_EL, SummaryCalculations.calculate_total_sum_without_tax(model.getCache())));
            totalTaxSumField.setText(String.format(FORMAT_EL, SummaryCalculations.calculate_total_tax_sum(model.getCache())));
            totalSumTaxInclField.setText(String.format(FORMAT_EL, SummaryCalculations.calculate_total_sum_tax_included(model.getCache())));
            
            ViewNavigation.loadView(Configs.ACC_MAIN); // instant table reload
            
        } else {
            // Nothing selected.
            AlertManagement.displayPreventionAlert(
                "No Selection", 
                "No Commodity Selected",
                "Please select a commodity in the table!");
        }
    }

    @FXML
    public void handleEdit() {  // not private!
        int selectedIndex = sM.getSelectedIndex();
        Commodity selectedCommodity = sM.getSelectedItem();
        if (selectedCommodity != null) {
            boolean okClicked = showCommodityChangeDialog(Configs.ACC_EDIT_VIEW, "Edit Item", selectedCommodity);
            if (okClicked) {
                model.edit(selectedIndex);
                totalSumWithoutTaxField.setText(String.format(FORMAT_EL, SummaryCalculations.calculate_total_sum_without_tax(model.getCache())));
                totalTaxSumField.setText(String.format(FORMAT_EL, SummaryCalculations.calculate_total_tax_sum(model.getCache())));
                totalSumTaxInclField.setText(String.format(FORMAT_EL, SummaryCalculations.calculate_total_sum_tax_included(model.getCache())));
                
                ViewNavigation.loadView(Configs.ACC_MAIN); // instant table reload
            }

        } else {
            // Nothing selected.
            AlertManagement.displayPreventionAlert(
                "No Selection", 
                "No Commodity Selected",
                "Please select a commodity in the table!");
        }
    }

}
