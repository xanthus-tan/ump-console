package com.neusoft.ump.recever.socket;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.neusoft.ump.recever.queue.UmpBlockingQueueFactory;
import com.neusoft.ump.recever.queue.UmpQueue;
import com.neusoft.ump.recever.queue.UmpQueueFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConsoleSocketServer {
    private final Log log = LogFactory.getLog(getClass());
    private static final Integer PORT = 5388;
    public void start(){
        UmpQueueFactory factory = new UmpBlockingQueueFactory();
        UmpQueue<ObjectNode> queue = factory.createInstance("default");
        Runnable colltorThread = () -> {
            ExecutorService executor = null;

            try {
                ServerSocket serverSocket = new ServerSocket(PORT);
                executor = Executors.newFixedThreadPool(5);
                log.info("Waiting for ump-agent....");
                while (true){
                    Socket clientSocket = serverSocket.accept();
                    Runnable work = new WorkHandler(clientSocket, queue);
                    executor.execute(work);
                }
            } catch (IOException e) {
                log.fatal(e.toString());
            }
        };

        Runnable receverThread = () -> {
            while (true){
                if (queue == null) return;
                ObjectNode clientNode = queue.get();
                Integer size = queue.size();
                String msg = clientNode.toString();
                log.info("Queue is " + msg);
            }
        };
        ExecutorService colltorExecutor = Executors.newSingleThreadExecutor();
        colltorExecutor.execute(colltorThread);
        ExecutorService receverExecutor = Executors.newSingleThreadExecutor();
        receverExecutor.execute(receverThread);
    }
}
