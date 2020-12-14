package com.neusoft.ump.mapper.dao;

import com.neusoft.ump.pojo.agent.NodeInfo;
import org.springframework.stereotype.Repository;

@Repository("nodeDAO")
public interface NodeDAO {
    public int addNode(NodeInfo node);
}
