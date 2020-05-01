/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.interfaces;

/**
 *
 * @author gabriel
 */
public interface IHelp {
    public abstract void setDisplayFactory(IDisplayFactory factory);
    public abstract javax.swing.JTabbedPane build(javax.swing.JTabbedPane tabbedPane);
}
