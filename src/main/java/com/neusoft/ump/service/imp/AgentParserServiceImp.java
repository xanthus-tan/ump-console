package com.neusoft.ump.service.imp;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.neusoft.ump.service.AgentParser;
import com.neusoft.ump.service.AgentParserService;
import org.springframework.stereotype.Service;

@Service("agentParserServiceImp")
public class AgentParserServiceImp implements AgentParserService {
    private AgentParser agentParser;
    @Override
    public void setParser(AgentParser agentParser) {
        this.agentParser = agentParser;
    }

    @Override
    public void parser(ObjectNode objectNode) {
        String type = objectNode.get("agent").get("header").get("type").asText();
        switch (type){
            case "node": agentParser.parserNodeItem(objectNode); break;
            case "memtrics": agentParser.parserMetricsItem(objectNode); break;
        }
    }
}
