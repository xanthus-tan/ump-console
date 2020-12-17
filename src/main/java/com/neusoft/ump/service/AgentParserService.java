package com.neusoft.ump.service;

import com.fasterxml.jackson.databind.JsonNode;

public interface AgentParserService {
    void setParser(AgentParser parser);
    void parser(JsonNode jsonNode);
}
