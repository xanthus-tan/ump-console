package com.neusoft.ump.server.socket;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class WorkHandler implements Runnable{
    private final Log log = LogFactory.getLog(getClass());
    private final Socket client;

    public WorkHandler(Socket client){
        this.client = client;
    }
    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            log.info("Thread started with name: " + Thread.currentThread().getName());
            String agent;
            while ((agent = in.readLine()) != null){
                log.info("Received message from " + Thread.currentThread().getName() + " ：" + agent);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
