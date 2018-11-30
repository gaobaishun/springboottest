package com.neo.Listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

public class ApplicationListenerStarted implements ApplicationListener<ApplicationStartingEvent> {
    Logger logger= LoggerFactory.getLogger(ApplicationListenerStarted.class);
    @Override
    public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent) {
        logger.debug("ApplicationStartingEvent");
        System.out.println("ApplicationStartingEvent");
        System.out.println(getClass().getSimpleName());
    }
}
