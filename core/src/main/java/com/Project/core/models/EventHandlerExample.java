package com.Project.core.models;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.replication.ReplicationAction;

@Component(service=EventHandler.class ,
 immediate = true , 
 property = {EventConstants.EVENT_TOPIC+"="+ReplicationAction.EVENT_TOPIC,
 EventConstants.EVENT_FILTER+"=(&(type=ACTIVE)(paths=/constant/aem-guides-Project/us/en/venkat/*))"

})
public class EventHandlerExample  implements EventHandler{
    public static final Logger LOG=LoggerFactory.getLogger(EventHandlerExample.class);

    @Override
    public void handleEvent(Event event) {
        // TODO Auto-generated method stub
        LOG.info("event handler executed");
        LOG.info("Topic Name{}",event.getTopic());
        String[] propertyNames=event.getPropertyNames();
        for(String name:propertyNames){
        LOG.info("topic Name{}, PropertyValue{}",name,event.getProperty(name).toString());
        }
    }

}
