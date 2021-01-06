package com.neusoft.ump.console.watchNode;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class WatchNode implements ApplicationListener<ContextRefreshedEvent> {
    private final Log log = LogFactory.getLog(getClass());

    @Qualifier("watchTask")
    @Autowired
    private WatchTask task;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (contextRefreshedEvent.getApplicationContext().getParent() == null) {
            log.info("Watch node work ........ interval 10s");
            task.work();
        }

    }
}
