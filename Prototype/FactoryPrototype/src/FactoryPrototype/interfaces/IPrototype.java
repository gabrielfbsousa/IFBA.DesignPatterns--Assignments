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
public interface IPrototype {

    public abstract IPrototype clone();

    public abstract String toString();
}
