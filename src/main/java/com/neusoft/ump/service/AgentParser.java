package com.neusoft.ump.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public abstract class AgentParser {
    abstract public void parserNodeItem(JsonNode objectNode);

    abstract public void parserMetricsItem(JsonNode objectNode);
}
