package com.Project.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables=Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class M {
    @ValueMapValue
    private String pathfield;
    @ValueMapValue
    private String additionaltext;
    @ValueMapValue
    private String checkbox;
    @ValueMapValue
    private String options;
    public String getPathfield() {
        return pathfield;
    }
    public String getAdditionaltext() {
        return additionaltext;
    }
    public String getCheckbox() {
        return checkbox;
    }
    public String getOptions() {
        return options;
    }

    

}
