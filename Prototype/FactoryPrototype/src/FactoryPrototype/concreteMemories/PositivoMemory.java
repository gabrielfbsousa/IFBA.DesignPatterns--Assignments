/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryPrototype.concreteMemories;

import FactoryPrototype.interfaces.IPrototype;

/**
 *
 * @author gabriel
 */
public class PositivoMemory implements IPrototype {

    @Override
    public IPrototype clone() {
        return new PositivoMemory();
    }

    @Override
    public String toString() {
        return "Positivo Memory";
    }

}
