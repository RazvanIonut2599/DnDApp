package com.Base.dndcharactersheet.HolderClasses;

import com.google.gson.annotations.SerializedName;

public class MainInformationHolder {
    @SerializedName("basic_info")
    private BasicInfoHolder basicInfoHolder;
    @SerializedName("combat_info")
    private CombatHolder combatHolder;
    @SerializedName("inventory_info")
    private InventoryHolder inventoryHolder;
    @SerializedName("journal_info")
    private JournalHolder journalHolder;
    @SerializedName("spells_info")
    private SpellsHolder spellsHolder;

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
