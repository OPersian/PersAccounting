/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persaccounting.AppStockAccounting.Views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import persaccounting.AppStockAccounting.Entity.Commodity;
import persaccounting.Auxiliaries.AlertManagement;

/**
 * FXML Controller class
 *
 * @author Olena
 */
public class EditViewController implements Initializable {

    @FXML private TextField commodityNameField;
    @FXML private TextField commodityDescriptionField;
    @FXML private TextField commodityQuantityInStockField;
    @FXML private TextField commodityPriceWithoutTaxField;

    private Stage dialogStage;
    private Commodity commodity;
    private boolean okClicked = false;
        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }    

    /**
     * Sets the commodity to be edited in the dialog.
     * 
     * @param c
     */
    public void setCommodity(Commodity c) {
        this.commodity = c;
        commodityNameField.setText(c.getCommodityName());
        commodityDescriptionField.setText(c.getCommodityDescription());
        commodityQuantityInStockField.setText(Double.toString(c.getCommodityQuantityInStock()));
        commodityPriceWithoutTaxField.setText(Double.toString(c.getCommodityPriceWithoutTax()));
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks OK.
     */
    @FXML
    private void handleOk(ActionEvent event) {
        if (isInputValid()) {
            commodity.setCommodityName(commodityNameField.getText());
            commodity.setCommodityDescription(commodityDescriptionField.getText());
            commodity.setCommodityQuantityInStock(Integer.parseInt(commodityQuantityInStockField.getText()));
            commodity.setCommodityPriceWithoutTax(Integer.parseInt(commodityPriceWithoutTaxField.getText()));
            okClicked = true;
            dialogStage.close();
        }       
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel(ActionEvent event) {
        dialogStage.close();       
    }
    
    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";
        if (commodityNameField.getText() == null || commodityNameField.getText().length() == 0) {
            errorMessage += "No valid first name!\n"; // TODO: change text
        }
        if (commodityDescriptionField.getText() == null || commodityDescriptionField.getText().length() == 0) {
            errorMessage += "No valid last name!\n"; // TODO: change text
        }
        if (commodityQuantityInStockField.getText() == null || commodityQuantityInStockField.getText().length() == 0) {
            errorMessage += "No valid mark 1!\n"; // TODO: change text
        }
        if (commodityPriceWithoutTaxField.getText() == null || commodityPriceWithoutTaxField.getText().length() == 0) {
            errorMessage += "No valid mark 2!\n"; // TODO: change text
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            AlertManagement.displayErrorAlert("Invalid fields", "Please correct invalid fields!");
            return false;
        }
    }    
}
