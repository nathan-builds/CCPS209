/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7done;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author n.hans
 */
public class ParticleField extends JPanel implements Runnable {

    private boolean running = true;
    private List<Particle> particles = new ArrayList<Particle>();

    public ParticleField(int n, int width, int height) {

        setPreferredSize(new Dimension(width, height));

        int count = 0;
        while (count < n) {
            particles.add(new Particle(1, 1));
            count++;
        }

        Thread t = new Thread(this);
        t.start();

    }

    @Override
    public void paintComponent(Graphics g) {
        for (Particle p : particles) {

            int x = (int) p.getX();
            int y = (int) p.getY();

            g.drawRect(x, y, 3, 3);
        }
    }

    public void terminate() {
        running = false;

    }

    @Override
    public void run() {
        while (running) {

            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(ParticleField.class.getName()).log(Level.SEVERE, null, ex);
            }

            for (Particle p : particles) {
                p.move();
            }
            repaint();
        }

    }

}
