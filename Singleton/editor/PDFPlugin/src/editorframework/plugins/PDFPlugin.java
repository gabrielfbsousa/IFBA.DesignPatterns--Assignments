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
 */
public class PDFPlugin  implements IPlugin, IEditorFactory {

    @Override
    public void initialize(ICore core) {
    }

    @Override
    public String supportedType() {
        return "PDF files";
    }

    @Override
    public String supportedExtensions() {
                return "pdf";
    }

    @Override
    public ISerializer createSerializer() {
        return new PDFSerializer();
    }

    @Override
    public IEditor createEditor() {
        return new PDFEditor();
    }

    @Override
    public IClipboard createClipboard() {
        return new PDFClipboard();
    }
    
}
