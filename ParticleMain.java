/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7done;

import javax.swing.JFrame;

/**
 *
 * @author n.hans
 */
public class ParticleMain {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(800, 800);
        ParticleField pf = new ParticleField(2000,800,800);
        frame.add(pf);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
