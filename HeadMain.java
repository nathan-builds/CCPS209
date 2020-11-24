/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab5done;

import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 *
 * @author n.hans
 */
public class HeadMain {

    public static void main(String[] args) {
        Head head1 = new Head();
        Head head2 = new Head();
        Head head3 = new Head();
        Head head4 = new Head();

        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(2, 2));
        frame.add(head1);
        frame.add(head2);
        frame.add(head3);
        frame.add(head4);

        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
