package com.neusoft.ump.pojo.agent;

import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository("nodeMetricsDisk")
public class NodeMetricsDisk {
    private String metricsDiskSCN;
    private String metricsDiskFstype;
    private Long metricsDiskTotal;
    private Long metricsDiskUsed;
    private Long metricsDiskUsedPercent;
    private Long metricsDiskFree;
    private String metricsDiskCollectTime;
    private String NodeIp;

    public Long getMetricsDiskFree() {
        return metricsDiskFree;
    }

    public void setMetricsDiskFree(Long metricsDiskFree) {
        this.metricsDiskFree = metricsDiskFree;
    }

    public String getMetricsDiskSCN() {
        return metricsDiskSCN;
    }

    public void setMetricsDiskSCN(String metricsDiskSCN) {
        this.metricsDiskSCN = metricsDiskSCN;
    }

    public String getMetricsDiskFstype() {
        return metricsDiskFstype;
    }

    public void setMetricsDiskFstype(String metricsDiskFstype) {
        this.metricsDiskFstype = metricsDiskFstype;
    }

    public Long getMetricsDiskTotal() {
        return metricsDiskTotal;
    }

    public void setMetricsDiskTotal(Long metricsDiskTotal) {
        this.metricsDiskTotal = metricsDiskTotal;
    }

    public Long getMetricsDiskUsed() {
        return metricsDiskUsed;
    }

    public void setMetricsDiskUsed(Long metricsDiskUsed) {
        this.metricsDiskUsed = metricsDiskUsed;
    }

    public Long getMetricsDiskUsedPercent() {
        return metricsDiskUsedPercent;
    }

    public void setMetricsDiskUsedPercent(Long metricsDiskUsedPercent) {
        this.metricsDiskUsedPercent = metricsDiskUsedPercent;
    }

    public String getMetricsDiskCollectTime() {
        return metricsDiskCollectTime;
    }

    public void setMetricsDiskCollectTime(String metricsDiskCollectTime) {
        this.metricsDiskCollectTime = metricsDiskCollectTime;
    }

    public String getNodeIp() {
        return NodeIp;
    }

    public void setNodeIp(String nodeIp) {
        NodeIp = nodeIp;
    }
}
