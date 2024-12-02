package com.Project.core.models;

import java.util.List;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;


@Model(adaptables =Resource.class , defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Interview {
@ValueMapValue
private String textf;

@ChildResource
private List<M>multifield;

public String getTextf() {
    return textf;
}

public List<M> getMultifield() {
    return multifield;
}


}
