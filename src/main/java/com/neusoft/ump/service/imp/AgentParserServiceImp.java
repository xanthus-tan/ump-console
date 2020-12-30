package com.neusoft.ump.service.imp;

import com.fasterxml.jackson.databind.JsonNode;
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
    public String parser(JsonNode jsonNode) {
        String type = jsonNode.get("agent").get("header").get("type").asText();
        switch (type) {
            case "node":
                return agentParser.nodeParser(jsonNode);
            case "metrics":
                agentParser.parserMetricsItem(jsonNode);
                break;
            case "probe":
                return agentParser.probeParser(jsonNode);
        }
        return "success";
    }
}
