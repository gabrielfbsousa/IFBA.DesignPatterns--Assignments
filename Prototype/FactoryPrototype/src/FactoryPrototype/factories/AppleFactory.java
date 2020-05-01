/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryPrototype.factories;

import FactoryPrototype.concreteDisks.AppleDisk;
import FactoryPrototype.concreteMemories.AppleMemory;
import FactoryPrototype.concreteProcessors.AppleProcessor;
import FactoryPrototype.interfaces.IComputerFactory;
import FactoryPrototype.interfaces.IPrototype;
import java.util.HashMap;

/**
 *
 * @author gabriel
 */
public class AppleFactory implements IComputerFactory {

    public HashMap<String, IPrototype> hash = new HashMap<>();

    public AppleFactory() {
        init();
    }

    @Override
    public void init() {
        register(new AppleDisk(), "Disk");
        register(new AppleMemory(), "Memory");
        register(new AppleProcessor(), "Processor");
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
        return "Apple Computer";
    }

}
