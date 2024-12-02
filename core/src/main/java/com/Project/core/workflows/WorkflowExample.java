package com.Project.core.workflows;


import org.osgi.service.component.annotations.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;

@Component(service = WorkflowProcess.class , immediate = true ,
            enabled = true , 
            property = {"process.label="+"venkatkatru"}
        )

public class WorkflowExample implements WorkflowProcess{
       private static final Logger log =LoggerFactory.getLogger(WorkflowExample.class);

    @Override
    public void execute(WorkItem workItem, WorkflowSession wSession, MetaDataMap msDataMap) throws WorkflowException {
       String payLoadType=workItem.getWorkflowData().getPayloadType();
       
       if(payLoadType.equals("JCR_PATH")){
            log.info("payLoadType{}", payLoadType);
            String path=workItem.getWorkflowData().getPayload().toString();
            log.info( "path{}",path);
       }
    }

}
