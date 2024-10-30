package com.github.curriculeon;

import java.util.ArrayList;
import java.util.List;

public class MyMap<KeyType, ValueType> implements  MyMapInterface{


    private static class Entry<KeyType, ValueType> {
        KeyType key;
        ValueType value;

        Entry(KeyType key, ValueType value) {
            this.key = key;
            this.value = value;
        }
    }
    final private List<Entry> myMap;

    public MyMap() {
        this.myMap = new ArrayList<>();
    }

    public void put(Object key, Object value){
        myMap.add(new Entry(key, value));
    }

    @Override
    public Object get(Object key) {
       for(Entry ele: myMap){
           if(ele.key.equals(key)){
               return ele.value;
           }
       }
       return null;
    }

    @Override
    public MySet getKeySet() {
        return null;
    }

    @Override
    public MyCollectionInterface getValues() {
        return null;
    }

    @Override
    public MySet<KeyValue> getList() {
        return null;
    }

    @Override
    public MyMapInterface invert() {
        return null;
    }



}
