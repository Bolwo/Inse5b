/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildingBloX;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author up723003
 */
public class GraphFrame extends javax.swing.JFrame {

    private BufferedImage paintImage;
    private DrawingArea panel;
    private int width;
    private int height;
    private int imgWidth=0;
    private int imgHeight=0;
    private ArrayList<ArrayList<Node>> chartData;
    private String chartType;
    private int layer = 0;

    public GraphFrame() {

    }

    /**
     * Creates new form GraphFrame
     */
    public GraphFrame(ArrayList<ArrayList<Node>> chartData, String chartType) {
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = (int) screenSize.getWidth();
        height = (int) screenSize.getHeight();
        this.setSize(width, height);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        createPanel();
        panel.setSize(1000, 2000);
        this.chartData = chartData;
        this.chartType = chartType;
        createChart();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        menuBar = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        save = new javax.swing.JMenuItem();
        load = new javax.swing.JMenuItem();
        addButton = new javax.swing.JMenu();
        removeButton = new javax.swing.JMenu();
        exportButton = new javax.swing.JMenu();
        printButton = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setMinimumSize(null);
        jScrollPane1.setPreferredSize(null);

        menu.setText("File");

        save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildingBloX/images/Lester,-Kit.png"))); // NOI18N
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        menu.add(save);

        load.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        load.setIcon(new javax.swing.ImageIcon(getClass().getResource("/buildingBloX/images/Lester,-Kit.png"))); // NOI18N
        load.setText("Load");
        menu.add(load);

        menuBar.add(menu);

        addButton.setText("Add/Edit tasks");
        addButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addButtonMousePressed(evt);
            }
        });
        menuBar.add(addButton);

        removeButton.setText("Remove tasks");
        removeButton.setActionCommand("");
        menuBar.add(removeButton);

        exportButton.setText("Export");
        menuBar.add(exportButton);

        printButton.setText("Print");
        menuBar.add(printButton);

        setJMenuBar(menuBar);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        panel.saveWBTChart();
    }//GEN-LAST:event_saveActionPerformed

    private void addButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMousePressed
        new addTasks().setVisible(true);
    }//GEN-LAST:event_addButtonMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    System.out.println("Done");
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("1");
            java.util.logging.Logger.getLogger(GraphFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            System.out.println("2");
            java.util.logging.Logger.getLogger(GraphFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            System.out.println("3");
            java.util.logging.Logger.getLogger(GraphFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            System.out.println("4");
            java.util.logging.Logger.getLogger(GraphFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraphFrame().setVisible(true);
            }
        });
    }

    public void createPanel() {
        getImageDimensions();
        panel = new DrawingArea(imgWidth, imgHeight);
        System.out.println(panel.getSize());
        jScrollPane1.setViewportView(panel);
        repaint();
        pack();
    }

    public void getImageDimensions(){
        
    }
    
    public void createChart() {
        switch (chartType) {
            case "WBT":
                createWBT();
                break;
            case "PERT":
                break;
            case "GANTT":
                break;
            default:
                break;
        }
    }

    // i for level
    // j for node
    
    public void createWBT() {
        int previousPos = width/2;
        for (int i = 0; i < chartData.size(); i++) {
            int positionOfEachBox = (width / (chartData.get(i).size()+1));
            for(int j = 0; j < chartData.get(i).size(); j++){
                panel.addWBTTask(positionOfEachBox * (1+j), 
                        
                        100+(100*i), 
                        chartData.get(i).get(j), 
                        previousPos * (1+ getParentXPosition(chartData.get(i).get(j).getParent(), i)), 
                        getParentValue(i, j));
            }
            previousPos = positionOfEachBox;
        }
    }
    
    public int getTaskXValue(Node node){
        if(node.getParent() == null){
            return width/2;
        }
        return 5;
    }
    
    public int getParentXPosition(Node node, int array){
        if(array==0){
            return 0;
        }
        else{
            for (int i = 0; i < chartData.get(array-1).size(); i++) {
                if(chartData.get(array-1).get(i) == node){
                    return i;
                }
            }
        }
        return 0;
    }
    
    public String getParentValue(int i, int j){
        if(chartData.get(i).get(j).getParent() != null){
            return chartData.get(i).get(j).getParent().getValue();
        }
        return "";
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu addButton;
    private javax.swing.JMenu exportButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem load;
    private javax.swing.JMenu menu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu printButton;
    private javax.swing.JMenu removeButton;
    private javax.swing.JMenuItem save;
    // End of variables declaration//GEN-END:variables

}
