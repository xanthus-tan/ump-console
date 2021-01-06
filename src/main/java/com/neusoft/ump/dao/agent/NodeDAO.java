package com.neusoft.ump.dao.agent;

import com.neusoft.ump.pojo.agent.NodeInfo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("nodeDAO")
public interface NodeDAO {
     void addNode(NodeInfo node);
     Integer isExistNode(String ip);
     void deleteNode(String ip);
     void updateSCN(String scn,String node_time, String ip);
     void nodeInactive(List<String> pk);
     List<Map<String, String>> getActiveNodes();
}
