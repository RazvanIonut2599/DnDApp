package com.Base.dndcharactersheet.HolderClasses.Journal;

import com.Base.dndcharactersheet.HolderClasses.Journal.JournalEntryHolder;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class JournalHolder {
    @SerializedName("journal_entries")
    public ArrayList<JournalEntryHolder> journalEntryList;

    public JournalHolder(){
        this.journalEntryList=new ArrayList<JournalEntryHolder>();
    }
    public JournalHolder(ArrayList<JournalEntryHolder> journalEntries){
        this.journalEntryList=journalEntries;
    }
}
