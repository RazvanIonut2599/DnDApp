package com.Base.dndcharactersheet.HolderClasses;

import com.google.gson.annotations.SerializedName;

public class InventoryHolder {
    @SerializedName("inventory")
    private String inventory;
    public InventoryHolder(String inv){
        this.inventory=inv;
    }
}
