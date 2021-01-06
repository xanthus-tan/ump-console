package com.neusoft.ump.service.imp;

import com.neusoft.ump.dao.agent.NodeDAO;
import com.neusoft.ump.service.WatchNodeService;
import com.neusoft.ump.utils.time.DateTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("watchNodeServiceWithRDMS")
public class WatchNodeServiceWithRDMS implements WatchNodeService {

    @Autowired
    @Qualifier("nodeDAO")
    private NodeDAO nodeDAO;

    @Override
    public void watchNode() {
        List<Map<String,String>> nodes = nodeDAO.getActiveNodes();
        Long consoleTimeSeconds = DateTool.currentTimeSeconds();
        System.out.println(consoleTimeSeconds);
        for (Map<String,String> n : nodes){
            String nodeTime = n.get("nodeTime");
            if (nodeTime == null ) continue;
            Long nodeTimeSeconds = DateTool.dateToTimeSeconds(nodeTime);
            if((consoleTimeSeconds - nodeTimeSeconds) > 30){
                System.out.println("记录node id");
            }
        }
    }
}
