package com.neusoft.ump.recever.socket;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.neusoft.ump.recever.queue.UmpBlockingQueueFactory;
import com.neusoft.ump.recever.queue.UmpQueue;
import com.neusoft.ump.recever.queue.UmpQueueFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.fasterxml.jackson.databind.node.ObjectNode;

@Component
public class ConsoleServerListener implements ServletContextListener {
    private final Log log = LogFactory.getLog(getClass());

    public void contextInitialized(ServletContextEvent sce) {
        new ConsoleSocketServer().start();
        log.info("Colltor server has been started");
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }

}
