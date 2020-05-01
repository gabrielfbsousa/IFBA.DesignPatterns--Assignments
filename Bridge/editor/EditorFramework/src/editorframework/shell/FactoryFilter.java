/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.shell;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author aluno
 */
public class FactoryFilter extends FileFilter {

    public FactoryFilter(String typeName, String supportedExtensions)
    {
        this.typeName = typeName;
        this.supportedExtensions = supportedExtensions;
    }
    
    @Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return false;
        }
        
        String []parts = file.getName().split("\\.");
        if (parts.length == 1)
            return false;

        String extension = parts[parts.length - 1];
        String []extensions = supportedExtensions.split("\\|");
        for (String extension1 : extensions) {
            if (extension.equals(extension1)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getDescription() {
        return typeName;
    }
    
    private String typeName;
    private String supportedExtensions;
}
