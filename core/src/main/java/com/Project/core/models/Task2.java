package com.Project.core.models;
import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;

@Model(adaptables =Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class Task2 {
    @ValueMapValue
    private String textfield;

    @ChildResource
    private List<Taskmin> multifield;

    public String getTextfield() {
        return textfield;
    }

    public List<Taskmin> getMultifield() {
        return multifield;
    }
 
}
