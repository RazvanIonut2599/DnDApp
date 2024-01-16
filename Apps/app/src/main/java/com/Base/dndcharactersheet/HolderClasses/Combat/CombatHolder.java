package com.Base.dndcharactersheet.HolderClasses.Combat;

import com.Base.dndcharactersheet.HolderClasses.Combat.AttackHolder;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CombatHolder {
    @SerializedName("maxHp")
    public String maxHp;
    @SerializedName("currentHp")
    public String currentHp;
    @SerializedName("tempHp")
    public String tempHp;
    @SerializedName("armorClass")
    public String armorClass;
    @SerializedName("movement")
    public String movement;
    @SerializedName("initiative")
    public String initiative;

    public ArrayList<AttackHolder> attacksList;
    public CombatHolder(){
        this.maxHp="";
        this.currentHp="";
        this.tempHp="";
        this.armorClass="";
        this.movement="";
        this.initiative="";
        this.attacksList=new ArrayList<AttackHolder>();
    }
    public CombatHolder(String maxHp, String currentHp, String tempHp, String hitDice, String movement, String initiative,ArrayList<AttackHolder> attacks){
        this.maxHp =maxHp;
        this.currentHp =currentHp;
        this.tempHp=tempHp;
        this.armorClass=hitDice;
        this.movement=movement;
        this.initiative=initiative;
        this.attacksList=attacks;
    }
}
