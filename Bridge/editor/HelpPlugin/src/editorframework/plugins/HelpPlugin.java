/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.plugins;

import editorframework.helps.HelpFactory;
import editorframework.creators.TxtHelpCreator;
import editorframework.creators.ImageHelpCreator;
import editorframework.creators.PDFHelpCreator;
import editorframework.creators.VideoHelpCreator;
import editorframework.interfaces.ICore;
import editorframework.interfaces.IHelp;
import editorframework.interfaces.IPlugin;
import editorframework.interfaces.IUiController;
import javax.swing.JButton;
import javax.swing.JComboBox;

/**
 *
 * @author gabrielferreira
 */
public class HelpPlugin implements IPlugin {

    public HelpWindow helpWindow;

    @Override
    public void initialize(ICore core) {

        final IUiController uiController = core.getUiController();
        uiController.addMenu("Help");

        javax.swing.JMenuItem newItem = uiController.addMenuItem("Help", "About");
        if (newItem != null) {
            newItem.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    configurePanel(uiController);
                }
            });
        }

        System.out.println("Help Plugin initialized !");

    }

    public void configurePanel(IUiController uiController) {

        helpWindow = new HelpWindow();
        final HelpFactory helpFactory = new HelpFactory();

        helpFactory.register(new VideoHelpCreator(), "Ways to work with videos");
        helpFactory.register(new PDFHelpCreator(), "How to deal with PDF on this editor");
        helpFactory.register(new ImageHelpCreator(), "Working with images");
        helpFactory.register(new TxtHelpCreator(), "Options to work with Txt");

        String[] boxNames = {
            "Ways to work with videos",
            "How to deal with PDF on this editor",
            "Working with images",
            "Options to work with Txt",};

        final JComboBox comboBox = new JComboBox(boxNames);
        helpWindow.getJToolBar().add(comboBox);
        javax.swing.JButton button = buildButton("dialog-ok");
        helpWindow.getJToolBar().add(button);
        helpWindow.pack();
        helpWindow.setVisible(true);

        if (button != null) {
            button.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    String selected = comboBox.getSelectedItem() + "";
                    IHelp selectedHelp = helpFactory.create(selected);
                    selectedHelp.setDisplayFactory(DisplayPlugin.getDisplayFactory());
                    selectedHelp.build(helpWindow.getJTabbedPane());
                    helpWindow.repaint();

                }
            });
        }

        

    }

    public JButton buildButton(String iconName) {
        javax.swing.JButton newButton = new javax.swing.JButton();
        newButton.setIcon(new javax.swing.ImageIcon("/usr/share/icons/oxygen/16x16/actions/" + iconName + ".png")); // NOI18N
        newButton.setFocusable(false);
        newButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        newButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        return newButton;
    }

}
