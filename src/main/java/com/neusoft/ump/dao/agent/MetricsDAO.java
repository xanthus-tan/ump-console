package com.neusoft.ump.dao.agent;

import com.neusoft.ump.pojo.agent.NodeMetricsCpu;
import com.neusoft.ump.pojo.agent.NodeMetricsDisk;
import com.neusoft.ump.pojo.agent.NodeMetricsMemory;
import org.springframework.stereotype.Repository;

@Repository("metricsDAO")
public interface MetricsDAO {
    void addMetricsCPU(NodeMetricsCpu metrics);
    void addMetricsMemory(NodeMetricsMemory metrics);
    void addMetricsDisk(NodeMetricsDisk metrics);
}
