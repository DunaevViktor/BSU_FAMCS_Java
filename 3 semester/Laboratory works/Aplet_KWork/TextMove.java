/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.*;
import javax.swing.*;

public class TextMove implements ActionListener{
    private JTextField tf;
    private JTextArea ta;
    TextMove(JTextField tf, JTextArea ta){
        this.tf=tf;
        this.ta=ta;
    }
    public void actionPerformed(ActionEvent ae){
        ta.append(tf.getText()+"\n");
    }
}
   
class MyNote extends JFrame{
    MyNote(String title){
        super(title);
        Container c = getContentPane();
        JTextField tf = new JTextField("", 50);
        c.add(tf,BorderLayout.NORTH);
        JTextArea ta = new JTextArea();
        ta.setEditable(false);
        c.add(ta);
        JPanel p = new JPanel();
        c.add(p,BorderLayout.SOUTH);
        JButton b = new JButton("OK GO: ");
        p.add(b);
        tf.addActionListener(new TextMove(tf,ta));
        b.addActionListener(new TextMove(tf,ta));
        setSize(300,200);
        setVisible(true);
    }
}
            