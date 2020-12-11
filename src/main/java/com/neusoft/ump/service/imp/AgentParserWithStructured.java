package com.neusoft.ump.service.imp;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.neusoft.ump.service.AgentParser;
import org.springframework.stereotype.Service;

@Service("agentParserWithStructured")
public class AgentParserWithStructured extends AgentParser {
    @Override
    public void parserNodeItem(ObjectNode objectNode, String client){

    }

    @Override
    public void parserMetricsItem(ObjectNode objectNode, String client){
        System.out.println("run........Metrics.............");
    }
}
