package com.Project.core.models;

import java.util.List;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Virat {
    @ValueMapValue
    private String description;
    @ValueMapValue
    private String image;
    @ValueMapValue
    private String articleCheckbox;
    @ValueMapValue
    @Optional
    private String date;
    @ValueMapValue
    private String articleType;
    @ValueMapValue
    private String num;
    @ValueMapValue
    private String textfield;
    @ChildResource
    private String[] mfield;
    @ChildResource
    private List <multi> nextedmultifield;
    public String getDescription() {
        return description;
    }
    public String getImage() {
        return image;
    }
    public String getArticleCheckbox() {
        return articleCheckbox;
    }
    public String getDate() {
        return date;
    }
    public String getArticleType() {
        return articleType;
    }
    public String getNum() {
        return num;
    }
    public String getTextfield() {
        return textfield;
    }
    public String[] getMfield() {
        return mfield;
    }
    

}
