/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab9done;

import javax.swing.JFrame;

/**
 *
 * @author n.hans
 */
public class LissajousMain {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500,500);
        Lissajous l = new Lissajous(500);
        frame.add(l);
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}
