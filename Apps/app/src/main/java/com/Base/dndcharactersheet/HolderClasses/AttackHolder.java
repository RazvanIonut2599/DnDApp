package com.Base.dndcharactersheet.HolderClasses;

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

    public AttackHolder(String name,String bonus,String damage,String type){
        this.name=name;
        this.bonus=bonus;
        this.damage=damage;
        this.type=type;
    }
}
