/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IteratorActivity.collections;

import IteratorActivity.interfaces.ICollection;
import IteratorActivity.interfaces.IIterator;
import IteratorActivity.iterators.ArrayListIterator;
import java.util.AbstractList;
import java.util.Collection;

/**
 *
 * @author gabriel
 */
public class ArrayList<E> implements ICollection {

    public java.util.ArrayList<E> list;
    public IIterator iterator;

    public ArrayList() {
        list = new java.util.ArrayList();
    }

    public IIterator iterator(String property, int value, String operator) {
        this.iterator.setOperator(operator);
        this.iterator.setValue(value);
        this.iterator.setProperty(property);
        return this.iterator;
    }
    
    @Override
    public void setIterator(IIterator iterator){
        if(iterator instanceof ArrayListIterator){
        this.iterator = iterator;
        this.iterator.setCollection(this);
        }
    }

    @Override
    public AbstractList<E> getList() {
        return (AbstractList) list;
    }

}
