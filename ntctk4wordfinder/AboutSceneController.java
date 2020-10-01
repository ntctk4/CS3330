/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ntctk4wordfinder;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Nathan
 */
public class AboutSceneController extends Switcher implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextArea textArea;
    
    @FXML
    private void handleBack(ActionEvent event){
        
        this.getSceneManager().switchTo("FinderMenu");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       textArea.appendText("Made by: Nathaniel Callahan\nFor: CS3330 at the University of Missouri\n\nThis application is a word find that\ntakes in words that the user gives,\nand creates a word search that has\nthe user generated words as the\nanswers. This app. was created by\nusing java code and FXML. The \nUI was created in Scene Manager\nwhile the java code was written\nin NetBeans. \n\nThe SceneManager and Switcher \nclasses were taken from lecture \nnotes, created by Dale Musser.");
       textArea.setEditable(false);
    }  
    
}
