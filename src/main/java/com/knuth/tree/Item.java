package com.knuth.tree;

/**
 * Container class.
 * <p/>
 * As opposed to {@link java.util.Optional}, value COULD be null.
 */
public class Item {
    private final boolean empty;
    private final Object value;

    private static Item EMPTY = new Item();

    public static Item empty() {
        return EMPTY;
    }

    public static Item ofValue(Object o) {
        return new Item(o);
    }

    private Item() {
        this.empty = true;
        this.value = null;
    }

    private Item(Object value) {
        this.empty = false;
        this.value = value;
    }

    public boolean isEmpty() {
        return empty;
    }

    public Object value() {
        if (empty) {
            throw new IllegalStateException("Contains no value");
        }

        return value;
    }
}
