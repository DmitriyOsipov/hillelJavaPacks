package com.lessons.Ex11.hashMap;

/**
 * Created by Dreamer on 19.03.2017.
 */
public abstract class MyMapElement {
    private Object key;
    private Object data;

    public abstract Object getKey();

    public abstract Object getData();

    public abstract void setData(Object value);
}
