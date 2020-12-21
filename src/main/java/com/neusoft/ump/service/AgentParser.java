package com.neusoft.ump.service;

import com.fasterxml.jackson.databind.JsonNode;

public abstract class AgentParser {
    abstract public void parserNodeItem(JsonNode jsonNode);
    abstract public void parserMetricsItem(JsonNode jsonNode);
    abstract public String parserProbe(JsonNode jsonNode);
}
