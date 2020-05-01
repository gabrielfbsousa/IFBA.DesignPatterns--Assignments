/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryPrototype.concreteProcessors;

import FactoryPrototype.interfaces.IPrototype;

/**
 *
 * @author gabriel
 */
public class AppleProcessor implements IPrototype{
    @Override
    public IPrototype clone() {
        return new AppleProcessor();
    }

    @Override
    public String toString() {
        return "Apple Processor";
    }
}
