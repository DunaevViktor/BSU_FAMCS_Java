/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab10;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import javax.swing.JPanel;

class MainFrame extends JFrame{
    public MainFrame() throws HeadlessException{
        super();
        setSize(WIDTH,HEIGHT);
        setLocation((int)(Toolkit.getDefaultToolkit().getScreenSize().width/2 - WIDTH/2),
                (int)(Toolkit.getDefaultToolkit().getScreenSize().height/2 - HEIGHT/2));
        setTitle("test frame");
        Container content=getContentPane();
        TestPanel tp = new TestPanel(list, this);
        content.add(tp);
    }
    public void addPoint(Point2D p){
        list.add(p);
        System.out.println(p.getX() + " " + p.getY());
    }
    private final int WIDTH = 300;
    private final int HEIGHT = 300;
    private ArrayList list = new ArrayList();
}

class MyMouseClick extends MouseAdapter{
    public MyMouseClick(MainFrame frame){
        super();
        this.frame = frame;
    }
    public void mouseClicked(MouseEvent e){
        super.mouseClicked(e);
        frame.addPoint(new Point2D.Float((float)e.getX(),(float)e.getY()));
        frame.repaint();
    }
    MainFrame frame;
}

class TestPanel extends JPanel{
    public TestPanel(ArrayList aList, MainFrame frame){
        super();
        list = aList;
        addMouseListener(new MyMouseClick(frame));
    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawString("Hello, World", 100, 100);
        Graphics2D g2 = (Graphics2D)g;
        for(int i=0;i<list.size();i++){
            g2.setColor(Color.cyan);
            int x = (int)((Point2D)(list.get(i))).getX();
            int y = (int)((Point2D)(list.get(i))).getY();
            g.fillRect(x-1, y-1, 13, 13);
        }
    }
    private ArrayList list;
    private MainFrame frame;
}
/**
 *
 * @author demet
 */

