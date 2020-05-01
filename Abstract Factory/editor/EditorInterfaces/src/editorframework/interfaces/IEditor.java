/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.interfaces;

import javax.swing.JPanel;

/**
 *
 * @author aluno
 */
public interface IEditor {
    public abstract void setDocument(IDocument doc);
    public abstract JPanel getPanel();
}
