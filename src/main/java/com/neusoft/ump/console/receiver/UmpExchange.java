package com.neusoft.ump.console.receiver;

import com.neusoft.ump.console.queue.UmpQueue;

public class UmpExchange<T> {
    private UmpQueue queue;
    private Receiver receiver;

    public UmpExchange() {
    }
    public UmpExchange(UmpQueue<T> queue) {
        this.queue = queue;
    }

    public void setQueue(UmpQueue<T> queue) {
        this.queue = queue;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public void exec() {
        receiver.handler(this.queue);
    }
}
