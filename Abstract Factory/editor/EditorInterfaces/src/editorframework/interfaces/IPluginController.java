/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.interfaces;

import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public interface IPluginController {
   public abstract void initialize(ICore core);
   public abstract ArrayList<IPlugin> getAllPlugins();
   public abstract IEditorFactory getFactoryPluginBySupportedExtension(String extension);
}
