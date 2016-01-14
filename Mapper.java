/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persaccounting;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Olena
 */
public class Mapper {
    
    /*--------------------------scene-style mapping--------------------------*/     
    // keys of submappers:
    public static String default_style = "default_style";
    public static String first_style = "first_style";
    public static String second_style = "second_style";
    
    // submappers for each scene init and population:
    private Map<String, String> calc_style_scene_mapper = new HashMap();
    private Map<String, String> graph_style_scene_mapper = new HashMap();
    
    /*
    Map<String, String> calc_style_scene_mapper = new HashMap() {{
        calc_style_scene_mapper.put(default_style, default_style);
        calc_style_scene_mapper.put(first_style, calculator_style_1);
        calc_style_scene_mapper.put(second_style, calculator_style_2);
    }};
            
    Map<String, String> graph_style_scene_mapper = new HashMap() {{
        graph_style_scene_mapper.put(default_style, graph_default_style);
        graph_style_scene_mapper.put(first_style, calculator_style_1);
        graph_style_scene_mapper.put(second_style, calculator_style_2);    
    }};
    */
    
    // main styling mapper:
    public Map<String, Map<String, String>> scene_style_mapper = new HashMap();
    
    public Mapper(){
                
        // submappers; TODO: refactor (resources overload)
        calc_style_scene_mapper.put(default_style, Configs.default_style);
        calc_style_scene_mapper.put(first_style, Configs.calculator_style_1);
        calc_style_scene_mapper.put(second_style, Configs.calculator_style_2);
        
        graph_style_scene_mapper.put(default_style, Configs.default_style);
        graph_style_scene_mapper.put(first_style, Configs.graph_style_1);
        graph_style_scene_mapper.put(second_style, Configs.graph_style_2); 
        
        // System.out.println(calc_style_scene_mapper);   // debug
        // System.out.println(graph_style_scene_mapper);  // debug
        
        // mapping itself:
        scene_style_mapper.put(Configs.CALCULATOR, calc_style_scene_mapper);
        scene_style_mapper.put(Configs.GRAPH_DISPLAY, graph_style_scene_mapper);
        
        // TODO: reimplement (with appropriate stylings)
        scene_style_mapper.put(Configs.MAIN_PAGE, calc_style_scene_mapper);
        scene_style_mapper.put(Configs.AUTHOR_INFO, calc_style_scene_mapper);
        scene_style_mapper.put(Configs.VIEW_SETTINGS, calc_style_scene_mapper);
        
        scene_style_mapper.put(Configs.ACC_MAIN, calc_style_scene_mapper);
        scene_style_mapper.put(Configs.ACC_ADD_VIEW, calc_style_scene_mapper);
        scene_style_mapper.put(Configs.ACC_EDIT_VIEW, calc_style_scene_mapper);
        
        // System.out.println(scene_style_mapper);       // debug
    }    
    /*----------------------END scene-style mapping--------------------------*/     
}
