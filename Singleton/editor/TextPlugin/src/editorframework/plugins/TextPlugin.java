/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.plugins;

import editorframework.interfaces.IClipboard;
import editorframework.interfaces.ICore;
import editorframework.interfaces.IEditor;
import editorframework.interfaces.IEditorFactory;
import editorframework.interfaces.IPlugin;
import editorframework.interfaces.ISerializer;

/**
 *
 * @author aluno
 * This class implements the text document factory.
 */
public class TextPlugin implements IPlugin, IEditorFactory {
    @Override
    public void initialize(ICore core) {
    }

    
    @Override
    public String supportedType() {
        return "Text files";
    }

    @Override
    public String supportedExtensions() {
        return "txt|xml";
    }

    @Override
    public ISerializer createSerializer() {
        return new TextSerializer();
    }

    @Override
    public IEditor createEditor() {
        return new TextEditor();
    }

    @Override
    public IClipboard createClipboard() {
        return new TextClipboard();
    }
}
