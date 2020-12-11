package com.neusoft.ump.receiver.socket;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.neusoft.ump.receiver.queue.UmpQueue;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class WorkHandler implements Runnable {
    private final Log log = LogFactory.getLog(getClass());
    private final Socket client;
    private UmpQueue queue;

    public WorkHandler(Socket client, UmpQueue queue) {
        this.client = client;
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            log.info("Thread started with name: " + Thread.currentThread().getName());
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            SocketAddress socketAddress = client.getRemoteSocketAddress();
            String clientAddr = "";
            if (socketAddress instanceof InetSocketAddress) {
                InetAddress inetAddress = ((InetSocketAddress) socketAddress).getAddress();
                clientAddr = inetAddress.getHostAddress();
            } else {
                log.error("Not an internet protocol socket.");
            }
            String agent;
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode clientNode = objectMapper.createObjectNode();
            clientNode.put("client", clientAddr);
            while ((agent = in.readLine()) != null) {
                JsonNode agentNode = objectMapper.readTree(agent);
                clientNode.set("agent",agentNode);
                String msg = objectMapper.writeValueAsString(clientNode);
                log.debug("Received message from " + Thread.currentThread().getName() + " ：" + msg);
                queue.add(clientNode);
            }
            client.close();
        } catch (IOException e) {
            log.error(e);
        }
    }
}
