package com.neusoft.ump.pojo.agent;

import java.util.Date;

public class NodeMetricsDisk {
    private String metricsDiskSCN;
    private String metricsDiskFstype;
    private Integer metricsDiskTotal;
    private Integer metricsDiskUsed;
    private Integer metricsDiskUsedPercent;
    private Date metricsDiskCollectTime;
    private String NodeIp;

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

    public Integer getMetricsDiskTotal() {
        return metricsDiskTotal;
    }

    public void setMetricsDiskTotal(Integer metricsDiskTotal) {
        this.metricsDiskTotal = metricsDiskTotal;
    }

    public Integer getMetricsDiskUsed() {
        return metricsDiskUsed;
    }

    public void setMetricsDiskUsed(Integer metricsDiskUsed) {
        this.metricsDiskUsed = metricsDiskUsed;
    }

    public Integer getMetricsDiskUsedPercent() {
        return metricsDiskUsedPercent;
    }

    public void setMetricsDiskUsedPercent(Integer metricsDiskUsedPercent) {
        this.metricsDiskUsedPercent = metricsDiskUsedPercent;
    }

    public Date getMetricsDiskCollectTime() {
        return metricsDiskCollectTime;
    }

    public void setMetricsDiskCollectTime(Date metricsDiskCollectTime) {
        this.metricsDiskCollectTime = metricsDiskCollectTime;
    }

    public String getNodeIp() {
        return NodeIp;
    }

    public void setNodeIp(String nodeIp) {
        NodeIp = nodeIp;
    }
}
