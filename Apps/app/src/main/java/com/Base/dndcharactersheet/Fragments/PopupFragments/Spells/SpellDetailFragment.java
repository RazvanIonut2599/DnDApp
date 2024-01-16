package com.Base.dndcharactersheet.Fragments.PopupFragments.Spells;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.Base.dndcharactersheet.Fragments.MainFragments.SpellsFragment;
import com.Base.dndcharactersheet.HolderClasses.Spells.SpellInfoHolder;
import com.Base.dndcharactersheet.MainActivity;
import com.Base.dndcharactersheet.R;

import InterfacesOrAbstracts.FragmentBase;

public class SpellDetailFragment extends FragmentBase {
    public SpellsFragment parentView;
    public TextView title;
    public TextView description;
    public TextView properties;
    public TextView subtitle;

    public SpellInfoHolder spell;

    public SpellDetailFragment(MainActivity parent,SpellInfoHolder spellInfo) {
        super(R.layout.fragment_spells_spelldetails,parent);
        this.spell=spellInfo;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.title.setText(spell.title);
        this.description.setText(spell.description);
        this.properties.setText(spell.properties);
        this.subtitle.setText(spell.subtitle);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View spellDetailVar = inflater.inflate(R.layout.fragment_spells_spelldetails,container,false);
        title =(TextView) spellDetailVar.findViewById(R.id.spellTitle);
        subtitle =(TextView) spellDetailVar.findViewById(R.id.spellsubTitle);
        description=(TextView) spellDetailVar.findViewById(R.id.spellDetails);
        properties=(TextView) spellDetailVar.findViewById(R.id.spellProperties);

        return spellDetailVar;
    }

    @Override
    public void MakeEditable() {

    }

    @Override
    public void MakeNotEditable() {

    }
}
