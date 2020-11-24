/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5done;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author n.hans
 */
public class Head extends JPanel {

    private boolean mouseInside = false;

    public Head() {

        setPreferredSize(new Dimension(500, 500));
        setBorder(BorderFactory.createBevelBorder(2));
        addMouseListener(new MyMouseListener(this));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawArc(100, 45, 80, 80, 0, 360);
        g.setColor(Color.blue);

        if (mouseInside) {
            g.drawArc(120, 70, 10, 10, 0, 360);
            g.drawArc(150, 70, 10, 10, 0, 360);
        }
        g.setColor(Color.magenta);
        g.drawLine(140, 85, 140, 100);
        g.setColor(Color.red);
        g.drawArc(110, 55, 60, 60, 0, -180);

    }

    private class MyMouseListener extends MouseAdapter {

        private Head jHead = null;

        public MyMouseListener(Head h) {
            jHead = h;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            mouseInside = true;
            jHead.repaint();
        }

        public void mouseExited(MouseEvent e) {
            mouseInside = false;
            jHead.repaint();
        }

    }
}
