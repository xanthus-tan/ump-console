package com.neusoft.ump.pojo.agent;

import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository("nodeMetricsCpu")
public class NodeMetricsCpu {
    private String metricsCpuSCN;
    private Long metricsCpuUser;
    private Long metricsCpuSystem;
    private Long metricsCpuIdle;
    private Long metricsCpuNice;
    private Long metricsCpuIowait;
    private String metricsCpuCollectTime;
    private String NodeIp;

    public String getMetricsCpuSCN() {
        return metricsCpuSCN;
    }

    public void setMetricsCpuSCN(String metricsCpuSCN) {
        this.metricsCpuSCN = metricsCpuSCN;
    }

    public Long getMetricsCpuUser() {
        return metricsCpuUser;
    }

    public void setMetricsCpuUser(Long metricsCpuUser) {
        this.metricsCpuUser = metricsCpuUser;
    }

    public Long getMetricsCpuSystem() {
        return metricsCpuSystem;
    }

    public void setMetricsCpuSystem(Long metricsCpuSystem) {
        this.metricsCpuSystem = metricsCpuSystem;
    }

    public Long getMetricsCpuIdle() {
        return metricsCpuIdle;
    }

    public void setMetricsCpuIdle(Long metricsCpuIdle) {
        this.metricsCpuIdle = metricsCpuIdle;
    }

    public Long getMetricsCpuNice() {
        return metricsCpuNice;
    }

    public void setMetricsCpuNice(Long metricsCpuNice) {
        this.metricsCpuNice = metricsCpuNice;
    }

    public Long getMetricsCpuIowait() {
        return metricsCpuIowait;
    }

    public void setMetricsCpuIowait(Long metricsCpuIowait) {
        this.metricsCpuIowait = metricsCpuIowait;
    }

    public String getMetricsCpuCollectTime() {
        return metricsCpuCollectTime;
    }

    public void setMetricsCpuCollectTime(String metricsCpuCollectTime) {
        this.metricsCpuCollectTime = metricsCpuCollectTime;
    }

    public String getNodeIp() {
        return NodeIp;
    }

    public void setNodeIp(String nodeIp) {
        NodeIp = nodeIp;
    }
}
