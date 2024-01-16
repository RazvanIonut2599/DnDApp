package com.Base.dndcharactersheet.HolderClasses.BasicInfo;

import com.google.gson.annotations.SerializedName;

public class SkillsHolder {
    //region Skills
    @SerializedName("athletics")
    public String athletics;
    @SerializedName("acrobatics")
    public String acrobatics;
    @SerializedName("sleightOfHand")
    public String sleightOfHand;
    @SerializedName("stealth")
    public String stealth;
    @SerializedName("arcana")
    public String arcana;
    @SerializedName("history")
    public String history;
    @SerializedName("investigation")
    public String investigation;
    @SerializedName("nature")
    public String nature;
    @SerializedName("religion")
    public String religion;
    @SerializedName("medicine")
    public String medicine;
    @SerializedName("perception")
    public String perception;
    @SerializedName("survival")
    public String survival;
    @SerializedName("deception")
    public String deception;
    @SerializedName("intimidation")
    public String intimidation;
    @SerializedName("performance")
    public String performance;
    @SerializedName("persuasion")
    public String persuasion;
    @SerializedName("animalHandling")
    public String animalHandling;
    @SerializedName("insight")
    public String insight;
    //endregion

    public SkillsHolder(){
        //region Skills
        this.athletics="";
        this.acrobatics="";
        this.sleightOfHand="";
        this.stealth="";
        this.arcana="";
        this.history="";
        this.investigation="";
        this.nature="";
        this.religion="";
        this.medicine="";
        this.perception="";
        this.survival="";
        this.deception="";
        this.intimidation="";
        this.performance="";
        this.persuasion="";
        this.animalHandling="";
        this.insight="";
        //endregion
    }
    public SkillsHolder(String path,String pacr,String psoh,String psth,String parc,String phis,String pinv,String pnat,String prel
            ,String pmed,String pper,String psur,String pdec,String pinti,String pperf,String ppers,String panh,String pins
    ){
        //region Skills
        this.athletics=path;
        this.acrobatics=pacr;
        this.sleightOfHand=psoh;
        this.stealth=psth;
        this.arcana=parc;
        this.history=phis;
        this.investigation=pinv;
        this.nature=pnat;
        this.religion=prel;
        this.medicine=pmed;
        this.perception=pper;
        this.survival=psur;
        this.deception=pdec;
        this.intimidation=pinti;
        this.performance=pperf;
        this.persuasion=ppers;
        this.animalHandling=panh;
        this.insight=pins;
        //endregion

    }
}
