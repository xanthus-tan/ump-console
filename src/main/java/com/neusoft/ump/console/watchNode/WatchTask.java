package com.neusoft.ump.console.watchNode;

import com.neusoft.ump.service.WatchNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("watchTask")
public class WatchTask {
    @Qualifier("watchNodeServiceWithRDMS")
    @Autowired
    private WatchNodeService watchNodeService;

    @Scheduled(cron = "0/10 * * * * ?")
    public void work() {
        watchNodeService.watchNode();
    }
}
