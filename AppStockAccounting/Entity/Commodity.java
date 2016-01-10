/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persaccounting.AppStockAccounting.Entity;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Olena
 */

public class Commodity {
    private IntegerProperty id;
    private StringProperty commodityName;
    private StringProperty commodityDescription;
    private DoubleProperty commodityQuantityInStock;
    private DoubleProperty commodityPriceWithoutTax;   
    
    // TODO: consider: implement 2nd constructor with attrs params in it
    public Commodity() {
        this.id = new SimpleIntegerProperty(-1000);
        this.commodityName = new SimpleStringProperty();
        this.commodityDescription = new SimpleStringProperty();        
        this.commodityQuantityInStock = new SimpleDoubleProperty();
        this.commodityPriceWithoutTax = new SimpleDoubleProperty();       
    }
    
    /* --------------------------------- id -------------------------------- */
    public int getId()                  { return id.get(); }
    public void setId(int id)           { this.id.set(id); }	
    public IntegerProperty idProperty() { return id; } // TODO: add destination

    /* ------------------------------- name -------------------------------- */
    public String getCommodityName() { 
        return commodityName.get(); }
    
    public void setCommodityName(String commodityName) { 
        this.commodityName.set(commodityName); }   
    
    public StringProperty commodityNameProperty() { 
        return commodityName; }

    /* ---------------------------- description ---------------------------- */
    public String getCommodityDescription() { 
        return commodityDescription.get(); }    
    
    public void setCommodityDescription(String commodityDescription)  { 
        this.commodityDescription.set(commodityDescription); }
    
    public StringProperty commodityNameDescription() { 
        return commodityDescription; }
        
    /* ------------------------ quantity in stock -------------------------- */
    public double getCommodityQuantityInStock() { 
        return commodityQuantityInStock.get(); }
    
    public void setCommodityQuantityInStock(double commodityQuantityInStock) { 
        this.commodityQuantityInStock.set(commodityQuantityInStock); }   
    
    public DoubleProperty commodityQuantityInStockProperty() { 
        return commodityQuantityInStock; }    

    /* ----------------------- price tax included -------------------------- */
    public double getCommodityPriceWithoutTax() { 
        return commodityPriceWithoutTax.get(); }
    
    public void setCommodityPriceWithoutTax(double commodityPriceWithoutTax) { 
        this.commodityPriceWithoutTax.set(commodityPriceWithoutTax); }   
    
    public DoubleProperty commodityPriceWithoutTaxProperty() { 
        return commodityPriceWithoutTax; }      
    
    /* ------------------------ unit calculations -------------------------- */
    double sales_tax_rate = 0.2;
    
    public DoubleProperty calculate_unit_sum_without_tax() {            
        return new SimpleDoubleProperty(
            commodityQuantityInStock.doubleValue() * 
                    commodityPriceWithoutTax.doubleValue()
        );
    }      

    public DoubleProperty calculate_unit_tax_sum() {            
        return new SimpleDoubleProperty(
            commodityQuantityInStock.doubleValue() * 
                    commodityPriceWithoutTax.doubleValue() 
                * sales_tax_rate
        );
    }     
    
    public DoubleProperty calculate_unit_sum_tax_included() {  
        return new SimpleDoubleProperty(
            calculate_unit_sum_without_tax().doubleValue() + 
                calculate_unit_tax_sum().doubleValue()
        );
    }         
}
