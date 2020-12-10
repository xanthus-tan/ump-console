package com.neusoft.ump.receiver.handler;

import com.neusoft.ump.receiver.queue.UmpQueue;

public interface ReceiveHandler {
    void handler(UmpQueue queue);
}
