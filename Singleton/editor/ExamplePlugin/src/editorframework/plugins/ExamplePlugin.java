/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.plugins;

import editorframework.interfaces.IPlugin;
import editorframework.interfaces.ICore;
import editorframework.interfaces.IUiController;

import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class ExamplePlugin implements IPlugin {
    @Override
    public void initialize(ICore core) {
        IUiController uiController = core.getUiController();
        uiController.addMenu("Help");
        javax.swing.JMenuItem newItem = uiController.addMenuItem("Help", "About");
        if (newItem != null) {
            newItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                javax.swing.JOptionPane.showMessageDialog(null, "Funcionou !", "Opa !", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        }
        
        javax.swing.JButton newButton = uiController.addToolBarItem("document-open");
        if (newButton != null) {
            newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                javax.swing.JOptionPane.showMessageDialog(null, "Funcionou o botão !", "Opa 2 !", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        }

        System.out.println("Example Plugin initialized !");
    }
}
