/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7done;

import java.util.Random;

/**
 *
 * @author n.hans
 */
public class Particle {

    private static final Random rng = new Random();
    private static final double BUZZY = 10;
    private double x; 
    private double y;
    private double heading;

    
    public Particle(int width, int height){
        
        x = rng.nextInt(width);
        y = rng.nextInt(height);
        heading = Math.PI * 2 * rng.nextDouble();
        
        
    }
    
    public double getX(){
        return x;
    }
    
    public double getY(){
    return y;
}
    
    public void move(){
        x+= Math.cos(heading);
        y+= Math.sin(heading);
        heading+= rng.nextGaussian()*BUZZY;
    }
    
    
}
