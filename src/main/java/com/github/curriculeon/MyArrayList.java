package com.github.curriculeon;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyArrayList<SomeType> implements MyCollectionInterface{
    private SomeType[] arrayList = (SomeType[]) new Object[]{};

    public MyArrayList() {
    }

    public MyArrayList(SomeType[] valuesToBePopulatedWith) {
        for(SomeType value: valuesToBePopulatedWith){
              arrayList= addElementToArray(arrayList, value);
        }
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


    @Override
    public void add(Object objectToAdd) {
       arrayList = (SomeType[]) addElementToArray(arrayList, objectToAdd);
    }

    @Override
    public void remove(Object objectToRemove) {
        @SuppressWarnings("unchecked")
        SomeType[] results = (SomeType[]) Array.newInstance(arrayList.getClass().getComponentType(), 0);
        for(SomeType ele: arrayList){
            if(!ele.equals(objectToRemove)){
              results=  addElementToArray(results, ele);
            }
            arrayList = results;
        }

    }

    @Override
    public void remove(int indexOfObjectToRemove) {
        @SuppressWarnings("unchecked")
        SomeType[] results = (SomeType[]) Array.newInstance(arrayList.getClass().getComponentType(), 0);
        int index = 0;
        for(SomeType ele: arrayList) {

            System.out.println("testing: " + index);
            if ( indexOfObjectToRemove != index) {
              results=  addElementToArray(results, ele);
            }
            index++;
        }
            arrayList = results;
    }

    @Override
    public Object get(int indexOfElement) {
        return arrayList[indexOfElement];
    }

    @Override
    public Boolean contains(Object objectToCheckFor) {
        boolean results = false;
        for(SomeType ele: arrayList){
            if(ele.equals(objectToCheckFor)){
                results = true;
                break;
            }
        }
        return results;
    }

    @Override
    public Integer size() {
        return arrayList.length;
    }

    @Override
    public Iterator iterator() {

        return null;
    }
}
