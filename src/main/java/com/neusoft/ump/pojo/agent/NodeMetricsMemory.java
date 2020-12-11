package com.neusoft.ump.pojo.agent;

import java.util.Date;

public class NodeMetricsMemory {
    private String  metricsMemorySCN;
    private Integer metricsMemoryAvailable;
    private Integer metricsMemoryUsed;
    private Integer metricsMemoryUsedPercent;
    private Integer metricsMemoryFree;
    private Integer metricsMemorySwapTotal;
    private Integer metricsMemorySwapFree;
    private Date    metricsMemoryCollectTime;
    private String  NodeIp;

    public String getMetricsMemorySCN() {
        return metricsMemorySCN;
    }

    public void setMetricsMemorySCN(String metricsMemorySCN) {
        this.metricsMemorySCN = metricsMemorySCN;
    }

    public Integer getMetricsMemoryAvailable() {
        return metricsMemoryAvailable;
    }

    public void setMetricsMemoryAvailable(Integer metricsMemoryAvailable) {
        this.metricsMemoryAvailable = metricsMemoryAvailable;
    }

    public Integer getMetricsMemoryUsed() {
        return metricsMemoryUsed;
    }

    public void setMetricsMemoryUsed(Integer metricsMemoryUsed) {
        this.metricsMemoryUsed = metricsMemoryUsed;
    }

    public Integer getMetricsMemoryUsedPercent() {
        return metricsMemoryUsedPercent;
    }

    public void setMetricsMemoryUsedPercent(Integer metricsMemoryUsedPercent) {
        this.metricsMemoryUsedPercent = metricsMemoryUsedPercent;
    }

    public Integer getMetricsMemoryFree() {
        return metricsMemoryFree;
    }

    public void setMetricsMemoryFree(Integer metricsMemoryFree) {
        this.metricsMemoryFree = metricsMemoryFree;
    }

    public Integer getMetricsMemorySwapTotal() {
        return metricsMemorySwapTotal;
    }

    public void setMetricsMemorySwapTotal(Integer metricsMemorySwapTotal) {
        this.metricsMemorySwapTotal = metricsMemorySwapTotal;
    }

    public Integer getMetricsMemorySwapFree() {
        return metricsMemorySwapFree;
    }

    public void setMetricsMemorySwapFree(Integer metricsMemorySwapFree) {
        this.metricsMemorySwapFree = metricsMemorySwapFree;
    }

    public Date getMetricsMemoryCollectTime() {
        return metricsMemoryCollectTime;
    }

    public void setMetricsMemoryCollectTime(Date metricsMemoryCollectTime) {
        this.metricsMemoryCollectTime = metricsMemoryCollectTime;
    }

    public String getNodeIp() {
        return NodeIp;
    }

    public void setNodeIp(String nodeIp) {
        NodeIp = nodeIp;
    }
}
