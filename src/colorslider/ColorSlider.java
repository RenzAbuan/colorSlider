/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lorenz
 */
package colorslider;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class ColorSlider extends JFrame {
    
    JSlider redSlider, greenSlider, blueSlider;
    JLabel redLabel, greenLabel, blueLabel, hexLabel;
    JPanel colorPanel, sliders, labels, generate;
   
    
    public ColorSlider(){
        
        redSlider = new JSlider(JSlider.HORIZONTAL, 0, 255,0);
        greenSlider = new JSlider(JSlider.HORIZONTAL, 0, 255,0);
        blueSlider = new JSlider(JSlider.HORIZONTAL, 0, 255,0);
        
        redLabel= new JLabel("Red = 0");
        greenLabel= new JLabel("Green = 0");
        blueLabel= new JLabel("Blue = 0");
        hexLabel = new JLabel("#000000");
        
        event e = new event();
        redSlider.addChangeListener(e);
        greenSlider.addChangeListener(e);
        blueSlider.addChangeListener(e);
        
        
        colorPanel = new JPanel();
        colorPanel.setBackground(Color.BLACK);
       // colorPanel.setLayout(new GridLayout(3,1,2,2));
        
        Container pane= this.getContentPane();
        pane.setLayout(new GridLayout(2,3,5,5));
        
        sliders = new JPanel();
        labels= new JPanel();
        generate = new JPanel();
        
        
        pane.add(sliders);
        pane.add(labels);
        pane.add(colorPanel);
        pane.add(generate);
        
        sliders.setLayout(new GridLayout(3,1,1,2));
        sliders.add(redSlider);
        sliders.add(greenSlider);
        sliders.add(blueSlider);
        
        labels.setLayout(new GridLayout(3,1,1,2));
        labels.add(redLabel);
        labels.add(greenLabel);
        labels.add(blueLabel); 
        
        generate.setLayout(new GridLayout(1,1,1,2));
        generate.add(hexLabel);
    }
    
    

    public class event implements ChangeListener{
        public void stateChanged(ChangeEvent e){
            int red = redSlider.getValue();
            int green = greenSlider.getValue();
            int blue = blueSlider.getValue();
            
            redLabel.setText("Red = "+red);
            greenLabel.setText("Green = "+green);
            blueLabel.setText("Blue = "+blue);
            
            String hex = String.format("#%02X%02X%02X", red, green, blue);
            
            hexLabel.setText(""+hex);
            
            colorPanel.setBackground(new Color(red,green,blue));
        }
        
    }
    public static void main(String[] args) {
        ColorSlider slide = new ColorSlider();
        slide.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        slide.setSize(300,220);
       // slide.setTitle("Color Generator");
        slide.setVisible(true);
        slide.setLocationRelativeTo(null);
    }
}
