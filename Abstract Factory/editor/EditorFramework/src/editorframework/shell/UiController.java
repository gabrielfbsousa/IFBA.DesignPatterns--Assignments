/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.shell;

import editorframework.interfaces.IUiController;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 *
 * @author aluno
 */
public class UiController implements IUiController {
    public UiController()
    {
        mainWindow = new MainWindow();
        mainWindow.setVisible(true);
    }

    @Override
    public boolean addMenu(String menuName) {
        javax.swing.JMenuBar menuBar = mainWindow.getJMenuBar();
        int c = menuBar.getMenuCount();
        for (int i = 0; i < c; ++i)
            if (menuBar.getMenu(i).getText().equals(menuName))
                return false;
      
        javax.swing.JMenu newMenu = new javax.swing.JMenu();
        newMenu.setText(menuName);
        menuBar.add(newMenu);
        return true;
    }

    @Override
    public javax.swing.JMenuItem addMenuItem(String menuName, String itemName) {
        javax.swing.JMenuBar menuBar = mainWindow.getJMenuBar();
        int c = menuBar.getMenuCount();
        javax.swing.JMenu myMenu = null;
        for (int i = 0; i < c; ++i) {
            if (menuBar.getMenu(i).getText().equals(menuName)) {
                myMenu = menuBar.getMenu(i);
                break;
            }
        }
        if (myMenu == null)
            return null;
        
        javax.swing.JMenuItem newMenuItem = new javax.swing.JMenuItem();
        newMenuItem.setText(itemName);
        myMenu.add(newMenuItem);
        return newMenuItem;
    }

    @Override
    public JButton addToolBarItem(String iconName) {
        javax.swing.JButton newButton = new javax.swing.JButton();
        
        newButton.setIcon(new javax.swing.ImageIcon("/usr/share/icons/oxygen/16x16/actions/" + iconName + ".png")); // NOI18N
        newButton.setFocusable(false);
        newButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        newButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mainWindow.getJToolBar().add(newButton);
        return newButton;
    }
    
    @Override
    public void setCentralWidget(JPanel panel)
    {
        mainWindow.getContentPane().add(panel);
    }


    @Override
    public JButton addComboBoxItem(javax.swing.JComboBox comboBox, String iconName) {
        mainWindow.getJToolBar().addSeparator();
        mainWindow.getJToolBar().add(comboBox);
        javax.swing.JButton newButton = this.addToolBarItem(iconName);
        mainWindow.getJToolBar().addSeparator();
        return newButton;
    }
    
    private MainWindow mainWindow;
}
