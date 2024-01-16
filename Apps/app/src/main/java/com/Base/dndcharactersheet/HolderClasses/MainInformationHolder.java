package com.Base.dndcharactersheet.HolderClasses;

import com.Base.dndcharactersheet.HolderClasses.BasicInfo.BasicInfoHolder;
import com.Base.dndcharactersheet.HolderClasses.Combat.CombatHolder;
import com.Base.dndcharactersheet.HolderClasses.Inventory.InventoryHolder;
import com.Base.dndcharactersheet.HolderClasses.Journal.JournalHolder;
import com.Base.dndcharactersheet.HolderClasses.Spells.SpellsHolder;
import com.google.gson.annotations.SerializedName;

public class MainInformationHolder {
    @SerializedName("basic_info")
    public BasicInfoHolder basicInfoHolder;
    @SerializedName("combat_info")
    public CombatHolder combatHolder;
    @SerializedName("inventory_info")
    public InventoryHolder inventoryHolder;
    @SerializedName("journal_info")
    public JournalHolder journalHolder;
    @SerializedName("spells_info")
    public SpellsHolder spellsHolder;

    public MainInformationHolder(
            BasicInfoHolder basicInfo,
            CombatHolder combatInfo,
            InventoryHolder inventoryInfo,
            JournalHolder journalInfo,
            SpellsHolder spellsInfo
    ){
        basicInfoHolder = basicInfo;
        combatHolder=combatInfo;
        inventoryHolder=inventoryInfo;
        journalHolder=journalInfo;
        spellsHolder=spellsInfo;
    }
}
