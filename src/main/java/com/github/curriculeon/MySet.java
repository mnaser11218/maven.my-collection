package com.github.curriculeon;

//import com.sun.org.apache.xalan.internal.xsltc.dom.SingletonIterator;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

public class MySet<T>implements MyCollectionInterface {
    private T[] mySetArray;

    public MySet() {
        mySetArray = (T[]) new Object[]{};
    }

    public MySet(Object[] valuesToBePopulatedWith) {
            mySetArray = (T[]) valuesToBePopulatedWith;
    }

    @Override
    public void add(Object objectToAdd) {
        mySetArray = (T[]) addElementToArray(mySetArray, objectToAdd);
    }

    @Override
    public void remove(Object objectToRemove) {
        mySetArray = (T[]) Arrays.stream(mySetArray).filter(ele-> !ele.equals(objectToRemove)).toArray();
    }

    @Override
    public void remove(int indexOfObjectToRemove) {
        System.out.println("insidde");
        T[] newArray = (T[]) new Object[]{};
        for (int i = 0; i < mySetArray.length; i++) {
            if(i!= indexOfObjectToRemove){
                newArray = addElementToArray(newArray, mySetArray[i]);
            }
            System.out.println(Arrays.asList(newArray));
        }
        mySetArray = newArray;
    }

    @Override
    public Object get(int indexOfElement) {
        return mySetArray[indexOfElement];
    }

    @Override
    public Boolean contains(Object objectToCheckFor) {
        for(T ele: mySetArray){
            if(ele.equals(objectToCheckFor)){
                return true;
            }
        }

        return false;
    }

    @Override
    public Integer size() {
        return mySetArray.length;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
    public <T> T[] addElementToArray(T[] array, T element) {
        @SuppressWarnings("unchecked")
        T[] results = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length + 1);

        for (int i = 0; i < array.length; i++) {
            results[i] = array[i];
        }

        results[array.length] = element;

        return results;
    }
}
