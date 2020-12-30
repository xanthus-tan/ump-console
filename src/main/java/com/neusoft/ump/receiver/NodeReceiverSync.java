package com.neusoft.ump.receiver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.neusoft.ump.receiver.queue.UmpQueue;
import com.neusoft.ump.service.AgentParser;
import com.neusoft.ump.service.AgentParserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("nodeReceiverSync")
public class NodeReceiverSync extends Receiver{
    private final Log log = LogFactory.getLog(getClass());
    @Autowired
    @Qualifier("agentParserServiceImp")
    private AgentParserService agentSerice;
    @Autowired
    @Qualifier("agentParserWithStructured")
    private AgentParser parser;

    @Override
    public void handler(UmpQueue<ObjectNode> queue) {

    }

    @Override
    public String handler(ObjectNode objectNode) {
        agentSerice.setParser(parser);
        ObjectMapper objectMapper = new ObjectMapper();
        String resultCode = null;
        try {
            JsonNode node = (JsonNode)objectMapper.readTree(objectNode.toString());
            resultCode = agentSerice.parser(node);
        } catch (JsonProcessingException e) {
            log.error(e.toString());
        }
        return resultCode;
    }
}
