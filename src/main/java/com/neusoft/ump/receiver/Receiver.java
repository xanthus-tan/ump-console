package com.neusoft.ump.receiver;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.neusoft.ump.receiver.queue.UmpQueue;

public abstract class Receiver {
    abstract void handler(UmpQueue<ObjectNode> queue);
}
