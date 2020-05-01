/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.displays;

import editorframework.interfaces.IDisplay;
import javax.swing.JPanel;

/**
 *
 * @author gabriel
 */
public class ImageDisplay implements IDisplay{

    private String name;
    
    public ImageDisplay(){
        this.name = "Image";
    }
    
    @Override
    public JPanel show(String address) {
        javax.swing.JPanel panel = new javax.swing.JPanel();
        javax.swing.ImageIcon img = new javax.swing.ImageIcon(address + ".jpg");

        int largura = img.getIconWidth();
        int altura = img.getIconHeight();

        javax.swing.JLabel labelimg = new javax.swing.JLabel(img);
        labelimg.setSize(largura, altura);

        panel.add(labelimg);
        return panel;
    }

    public String getName() {
        return name;
    }
    
    
}
