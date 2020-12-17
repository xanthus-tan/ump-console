package com.neusoft.ump.pojo.agent;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class NodeInfo {
    private String nodeHostname;
    private String nodeArch;
    private String nodeOS;
    private String nodeName;
    private String nodeIp;
    private String nodeSCN;
    private Integer nodeCpuNumber;
    private Long nodeMemorySize;
    private Long nodeDiskSize;
    private String nodeRegisteredTime;

    public String getNodeHostname() {
        return nodeHostname;
    }

    public void setNodeHostname(String nodeHostname) {
        this.nodeHostname = nodeHostname;
    }

    public String getNodeArch() {
        return nodeArch;
    }

    public void setNodeArch(String nodeArch) {
        this.nodeArch = nodeArch;
    }

    public String getNodeOS() {
        return nodeOS;
    }

    public void setNodeOS(String nodeOS) {
        this.nodeOS = nodeOS;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodeIp() {
        return nodeIp;
    }

    public void setNodeIp(String nodeIp) {
        this.nodeIp = nodeIp;
    }

    public String getNodeSCN() {
        return nodeSCN;
    }

    public void setNodeSCN(String nodeSCN) {
        this.nodeSCN = nodeSCN;
    }

    public Integer getNodeCpuNumber() {
        return nodeCpuNumber;
    }

    public void setNodeCpuNumber(Integer nodeCpuNumber) {
        this.nodeCpuNumber = nodeCpuNumber;
    }

    public Long getNodeMemorySize() {
        return nodeMemorySize;
    }

    public void setNodeMemorySize(Long nodeMemorySize) {
        this.nodeMemorySize = nodeMemorySize;
    }

    public Long getNodeDiskSize() {
        return nodeDiskSize;
    }

    public void setNodeDiskSize(Long nodeDiskSize) {
        this.nodeDiskSize = nodeDiskSize;
    }

    public String getNodeRegisteredTime() {
        return nodeRegisteredTime;
    }

    public void setNodeRegisteredTime(String nodeRegisteredTime) {
        this.nodeRegisteredTime = nodeRegisteredTime;
    }


}
