package com.Base.dndcharactersheet.HolderClasses.BasicInfo;

import com.google.gson.annotations.SerializedName;
public class BasicInfoHolder {


    public DetailsHolder details;
    public SkillsHolder skills;
    @SerializedName("Attributes")
    public AttributesHolder attributes;

    public BasicInfoHolder(){
        this.details=new DetailsHolder();
        this.skills=new SkillsHolder();
        this.attributes=new AttributesHolder();

    }
    public BasicInfoHolder(
            DetailsHolder details,
            AttributesHolder attributes,
            SkillsHolder skills
            ){
        this.attributes=attributes;
        this.details=details;
        this.skills=skills;
    }
}
