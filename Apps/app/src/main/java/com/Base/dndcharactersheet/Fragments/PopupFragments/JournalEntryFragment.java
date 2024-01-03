package com.Base.dndcharactersheet.Fragments.PopupFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.Base.dndcharactersheet.Fragments.MainFragments.JournalFragment;
import com.Base.dndcharactersheet.HolderClasses.JournalEntryHolder;
import com.Base.dndcharactersheet.ListViewAdapters.JournalEntryAdapter;
import com.Base.dndcharactersheet.MainActivity;
import com.Base.dndcharactersheet.R;

import InterfacesOrAbstracts.FragmentBase;

public class JournalEntryFragment extends FragmentBase {
    public JournalFragment parentView;
    public Button buttonDoneJournalEntry;
    public EditText editJournalEntryTitle;
    public EditText editJournalEntryText;
    private String text;
    private String title;
    public JournalEntryFragment(MainActivity parent, JournalFragment journalView){
        super(R.layout.fragment_journalentry,parent);
        parentView=journalView;
        text="";
        title="";
    }
    public JournalEntryFragment(MainActivity parent,JournalFragment journalView,String title,String text ){
        super(R.layout.fragment_journalentry,parent);
        parentView=journalView;
        this.text=text;
        this.title=title;
    }
    @Nullable
    @Override
    public android.view.View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View journalEntryVar = inflater.inflate(R.layout.fragment_journalentry,container,false);

        buttonDoneJournalEntry=(Button) journalEntryVar.findViewById(R.id.buttonDoneJournalEntry);
        editJournalEntryTitle=(EditText) journalEntryVar.findViewById(R.id.editJournalEntryTitle);
        editJournalEntryText=(EditText) journalEntryVar.findViewById(R.id.editJournalEntryText);

        editJournalEntryText.setText(text);
        editJournalEntryTitle.setText(title);
        buttonDoneJournalEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                String title=editJournalEntryTitle.getText().toString();
                String text=editJournalEntryText.getText().toString();
                if(!title.isEmpty() && !text.isEmpty()) {
                    if (parentView.journalEntryExists(title))
                        parentView.setJournalEntryText(title, text);
                    else
                        parentView.journalEntryList.add(new JournalEntryHolder(title, text));

                    JournalEntryAdapter j= ((JournalEntryAdapter)parentView.journalEntryListView.getAdapter());
                    j.notifyDataSetChanged();

                    mainActivity.replaceFragment(parentView);
                }
            }
        });
        return journalEntryVar;
    }

    @Override
    public void MakeEditable() {

    }
    @Override
    public void MakeNotEditable() {

    }
}
