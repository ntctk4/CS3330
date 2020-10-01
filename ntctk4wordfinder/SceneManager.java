/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ntctk4wordfinder;

import java.util.HashMap;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 *
 * @author Nathan
 */
public class SceneManager {
     private Scene scene;
    private final HashMap<String, Switcher> controllers = new HashMap<>();
    
    public SceneManager() {
        
    }
    
    public SceneManager(Scene scene) {
        this.scene = scene;
    }
    
    public void setScene(Scene scene) {
        this.scene = scene;
    }
    
    public Scene getScene() {
        return scene;
    }
    
    public Switcher add(String name) {
        Switcher controller;
        
        controller = controllers.get(name);
        
        if (controller == null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource(name + ".fxml"));
                Parent root = (Parent)loader.load();
                controller = (Switcher)loader.getController();
                controller.setRoot(root);
                controller.setSceneManager(this);
                controllers.put(name, controller);
            } catch (Exception ex) {
                controller = null;
            }
        }
        
        return controller;
    }
    
    public void switchTo(String name) {
        Switcher controller = controllers.get(name);
        
        if(name == "GameScene"){
            controllers.remove(name);
            controller = null;
        }
        
        
        if (controller == null) {
            controller = add(name);
        }
        
        if (controller != null) {
            if (scene != null) {
                scene.setRoot(controller.getRoot());
            }
        }
    }
}
