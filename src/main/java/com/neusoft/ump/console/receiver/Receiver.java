package com.neusoft.ump.console.receiver;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.neusoft.ump.console.queue.UmpQueue;
import org.springframework.stereotype.Component;

@Component
public abstract class Receiver {
    abstract public void handler(UmpQueue<ObjectNode> queue);
    abstract public String handler(ObjectNode objectNode);
}
