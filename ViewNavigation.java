/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persaccounting;

import persaccounting.Controllers.RootLayoutController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;

/**
 *
 * @author Olena
 */
public class ViewNavigation {
    

    
    private static RootLayoutController mainController;
    
    public static void setMainController(RootLayoutController mainController){
        ViewNavigation.mainController = mainController;
    }
    
    // load sub-view
    public static void loadView(String fxml) {
        try {
            mainController.setView(
                FXMLLoader.load(
                    ViewNavigation.class.getResource(
                        fxml
                    )
                )         
            );
            Main.currentSubView = fxml;
            System.out.println(Main.currentSubView); // debug
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        /*
        // peupler la liste des articles quand on charge l'application
        if (MainMotsApp.mabaseArticle_stockage == null) {
        MainMotsApp.mabaseArticle_stockage = MainMotsApp.mabaseArticle_onload;
        }
        // peupler la liste des photos quand on charge l'application
        if (MainMotsApp.mabasePhoto_stockage == null) {
        MainMotsApp.mabasePhoto_stockage = MainMotsApp.mabasePhoto_onload;
        }
        */
    }    

    /*---------regles de relations entre vues-types de matieres---------------*/
    /*
    public static Boolean nonMatiereVueCheck(){
        return (MainMotsApp.couranteSousVue != VueNavigateur.PAGE_ACCUEIL && 
                MainMotsApp.couranteSousVue != VueNavigateur.RESULTATS_RECHERCHE &&
                MainMotsApp.couranteSousVue != VueNavigateur.AUTEURS_INFO);
    }
    public static Boolean articleVueCheck(){
        return (MainMotsApp.couranteSousVue == VueNavigateur.ARTICLE_AJOUTE || 
                MainMotsApp.couranteSousVue == VueNavigateur.ARTICLE_TABLEAU);
    }
    public static Boolean photoVueCheck(){
        return (MainMotsApp.couranteSousVue == VueNavigateur.PHOTO_AJOUTE || 
                MainMotsApp.couranteSousVue == VueNavigateur.PHOTO_TABLEAU);
    }
    */
    /*------------------------------END regles--------------------------------*/    
}
