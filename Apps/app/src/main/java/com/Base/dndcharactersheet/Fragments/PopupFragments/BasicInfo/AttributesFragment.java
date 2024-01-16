package com.Base.dndcharactersheet.Fragments.PopupFragments.BasicInfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.Base.dndcharactersheet.Fragments.MainFragments.BasicInfoFragment;
import com.Base.dndcharactersheet.HolderClasses.BasicInfo.AttributesHolder;
import com.Base.dndcharactersheet.MainActivity;
import com.Base.dndcharactersheet.R;

import InterfacesOrAbstracts.FragmentBase;

public class AttributesFragment extends FragmentBase {
    public BasicInfoFragment parentView;
    //region Stats
    public EditText str;
    public EditText dex;
    public EditText intel;
    public EditText con;
    public EditText wis;
    public EditText cha;
    //endregion
    AttributesHolder dataHolder;

    public AttributesFragment(MainActivity parent,BasicInfoFragment basicInfoView){
        super(R.layout.fragment_basicinfo_attributes,parent);
        this.parentView=basicInfoView;
        this.dataHolder=new AttributesHolder();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        str.setText(dataHolder.strVal);
        dex.setText(dataHolder.dexVal);
        con.setText(dataHolder.conVal);
        intel.setText(dataHolder.intVal);
        wis.setText(dataHolder.wisVal);
        cha.setText(dataHolder.chaVal);
        created=true;
        MakeNotEditable();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewVar = inflater.inflate(R.layout.fragment_basicinfo_attributes,container,false);

        //region stats
        str    =(EditText) viewVar.findViewById(R.id.editSTR);
        dex    =(EditText) viewVar.findViewById(R.id.editDEX);
        con    =(EditText) viewVar.findViewById(R.id.editCON);
        intel  =(EditText) viewVar.findViewById(R.id.editINT);
        wis    =(EditText) viewVar.findViewById(R.id.editWIS);
        cha    =(EditText) viewVar.findViewById(R.id.editCHA);
        //endregion
        return viewVar;
    }

    @Override
    public void MakeEditable() {
        str.setEnabled(true);
        dex.setEnabled(true);
        intel.setEnabled(true);
        con.setEnabled(true);
        wis.setEnabled(true);
        cha.setEnabled(true);
    }

    @Override
    public void MakeNotEditable() {
        str.setEnabled(false);
        dex.setEnabled(false);
        intel.setEnabled(false);
        con.setEnabled(false);
        wis.setEnabled(false);
        cha.setEnabled(false);
    }

    public AttributesHolder getHolder(){
        if(str!=null)
            return new AttributesHolder(
                    str.getText().toString(),dex.getText().toString(),intel.getText().toString(),
                    con.getText().toString(),wis.getText().toString(),cha.getText().toString()
            );
        else
            return dataHolder;
    }
    public void setValues(AttributesHolder holder){
        this.dataHolder=holder;
    }
}
