package com.Project.core.models;

import javax.xml.transform.Source;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables=Resource.class ,defaultInjectionStrategy=DefaultInjectionStrategy.OPTIONAL)
public class V {
    @ValueMapValue
    private String text;

    public String getText() {
        return text;
    }
    
}
