/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryPrototype.factories;

import FactoryPrototype.concreteDisks.HPDisk;
import FactoryPrototype.concreteMemories.HPMemory;
import FactoryPrototype.concreteProcessors.HPProcessor;
import FactoryPrototype.interfaces.IComputerFactory;
import FactoryPrototype.interfaces.IPrototype;
import java.util.HashMap;

/**
 *
 * @author gabriel
 */
public class HPFactory implements IComputerFactory {

    public HashMap<String, IPrototype> hash = new HashMap<>();
    
    public HPFactory(){
        init();
    }

    @Override
    public void init() {
        register(new HPDisk(), "Disk");
        register(new HPMemory(), "Memory");
        register(new HPProcessor(), "Processor");
    }

    @Override
    public IPrototype create(String prototypeDescription) {
        IPrototype prototype = (IPrototype) hash.get(prototypeDescription);
        return prototype.clone();
    }

    @Override
    public boolean register(IPrototype prototype, String prototypeDescription) {
        if (hash.containsValue(prototype)) {
            return false;
        }
        hash.put(prototypeDescription, prototype);
        return true;
    }

    @Override
    public boolean unregister(String prototypeDescription) {
        if (hash.containsKey(prototypeDescription)) {
            hash.remove(prototypeDescription);
            return true;
        }
        return false;
    }
    
        @Override
    public String description() {
        return "HP Computer";
    }

}
