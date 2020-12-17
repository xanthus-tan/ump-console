package com.neusoft.ump.service.imp;

import com.fasterxml.jackson.databind.JsonNode;
import com.neusoft.ump.dao.agent.MetricsDAO;
import com.neusoft.ump.dao.agent.NodeDAO;
import com.neusoft.ump.pojo.agent.NodeInfo;
import com.neusoft.ump.pojo.agent.NodeMetricsCpu;
import com.neusoft.ump.pojo.agent.NodeMetricsDisk;
import com.neusoft.ump.pojo.agent.NodeMetricsMemory;
import com.neusoft.ump.service.AgentParser;
import com.neusoft.ump.utils.time.CurrentDate;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.binding.BindingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("agentParserWithStructured")
public class AgentParserWithStructured extends AgentParser {
    private final Log log = LogFactory.getLog(getClass());

    @Autowired
    @Qualifier("nodeInfo")
    private NodeInfo node;

    @Autowired
    @Qualifier("nodeMetricsCpu")
    private NodeMetricsCpu cpu;

    @Autowired
    @Qualifier("nodeMetricsDisk")
    private NodeMetricsDisk disk;

    @Autowired
    @Qualifier("nodeMetricsMemory")
    private NodeMetricsMemory memory;

    @Autowired
    @Qualifier("nodeDAO")
    private NodeDAO nodeDAO;

    @Autowired
    @Qualifier("metricsDAO")
    private MetricsDAO metricsDAO;


    @Override
    public void parserNodeItem(JsonNode jsonNode) {
        try {
            JsonNode agentNode = jsonNode.get("agent");
            node.setNodeArch(agentNode.get("computer").get("arch").asText());
            node.setNodeOS(agentNode.get("computer").get("os").asText());
            node.setNodeHostname(agentNode.get("computer").get("hostname").asText());
            node.setNodeCpuNumber(agentNode.get("resource").get("cpus").asInt());
            node.setNodeMemorySize(agentNode.get("resource").get("memSize").asLong());
            node.setNodeDiskSize(agentNode.get("resource").get("diskSize").asLong());
            node.setNodeIp(getClientAddr(jsonNode));
            node.setNodeRegisteredTime(CurrentDate.getCurrentDateFormat());
            addNode(node);
        } catch (NullPointerException e) {
            log.error(e.getMessage());
            log.error("agent json parser error......");
        } catch (BindingException e) {
            log.error(e.getMessage());
        }

    }

    @Override
    public void parserMetricsItem(JsonNode jsonNode) {
        String metricsItem = jsonNode.get("agent").get("header").get("item").asText();
        switch (metricsItem) {
            case "memory":
                parserMetricsMemory(jsonNode);
                break;
            case "disk":
                parserMetricsDisk(jsonNode);
                break;
            case "cpu":
                parserMetricsCpu(jsonNode);
                break;
        }
    }

    private void parserMetricsCpu(JsonNode jsonNode) {
        cpu.setNodeIp(getClientAddr(jsonNode));
        JsonNode metricsCpuNodeArray = getMetrics(jsonNode);
        metricsCpuNodeArray.forEach(metricsCpu -> {
            cpu.setMetricsCpuIdle(metricsCpu.get("idle").asLong());
            cpu.setMetricsCpuIowait(metricsCpu.get("iowait").asLong());
            cpu.setMetricsCpuNice(metricsCpu.get("nice").asLong());
            cpu.setMetricsCpuSystem(metricsCpu.get("system").asLong());
            cpu.setMetricsCpuUser(metricsCpu.get("user").asLong());
            cpu.setMetricsCpuCollectTime(CurrentDate.getCurrentDateFormat());
            addMetricsCPU(cpu);
        });
    }

    private void parserMetricsDisk(JsonNode jsonNode) {
        disk.setNodeIp(getClientAddr(jsonNode));
        JsonNode metricsDisk = getMetrics(jsonNode);
        disk.setMetricsDiskTotal(metricsDisk.get("total").asLong());
        disk.setMetricsDiskUsed(metricsDisk.get("used").asLong());
        disk.setMetricsDiskUsedPercent(metricsDisk.get("usedPercent").asLong());
        disk.setMetricsDiskFstype(metricsDisk.get("fstype").asText());
        disk.setMetricsDiskFree(metricsDisk.get("free").asLong());
        disk.setMetricsDiskCollectTime(CurrentDate.getCurrentDateFormat());
        addMetricsDisk(disk);
    }

    private void parserMetricsMemory(JsonNode jsonNode) {
        JsonNode metricsMemory = getMetrics(jsonNode);
        memory.setNodeIp(getClientAddr(jsonNode));
        memory.setMetricsMemoryFree(metricsMemory.get("free").asLong());
        memory.setMetricsMemoryAvailable(metricsMemory.get("available").asLong());
        memory.setMetricsMemoryUsed(metricsMemory.get("used").asLong());
        memory.setMetricsMemoryUsedPercent(metricsMemory.get("usedPercent").asLong());
        memory.setMetricsMemorySwapTotal(metricsMemory.get("swapTotal").asLong());
        memory.setMetricsMemorySwapFree(metricsMemory.get("swapFree").asLong());
        memory.setMetricsMemoryCollectTime(CurrentDate.getCurrentDateFormat());
        addMetricsMemory(memory);
    }

    @Transactional
    private void addNode(NodeInfo node) {
        nodeDAO.addNode(node);
    }

    @Transactional
    private void addMetricsCPU(NodeMetricsCpu cpu) {
        metricsDAO.addMetricsCPU(cpu);
    }

    @Transactional
    private void addMetricsDisk(NodeMetricsDisk disk) {
        metricsDAO.addMetricsDisk(disk);
    }

    @Transactional
    private void addMetricsMemory(NodeMetricsMemory memory) {
        metricsDAO.addMetricsMemory(memory);
    }

    private String getClientAddr(JsonNode jsonNode) {
        return jsonNode.get("client").asText();
    }

    private JsonNode getMetrics(JsonNode jsonNode) {
        return jsonNode.get("agent").get("body");
    }
}


