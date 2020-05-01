/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.plugins;

import editorframework.displays.DisplayFactory;
import editorframework.displays.TxtDisplay;
import editorframework.displays.ImageDisplay;
import editorframework.displays.PDFDisplay;
import editorframework.displays.VideoDisplay;
import editorframework.interfaces.ICore;
import editorframework.interfaces.IPlugin;

/**
 *
 * @author gabriel
 */
public class DisplayPlugin implements IPlugin {

    public static DisplayFactory factory;

    @Override
    public void initialize(ICore core) {
        factory = new DisplayFactory();
        factory.addDisplay(new VideoDisplay());
        factory.addDisplay(new TxtDisplay());
        factory.addDisplay(new ImageDisplay());
        factory.addDisplay(new PDFDisplay());
        

        System.out.println("Display Plugin initialized !");
    }

    public static DisplayFactory getDisplayFactory() {
        return factory;
    }

}
