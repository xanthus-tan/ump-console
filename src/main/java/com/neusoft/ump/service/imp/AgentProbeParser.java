package com.neusoft.ump.service.imp;

import com.fasterxml.jackson.databind.JsonNode;
import com.neusoft.ump.dao.agent.NodeDAO;
import com.neusoft.ump.service.AgentParser;
import com.neusoft.ump.utils.time.UMPCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("agentProbeParser")
public class AgentProbeParser extends AgentParser {
    @Autowired
    @Qualifier("nodeDAO")
    private NodeDAO nodeDAO;

    @Override
    public void parserNodeItem(JsonNode jsonNode) {

    }

    @Override
    public void parserMetricsItem(JsonNode jsonNode) {

    }

    @Override
    public String parserProbe(JsonNode jsonNode) {
        System.out.println(jsonNode.toString());
        String code = jsonNode.get("agent").get("header").get("code").asText();
        String nodeIP = jsonNode.get("client").asText();
        switch (code) {
            case UMPCode.INITCODE:
                System.out.println(nodeDAO);
                String result = nodeDAO.isExistNode(nodeIP);
                System.out.println(result);
                break;
            case UMPCode.HEARTBEATCODE:
                System.out.println("更新scn");
                break;
        }
        return null;
    }
}
