package com.Base.dndcharactersheet.HolderClasses;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CombatHolder {
    @SerializedName("maxHp")
    private String maxHp;
    @SerializedName("currentHp")
    private String currentHp;
    @SerializedName("tempHp")
    private String tempHp;
    @SerializedName("hitDice")
    private String hitDice;
    @SerializedName("movement")
    private String movement;
    @SerializedName("initiative")
    private String initiative;

    private ArrayList<AttackHolder> attacksList;
    public CombatHolder(String maxHp, String currentHp, String tempHp, String hitDice, String movement, String initiative,ArrayList<AttackHolder> attacks){
        this.maxHp =maxHp;
        this.currentHp =currentHp;
        this.tempHp=tempHp;
        this.hitDice=hitDice;
        this.movement=movement;
        this.initiative=initiative;
        this.attacksList=attacks;
    }
}
