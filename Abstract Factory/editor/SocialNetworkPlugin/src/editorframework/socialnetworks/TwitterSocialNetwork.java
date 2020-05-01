/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package editorframework.socialnetworks;

import editorframework.interfaces.IDocument;
import editorframework.interfaces.ISocialNetwork;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class TwitterSocialNetwork implements ISocialNetwork {
 
    public String networkName;
    
    public TwitterSocialNetwork(){
        networkName = "Twitter";
    }
    
    @Override
    public boolean post(IDocument document) {
        javax.swing.JOptionPane.showMessageDialog(null, "Postando no Twitter !", "Postando...", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }

    @Override
    public String getName() {
        return networkName;
    }
    
    
    
}

