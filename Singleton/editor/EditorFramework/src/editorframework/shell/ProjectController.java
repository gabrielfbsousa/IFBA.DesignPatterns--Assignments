/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.shell;

import editorframework.interfaces.ICore;
import editorframework.interfaces.IDocument;
import editorframework.interfaces.IEditor;
import editorframework.interfaces.IEditorFactory;
import editorframework.interfaces.IPlugin;
import editorframework.interfaces.IProjectController;
import editorframework.interfaces.ISerializer;
import editorframework.interfaces.IUiController;
import editorframework.interfaces.SocialNetworkCreator;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class ProjectController implements IProjectController {

    @Override
    public void initialize(final ICore core) {
        IUiController uiController = core.getUiController();
        uiController.addMenu("File");
        javax.swing.JMenuItem newItem = uiController.addMenuItem("File", "Open");
        if (newItem != null) {
            newItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileOpen(core);
            }
        });
        }
        
        javax.swing.JButton newButton = uiController.addToolBarItem("document-open");
        if (newButton != null) {
            newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileOpen(core);
            }
        });
        }

        newItem = uiController.addMenuItem("File", "Save");
        if (newItem != null) {
            newItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileSave(core, null);
            }
        });
        }
        
        newButton = uiController.addToolBarItem("document-save");
        if (newButton != null) {
            newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileSave(core, null);
            }
        });
        }
        
        newButton = uiController.addToolBarItem("fork");
        if (newButton != null) {
            newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                post(core);
            }
        });
        }
        
        socialNetworkCreator = null;
        setSocialNetworkCreator(new TwitterCreator());
    }
    
    public boolean post(ICore core)
    {
        if (socialNetworkCreator == null) {
            javax.swing.JOptionPane.showMessageDialog(null, "Creator concreto de Redes Sociais não ajustado !", "Opa 2 !", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return socialNetworkCreator.post(currentDocument);
    }

    public void fileOpen(ICore core)
    {
        ArrayList<IPlugin> loadedPlugins = core.getPluginController().getAllPlugins();
        Iterator i = loadedPlugins.iterator();
        JFileChooser jfc = new JFileChooser();
	jfc.setDialogTitle("Open Document");
	jfc.setDialogType(JFileChooser.OPEN_DIALOG);
        while (i.hasNext()) {
            IPlugin plugin = (IPlugin) i.next();
            if (plugin instanceof IEditorFactory) {
                IEditorFactory factoryPlugin = (IEditorFactory) plugin;
                FactoryFilter ff = new FactoryFilter(factoryPlugin.supportedType(), factoryPlugin.supportedExtensions());
                jfc.addChoosableFileFilter(ff);
            }
        }
        if (jfc.showDialog(null, "Ok") == JFileChooser.APPROVE_OPTION)
        {
            File documentFile = jfc.getSelectedFile();
            String[] documentFileName = documentFile.getName().split("\\.");
            IEditorFactory factory = core.getPluginController().getFactoryPluginBySupportedExtension(documentFileName[documentFileName.length-1]);
            if (factory != null) {
                ISerializer serializer = factory.createSerializer();
                IDocument document = serializer.load(documentFile.getAbsolutePath());
                IEditor editor = factory.createEditor();
                editor.setDocument(document);
                core.getUiController().setCentralWidget(editor.getPanel());
            }
        }
    }
    
    public void fileSave(ICore core, IDocument doc)
    {
    }
    
    public void setSocialNetworkCreator(SocialNetworkCreator socialNetworkCreator)
    {
        this.socialNetworkCreator = socialNetworkCreator;
    }
    
    private SocialNetworkCreator socialNetworkCreator;
    private IDocument currentDocument;
}