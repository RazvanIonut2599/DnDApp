package com.Base.dndcharactersheet.HolderClasses.BasicInfo;

import com.google.gson.annotations.SerializedName;

public class DetailsHolder {
    //region Info
    @SerializedName("Name")
    public String Name;
    @SerializedName("Class")
    public String Class;
    @SerializedName("Level")
    public String Level;
    @SerializedName("Race")
    public String Race;
    @SerializedName("ProficiencyBonus")
    public String ProficiencyBonus;
    //endregion
    //region Features
    @SerializedName("features")
    public String features;
    //endregion
    public DetailsHolder(){
        this.Name="";
        this.Class="";
        this.Level="";
        this.features="";
        this.Race="";
        this.ProficiencyBonus="";
    }
    public DetailsHolder(String pname,String pclass,String plevel,String prace,String pproficiencyBonus,String pfeatures){
        this.Name=pname;
        this.Class=pclass;
        this.Level=plevel;
        this.features=pfeatures;
        this.Race=prace;
        this.ProficiencyBonus=pproficiencyBonus;
    }
}
