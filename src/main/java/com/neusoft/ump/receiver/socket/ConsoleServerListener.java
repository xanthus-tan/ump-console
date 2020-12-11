package com.neusoft.ump.receiver.socket;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class ConsoleServerListener implements ApplicationListener<ContextRefreshedEvent> {
    private final Log log = LogFactory.getLog(getClass());

    @Autowired
    @Qualifier("consoleSockerServer")
    private ConsoleSocketServer server;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (contextRefreshedEvent.getApplicationContext().getParent() == null) {
            server.start();
        }

    }
}
