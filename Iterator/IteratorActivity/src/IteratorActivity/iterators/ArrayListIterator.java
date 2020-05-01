/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IteratorActivity.iterators;

import IteratorActivity.interfaces.ICollection;
import IteratorActivity.interfaces.IIterator;

/**
 *
 * @author gabriel
 */
public abstract class ArrayListIterator extends IIterator {

    public ArrayListIterator(ICollection collection) {
        super(collection);
    }

    @Override
    public abstract Object next();

    @Override
    public abstract boolean hasNext();

    @Override
    public void setCollection(ICollection collection) {
        this.collection = collection;
        this.position = -1;
    }
    
    
}
