/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persaccounting.Views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;

/**
 * FXML Controller class
 *
 * @author Olena
 */
public class MainPageController implements Initializable {

    @FXML private TitledPane x2;
    @FXML private Label functionaliteLabel;
    @FXML private Label utiliteLabel;
    @FXML private TitledPane x1;
    @FXML private Label efficaciteLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        functionaliteLabel.setText("MotsApp! vous permet de bien sauvegarder tous vos "
                + "données de manière vraiment multifonctionnelle! "
                + "\n"
                + "\nLes fichiers en format XML tiennent vos articles et vos "
                + "photos de n'importe quel volume!"
                + "\n"                
                + "\nDe plus, vous pouvez naviguer sur vos données et même "
                + "chercher!");
        
        utiliteLabel.setText("L'application est utile dans votre vie privée et celle de professionelle! Miex vaut tojours tracer "
                + "les résultats de vos travaux en formats des notes ou screenshots. "
                + "\n"
                + "\nVos souvenirs intimes peuvent être aussi memorizes grâce à MotsApp! "
                + "\n"
                + "\nVous vous intéressez au sujet particulier? Les collections des articles "
                + "et des photos sont à votre disposition!");
        
        efficaciteLabel.setText("MotsApp! garde bien vos articles et photos en format XML que vous notamment permettra d'echanger "
                + "vos données avec les autres applications sans aucun probleme! "
                + "\n"
                + "\nPrenez le contrôle de votre productivité, comme MotsApp! "
                + "vous permet de sauvegarder, modifier et naviguer sur vos données de façon le plus efficace!"
                + "\n"
                + "\nDe plus, nous vous garantissons de vous bien soutenir pendant tout le période d'emploi de MotsApp!");
    }    
    
}
