/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.displays;

import editorframework.interfaces.IDisplay;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.*;

/**
 *
 * @author gabriel
 */
public class PDFDisplay implements IDisplay {

    private String name;

    public PDFDisplay() {
        this.name = "PDF";
    }

    @Override
    public JPanel show(final String address) {

        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());

        javax.swing.JButton button = buildButton("document-edit-verify");
        painel.add(button);

        if (button != null) {
            button.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    File file = new File(address + ".pdf");
                    try {
                        java.awt.Desktop.getDesktop().open(file);
                    } catch (IOException ex) {
                        Logger.getLogger(PDFDisplay.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        }

        return painel;
    }

    public String getName() {
        return name;
    }

    public JButton buildButton(String iconName) {
        javax.swing.JButton newButton = new javax.swing.JButton();
        newButton.setIcon(new javax.swing.ImageIcon("/usr/share/icons/oxygen/48x48/actions/" + iconName + ".png"));
        newButton.setFocusable(false);
        newButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        newButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        return newButton;
    }
}
