package com.github.curriculeon;

import java.lang.reflect.Array;
import java.util.Iterator;

public class MyLinkedList<SomeType>  implements MyCollectionInterface{
    private SomeType[] linkedList = (SomeType[]) new Object[]{};

    public MyLinkedList() {
    }

    public MyLinkedList(SomeType... valuesToBePopulatedWith) {
        for(SomeType value: valuesToBePopulatedWith){
            this.linkedList= addElementToArray(this.linkedList, value);
        }
    }


    @Override
    public void add(Object objectToAdd) {
        linkedList = (SomeType[]) addElementToArray(linkedList, objectToAdd);

    }

    @Override
    public void remove(Object objectToRemove) {
        SomeType[] results = (SomeType[]) Array.newInstance(linkedList.getClass().getComponentType(), 0);
        for(SomeType ele: linkedList){
            if(!ele.equals(objectToRemove)){
                results=  addElementToArray(results, ele);
            }
            linkedList = results;
        }
    }

    @Override
    public void remove(int indexOfObjectToRemove) {
        @SuppressWarnings("unchecked")
        SomeType[] results = (SomeType[]) Array.newInstance(linkedList.getClass().getComponentType(), 0);
        int index = 0;
        for(SomeType ele: linkedList) {

            System.out.println("testing: " + index);
            if ( indexOfObjectToRemove != index) {
                results=  addElementToArray(results, ele);
            }
            index++;
        }
        linkedList = results;
    }

    @Override
    public Object get(int indexOfElement) {
        return linkedList[indexOfElement];
    }

    @Override
    public Boolean contains(Object objectToCheckFor) {
        boolean results = false;
        for(SomeType ele: linkedList){
            if(ele.equals(objectToCheckFor)){
                results = true;
                break;
            }
        }
        return results;
    }

    @Override
    public Integer size() {
        return linkedList.length;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    public <SomeType> SomeType[] addElementToArray(SomeType[] array, SomeType element) {
        @SuppressWarnings("unchecked")
        SomeType[] results = (SomeType[]) Array.newInstance(array.getClass().getComponentType(), array.length + 1);

        for (int i = 0; i < array.length; i++) {
            results[i] = array[i];
        }

        results[array.length] = element;

        return results;
    }
}
