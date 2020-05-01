/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IteratorActivity.concreteIterators;

import IteratorActivity.interfaces.ICollection;
import IteratorActivity.iterators.ArrayListIterator;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel
 */
public class ArrayListIteratorB extends ArrayListIterator{

    public ArrayListIteratorB(ICollection collection, String property, int value, String operator) {
        super(collection);
        this.property = property;
        this.value = value;
        this.operator = operator;
    }
    
    public ArrayListIteratorB(ICollection collection){
        super(collection);
    }
    

    @Override
    public Object next() { //Next() que pega apenas números ímpares
        position++;
        if(this.position < collection.getList().size() && (this.position%2 == 1)){
            return collection.getList().get(position);
        }
        return null;
    }
    
    @Override
    public boolean hasNext() {
        Object objectFromList = this.collection.getList().get(position + 1);
       
       Field foundField = null; 
        try {
            foundField = objectFromList.getClass().getDeclaredField(this.property); //verifica se o atributo a verificar existe
        } catch (SecurityException ex) {
            Logger.getLogger(ArrayListIterator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(ArrayListIterator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int fieldValue = 0;
        try {
           fieldValue  = (int) foundField.get(this.property); //recebe o valor deste atributo
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(ArrayListIterator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ArrayListIterator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(fieldValue == this.value - 1){ //compara se o atributo desejado contém o valor que se quer
            return true;
        }
        
        return false;
    }
}
