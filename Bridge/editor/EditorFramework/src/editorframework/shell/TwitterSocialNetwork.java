/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.shell;

import editorframework.interfaces.IDocument;
import editorframework.interfaces.ISocialNetwork;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class TwitterSocialNetwork implements ISocialNetwork {

    @Override
    public boolean post(IDocument document) {
        javax.swing.JOptionPane.showMessageDialog(null, "Postando no Twitter !", "Opa 2 !", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
    
}
