package com.Project.core.models;

import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables =Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MultiField {
    @ValueMapValue
    private String date;
    @ValueMapValue
    private String mfield;
    
    @ValueMapValue
    private String num;
    @ChildResource
    private List<Nmulti> nmultifield;

    public String getDate() {
        return date;
    }
    public String getMfield() {
        return mfield;
    }
    public String getNum() {
        return num;
    }
    
    
}
