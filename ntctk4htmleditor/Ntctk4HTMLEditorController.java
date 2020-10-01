/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ntctk4htmleditor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Nathan
 */
public class Ntctk4HTMLEditorController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    HTMLEditor htmlEditor;
    
    FileChooser fileChooser = new FileChooser();
    
    @FXML
    private void handleOpen(ActionEvent event) 
    {
      
        File file = fileChooser.showOpenDialog(null);
        
       
        
        if(file != null)
        {
            
          try
           {
                FileReader fr = new FileReader(file);
              try (BufferedReader br = new BufferedReader(fr)) {
                  String str;
                  String text = br.readLine();
                  while ((str = br.readLine()) != null)
                  {
                      text = text + str;
                  }
                  
                  htmlEditor.setHtmlText(text);
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
    private void handleSave(ActionEvent event) 
    {

        File file = fileChooser.showSaveDialog(null);
        
        
        if(file != null)
        {
            
            String name = file.getAbsolutePath();
            
            if(!name.endsWith(".html"))
            {
                file = new File(name + ".html");
            }
            
            try
            {
                FileWriter fw = new FileWriter(file, false);
                try (BufferedWriter bw = new BufferedWriter(fw)) {
                    String string = htmlEditor.getHtmlText();
                    bw.write(string, 0, string.length());
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
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    
    
}
