package com.Base.dndcharactersheet.HolderClasses;

import com.google.gson.annotations.SerializedName;

public class JournalEntryHolder {

    @SerializedName("Text")
    public String Text;
    @SerializedName("Title")
    public String Title;

    public JournalEntryHolder(String title, String text){
        this.Text = text;
        this.Title=title;
    }

}
