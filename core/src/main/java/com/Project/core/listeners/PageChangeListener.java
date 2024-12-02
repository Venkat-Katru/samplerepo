package com.Project.core.listeners;

import org.apache.sling.api.SlingConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = EventHandler.class,
           immediate = true,
           property = {
               "event.topics=" + SlingConstants.TOPIC_RESOURCE_CHANGED
           })
public class PageChangeListener implements EventHandler {

    private static final Logger LOG = LoggerFactory.getLogger(PageChangeListener.class);

    @Override
    public void handleEvent(Event event) {
        String resourcePath = (String) event.getProperty(SlingConstants.PROPERTY_PATH);

        if (event.getTopic().equals(SlingConstants.TOPIC_RESOURCE_CHANGED)) {
            LOG.info("Page changed: {}", resourcePath);
        }
    }
}
