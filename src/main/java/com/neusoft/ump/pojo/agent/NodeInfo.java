package com.neusoft.ump.pojo.agent;

import java.util.Date;

public class NodeInfo {
    private String nodeHostname;
    private String nodeArch;
    private String nodeOS;
    private String nodeName;
    private String nodeIp;

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

    public String getNodeCpuNumber() {
        return nodeCpuNumber;
    }

    public void setNodeCpuNumber(String nodeCpuNumber) {
        this.nodeCpuNumber = nodeCpuNumber;
    }

    public String getNodeMemorySize() {
        return nodeMemorySize;
    }

    public void setNodeMemorySize(String nodeMemorySize) {
        this.nodeMemorySize = nodeMemorySize;
    }

    public String getNodeDiskSize() {
        return nodeDiskSize;
    }

    public void setNodeDiskSize(String nodeDiskSize) {
        this.nodeDiskSize = nodeDiskSize;
    }

    public Date getNodeRegisteredTime() {
        return nodeRegisteredTime;
    }

    public void setNodeRegisteredTime(Date nodeRegisteredTime) {
        this.nodeRegisteredTime = nodeRegisteredTime;
    }

    private String nodeSCN;
    private String nodeCpuNumber;
    private String nodeMemorySize;
    private String nodeDiskSize;
    private Date nodeRegisteredTime;


}
