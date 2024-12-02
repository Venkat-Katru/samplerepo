package com.Project.core.models;
import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Taskmin {
    @ValueMapValue
    private String pathfield;

    @ValueMapValue
    private String additionaltext;

    @ValueMapValue
    private String checkbox;

    @ValueMapValue
    private String options;

    @ChildResource
    private List<NestedField> nestedmultifield;

    
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

    public List<NestedField> getNestedmultifield() {
        return nestedmultifield;
    }


}
