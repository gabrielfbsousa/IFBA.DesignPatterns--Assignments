/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.displays;

import editorframework.interfaces.IDisplay;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author gabriel
 */
public class TxtDisplay implements IDisplay {

    private String name;

    public TxtDisplay() {
        this.name = "Text";
    }

    @Override
    public JPanel show(String address) {
        javax.swing.JPanel panel = new javax.swing.JPanel();

        File file = new File(address + ".txt");
        FileInputStream fis = null;
        String texto = "";

        try {
            fis = new FileInputStream(file);
            int content;
            while ((content = fis.read()) != -1) {
                texto += (char) content;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        JTextArea textArea = new JTextArea(texto);
        textArea.setLineWrap(true); //quebra de linha automática

        //JTextArea textArea = new JTextArea("/home/gabriel/Downloads/Bridge/HelpPlugin/src/res/texto.txt");
        textArea.setEditable(false);
        textArea.setCursor(null);
        textArea.setOpaque(false);
        textArea.setFocusable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setVisible(true);
        textArea.setBounds(0, 0, 200, 50);
        panel.add(textArea);
        
        return panel;
    }

    public String getName() {
        return name;
    }
}
