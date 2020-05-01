/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.displays;

import editorframework.interfaces.IDisplay;
import editorframework.interfaces.IDisplayFactory;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author gabriel
 */
public class DisplayFactory implements IDisplayFactory {

    public ArrayList<IDisplay> displayList;

    public DisplayFactory() {
        displayList = new ArrayList();
    }

    public void show(String address, final javax.swing.JTabbedPane tabbedPane) {

        for (int i = 0; i < displayList.size(); i++) {
            final int j = i;
            javax.swing.JPanel panel = displayList.get(i).show(address);
            JScrollPane scroll = new JScrollPane(panel);
            tabbedPane.add(displayList.get(i).getName(), scroll);
        }
    }

    public boolean addDisplay(IDisplay display) {
        if (displayList.contains(display)) {
            return false;
        }
        displayList.add(display);

        return true;
    }
    

}
