package com.Base.dndcharactersheet.Fragments.MainFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.Base.dndcharactersheet.HolderClasses.SpellsHolder;
import com.Base.dndcharactersheet.HolderClasses.SpellsJSONHolder;
import com.Base.dndcharactersheet.MainActivity;
import com.Base.dndcharactersheet.R;

import InterfacesOrAbstracts.FragmentBase;

public class SpellsFragment extends FragmentBase {
    public Button buttonSpells;
    private SpellsJSONHolder spells;

    public SpellsFragment(MainActivity parent){
        super(R.layout.fragment_spells,parent);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View spellsVar = inflater.inflate(R.layout.fragment_spells,container,false);

        MakeNotEditable();
        return spellsVar;
    }

    @Override
    public void MakeEditable() {

    }

    @Override
    public void MakeNotEditable() {

    }

    public SpellsHolder getHolder(){
        return new SpellsHolder(

        );
    }
}