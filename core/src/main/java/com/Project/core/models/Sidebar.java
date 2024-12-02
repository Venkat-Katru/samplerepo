package com.Project.core.models;

import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;

@Model(adaptables =Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class Sidebar {
    @ValueMapValue
    private String logoPath;

    @ValueMapValue
    private String logoMobileImage;

    @ValueMapValue
    private String logoLink;

    @ValueMapValue
    private String enableSwitch;

     @ChildResource
    private List<Sidebar2> multifield;

    @ChildResource
    private List<Sidebar3> multifield2;

    @ValueMapValue
    private String navigationurl;

    @ValueMapValue
    private String countries;

    public String getLogoPath() {
        return logoPath;
    }

    public String getLogoMobileImage() {
        return logoMobileImage;
    }

    public String getLogoLink() {
        return logoLink;
    }

    public String getEnableSwitch() {
        return enableSwitch;
    }

    public List<Sidebar2> getMultifield() {
        return multifield;
    }

    public List<Sidebar3> getMultifield2() {
        return multifield2;
    }

    public String getNavigationurl() {
        return navigationurl;
    }

    public String getCountries() {
        return countries;
    }

    

}

