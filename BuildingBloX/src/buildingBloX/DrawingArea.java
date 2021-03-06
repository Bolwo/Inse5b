/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildingBloX;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;

/**
 *
 * @author up723003
 */
public class DrawingArea extends javax.swing.JPanel {

    private BufferedImage paintImage;
    private int width;
    private int height;
    private HashMap map = new HashMap();
    
    /**
     * Creates new form DrawingArea
     */
    public DrawingArea(int imageWidth, int imageHeight) {
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = (int) screenSize.getWidth();
        height = (int) screenSize.getHeight();
        paintImage = new BufferedImage(5000, 5000, BufferedImage.TYPE_3BYTE_BGR);
        clearScreen();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1142, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    @Override
    public void paintComponent(Graphics g){
        g.drawImage(paintImage, 0, 0, null);
    }
    
    public void updatePaint(){
        
    }
    
    public void saveWBTChart(){
        File outputfile = new File("WBT.jpg");
        try{
            ImageIO.write(paintImage, "jpg", outputfile);
        }
        catch(IOException exc){
            System.out.println("Fuck.");
        }
    }
    
    public void clearScreen(){
        Graphics g = paintImage.createGraphics();
        g.setColor(new Color(245,255,255));
        g.fillRect(0,0,5000,5000);
        g.dispose();
        repaint();
    }
    
    public void addWBTTask(int x, int y, Node task, int parentX, String parentName){
        
        Graphics g = paintImage.createGraphics();
        String taskName = task.getValue();
        Node parentTask = task.getParent();
        
        
        FontMetrics fm = g.getFontMetrics();
        int stringSize = fm.stringWidth(taskName);
        //Draw box and write text
        g.setColor(new Color(0,0,0));
        Rectangle rect = new Rectangle(x - (stringSize+20), y, stringSize+20, 30);
        g.drawRect((int) rect.getX(), (int) rect.getY(), (int) rect.getWidth(), (int) rect.getHeight());
        g.drawString(taskName, (x - (stringSize+20))+10, y+20);
        
        //Connect boxes
        if(parentTask != null){
            Point currentBox = new Point((int) rect.getX() + ((int) rect.getWidth() /2),y);
            Point parentBox = new Point(parentX - ((fm.stringWidth(parentName)+20)/2), (int) currentBox.getY()-70);
            Line2D parentLine = new Line2D.Double(currentBox, parentBox);
            g.drawLine((int) parentLine.getX1(), (int) parentLine.getY1(), (int) parentLine.getX2(), (int) parentLine.getY2());
            map.put(rect, parentLine);
        }
        g.dispose();
        repaint();
        revalidate();
        setPreferredSize(new Dimension(width, (int) rect.getY()+100));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
