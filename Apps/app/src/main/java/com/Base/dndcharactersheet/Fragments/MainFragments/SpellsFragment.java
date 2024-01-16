package com.Base.dndcharactersheet.Fragments.MainFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.Base.dndcharactersheet.Fragments.PopupFragments.Spells.SpellDetailFragment;
import com.Base.dndcharactersheet.HolderClasses.Spells.SpellInfoHolder;
import com.Base.dndcharactersheet.HolderClasses.Spells.SpellsHolder;
import com.Base.dndcharactersheet.ListViewAdapters.SpellAdapter;
import com.Base.dndcharactersheet.MainActivity;
import com.Base.dndcharactersheet.R;

import java.util.ArrayList;

import InterfacesOrAbstracts.FragmentBase;

public class SpellsFragment extends FragmentBase {
    public Button buttonSpells;
    public EditText editSpellslots;
    public Button addSpell;
    public EditText addSpellName;
    public ListView listViewSpells;
    private ArrayList<SpellInfoHolder> availableSpells;
    public ArrayList<SpellInfoHolder> currentSpells;
    SpellsHolder dataHolder;

    public SpellsFragment(MainActivity parent,SpellsHolder dataHolder){
        super(R.layout.fragment_spells,parent);
        this.dataHolder=dataHolder;
        this.availableSpells=new ArrayList<SpellInfoHolder>();
        this.currentSpells=new ArrayList<SpellInfoHolder>();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.currentSpells=dataHolder.spellsList;
        SpellAdapter adapter=new SpellAdapter(mainActivity.getApplicationContext(),this.currentSpells);
        listViewSpells.setAdapter(adapter);
        ((SpellAdapter)(listViewSpells.getAdapter())).notifyDataSetChanged();
        MakeNotEditable();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View spellsVar = inflater.inflate(R.layout.fragment_spells,container,false);
        SpellsFragment parentFragment=this;
        editSpellslots =(EditText)spellsVar.findViewById(R.id.editSpellslots);
        addSpellName=(EditText)spellsVar.findViewById(R.id.addSpellName);
        addSpell =(Button) spellsVar.findViewById(R.id.addSpell);
        addSpell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String spellNameToAdd = addSpellName.getText().toString().toLowerCase();
                for (SpellInfoHolder spell:availableSpells) {
                    if(spell.title.equalsIgnoreCase(spellNameToAdd))
                    {
                        currentSpells.add(spell);
                        addSpellName.setText("");
                        ((SpellAdapter)(parentFragment.listViewSpells.getAdapter())).notifyDataSetChanged();
                        break;
                    }
                }
            }
        });
        listViewSpells = (ListView)spellsVar.findViewById(R.id.listViewSpells);
        listViewSpells.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SpellInfoHolder clickedItem=(SpellInfoHolder)parent.getItemAtPosition(position);
                if(clickedItem!=null)
                    mainActivity.replaceFragment(new SpellDetailFragment(mainActivity,clickedItem));

            }
        });


        return spellsVar;
    }

    public void addAvailableSpell(SpellInfoHolder spell){
        this.availableSpells.add(spell);
    }
    @Override
    public void MakeEditable() {
        editSpellslots.setEnabled(true);
        addSpellName.setEnabled(true);
    }
    @Override
    public void MakeNotEditable() {
        editSpellslots.setEnabled(false);
        addSpellName.setEnabled(false);
    }

    public SpellsHolder getHolder(){
        if(listViewSpells!=null)
            return new SpellsHolder(currentSpells);
        else
            return dataHolder;
    }
    public void setValues(SpellsHolder holder){
        this.dataHolder=holder;
    }

}