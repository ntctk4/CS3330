/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ntctk4wordfinder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Nathan
 */
public class Ntctk4WordFinder extends Application {
    
    
    private SceneManager sceneManager;
    
    
    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("FinderMenu.fxml"));
        
        
        //new
        
       // WordMixer mixer = new WordMixer();
        
        HBox root = new HBox();
        
        Scene scene = new Scene(root);
        
        
       //new
       sceneManager = new SceneManager(scene);
       sceneManager.switchTo("FinderMenu");
        
        
        
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
