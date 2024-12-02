package com.Project.core.services;



import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.Project.core.schedulers.PageExpiryScheduler;

import java.util.HashMap;
import java.util.Map;

@Component(service = PageExpiryScheduler.ResourceResolverService.class)
public class ResourceResolverServiceImpl implements PageExpiryScheduler.ResourceResolverService {

    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    @Override
    public ResourceResolver createWriter() {
        try {
            Map<String, Object> authInfo = new HashMap<>();
            authInfo.put(ResourceResolverFactory.SUBSERVICE, "writeService");
            return resourceResolverFactory.getServiceResourceResolver(authInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
