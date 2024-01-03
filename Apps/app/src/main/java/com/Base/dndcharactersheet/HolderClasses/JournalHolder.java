package com.Base.dndcharactersheet.HolderClasses;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class JournalHolder {
    @SerializedName("journal_entries")
    public ArrayList<JournalEntryHolder> journalEntryList;

    public JournalHolder(ArrayList<JournalEntryHolder> journalEntries){
        this.journalEntryList=journalEntries;
    }
}
