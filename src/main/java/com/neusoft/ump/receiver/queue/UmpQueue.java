package com.neusoft.ump.recever.queue;

public interface UmpQueue<T>  {
    // 队列长度
    int size();
    // 入队
    void add(T t);
    // 出队
    T get();
}
