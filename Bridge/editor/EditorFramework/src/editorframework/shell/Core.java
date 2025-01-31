/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.shell;

import editorframework.interfaces.ICore;
import editorframework.interfaces.IProjectController;
import editorframework.interfaces.IUiController;
import editorframework.interfaces.IPluginController;

/**
 *
 * @author aluno
 */
public class Core implements ICore {

    public Core()
    {
        uiController = new UiController();
        pluginController = new PluginController();
        pluginController.initialize(this);
        projectController = new ProjectController();
        projectController.initialize(this);
    }
    
    @Override
    public IUiController getUiController() {
        return uiController;
    }

    @Override
    public IProjectController getProjectController() {
        return projectController;
    }
    
    @Override
    public IPluginController getPluginController() {
        return pluginController;
    }
    
    private UiController uiController;
    private ProjectController projectController;
    private PluginController pluginController;
}
