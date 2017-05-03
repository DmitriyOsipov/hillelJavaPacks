package com.lessons.Ex8_2.Queues;

import com.lessons.Ex8_2.MyLinkedList;

public class MyQueue{
    protected MyLinkedList list = new MyLinkedList();

    public MyQueue(){}

    public MyQueue(Object o){
        this.pushBack(o);
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public int size(){
        return list.size();
    }

    public void clear(){
        this.list.clear();
    }

    public Object popFront(){
        if (!list.isEmpty()){
            return list.remove(0);
        }
        return null;
    }

    public void pushBack(Object o){
        list.add(o);
    }

    @Override
    public String toString(){
        return list.toString();
    }


}
