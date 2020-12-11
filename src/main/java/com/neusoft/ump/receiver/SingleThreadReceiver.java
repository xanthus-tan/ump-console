package com.neusoft.ump.receiver.handler;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.neusoft.ump.receiver.queue.UmpQueue;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SingleThreadReceiver extends Receiver{
    private volatile static Receiver receiver;
    private final Log log = LogFactory.getLog(getClass());

    private SingleThreadReceiver(){}

    public static Receiver getInstance(){
        if(receiver == null){
            synchronized (SingleThreadReceiver.class){
                if (receiver == null){
                    receiver = new SingleThreadReceiver();
                }
            }
        }
        return receiver;
    }
    @Override
    void handler(UmpQueue<ObjectNode> queue) {
        log.info("aaaaaaaaaaaaaaaaaaaaaaaaaaa");
        while (true){
            ObjectNode agent = queue.get();
            log.debug("Queue length is " + queue.size());
        }
    }
    private void handler(){}
}
