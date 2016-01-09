/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persaccounting.AppGraphic;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author Olena
 */
public class GraphDisplayController implements Initializable {
    
    /**
     * Initializes the controller class.
     */
    
    @FXML
    private LineChart<Double, Double> chart;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO: implement GUI for startX inputting
        double coefficient = 3, startX = 1, stopX = 100, step = 5;
        chart.getData().add(initSerie(coefficient, startX, stopX, step));		
    }   
    
    private XYChart.Series<Double, Double> initSerie(
            double coefficient, 
            double start, 
            double stop, 
            double delta) {		
        XYChart.Series<Double, Double> series = new XYChart.Series();
        // defining a series:
        series.setName("Graph of y=k/x function");
        // populating the series with data:
        for (double i = start; i <= stop; i += delta) {	
            // System.out.println(i + "; " + coefficient/i);  // debug
            series.getData().add(new XYChart.Data(i, coefficient/i));
        }
        return series;
    }    
    
}
