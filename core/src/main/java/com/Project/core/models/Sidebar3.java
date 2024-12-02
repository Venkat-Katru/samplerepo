package com.Project.core.models;
import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;

@Model(adaptables =Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Sidebar3 {
    @ValueMapValue
    private String desktopicon;

    @ValueMapValue
    private String mobileicon;

   @ChildResource
    private List<Sidebar32> nestedmultifield;

public String getDesktopicon() {
    return desktopicon;
}

public String getMobileicon() {
    return mobileicon;
}

public List<Sidebar32> getNestedmultifield() {
    return nestedmultifield;
}

    

}
