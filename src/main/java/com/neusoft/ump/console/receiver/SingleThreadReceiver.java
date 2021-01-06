package com.neusoft.ump.console.receiver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.neusoft.ump.console.queue.UmpQueue;
import com.neusoft.ump.service.AgentParser;
import com.neusoft.ump.service.AgentParserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("singleThreadReceiver")
@Scope("singleton")
public class SingleThreadReceiver extends Receiver{
    private final Log log = LogFactory.getLog(getClass());

    @Autowired
    @Qualifier("agentParserServiceImp")
    private AgentParserService agentSerice;
    @Autowired
    @Qualifier("agentParserWithStructured")
    private AgentParser parser;
    @Override
    public void handler(UmpQueue<ObjectNode> queue) {
        ObjectMapper objectMapper = new ObjectMapper();
        while (true){
            ObjectNode objectNode = queue.get();
            JsonNode agentNode = null;
            try {
                agentSerice.setParser(parser);
                agentNode = (JsonNode)objectMapper.readTree(objectNode.toString());
                log.debug("queue handler, agent json content is " + agentNode.toString());
                log.debug("Queue length is " + queue.size());
                agentSerice.parser(agentNode);
                objectMapper.clearProblemHandlers();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String handler(ObjectNode objectNode) {
        return null;
    }
}
