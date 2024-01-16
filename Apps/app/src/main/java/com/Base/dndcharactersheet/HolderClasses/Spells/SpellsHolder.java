package com.Base.dndcharactersheet.HolderClasses.Spells;

import com.Base.dndcharactersheet.HolderClasses.Spells.SpellInfoHolder;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SpellsHolder {
    @SerializedName("spells")
    public ArrayList<SpellInfoHolder> spellsList;
    public SpellsHolder(){
        this.spellsList=new ArrayList<SpellInfoHolder>();
    }
    public SpellsHolder(ArrayList<SpellInfoHolder> spellsList){
        this.spellsList=spellsList;
    }

}
