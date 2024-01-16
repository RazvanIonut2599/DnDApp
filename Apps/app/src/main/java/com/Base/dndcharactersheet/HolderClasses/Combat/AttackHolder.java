package com.Base.dndcharactersheet.HolderClasses.Combat;

import com.google.gson.annotations.SerializedName;

public class AttackHolder {
    @SerializedName("name")
    public String name;
    @SerializedName("bonus")
    public String bonus;
    @SerializedName("damage")
    public String damage;
    @SerializedName("type")
    public String type;
    public AttackHolder(){
        this.name="";
        this.bonus="";
        this.type="";
        this.damage="";
    }
    public AttackHolder(String name, String bonus, String damage, String type){
        this.name=name;
        this.bonus=bonus;
        this.damage=damage;
        this.type=type;
    }
}
