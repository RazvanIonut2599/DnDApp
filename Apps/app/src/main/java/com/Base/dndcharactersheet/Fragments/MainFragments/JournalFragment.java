package com.Base.dndcharactersheet.Fragments.MainFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.Base.dndcharactersheet.Fragments.PopupFragments.Journal.JournalEntryFragment;
import com.Base.dndcharactersheet.HolderClasses.Journal.JournalEntryHolder;
import com.Base.dndcharactersheet.HolderClasses.Journal.JournalHolder;
import com.Base.dndcharactersheet.ListViewAdapters.JournalEntryAdapter;
import com.Base.dndcharactersheet.MainActivity;
import com.Base.dndcharactersheet.R;

import java.util.ArrayList;

import InterfacesOrAbstracts.FragmentBase;

public class JournalFragment extends FragmentBase {

    public Button buttonJournal;
    public Button addJournalEntry;
    public ArrayList<JournalEntryHolder> journalEntryList;
    public ListView journalEntryListView;
    JournalHolder dataHolder;

    public JournalFragment(MainActivity parent,JournalHolder dataHolder){

        super(R.layout.fragment_journal,parent);
        journalEntryList=new ArrayList<JournalEntryHolder>();
        this.dataHolder=dataHolder;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        journalEntryList=dataHolder.journalEntryList;
        JournalEntryAdapter journalEntryAdapter = new JournalEntryAdapter(mainActivity.getApplicationContext(),this.journalEntryList);
        journalEntryListView.setAdapter(journalEntryAdapter);

        ((JournalEntryAdapter)(journalEntryListView.getAdapter())).notifyDataSetChanged();
        MakeNotEditable();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View journalVar = inflater.inflate(R.layout.fragment_journal,container,false);
        JournalFragment parentFragment=this;
        addJournalEntry = (Button)journalVar.findViewById(R.id.addJournalEntry);
        journalEntryListView=(ListView)journalVar.findViewById(R.id.listViewJournalEntry);
        journalEntryListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                JournalEntryHolder clickedItem=(JournalEntryHolder)adapterView.getItemAtPosition(position);
                if(clickedItem!=null)
                    mainActivity.replaceFragment(new JournalEntryFragment(mainActivity,parentFragment,clickedItem.Title, clickedItem.Text));
            }
        });

        addJournalEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //journalEntryFragment.clearTexts();
                mainActivity.replaceFragment(new JournalEntryFragment(mainActivity,parentFragment));
            }
        });
        return journalVar;
    }

    @Override
    public void MakeEditable() {

    }

    @Override
    public void MakeNotEditable() {

    }
    public boolean journalEntryExists(String title){
        for (JournalEntryHolder entry:journalEntryList) {
            if(entry.Title.equalsIgnoreCase(title))
                return true;
        }
        return false;
    }
    public void setJournalEntryText(String title,String text){
        for (JournalEntryHolder entry:journalEntryList) {
            if(entry.Title.equalsIgnoreCase(title))
            {
                entry.Text=text;
                return;
            }
        }
    }

    public JournalHolder getHolder(){
        if(journalEntryListView!=null)
            return new JournalHolder(journalEntryList);
        else
            return dataHolder;
    }
    public void setValues(JournalHolder holder){
        this.dataHolder=holder;
    }


}