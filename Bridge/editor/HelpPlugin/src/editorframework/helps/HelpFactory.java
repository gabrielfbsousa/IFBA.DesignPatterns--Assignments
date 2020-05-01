/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editorframework.helps;

import editorframework.interfaces.HelpCreator;
import editorframework.interfaces.IHelp;
import java.util.HashMap;

/**
 *
 * @author gabriel
 */
public class HelpFactory {
    
  public HashMap<String, IHelp> creators = new HashMap<>();


    public IHelp create(String nome) {
        IHelp selected = creators.get(nome);
        return selected;
    }


    public boolean register(HelpCreator helpCreator, String nome) {
        if (creators.containsKey(nome)) return false;
        creators.put(nome, helpCreator.createHelp());
        return true;
    }


    public boolean unregister(String nome) {
        if (!creators.containsKey(nome)) return false;
        creators.remove(nome);
        return true;
    }  
}
