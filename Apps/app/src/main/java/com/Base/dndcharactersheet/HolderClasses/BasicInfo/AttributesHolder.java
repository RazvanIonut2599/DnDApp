package com.Base.dndcharactersheet.HolderClasses.BasicInfo;

import com.google.gson.annotations.SerializedName;

public class AttributesHolder {
    //region Stats
    @SerializedName("strVal")
    public String strVal;
    @SerializedName("dexVal")
    public String dexVal;
    @SerializedName("intVal")
    public String intVal;
    @SerializedName("conVal")
    public String conVal;
    @SerializedName("wisVal")
    public String wisVal;
    @SerializedName("chaVal")
    public String chaVal;
    //endregion

    public AttributesHolder(){
        //region Stats
        this.strVal="";
        this.dexVal="";
        this.intVal="";
        this.conVal="";
        this.wisVal="";
        this.chaVal="";
        //endregion
    }
    public AttributesHolder(String pstr, String pdex, String pint, String pcon, String pwis, String pcha){
        //region Stats
        this.strVal=pstr;
        this.dexVal=pdex;
        this.intVal=pint;
        this.conVal=pcon;
        this.wisVal=pwis;
        this.chaVal=pcha;
        //endregion
    }


}
