package com.math.data.impl;

import com.math.data.HeadListNode;

class ImplHeadListNode extends ImplListNode implements HeadListNode {

    @Override
    public boolean isHeadNode() {
        return true;
    }

    @Override
    public boolean isDataNode() {
        return false;
    }

    @Override
    public String toString() {
        return "Head node";
    }
}
