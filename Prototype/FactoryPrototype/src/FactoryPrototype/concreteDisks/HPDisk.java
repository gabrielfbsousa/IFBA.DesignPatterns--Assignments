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
public class HPDisk implements IPrototype{

    @Override
    public IPrototype clone() {
        return new HPDisk();
    }

    @Override
    public String toString() {
        return "HP Disk";
    }
}
