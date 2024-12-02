package com.Project.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;

@Model(adaptables =Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Task1 {
    @ValueMapValue
    private String textfield;

    @ValueMapValue
    private String fileReference;

    @ValueMapValue
    private String Checkbox;

    public String getTextfield() {
        return textfield;
    }


    public String getCheckbox() {
        return Checkbox;
    }

    public String getCountries() {
        return countries;
    }

    @ValueMapValue
    private String countries;

    public String getFileReference() {
        return fileReference;
    }
}

