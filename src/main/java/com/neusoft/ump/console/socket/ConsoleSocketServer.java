package com.neusoft.ump.console.socket;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.neusoft.ump.console.receiver.Receiver;
import com.neusoft.ump.console.receiver.UmpExchange;
import com.neusoft.ump.console.queue.UmpBlockingQueueFactory;
import com.neusoft.ump.console.queue.UmpQueue;
import com.neusoft.ump.console.queue.UmpQueueFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component("consoleSockerServer")
public class ConsoleSocketServer {
    private final Log log = LogFactory.getLog(getClass());
    private static final Integer PORT = 5388;
    private UmpQueue<ObjectNode> queue;

    @Autowired
    @Qualifier("singleThreadReceiver")
    private Receiver receiver;

    @Autowired
    @Qualifier("workHandler")
    WorkHandler work;

    public ConsoleSocketServer() {
        UmpQueueFactory factory = new UmpBlockingQueueFactory();
        this.queue = factory.createInstance("default");
        log.info("Initialize ump queue ........");
    }

    public void start() {
        Runnable colltorThread = () -> {
            ExecutorService executor = null;
            try {
                ServerSocket serverSocket = new ServerSocket(PORT);
                executor = Executors.newFixedThreadPool(5);
                log.info("Waiting for ump-agent ........");
                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    work.setSocket(clientSocket);
                    work.setQueue(queue);
                    executor.execute(work);
                }
            } catch (IOException e) {
                log.fatal(e.toString());
            }
        };

        Runnable receverThread = () -> {
            log.info("Receiver has been started ........");
            UmpExchange<ObjectNode> exchange = new UmpExchange(queue);
            exchange.setReceiver(receiver);
            exchange.exec();
        };
        ExecutorService colltorExecutor = Executors.newSingleThreadExecutor();
        colltorExecutor.execute(colltorThread);
        ExecutorService receverExecutor = Executors.newSingleThreadExecutor();
        receverExecutor.execute(receverThread);
    }
}
