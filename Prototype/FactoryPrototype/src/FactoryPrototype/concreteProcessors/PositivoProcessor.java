/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryPrototype.concreteProcessors;

import FactoryPrototype.concreteMemories.AppleMemory;
import FactoryPrototype.interfaces.IPrototype;

/**
 *
 * @author gabriel
 */
public class PositivoProcessor implements IPrototype{
    @Override
    public IPrototype clone() {
        return new PositivoProcessor();
    }

    @Override
    public String toString() {
        return "Positivo Processor";
    }
}
