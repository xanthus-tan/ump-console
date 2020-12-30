package com.neusoft.ump.service.imp;

import com.fasterxml.jackson.databind.JsonNode;
import com.neusoft.ump.dao.agent.NodeDAO;
import com.neusoft.ump.service.AgentParser;
import com.neusoft.ump.utils.time.UMPCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("agentProbeParser")
public class AgentProbeParser extends AgentParser {
    @Autowired
    @Qualifier("nodeDAO")
    private NodeDAO nodeDAO;

    @Override
    public String nodeParser(JsonNode jsonNode) {
        return null;
    }

    @Override
    public void parserMetricsItem(JsonNode jsonNode) {

    }

    @Override
    public String probeParser(JsonNode jsonNode) {
        JsonNode header = jsonNode.get("agent").get("header");
        String code = header.get("code").asText();
        String scn = header.get("scn").asText();
        String nodeIP = jsonNode.get("ip").asText();
        String resultCode;
        switch (code) {
            case UMPCode.INITCODE:
                Integer result = nodeDAO.isExistNode(nodeIP);
                if(result == 1){
                    resultCode = UMPCode.CONSOLEACTIVE;
                }else if(result == 0){
                    resultCode = UMPCode.REGISTEREQUESTCODE;
                }else{
                    nodeDAO.deleteNode(nodeIP);

                    resultCode = UMPCode.REGISTEREQUESTCODE;
                }
                break;
            case UMPCode.HEARTBEATCODE:
                updateSCN(scn,nodeIP);
                resultCode = UMPCode.CONSOLEACTIVE;
                break;
            default:
                resultCode = UMPCode.CONSOLEACTIVE;
        }

        return resultCode;
    }

    @Transactional
    private void updateSCN(String scn, String nodeIP){
        nodeDAO.updateSCN(scn,nodeIP);
    }
}
