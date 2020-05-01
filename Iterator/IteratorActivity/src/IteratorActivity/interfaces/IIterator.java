/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IteratorActivity.interfaces;

/**
 *
 * @author gabriel
 */
public abstract class IIterator {
    public abstract void setCollection(ICollection collection);
    public abstract Object next(); //A semântica é: me dê o próximo
    public abstract boolean hasNext(); //baseado em reflexão computacional. A meta é 
    //fazer um new Iterator("propriedade", "operador", "valor")
    
    public IIterator(ICollection collection){
        this.collection = collection;
        this.position = -1;
    }
    
    public void setProperty(String property) {
        this.property = property;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
    
    public ICollection collection;
    public int position;
    public String property; // a propriedade que se quer analisar ou comparar (como "idade")
    public int value; // o valor, o valor ao qual se quer comparar (digamos, 25)
    public String operator; //o segundo parâmetro é um operador (digamos, "menor")
}
