/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteratoractivity;

import IteratorActivity.collections.ArrayList;
import IteratorActivity.concreteIterators.ArrayListIteratorA;
import IteratorActivity.interfaces.ICollection;
import IteratorActivity.interfaces.IIterator;

/**
 *
 * @author gabriel
 */
public class IteratorActivity {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        iteratorCollection(new ArrayList());
    }
    
    public static void iteratorCollection(ICollection c){
        c.setIterator(new ArrayListIteratorA(c));
        IIterator i = c.iterator("Altura", 25, "Menor"); // atribui à esse iterator os parâmetros desejados
        while(i.hasNext()){
            Object o = i.next();
        }
    }
    
    // Java bin (pojo) é uma classe Java que só tem atributos privados, e pra eles, apenas gets e sets, além de um construtor sem parâmetro
    //vamos assumir que o iterator vai iterar em collections de pojos (porque o que quero é criar um iterator, e passar como parâmetro:
    //a reflexão computacional serve pra perguntar se o objeto tem a propriedade
}
