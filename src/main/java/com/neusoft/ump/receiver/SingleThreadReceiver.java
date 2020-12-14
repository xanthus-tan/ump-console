package com.neusoft.ump.receiver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.neusoft.ump.receiver.queue.UmpQueue;
import com.neusoft.ump.service.AgentParser;
import com.neusoft.ump.service.AgentParserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("singleThreadReceiver")
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
        agentSerice.setParser(parser);
        while (true){
            ObjectNode agentNode = queue.get();
            agentSerice.parser(agentNode);
            log.debug("Queue length is " + queue.size());
        }
    }
}
