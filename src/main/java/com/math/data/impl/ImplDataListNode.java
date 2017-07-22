package com.math.data.impl;

import com.math.data.DataListNode;

import java.util.Objects;

class ImplDataListNode extends ImplListNode implements DataListNode {
    private Object data;

    ImplDataListNode(Object data) {
        Objects.requireNonNull(data);
        this.data = data;
    }

    @Override
    public Object getData() {
        checkStale();
        return data;
    }


    @Override
    public void setData(Object o) {
        checkStale();
        Objects.requireNonNull(o);
        this.data = o;
    }

    @Override
    public String toString() {
        return "Data node {data=" + data + "}";
    }
}
