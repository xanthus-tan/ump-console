package com.neusoft.ump.pojo.agent;

import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository("nodeMetricsMemory")
public class NodeMetricsMemory {
    private String metricsMemorySCN;
    private Long metricsMemoryAvailable;
    private Long metricsMemoryUsed;
    private Long metricsMemoryUsedPercent;
    private Long metricsMemoryFree;
    private Long metricsMemorySwapTotal;
    private Long metricsMemorySwapFree;
    private String metricsMemoryCollectTime;
    private String NodeIp;

    public String getMetricsMemorySCN() {
        return metricsMemorySCN;
    }

    public void setMetricsMemorySCN(String metricsMemorySCN) {
        this.metricsMemorySCN = metricsMemorySCN;
    }

    public Long getMetricsMemoryAvailable() {
        return metricsMemoryAvailable;
    }

    public void setMetricsMemoryAvailable(Long metricsMemoryAvailable) {
        this.metricsMemoryAvailable = metricsMemoryAvailable;
    }

    public Long getMetricsMemoryUsed() {
        return metricsMemoryUsed;
    }

    public void setMetricsMemoryUsed(Long metricsMemoryUsed) {
        this.metricsMemoryUsed = metricsMemoryUsed;
    }

    public Long getMetricsMemoryUsedPercent() {
        return metricsMemoryUsedPercent;
    }

    public void setMetricsMemoryUsedPercent(Long metricsMemoryUsedPercent) {
        this.metricsMemoryUsedPercent = metricsMemoryUsedPercent;
    }

    public Long getMetricsMemoryFree() {
        return metricsMemoryFree;
    }

    public void setMetricsMemoryFree(Long metricsMemoryFree) {
        this.metricsMemoryFree = metricsMemoryFree;
    }

    public Long getMetricsMemorySwapTotal() {
        return metricsMemorySwapTotal;
    }

    public void setMetricsMemorySwapTotal(Long metricsMemorySwapTotal) {
        this.metricsMemorySwapTotal = metricsMemorySwapTotal;
    }

    public Long getMetricsMemorySwapFree() {
        return metricsMemorySwapFree;
    }

    public void setMetricsMemorySwapFree(Long metricsMemorySwapFree) {
        this.metricsMemorySwapFree = metricsMemorySwapFree;
    }

    public String getMetricsMemoryCollectTime() {
        return metricsMemoryCollectTime;
    }

    public void setMetricsMemoryCollectTime(String metricsMemoryCollectTime) {
        this.metricsMemoryCollectTime = metricsMemoryCollectTime;
    }

    public String getNodeIp() {
        return NodeIp;
    }

    public void setNodeIp(String nodeIp) {
        NodeIp = nodeIp;
    }
}
