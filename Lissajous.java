/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab9done;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author n.hans
 */
public class Lissajous extends JPanel {

    public JTextField aText;
    public JTextField bText;
    public JTextField deltaText;
    public int jSize;
    int previousX = 0;
    int previousY = 0;

    public Lissajous(int size) {

        setPreferredSize(new Dimension(size, size));

        jSize = size;
        aText = new JTextField("2    ");
        bText = new JTextField("3     ");
        deltaText = new JTextField("0.5     ");

        FieldListener listener = new FieldListener(this);
        aText.addActionListener(listener);
        bText.addActionListener(listener);
        deltaText.addActionListener(listener);

        JLabel aLabel = new JLabel("a");
        JLabel bLabel = new JLabel("b");
        JLabel delta = new JLabel("delta");

        add(aLabel);
        add(aText);
        add(bLabel);
        add(bText);
        add(delta);
        add(deltaText);

    }

    @Override
    public void paintComponent(Graphics g) {

        double a = Double.parseDouble(aText.getText());
        double b = Double.parseDouble(bText.getText());
        double delta = Double.parseDouble(deltaText.getText());

        double firstX = jSize / 2 + 2 * jSize / 5 * Math.sin(a * 0 + delta); // t = 0 on first go 
        double firstY = jSize / 2 + 2 * jSize / 5 * Math.cos(b * 0);
        previousX = (int) firstX;
        previousY = (int) firstY;

        for (double t = 0; t < ((a + b) * Math.PI); t += .01) {
            double currentX = jSize / 2 + 2 * jSize / 5 * Math.sin(a * t + delta);
            double currentY = jSize / 2 + 2 * jSize / 5 * Math.cos(b * t);
            g.drawLine((int) currentX, (int) currentY, (int) previousX, (int) previousY);
            previousX = (int) currentX;
            previousY = (int) currentY;

        }

    }

    class FieldListener implements ActionListener {

        Lissajous lissajous;

        public FieldListener(Lissajous lis) {
            lissajous = lis;

        }

        @Override
        public void actionPerformed(ActionEvent arg0) {

            lissajous.repaint();

        }

    }

}
