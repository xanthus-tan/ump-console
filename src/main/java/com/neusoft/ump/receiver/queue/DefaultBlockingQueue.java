package com.neusoft.ump.recever.queue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.concurrent.ArrayBlockingQueue;

public class DefaultBlockingQueue<T>  implements UmpQueue<T>  {
    private final Log log = LogFactory.getLog(getClass());
    private static final int QUEUE_SIZE = 1000;
    private ArrayBlockingQueue<T> queue;
    public DefaultBlockingQueue(){
        this(QUEUE_SIZE);
    }
    public DefaultBlockingQueue(int size){
        this.queue = new ArrayBlockingQueue<T>(size);
    }
    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public void add(T t) {
        queue.add(t);
    }

    @Override
    public T get() {
        T t = null;
        try {
           t =  this.queue.take();
        } catch (InterruptedException e) {
           log.error(e.getMessage());
        }
        return t;
    }
}
