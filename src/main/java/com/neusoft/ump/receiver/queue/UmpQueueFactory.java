package com.neusoft.ump.recever.queue;

public abstract class UmpQueueFactory {

    public UmpQueue createInstance(String type){
        UmpQueue queue = createQueue(type);
        return queue;
    }

    protected abstract UmpQueue createQueue(String type);
}
