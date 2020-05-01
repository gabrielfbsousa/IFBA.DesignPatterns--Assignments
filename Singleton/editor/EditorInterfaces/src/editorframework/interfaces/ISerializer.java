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
public interface ISerializer {
    public abstract IDocument load(String fileName);
    public abstract boolean save(IDocument doc, String fileName);
}
