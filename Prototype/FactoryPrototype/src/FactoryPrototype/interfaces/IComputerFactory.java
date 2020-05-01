package FactoryPrototype.interfaces;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gabriel
 */
public interface IComputerFactory {

    public abstract IPrototype create(String prototypeDescription);

    public abstract boolean register(IPrototype prototype, String prototypeDescription);

    public abstract boolean unregister(String prototypeDescription);
    
    public abstract void init();
    
    public abstract String description();
}
