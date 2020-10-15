/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab10;

import javax.swing.JFrame;

/**
 *
 * @author demet
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.*;
import javax.swing.*;

            
public class Lab10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame f = new MyNote("Obrabotka ActionEvent");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame mf = new MainFrame();    
        mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mf.show();
    }
    
}
