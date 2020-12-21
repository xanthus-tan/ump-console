package com.neusoft.ump.receiver.socket;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.neusoft.ump.receiver.ProbeReceiverSync;
import com.neusoft.ump.receiver.Receiver;
import com.neusoft.ump.receiver.queue.UmpQueue;
import com.neusoft.ump.utils.time.UMPCode;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class WorkHandler implements Runnable {
    private final Log log = LogFactory.getLog(getClass());
    private final Socket client;
    private UmpQueue queue;

    @Qualifier("probeReceiverSync")
    @Autowired
    private Receiver receiver;

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
            PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
            String clientAddr = "";
            if (socketAddress instanceof InetSocketAddress) {
                InetAddress inetAddress = ((InetSocketAddress) socketAddress).getAddress();
                clientAddr = inetAddress.getHostAddress();
            } else {
                log.error("Not an internet protocol socket.");
            }
            String agent;
            ObjectMapper objectMapper = new ObjectMapper();
            while ((agent = in.readLine()) != null) {
                ObjectNode clientNode = objectMapper.createObjectNode();
                clientNode.put("client", clientAddr);
                JsonNode agentNode = objectMapper.readTree(agent);
                clientNode.set("agent",agentNode);
                String type = clientNode.get("agent").get("header").get("type").asText();
                if (type.equals(UMPCode.PROBE)){
                  String code = probeHanlder(clientNode);
                  pw.println(code);
                  continue;
                }
                log.debug("Received message from " + Thread.currentThread().getName() + " ：" + clientNode.toString());
                queue.add(clientNode);
            }
            client.close();
        } catch (IOException e) {
            log.error(e);
        }
    }
    private String probeHanlder(ObjectNode probe){
        Receiver receiver = new ProbeReceiverSync();
        receiver.ProbeHandler(probe);
        return UMPCode.REGISTERSUCCESSCODE;
    }
}
