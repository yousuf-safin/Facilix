/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.facilix;

import com.facilix.ui.HomeJFrame;
import javax.swing.UIManager;
import com.formdev.flatlaf.FlatDarkLaf;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @Yousuf
 */
public class Facilix {

    public static void main(String[] args) {
        // Set the look and feel of the GUI to FlatLaf
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf()); // Use FlatDarkLaf or other FlatLaf themes
        } catch (Exception ex) {
            // If there's an error in setting the look and feel, log the error
            Logger.getLogger(HomeJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HomeJFrame homeFrame = new HomeJFrame();
                homeFrame.setLocationRelativeTo(null);
                homeFrame.setVisible(true);
            }
        });
    }
}
