package com.Base.dndcharactersheet.HolderClasses.Spells;

import com.google.gson.annotations.SerializedName;

public class SpellInfoHolder {
    @SerializedName("title")
    public String title;
    @SerializedName("subtitle")
    public String subtitle;
    @SerializedName("description")
    public String description;
    @SerializedName("properties")
    public String properties;
    public SpellInfoHolder(){
        this.properties="";
        this.title="";
        this.subtitle="";
        this.description="";
    }
    public SpellInfoHolder(String title,String description,String properties,String subtitle){
        this.properties=properties;
        this.title=title;
        this.description=description;
        this.subtitle=subtitle;
    }


}
