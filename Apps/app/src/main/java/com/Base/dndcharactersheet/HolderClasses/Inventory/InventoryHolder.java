package com.Base.dndcharactersheet.HolderClasses.Inventory;

import com.google.gson.annotations.SerializedName;

public class InventoryHolder {
    @SerializedName("inventory")
    public String inventory;
    public InventoryHolder(){
        this.inventory="";
    }
    public InventoryHolder(String inv){
        this.inventory=inv;
    }
}
