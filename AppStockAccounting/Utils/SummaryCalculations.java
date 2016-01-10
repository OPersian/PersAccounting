/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persaccounting.AppStockAccounting.Utils;

import java.util.List;
import javafx.beans.property.SimpleDoubleProperty;
import persaccounting.AppStockAccounting.Entity.Commodity;

/**
 *
 * @author Olena
 */

// TODO: test; continue implementation with fxml

public class SummaryCalculations {
    
    public static double calculate_total_sum_without_tax(List<Commodity> lst) {
        double sum = 0;		
        for (Commodity c : lst) {                
            SimpleDoubleProperty incr = new SimpleDoubleProperty(
                c.calculate_unit_sum_without_tax().doubleValue()
            );                 
            sum += incr.doubleValue();
        }
        return sum;
    }

    public static double calculate_total_tax_sum(List<Commodity> lst) {
        double sum = 0;		
        for (Commodity c : lst) {                
            SimpleDoubleProperty incr = new SimpleDoubleProperty(
                c.calculate_unit_tax_sum().doubleValue()
            );                 
            sum += incr.doubleValue();
        }
        return sum;
    }
    
    public static double calculate_total_sum_tax_included(List<Commodity> lst) {
        double sum = 0;		
        for (Commodity c : lst) {                
            SimpleDoubleProperty incr = new SimpleDoubleProperty(
                c.calculate_unit_sum_tax_included().doubleValue()
            );                 
            sum += incr.doubleValue();
        }
        return sum;
    }     
}
