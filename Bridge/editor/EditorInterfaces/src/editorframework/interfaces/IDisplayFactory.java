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
public interface IDisplayFactory {
    public abstract void show(String scope, javax.swing.JTabbedPane tabbedPane);
    public abstract boolean addDisplay(IDisplay display);
}
