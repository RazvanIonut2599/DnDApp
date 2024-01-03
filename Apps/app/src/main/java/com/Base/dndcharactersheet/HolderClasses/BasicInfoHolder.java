package com.Base.dndcharactersheet.HolderClasses;

import com.google.gson.annotations.SerializedName;

public class BasicInfoHolder {
    //region stats
    //region Info
    @SerializedName("Name")
    private String Name;
    @SerializedName("Class")
    private String Class;
    @SerializedName("Level")
    private String Level;
    //endregion

    //region Stats
    @SerializedName("strVal")
    private String strVal;
    @SerializedName("dexVal")
    private String dexVal;
    @SerializedName("intVal")
    private String intVal;
    @SerializedName("conVal")
    private String conVal;
    @SerializedName("wisVal")
    private String wisVal;
    @SerializedName("chaVal")
    private String chaVal;
    //endregion

    //region Skills
    @SerializedName("athletics")
    private String athletics;
    @SerializedName("acrobatics")
    private String acrobatics;
    @SerializedName("sleightOfHand")
    private String sleightOfHand;
    @SerializedName("stealth")
    private String stealth;
    @SerializedName("arcana")
    private String arcana;
    @SerializedName("history")
    private String history;
    @SerializedName("investigation")
    private String investigation;
    @SerializedName("nature")
    private String nature;
    @SerializedName("religion")
    private String religion;
    @SerializedName("medicine")
    private String medicine;
    @SerializedName("perception")
    private String perception;
    @SerializedName("survival")
    private String survival;
    @SerializedName("deception")
    private String deception;
    @SerializedName("intimidation")
    private String intimidation;
    @SerializedName("performance")
    private String performance;
    @SerializedName("persuasion")
    private String persuasion;
    @SerializedName("animalHandling")
    private String animalHandling;
    @SerializedName("insight")
    private String insight;
    //endregion

    //region Features
    @SerializedName("features")
    private String features;
    //endregion
    //endregion

    public BasicInfoHolder(
            String pname,String pclass,String plevel,
            String pstr,String pdex,String pint,String pcon,String pwis,String pcha,
            String path,String pacr,String psoh,String psth,String parc,String phis,String pinv,String pnat,String prel
            ,String pmed,String pper,String psur,String pdec,String pinti,String pperf,String ppers,String panh,String pins
            ,String pfeatures
            ){
        //region stats
        //region Info
        this.Name=pname;
        this.Class=pclass;
        this.Level=plevel;
        //endregion

        //region Stats
        this.strVal=pstr;
        this.dexVal=pdex;
        this.intVal=pint;
        this.conVal=pcon;
        this.wisVal=pwis;
        this.chaVal=pcha;
        //endregion

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

        //region Features
        this.features=pfeatures;
        //endregion
        //endregion
    }
}
