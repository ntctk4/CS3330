/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ntctk4wordfinder;

import com.sun.javafx.scene.traversal.Direction;
import java.awt.Point;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;

/**
 *
 * @author Nathan
 */
public class WordMixer {
   
    
    int i = 0;
    int j = 0;
    int k = 0;
    List<String> words = new ArrayList<String>();
    List<LocationHolder> location = new ArrayList<>();
    //http://stackoverflow.com/questions/943113/algorithm-to-generate-a-crossword
    //http://www.codeproject.com/Articles/571299/Structuring-a-Word-Search-Generator
    
    Random rand = new Random();
    
    
    public void WordMixer()
    {
     
    }
    
    public void createArray(TilePane tile)
    {
        i = 0;
        
        for(Node tp : tile.getChildren()){
            if(tp instanceof TextField){
                if(((TextField)tp).getText().length() <= 5 && i <= 4)
                {
                    words.add(((TextField)tp).getText().replaceAll("\\s", "").replaceAll("[^A-Za-z]+", "").trim());
                    i++;
                }
                //else
                    //System.out.println(((TextField)tp).getText()+ " is too long for the word find\n");
            }
        }
       
       Comparator<String> len = (String word1, String word2) -> {
           if(word1.length() > word2.length())
               return -1;
           
           if(word1.length() > word2.length())
               return 1;
           
           return 0;
        };
       Collections.sort(words, len);
    }
    
    
    
    public void clearArray()
    {
        words.clear();
    }
    
    
    
    public Boolean fHorizontal(char[] array, Button[][] buttons)
    {
            int charLength = array.length;
            int hRan = rand.nextInt((6-charLength)+1);
            int vRan = rand.nextInt(6);
      
            
            int hCheck = 0;
            int vCheck = 0;
            
            
            
           
           
            if(!location.isEmpty())
            {
                for(i = 0; i<charLength; i++)
                {
                    String valString = Character.toString(array[i]).toLowerCase();
                    if(i == 0)
                    {
                        hCheck = hRan;
                        vCheck = vRan;
                        j = 0;
                    }
                    while(location.size() > k)
                    {
                        if(hCheck == location.get(k).x && vCheck == location.get(k).y)
                        {
                            //if(!location.get(k).letter.equals(valString))
                            if(valString != location.get(k).letter)
                            {
                                hRan = rand.nextInt((6-charLength)+1);
                                vRan = rand.nextInt(6);
                                k=location.size();
                                i = -1;
                                j++;
                            } 
                        }
                            k++;
                    }
                    hCheck++;
                    k=0;
                    
                 if(j >= 20)
                     return false;
                }
            }
           
           
            for(j= 0; j<charLength; j++)
            {
                String valString2 = Character.toString(array[j]).toLowerCase();
                buttons[vRan][hRan].setText(valString2);
                LocationHolder holder = new LocationHolder(hRan, vRan, valString2);
                location.add(holder);
                buttons[vRan][hRan].setPrefSize(30, 30);
                hRan++;
            }
            return true;
    }
    
    
    public Boolean bHorizontal(char[] array, Button[][] buttons)
    {
            int charLength = array.length;
            int hRan = rand.nextInt((6-charLength)+1)+ (charLength-1);
            int vRan = rand.nextInt(6);
           
            int hCheck = 0;
            int vCheck = 0;
            j = 0;
            
            
           
           
            if(!location.isEmpty())
            {
                for(i = 0; i<charLength; i++)
                {
                    String valString = Character.toString(array[i]).toLowerCase();
                    if(i == 0)
                    {
                        hCheck = hRan;
                        vCheck = vRan;
                    }
                    while(location.size() > k)
                    {
                        if(hCheck == location.get(k).x && vCheck == location.get(k).y)
                        {
                            //if(!location.get(k).letter.equals(valString))
                            if(valString != location.get(k).letter)
                            {
                                hRan = rand.nextInt((6-charLength)+1)+ (charLength-1);
                                vRan = rand.nextInt(6);
                                k=location.size();
                                i = -1;
                                j++;
                            } 
                        }
                            k++;
                    }
                    hCheck--;
                    k=0;
                    
                    if(j >= 20)
                        return false;
                }
            }
           
            
            
            
            
            for(int j= 0; j<charLength; j++)
            {
                String valString2 = Character.toString(array[j]).toLowerCase();
                buttons[vRan][hRan].setText(valString2);
                LocationHolder holder = new LocationHolder(hRan, vRan, valString2);
                location.add(holder);
                buttons[vRan][hRan].setPrefSize(30, 30);
                hRan--;
            }
            return true;
    }
    
    public Boolean fVertical(char[] array, Button[][] buttons)
    {
            int charLength = array.length;
            int hRan = rand.nextInt(6);
            int vRan = rand.nextInt((6-charLength)+1);
            
            int hCheck = 0;
            int vCheck = 0;
            j = 0;
            
            
           
           
            if(!location.isEmpty())
            {
                for(i = 0; i<charLength; i++)
                {
                    String valString = Character.toString(array[i]).toLowerCase();
                    if(i == 0)
                    {
                        hCheck = hRan;
                        vCheck = vRan;
                    }
                    while(location.size() > k)
                    {
                        if(hCheck == location.get(k).x && vCheck == location.get(k).y)
                        {
                            //if(!location.get(k).letter.equals(valString))
                            if(valString != location.get(k).letter)
                            {
                                hRan = rand.nextInt(6);
                                vRan = rand.nextInt((6-charLength)+1);
                                k=location.size();
                                i = -1;
                                j++;
                            } 
                        }
                            k++;
                    }
                    vCheck++;
                    k=0;
                    
                    if(j >= 20)
                        return false;
                }
            }
           
            
            
            
            for(int j= 0; j<charLength; j++)
            {
                String valString2 = Character.toString(array[j]).toLowerCase();
                buttons[vRan][hRan].setText(valString2);
                LocationHolder holder = new LocationHolder(hRan, vRan, valString2);
                location.add(holder);
                buttons[vRan][hRan].setPrefSize(30, 30);
                vRan++;
            }
            return true;
    }
    
    
    public Boolean bVertical(char[] array, Button[][] buttons)
    {
            int charLength = array.length;
            int hRan = rand.nextInt(6);
            int vRan = rand.nextInt((6-charLength)+1)+ (charLength-1);
            
            int hCheck = 0;
            int vCheck = 0;
            j = 0;
            
            
           
           
            if(!location.isEmpty())
            {
                for(i = 0; i<charLength; i++)
                {
                    String valString = Character.toString(array[i]).toLowerCase();
                    if(i == 0)
                    {
                        hCheck = hRan;
                        vCheck = vRan;
                    }
                    while(location.size() > k)
                    {
                        if(hCheck == location.get(k).x && vCheck == location.get(k).y)
                        {
                            //if(!location.get(k).letter.equals(valString))
                            if(valString != location.get(k).letter)
                            {
                                hRan = rand.nextInt(6);
                                vRan = rand.nextInt((6-charLength)+1)+ (charLength-1);
                                k=location.size();
                                i = -1;
                                j++;
                            } 
                        }
                            k++;
                    }
                    vCheck--;
                    k=0;
                    
                    if(j >= 20)
                        return false;
                }
            }
            
            
            
            for(int j= 0; j<charLength; j++)
            {
                String valString2 = Character.toString(array[j]).toLowerCase();
                buttons[vRan][hRan].setText(valString2);
                LocationHolder holder = new LocationHolder(hRan, vRan, valString2);
                location.add(holder);
                buttons[vRan][hRan].setPrefSize(30, 30);
                vRan--;
            }
            return true;
    }
    
    public Boolean diagonalUpL(char[] array, Button[][] buttons)
    {
            int charLength = array.length;
            int hRan = rand.nextInt((6-charLength)+1)+ (charLength-1);
            int vRan = rand.nextInt((6-charLength)+1)+ (charLength-1);
            
            int hCheck = 0;
            int vCheck = 0;
            j = 0;
            
            
           
           
            if(!location.isEmpty())
            {
                for(i = 0; i<charLength; i++)
                {
                    String valString = Character.toString(array[i]).toLowerCase();
                    if(i == 0)
                    {
                        hCheck = hRan;
                        vCheck = vRan;
                    }
                    while(location.size() > k)
                    {
                        if(hCheck == location.get(k).x && vCheck == location.get(k).y)
                        {
                            //if(!location.get(k).letter.equals(valString))
                            if(valString != location.get(k).letter)
                            {
                                hRan = rand.nextInt((6-charLength)+1)+ (charLength-1);
                                vRan = rand.nextInt((6-charLength)+1)+ (charLength-1);
                                k=location.size();
                                i = -1;
                                j++;
                            } 
                        }
                            k++;
                    }
                    vCheck--;
                    hCheck--;
                    k=0;
                    
                    if(j >= 20)
                        return false;
                }
            }
            
            
            
            
            for(int j= 0; j<charLength; j++)
            {
                String valString2 = Character.toString(array[j]).toLowerCase();
                buttons[vRan][hRan].setText(valString2);
                LocationHolder holder = new LocationHolder(hRan, vRan, valString2);
                location.add(holder);
                buttons[vRan][hRan].setPrefSize(30, 30);
                vRan--;
                hRan--;
            }
            return true;
    }
    
    public Boolean diagonalUpR(char[] array, Button[][] buttons)
    {
            int charLength = array.length;
            int hRan = rand.nextInt((6-charLength)+1);
            int vRan = rand.nextInt((6-charLength)+1) +(charLength-1);
            
            int hCheck = 0;
            int vCheck = 0;
            j = 0;
            
            
           
           
            if(!location.isEmpty())
            {
                for(i = 0; i<charLength; i++)
                {
                    String valString = Character.toString(array[i]).toLowerCase();
                    if(i == 0)
                    {
                        hCheck = hRan;
                        vCheck = vRan;
                    }
                    while(location.size() > k)
                    {
                        if(hCheck == location.get(k).x && vCheck == location.get(k).y)
                        {
                            //if(!location.get(k).letter.equals(valString))
                            if(valString != location.get(k).letter)
                            {
                                hRan = rand.nextInt((6-charLength)+1);
                                vRan = rand.nextInt((6-charLength)+1)+ (charLength-1);
                                k=location.size();
                                i = -1;
                                j++;
                            } 
                        }
                            k++;
                    }
                    vCheck--;
                    hCheck++;
                    k=0;
                    
                    if(j >= 20)
                        return false;
                }
            }
            
            
            
            
            for(int j= 0; j<charLength; j++)
            {
                String valString2 = Character.toString(array[j]).toLowerCase();
                //buttons[vRan][hRan] = new Button(valString);
                buttons[vRan][hRan].setText(valString2);
                LocationHolder holder = new LocationHolder(hRan, vRan, valString2);
                location.add(holder);
                buttons[vRan][hRan].setPrefSize(30, 30);
                vRan--;
                hRan++;
            }
            return true;
    }
    
    public Boolean diagonalDownL(char[] array, Button[][] buttons)
    {
            int charLength = array.length;
            int hRan = rand.nextInt((6-charLength)+1);
            int vRan = rand.nextInt((6-charLength)+1);
            
            int hCheck = 0;
            int vCheck = 0;
            j = 0;
            
            
           
           
            if(!location.isEmpty())
            {
                for(i = 0; i<charLength; i++)
                {
                    String valString = Character.toString(array[i]).toLowerCase();
                    if(i == 0)
                    {
                        hCheck = hRan;
                        vCheck = vRan;
                    }
                    while(location.size() > k)
                    {
                        if(hCheck == location.get(k).x && vCheck == location.get(k).y)
                        {
                            //if(!location.get(k).letter.equals(valString))
                            if(valString != location.get(k).letter)
                            {
                                hRan = rand.nextInt((6-charLength)+1);
                                vRan = rand.nextInt((6-charLength)+1);
                                k=location.size();
                                i = -1;
                                j++;
                            } 
                        }
                            k++;
                    }
                    vCheck++;
                    hCheck++;
                    k=0;
                    
                    if(j >= 20)
                        return false;
                }
            }
            
            
            
            
            
            for(int j= 0; j<charLength; j++)
            {
                String valString2 = Character.toString(array[j]).toLowerCase();
                buttons[vRan][hRan].setText(valString2);
                LocationHolder holder = new LocationHolder(hRan, vRan, valString2);
                location.add(holder);
                buttons[vRan][hRan].setPrefSize(30, 30);
                vRan++;
                hRan++;
            }
            return true;
    }
    
    public Boolean diagonalDownR(char[] array, Button[][] buttons)
    {
            int charLength = array.length;
            int hRan = rand.nextInt((6-charLength)+1)+ (charLength-1);
            int vRan = rand.nextInt((6-charLength)+1);
            
            int hCheck = 0;
            int vCheck = 0;
            j = 0;
            
            
           
           
            if(!location.isEmpty())
            {
                for(i = 0; i<charLength; i++)
                {
                    String valString = Character.toString(array[i]).toLowerCase();
                    if(i == 0)
                    {
                        hCheck = hRan;
                        vCheck = vRan;
                    }
                    while(location.size() > k)
                    {
                        if(hCheck == location.get(k).x && vCheck == location.get(k).y)
                        {
                            //if(!location.get(k).letter.equals(valString))
                            if(valString != location.get(k).letter)
                            {
                                hRan = rand.nextInt((6-charLength)+1)+ (charLength-1);
                                vRan = rand.nextInt((6-charLength)+1);
                                k=location.size();
                                i = -1;
                                j++;
                            } 
                        }
                            k++;
                    }
                    vCheck++;
                    hCheck--;
                    k=0;
                    
                    if(j >= 20)
                        return false;
                }
            }
            
            
            
            
            for(int j= 0; j<charLength; j++)
            {
                String valString2 = Character.toString(array[j]).toLowerCase();
                buttons[vRan][hRan].setText(valString2);
                LocationHolder holder = new LocationHolder(hRan, vRan, valString2);
                location.add(holder);
                buttons[vRan][hRan].setPrefSize(30, 30);
                vRan++;
                hRan--;
            }
            return true;
    }
 
    
}
