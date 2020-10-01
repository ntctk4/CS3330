/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ntctk4wordfinder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Nathan
 */
public class FinderMenuController extends Switcher implements Initializable {

    /**
     * Initializes the controller class.
     */
    
  
    
   @FXML 
   protected TilePane tile;
   
   @FXML
   private ScrollPane scroll;
   
   @FXML
   private TextField textField;
   
   @FXML
   private Button open;
   
   @FXML
   private Button save;
   
   @FXML
   private Text text;
   
   @FXML
   private TextArea textArea;
   
   
   FileChooser fileChooser = new FileChooser();
   
   @FXML
   private void handleOpen(){
     
       File file = fileChooser.showOpenDialog(null);
       
       if(file != null)
        {
            
          try
           {
                FileReader fr = new FileReader(file);
              try (BufferedReader br = new BufferedReader(fr)) {
                  String str;
                  //String text = br.readLine();
                  while ((str = br.readLine()) != null)
                  {
                      TextField textField = new TextField(str);
                      tile.getChildren().add(textField);
                      tile.setAlignment(Pos.TOP_CENTER);
                      //text = text + str;
                  }
                  
                  //htmlEditor.setHtmlText(text);
              }
            }
           catch(IOException e)
            {
                System.out.println("IOException:" + e.getMessage());
            }
        }
        
        else 
        {
            System.out.println("Document open was cancelled by user.");
        }
}
   @FXML 
   private void handleSave(){
        File file = fileChooser.showSaveDialog(null);
        
        
        if(file != null)
        {
            
            String name = file.getAbsolutePath();
            
            if(!name.endsWith(".txt"))
            {
                file = new File(name + ".txt");
            }
            
            try
            {
                FileWriter fw = new FileWriter(file, false);
                try (BufferedWriter bw = new BufferedWriter(fw)) {
                    
                    String string = "";
                    for(Node tp : tile.getChildren()){
                        if(tp instanceof TextField){
                            string = /*string +*/ ((TextField)tp).getText() + "\n";
                        }
                        bw.write(string, 0, string.length());
                        }
                    
                }
                
                
                
                
                
            }
            catch(IOException e)
                   {
                       System.out.println("IOException:" + e.getMessage());
                   }
        }
        
        else
        {
            System.out.println("Document save was cancelled by user.");
        }
   }
   
    @FXML
    private void handleClear(ActionEvent event){
        tile.getChildren().clear();
       
    }
   
    @FXML
    private void handleGoToGame(ActionEvent event) {
        
        
       
        
        Context.getInstance().currentMixer().createArray(tile);
        
       
        this.getSceneManager().switchTo("GameScene"); 
       
       
    }
    
    @FXML
    private void handleAbout(ActionEvent event){
        this.getSceneManager().switchTo("AboutScene");
    }

    @FXML
    private void handleAdd(ActionEvent event){
        TextField textField = new TextField();
        
        tile.getChildren().add(textField);
        tile.setAlignment(Pos.TOP_CENTER);
       
    }
    
     
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //tile.setHgap(12);
        tile.setVgap(10);
        textArea.appendText("Rules:\n-no more than five words\n-each word can only have a\n  max of five letter\n- nothing but letters can be\n   used as words\n-  have fun!!!");
        textArea.setEditable(false);
    }    
   
    
}
