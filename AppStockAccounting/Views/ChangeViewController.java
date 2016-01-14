/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persaccounting.AppStockAccounting.Views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import persaccounting.AppStockAccounting.Entity.Commodity;
import persaccounting.Auxiliaries.AlertManagement;

/**
 * FXML Controller class
 *
 * @author Olena
 */
public class ChangeViewController  {

    @FXML private TextField commodityNameField;
    @FXML private TextField commodityDescriptionField;
    @FXML private TextField commodityQuantityInStockField;
    @FXML private TextField commodityPriceWithoutTaxField;

    private Stage dialogStage;
    private Commodity commodity;
    private boolean okClicked = false;
    
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
        try {
            if (isInputValid()) {
                commodity.setCommodityName(commodityNameField.getText());
                commodity.setCommodityDescription(commodityDescriptionField.getText());
                commodity.setCommodityQuantityInStock(Double.parseDouble(commodityQuantityInStockField.getText()));
                commodity.setCommodityPriceWithoutTax(Double.parseDouble(commodityPriceWithoutTaxField.getText()));
                okClicked = true;
                dialogStage.close(); }
            
        } catch (java.lang.NumberFormatException e) {
            
            AlertManagement.displayErrorAlert(
                "trying to update the data on commodities! "
                        + "\nEnsure you have correctly entered "
                        + "all the data on a commodity!",
                e.toString());
            
            // debug:
            System.out.println("Could not update data on commodities!");
            e.printStackTrace(); 
            
        } catch (Exception error) {
            
            AlertManagement.displayErrorAlert(
                "trying to update the data on commodities! ",
                error.toString());
            
            // debug:
            System.out.println("Could not update data on commodities!");
            error.printStackTrace();  
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
            errorMessage += "\nNo valid commodity name!";
        }
        if (commodityDescriptionField.getText() == null || commodityDescriptionField.getText().length() == 0) {
            errorMessage += "\nNo valid commodity description!"; // TODO: refactor; can be NULL!
        }
        if (commodityQuantityInStockField.getText() == null || commodityQuantityInStockField.getText().length() == 0) {
            errorMessage += "\nNo valid quantity in stock!"; // TODO: refactor; can be NULL!
        }
        if (commodityPriceWithoutTaxField.getText() == null || commodityPriceWithoutTaxField.getText().length() == 0) {
            errorMessage += "\nNo valid price!"; // TODO: refactor; can be NULL!
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            AlertManagement.displayErrorAlert(
                "Invalid fields. Please correct invalid fields!", 
                errorMessage);
            return false;
        }
    }    
}
