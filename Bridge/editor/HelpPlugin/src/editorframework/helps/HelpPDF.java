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
public class HelpPDF implements IHelp {

    private IDisplayFactory factory;
    public String name;
    public String address;

    public HelpPDF() throws IOException {
        name = "How to deal with PDF on this editor";
        address = new File("../HelpPlugin/src/res/Pdf/pdf_help").getCanonicalPath();
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
