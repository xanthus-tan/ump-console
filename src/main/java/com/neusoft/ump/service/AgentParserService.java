package com.neusoft.ump.service;

import com.fasterxml.jackson.databind.node.ObjectNode;

public interface AgentParserService {
    void setParser(AgentParser parser);
    void parser(ObjectNode objectNode);
}
