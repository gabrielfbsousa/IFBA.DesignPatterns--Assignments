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
public interface IEditorFactory {
    public abstract String supportedType();
    public abstract String supportedExtensions();
    public abstract ISerializer createSerializer();
    public abstract IEditor createEditor();
    public abstract IClipboard createClipboard();
}
