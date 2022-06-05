/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;


import java.awt.FlowLayout;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;


/**
 *
 * @author raylane
 */
public class Loading implements Runnable {

    private static final String IMAGE_URL = "/caracol.gif";
    private JFrame frame;

    public Loading(JFrame frame) {
        this.frame = frame;
        
    }

    @Override
    public void run() {
        System.out.println("Executando");
        try {
            JDialog dialog = new JDialog(frame);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setTitle("loading...");
            dialog.setSize(800, 600);
            dialog.setLayout(new FlowLayout());
            dialog.setLocationRelativeTo(null);

            dialog.add(new JLabel(new ImageIcon(ImageIO.read(getClass().getResource(IMAGE_URL)))));

            dialog.pack();
            dialog.setLocationByPlatform(true);
            //dialog.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

}
