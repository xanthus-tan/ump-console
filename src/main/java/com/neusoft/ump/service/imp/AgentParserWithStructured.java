package com.neusoft.ump.service.imp;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.neusoft.ump.pojo.agent.NodeInfo;
import com.neusoft.ump.service.AgentParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("agentParserWithStructured")
public class AgentParserWithStructured extends AgentParser {
    @Autowired
    @Qualifier("nodeInfo")
    private NodeInfo node;

    @Override
    public  void parserNodeItem(ObjectNode objectNode){
        String t = objectNode.get("agent").toString();
        System.out.println("################" + t);
        String t1 = objectNode.get("agent").toString();
        System.out.println("################" + t1);


//        node.setNodeArch(objectNode.get("agent").get("arch").asText());
//        node.setNodeOS(objectNode.get("agent").get("os").asText());
//        node.setNodeHostname(objectNode.get("agent").get("computer").get("hostname").asText());
//        node.setNodeCpuNumber(objectNode.get("agent").get("resource").get("cpus").asText());
//        node.setNodeMemorySize(objectNode.get("agent").get("resource").get("memSize").asText());
//        node.setNodeDiskSize(objectNode.get("agent").get("resource").get("diskSize").asText());
//        node.setNodeIp(objectNode.get("client").asText());

    }

    @Override
    public void parserMetricsItem(ObjectNode objectNode){
        System.out.println("run........Metrics.............");
    }
}
