/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ntctk4notifier;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Nathan
 */
public class Ntctk4Notifier extends Application {
    
    @Override
    public void start(Stage primaryStage) 
    { 
      
        
       GridPane root = new GridPane();
       
       root.setAlignment(Pos.CENTER);
       root.setHgap(10);
       root.setVgap(10);
        
        TextField textField = new TextField();
        //TextArea editor = new TextArea();
        Button notifyButton = new Button("Notify");
            notifyButton.setOnAction((ActionEvent event) -> {
                textField.setPromptText("You have been notified!");
            });
        
            
            
        Button clearButton = new Button("Clear");
            clearButton.setOnAction((ActionEvent event) -> {
                textField.setPromptText(" ");
            });
            
            
        root.add(textField, 0, 0);
        root.add(notifyButton, 1, 0);
        root.add(clearButton, 1, 1);
        
        Scene scene = new Scene(root, 400, 250);
        
        primaryStage.setTitle("Notifier");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
