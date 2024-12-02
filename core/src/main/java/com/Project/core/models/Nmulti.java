package com.Project.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Nmulti {
    @ValueMapValue
    private String mmfield;


     public String getMmfield() {
        return mmfield;
    }


    public String getNumm() {
        return numm;
    }


    @ValueMapValue
     private String numm;
}