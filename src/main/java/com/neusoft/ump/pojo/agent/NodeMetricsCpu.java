package com.neusoft.ump.pojo.agent;

import java.util.Date;

public class NodeMetricsCpu {
    private String metricsCpuSCN;
    private Integer metricsCpuUser;
    private Integer metricsCpuSystem;
    private Integer metricsCpuIdle;
    private Integer metricsCpuNice;
    private Integer metricsCpuIowait;
    private Date metricsCpuCollectTime;
    private String NodeIp;

    public String getMetricsCpuSCN() {
        return metricsCpuSCN;
    }

    public void setMetricsCpuSCN(String metricsCpuSCN) {
        this.metricsCpuSCN = metricsCpuSCN;
    }

    public Integer getMetricsCpuUser() {
        return metricsCpuUser;
    }

    public void setMetricsCpuUser(Integer metricsCpuUser) {
        this.metricsCpuUser = metricsCpuUser;
    }

    public Integer getMetricsCpuSystem() {
        return metricsCpuSystem;
    }

    public void setMetricsCpuSystem(Integer metricsCpuSystem) {
        this.metricsCpuSystem = metricsCpuSystem;
    }

    public Integer getMetricsCpuIdle() {
        return metricsCpuIdle;
    }

    public void setMetricsCpuIdle(Integer metricsCpuIdle) {
        this.metricsCpuIdle = metricsCpuIdle;
    }

    public Integer getMetricsCpuNice() {
        return metricsCpuNice;
    }

    public void setMetricsCpuNice(Integer metricsCpuNice) {
        this.metricsCpuNice = metricsCpuNice;
    }

    public Integer getMetricsCpuIowait() {
        return metricsCpuIowait;
    }

    public void setMetricsCpuIowait(Integer metricsCpuIowait) {
        this.metricsCpuIowait = metricsCpuIowait;
    }

    public Date getMetricsCpuCollectTime() {
        return metricsCpuCollectTime;
    }

    public void setMetricsCpuCollectTime(Date metricsCpuCollectTime) {
        this.metricsCpuCollectTime = metricsCpuCollectTime;
    }

    public String getNodeIp() {
        return NodeIp;
    }

    public void setNodeIp(String nodeIp) {
        NodeIp = nodeIp;
    }
}
