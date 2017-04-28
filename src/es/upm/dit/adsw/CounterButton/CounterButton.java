package es.upm.dit.adsw.CounterButton;

/**
 * Created by aalonso on 30/3/17.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CounterButton {
    private JLabel jlab; // display the elapsed time
    private JButton jbtnIncrement; // Increment the counter

    private int Counter = 0;

    CounterButton() {
        JFrame jfrm = new JFrame("Counter");
        jfrm.getContentPane().setLayout(new FlowLayout());
        jfrm.setSize(150, 90);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configure the button
        jlab = new JLabel();//("Press Start to begin timing.");
        jfrm.getContentPane().add(jlab);
        jlab.setText("The value is: " + Counter);

        jbtnIncrement = new JButton("Increment");
        jfrm.getContentPane().add(jbtnIncrement);
        jbtnIncrement.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                Counter ++;
                jlab.setText("The value is: " + Counter);
            }
        });

        // Cause the window to be visible
        jfrm.setVisible(true);
    }

    public static void main(String args[]) {
        // Create the frame on the event dispatching thread.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CounterButton();
            }
        });
    }
}
