/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FactoryPrototype.concreteDisks;

import FactoryPrototype.interfaces.IPrototype;

/**
 *
 * @author gabriel
 */
public class PositivoDisk implements IPrototype {

    @Override
    public IPrototype clone() {
        return new PositivoDisk();
    }

    @Override
    public String toString() {
        return "Positivo Disk";
    }
}
