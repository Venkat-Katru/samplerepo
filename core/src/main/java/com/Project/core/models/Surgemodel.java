package com.Project.core.models;

import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Surgemodel {

    @ValueMapValue
    private String text;

    @ChildResource
    private String[] multifield;

    @ChildResource
    private List<Aem>nextedmultifield;

    public String getText() {
        return text;
    }
    public String[] getMultifield() {
        return multifield;
    }
    public List<Aem> getNextedmultifield() {
        return nextedmultifield;
    }

}
