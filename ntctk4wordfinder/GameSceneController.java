/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ntctk4wordfinder;

import com.sun.javafx.scene.traversal.Direction;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

/**
 * FXML Controller class
 *
 * @author Nathan
 */
public class GameSceneController extends Switcher implements Initializable {
    
    @FXML
    private TextFlow textFlow;
    
    @FXML
   private TilePane pane;
  // private GridPane pane;
   
   @FXML
    private void handleOnOpen(ActionEvent event) {
        
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        //System.out.println("You clicked me!");
         this.getSceneManager().switchTo("FinderMenu");
         Context.getInstance().currentMixer().clearArray();
         Context.getInstance().currentMixer().location.clear();
         
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        int i = 0;
        int j = 0;
        //int u = 0;
        //System.out.println(Context.getInstance().currentMixer().words);
        
        int size = Context.getInstance().currentMixer().words.size();
        String[] sArray = new String[size];
        
        for(i=0; i<Context.getInstance().currentMixer().words.size(); i++)
        {
            if(Context.getInstance().currentMixer().words.get(i).length() <= 5 && j <= 4)
            {
                Text text = new Text(Context.getInstance().currentMixer().words.get(i).toLowerCase() + "\n\n");
                textFlow.getChildren().add(text);
                textFlow.setTextAlignment(TextAlignment.CENTER);
                j++;   
            }
        }
            
      //sArray = Context.getInstance().currentMixer().words.toArray(sArray);
        
        
     //char[] array = sArray[0].toCharArray();
      //int charLength = array.length;
        
       
        
        Button[][] buttons = new Button[6][6];
        
        Random random = new Random();
        
     
        String[] letter = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        
        //pane.setAlignment(Pos.CENTER);
        pane.setHgap(0);
        pane.setVgap(0);
      //pane.setPrefColumns(2);
        //pane.setPrefRows(4);
       // for (int i = 0; i<25; i++)
        for(i = 0; i<buttons.length; i++)
        {
            for(j = 0; j<buttons[i].length; j++)
            {   
                int ranNum =  random.nextInt(25);
         
                //Button button = new Button(letter[ranNum]);
                buttons[i][j] = new Button(letter[ranNum]);
                buttons[i][j].setPrefSize(30, 30);
                
                Button button = buttons[i][j];
                button.setOnAction(new EventHandler<ActionEvent>(){
                //buttons[i][j].setOnAction(new EventHandler<ActionEvent>(){
            
                    @Override public void handle(ActionEvent e){
                        //button.setTextFill(Color.RED);
                        
                      
                        
                        if("" != button.getStyle()){
                            button.setStyle("");
                            button.setTextFill(Color.BLACK);
                        }
                        else
                        {
                        button.setStyle("-fx-background-color: blue");
                        button.setTextFill(Color.YELLOW);
                        }
                }
                });
            
            pane.getChildren().add(buttons[i][j]);
         
            }
        }
        
        
        sArray = Context.getInstance().currentMixer().words.toArray(sArray);
        
        for(i = 0; i<sArray.length; i++)
        {
            char[] array = sArray[i].toCharArray();
            //int charLength = array.length;
            Boolean works = true;
            
            int ranDir = random.nextInt(8)+1;
            
            
            switch(ranDir)
            {
                case 1: works = Context.getInstance().currentMixer().fHorizontal(array, buttons);
                        break;
                case 2: works = Context.getInstance().currentMixer().bHorizontal(array, buttons);
                        break;
                case 3: works = Context.getInstance().currentMixer().fVertical(array, buttons);
                        break;
                case 4: works = Context.getInstance().currentMixer().bVertical(array, buttons);
                        break;
                case 5: works = Context.getInstance().currentMixer().diagonalUpL(array, buttons);
                        break;
                case 6: works = Context.getInstance().currentMixer().diagonalUpR(array, buttons);
                        break;
                case 7: works = Context.getInstance().currentMixer().diagonalDownL(array, buttons);
                        break;
                case 8: works = Context.getInstance().currentMixer().diagonalDownR(array, buttons);
                        break;
            }
          
           if(!works)
           {
             i--;  
           }
         
        }
        
       
        
    }    
    
    
}
