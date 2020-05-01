/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.plugins;

import editorframework.creators.TwitterCreator;
import editorframework.creators.FacebookCreator;
import editorframework.creators.GooglePlusCreator;
import editorframework.creators.LinkedInCreator;
import editorframework.interfaces.ICore;
import editorframework.interfaces.IPlugin;
import editorframework.interfaces.ISocialNetwork;
import editorframework.interfaces.IUiController;
import editorframework.interfaces.SocialNetworkCreator;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import java.lang.String;
import javax.swing.JOptionPane;

/**
 *
 * @author gabrielferreira
 */
public class SocialNetworkPlugin implements IPlugin {

    @Override
    public void initialize(ICore core) {
        IUiController uiController = core.getUiController();
        final SocialNetworkFactory factory = new SocialNetworkFactory();
        
        factory.register(new FacebookCreator(), "Facebook");
        factory.register(new TwitterCreator(), "Twitter");
        factory.register(new LinkedInCreator(), "LinkedIn");
        factory.register(new GooglePlusCreator(), "Google+");

        
        String[] patternExamples = {
            "Twitter",
            "Facebook",
            "LinkedIn",
            "Google+"
        };

        final JComboBox comboBox = new JComboBox(patternExamples);
        javax.swing.JButton button = uiController.addComboBoxItem(comboBox, "dialog-ok");
        
        if (button != null) {
            button.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    String selected = comboBox.getSelectedItem() + "";
                    ISocialNetwork networkSelected = factory.create(selected);
                    networkSelected.post(null);
                }
            });
        }
        System.out.println("SocialNetwork Plugin initialized !");

    }

}
