package com.neusoft.ump.receiver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.neusoft.ump.receiver.queue.UmpQueue;
import com.neusoft.ump.service.AgentParser;
import com.neusoft.ump.service.AgentParserService;
import com.neusoft.ump.service.imp.AgentParserServiceImp;
import com.neusoft.ump.service.imp.AgentProbeParser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class ProbeReceiverSync extends Receiver{
    private final Log log = LogFactory.getLog(getClass());
    private AgentParserService agentSerice;
    private AgentParser parser;

    @Override
    public void handler(UmpQueue<ObjectNode> queue) {

    }

    @Override
    public String ProbeHandler(ObjectNode objectNode) {
        agentSerice = new AgentParserServiceImp();
        parser = new AgentProbeParser();
        agentSerice.setParser(parser);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode probe = (JsonNode)objectMapper.readTree(objectNode.toString());
            parser.parserProbe(probe);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
