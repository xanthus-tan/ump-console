package com.neusoft.ump.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public abstract class AgentParser {
    abstract public void parserNodeItem(ObjectNode objectNode, String client);
    abstract public void parserMetricsItem(ObjectNode objectNode, String cline);
}
