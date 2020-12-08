package com.neusoft.ump.server.socket;

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


@Component
public class ConsoleServerListener implements ServletContextListener {
    private final Log log = LogFactory.getLog(getClass());
    private static final Integer PORT = 5388;
    public void contextInitialized(ServletContextEvent sce) {

        Runnable collectorThread = () -> {
            ExecutorService executor = null;
            log.info("Colltor server has been started");
            try {
                ServerSocket serverSocket = new ServerSocket(PORT);
                executor = Executors.newFixedThreadPool(5);
                log.info("Waiting for ump-agent....");
                while (true){
                    Socket clientSocket = serverSocket.accept();
                    Runnable work = new WorkHandler(clientSocket);
                    executor.execute(work);
                }
            } catch (IOException e) {
                log.fatal(e.toString());
            }
        };
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(collectorThread);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        log.info("shutdown");
    }

}
