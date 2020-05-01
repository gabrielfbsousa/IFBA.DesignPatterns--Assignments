/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.interfaces;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author aluno
 */
public interface IUiController {
    public abstract boolean addMenu(String menuName);
    public abstract javax.swing.JMenuItem addMenuItem(String menuName, String itemName);
    public abstract javax.swing.JButton addToolBarItem(String iconName);
    public abstract void setCentralWidget(JPanel panel);
}
