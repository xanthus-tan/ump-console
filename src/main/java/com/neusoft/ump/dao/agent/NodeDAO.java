package com.neusoft.ump.dao.agent;

import com.neusoft.ump.pojo.agent.NodeInfo;
import org.springframework.stereotype.Repository;

@Repository("nodeDAO")
public interface NodeDAO {
     void addNode(NodeInfo node);
}