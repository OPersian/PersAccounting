/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persaccounting.AppStockAccounting.Model;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import persaccounting.AppStockAccounting.Entity.Commodity;

/**
 *
 * @author Olena
 */

public class DataModel {
    
    private static DataModel instance;
    private static ObservableList<Commodity> cache;
    private static CommodityDAO dAO;

    private DataModel() {
        cache = FXCollections.observableArrayList();
        dAO = CommodityDAO.getInstance();
    }

    public static DataModel GetInstance() {
        if (instance == null) {
            instance = new DataModel();
        }
        return instance;
    }

    public ObservableList<Commodity> getCache() {
        return cache;
    }	

    public void clear() {
        cache.clear();
    }

    public void add(Commodity c) {		
        dAO.addCommodity(c);
        cache.add(c);		
    }

    public void addAll(List<Commodity> c) {
        cache.addAll(c);		
    }

    public void delete(int i) {		
        dAO.deleteCommodity(cache.get(i).getId());
        cache.remove(i);		
    }

    public void edit(int i) {
        Commodity tmp = cache.get(i);		
        dAO.updateCommodity(tmp);
        cache.set(i, tmp);		
    }	

    public void load() {
        addAll(dAO.getAllCommodities());
    }     
}
