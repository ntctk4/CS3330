/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audioviz;

import static java.lang.Integer.min;
import static java.lang.Math.random;
import java.util.Random;
import javafx.animation.PathTransition;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 * @author Nathan Callahan
 */
public class Ntctk4RectangelVisualizer implements Visualizer{
    
private String name = "Ntctk4 Rectangle Visualizer";
    
    private Integer numBands;
    private AnchorPane vizPane;
    
 
    private Double minHeight = 20.0; 
    
    private Double width = 0.0;
    private Double height = 0.0;
    
    private Double bandWidth = 0.0;
    
    private Double startHue = 160.0;
    
    private Rectangle[] rectangles;
    
    public Ntctk4RectangelVisualizer() {
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    
    @Override
    public void start(Integer numBands, AnchorPane vizPane){
        end();
        
        this.numBands = numBands;
        this.vizPane = vizPane;
        
        height = vizPane.getHeight();
        width = vizPane.getWidth();
        
        bandWidth = width / numBands;
        rectangles = new Rectangle[numBands];
        
        for(int i=0; i<numBands; i++)
        {
            Rectangle rectangle = new Rectangle();
            rectangle.setX(bandWidth/2 + bandWidth * i);
            rectangle.setY(height/2);
            rectangle.setWidth(bandWidth/2);
            rectangle.setHeight(minHeight);
            rectangle.setFill(Color.hsb(startHue, 1.0, 1.0));
            vizPane.getChildren().add(rectangle);
            rectangles[i] = rectangle;
        }
        
    }
    
    @Override
    public void end(){
         if (rectangles != null) {
            for (int i = 0; i < rectangles.length; i++) {
                vizPane.getChildren().remove(rectangles[i]);
            }
            rectangles = null;
            }
    }
    
    @Override
    public void update(double timestamp, double duration, float[] magnitudes, float[] phases){
        if(rectangles == null){
            return;
        }
              Integer num = min(rectangles.length, magnitudes.length);
        
              Random random = new Random();
              
              //Path path = new Path();
              //PathTransition pathTransition = new PathTransition();
              
              height = vizPane.getHeight();
              width = vizPane.getWidth();
              
              
        for (int i = 0; i < num; i++) {
            
            Path path = new Path();
            PathTransition pathTransition = new PathTransition();
            
            Double ranW = random.nextDouble() * width;
            Double ranH = random.nextDouble()* height;
            
            Double ranW2 = random.nextDouble() * width;
            Double ranH2 = random.nextDouble()* height;
            
            Double ranW3 = random.nextDouble() * width;
            Double ranH3 = random.nextDouble()* height;
            
            

            
            Double  size = magnitudes[i] * -(random.nextDouble());
            rectangles[i].setWidth(size);
            rectangles[i].setHeight(size);
          
           path.getElements().add(new MoveTo(width/2, height/2));
            path.getElements().add(new CubicCurveTo(ranW, ranW2, ranH, ranH2, ranW3, ranH3));
            path.getElements().add(new CubicCurveTo(ranW3, ranW, ranH3, ranH, width/2, height/2));
            
            pathTransition.setDuration(Duration.millis(2000));
            pathTransition.setPath(path);
            pathTransition.setNode(rectangles[i]);
            pathTransition.play();
            
           
            
            
             rectangles[i].setFill(Color.hsb(startHue - (magnitudes[i] * -6.0)* 2, 1.0, 1.0, 1.0));
            
        }
    }
}
