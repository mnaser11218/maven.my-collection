package com.github.curriculeon;

import javax.naming.OperationNotSupportedException;

public class KeyValue<KeyType, ValueType> {
    private KeyType key =null;
    private ValueType value = null;
    public KeyValue(KeyType key, ValueType value) {
        // TODO - Implement method
        this.key = key;
        this.value=value;

    }

    public KeyType getKey() {
        return key; // TODO - Implement method

    }

    public ValueType getValue() {
        return value; // TODO - Implement method
    }

    public void setKey(KeyType key) {
        this.key = key;
        // TODO - Implement method
    }

    public void setValue(ValueType value) {
        this.value= value;
        // TODO - Implement method
    }
}
