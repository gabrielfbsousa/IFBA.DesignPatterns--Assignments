/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IteratorActivity.interfaces;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author gabriel
 */
public interface ICollection<E> {
    public abstract AbstractList<E> getList();
    public abstract IIterator iterator(String property, int value, String operator);
    public void setIterator(IIterator iterator);
}
