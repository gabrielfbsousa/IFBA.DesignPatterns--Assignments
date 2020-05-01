/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.shell;

import editorframework.interfaces.ICore;
import editorframework.interfaces.IEditorFactory;
import editorframework.interfaces.IPlugin;
import editorframework.interfaces.IPluginController;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class PluginController implements IPluginController {

    public PluginController()
    {
        loadedPlugins = new ArrayList<IPlugin>();
    }
    @Override
    public void initialize(ICore core) {
        File currentDir = new File("./plugins");
        String []plugins = currentDir.list();
        System.out.println("Found " + plugins.length + " plugins !");
        int i;
        URL []jars = new URL[plugins.length];
        for (i = 0; i < plugins.length; i++)
            try {
                jars[i] = (new File("./plugins/" + plugins[i])).toURI().toURL();
            } catch (MalformedURLException ex) {
                Logger.getLogger(PluginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        URLClassLoader ulc = new URLClassLoader(jars);

        for (i = 0; i < plugins.length; i++) {
            String []parts = jars[i].toString().split("/");
            String className = (parts[parts.length-1]).split("\\.")[0];
            IPlugin plugin = null;
            try {
                plugin = (IPlugin) Class.forName("editorframework.plugins." + className, true, ulc).newInstance();
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(PluginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (plugin != null) {
                System.out.println("Initializing plugin " + className);
                plugin.initialize(core);
                loadedPlugins.add(plugin);
            }
        }
    }

    @Override
    public ArrayList<IPlugin> getAllPlugins() {
        return loadedPlugins;
    }
    
    @Override
    public IEditorFactory getFactoryPluginBySupportedExtension(String extension)
    {
        ArrayList<IPlugin> loadedPlugins = getAllPlugins();
        for (IPlugin plugin : loadedPlugins) {
            if (plugin instanceof IEditorFactory) {
                IEditorFactory factory = (IEditorFactory) plugin;
                if (factory.supportedExtensions().contains(extension))
                    return factory;
            }
        }
        return null;
    }

    private ArrayList<IPlugin> loadedPlugins;
}
