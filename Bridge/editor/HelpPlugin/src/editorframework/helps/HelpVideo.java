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
 * @author gabriel
 */
public class HelpVideo implements IHelp{
    
    private IDisplayFactory factory;
    public String name;
    public String address;

    public HelpVideo() throws IOException{
        name = "Ways to work with videos";
        address = new File("../HelpPlugin/src/res/Video/video_help").getCanonicalPath(); 
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
