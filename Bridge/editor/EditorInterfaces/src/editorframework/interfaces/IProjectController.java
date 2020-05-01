/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.interfaces;

/**
 *
 * @author aluno
 */
public interface IProjectController {
    public abstract void initialize(ICore core);
    public void fileOpen(ICore core);
    public void fileSave(ICore core, IDocument doc);
}
