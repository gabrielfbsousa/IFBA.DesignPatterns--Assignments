/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.helps;

import editorframework.interfaces.IDisplayFactory;
import editorframework.interfaces.IHelp;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author gabrielferreira
 */
public class HelpTxt implements IHelp{
    
    private IDisplayFactory factory;
    public String name;
    public String address;

    public HelpTxt() throws IOException{
        name = "Options to work with Txt";
        address = new File("../HelpPlugin/src/res/Txt/txt_help").getCanonicalPath();
    }
    
    public javax.swing.JTabbedPane build(javax.swing.JTabbedPane tabbedPane) {
        tabbedPane.removeAll();
        factory.show(address, tabbedPane);
        
        return tabbedPane;
    }

    public void setDisplayFactory(IDisplayFactory factory) {
        this.factory = factory;
    }


}
