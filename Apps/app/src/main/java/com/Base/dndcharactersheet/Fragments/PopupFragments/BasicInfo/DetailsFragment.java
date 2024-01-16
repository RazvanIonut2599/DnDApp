package com.Base.dndcharactersheet.Fragments.PopupFragments.BasicInfo;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.Base.dndcharactersheet.Fragments.MainFragments.BasicInfoFragment;
import com.Base.dndcharactersheet.HolderClasses.BasicInfo.DetailsHolder;
import com.Base.dndcharactersheet.MainActivity;
import com.Base.dndcharactersheet.R;

import InterfacesOrAbstracts.FragmentBase;

public class DetailsFragment extends FragmentBase {
    public BasicInfoFragment parentView;
    //region Info
    public EditText editTextName;
    public EditText editTextClass;
    public EditText editTextLevel;
    public EditText editTextRace;
    public EditText editTextProficiencyBonus;
    //endregion
    //region Features
    public EditText features;
    //endregion
    DetailsHolder dataHolder;
    public DetailsFragment(MainActivity parent, BasicInfoFragment basicInfoView){
        super(R.layout.fragment_basicinfo_attributes,parent);
        this.parentView=basicInfoView;
        this.dataHolder=new DetailsHolder();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editTextName.setText(dataHolder.Name);
        editTextClass.setText(dataHolder.Class);
        features.setText(dataHolder.features);
        editTextLevel.setText(dataHolder.Level);
        editTextRace.setText(dataHolder.Race);
        editTextProficiencyBonus.setText(dataHolder.ProficiencyBonus);
        created=true;
        MakeNotEditable();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewVar = inflater.inflate(R.layout.fragment_basicinfo_details,container,false);

        editTextName=(EditText) viewVar.findViewById(R.id.editTextName);
        editTextName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mainActivity.characterFileName=s+".txt";
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
        editTextClass=(EditText) viewVar.findViewById(R.id.editTextClass);
        editTextRace=(EditText) viewVar.findViewById(R.id.editTextRace);
        editTextLevel=(EditText) viewVar.findViewById(R.id.editTextLevel);
        editTextProficiencyBonus=(EditText) viewVar.findViewById(R.id.editTextPB);

        features   =(EditText) viewVar.findViewById(R.id.editFeatures);

        return viewVar;
    }

    @Override
    public void MakeEditable() {
        editTextName.setEnabled(true);
        editTextClass.setEnabled(true);
        editTextClass.setEnabled(true);
        editTextRace.setEnabled(true);
        editTextLevel.setEnabled(true);
        editTextProficiencyBonus.setEnabled(true);
        features.setEnabled(true);

    }

    @Override
    public void MakeNotEditable() {
        editTextName.setEnabled(false);
        editTextClass.setEnabled(false);
        editTextClass.setEnabled(false);
        editTextRace.setEnabled(false);
        editTextLevel.setEnabled(false);
        editTextProficiencyBonus.setEnabled(false);
        features.setEnabled(false);
    }
    public DetailsHolder getHolder(){
        if(editTextName!=null)
            return new DetailsHolder(
                    editTextName.getText().toString(),
                    editTextClass.getText().toString(),
                    editTextLevel.getText().toString(),
                    editTextRace.getText().toString(),
                    editTextProficiencyBonus.getText().toString(),
                    features.getText().toString()
            );
        else
            return dataHolder;
    }
    public void setValues(DetailsHolder holder){
        this.dataHolder=holder;
    }
}
