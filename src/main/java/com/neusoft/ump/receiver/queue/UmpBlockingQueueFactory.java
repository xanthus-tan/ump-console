package com.neusoft.ump.recever.queue;

public class UmpBlockingQueueFactory extends UmpQueueFactory{

    @Override
    public UmpQueue createQueue(String type) {
        UmpQueue queue = null;
        if ("default".equals(type)){
            queue = new DefaultBlockingQueue();
        }
        return queue;
    }
}
