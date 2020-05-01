/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.creators;

import editorframework.helps.HelpTxt;
import editorframework.interfaces.HelpCreator;
import editorframework.interfaces.IHelp;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel
 */
public class TxtHelpCreator extends HelpCreator{
    @Override
    public IHelp createHelp() {
        try {
            return new HelpTxt();
        } catch (IOException ex) {
            Logger.getLogger(TxtHelpCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
