package com.Project.core.models;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;

@Model(adaptables =Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Sidebar2 {
    @ValueMapValue
    private String name;

    @ValueMapValue
    private String image;

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }
    
}
