package com.Base.dndcharactersheet.Fragments.MainFragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.Base.dndcharactersheet.Fragments.PopupFragments.BasicInfo.AttributesFragment;
import com.Base.dndcharactersheet.Fragments.PopupFragments.BasicInfo.DetailsFragment;
import com.Base.dndcharactersheet.Fragments.PopupFragments.BasicInfo.SkillFragment;
import com.Base.dndcharactersheet.HolderClasses.BasicInfo.BasicInfoHolder;
import com.Base.dndcharactersheet.MainActivity;
import com.Base.dndcharactersheet.R;

import InterfacesOrAbstracts.FragmentBase;

public class BasicInfoFragment extends FragmentBase {
    public Button buttonBasicInfo;
    public Button buttonSkills;
    public Button buttonDetails;
    public Button buttonAttributes;
    //region Fragments
    AttributesFragment attributes;
    DetailsFragment details;
    SkillFragment skills;
    //endregion

    BasicInfoHolder dataHolder;
    public BasicInfoFragment(MainActivity parent,BasicInfoHolder dataHolder){
        super(R.layout.fragment_basic_info,parent);
        attributes=new AttributesFragment(parent,this);
        details=new DetailsFragment(parent,this);
        skills=new SkillFragment(parent,this);

        this.dataHolder=new BasicInfoHolder();
        this.setValues(dataHolder);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        created=true;
        MakeNotEditable();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View infoViewVar = inflater.inflate(R.layout.fragment_basic_info,container,false);
        BasicInfoFragment thisFragment=this;
        buttonSkills=(Button)infoViewVar.findViewById(R.id.buttonSkills);
        buttonSkills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(skills,mainActivity.getSupportFragmentManager());
            }
        });
        buttonAttributes=(Button) infoViewVar.findViewById(R.id.buttonAttributes);
        buttonAttributes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(attributes,mainActivity.getSupportFragmentManager());
            }
        });
        buttonDetails=(Button) infoViewVar.findViewById(R.id.buttonDetails);
        buttonDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(details,mainActivity.getSupportFragmentManager());
            }
        });

        return infoViewVar;
    }

    @Override
    public void MakeEditable() {
        if(attributes.created)
            attributes.MakeEditable();
        if(details.created)
            details.MakeEditable();
        if(skills.created)
            skills.MakeEditable();
    }
    @Override
    public void MakeNotEditable() {
        if(attributes.created)
            attributes.MakeNotEditable();
        if(details.created)
            details.MakeNotEditable();
        if(skills.created)
            skills.MakeNotEditable();
    }

    public BasicInfoHolder getHolder(){
        if(created)
           return new BasicInfoHolder(
                    details.getHolder(),
                    attributes.getHolder(),
                    skills.getHolder()
           );
       else
            return dataHolder;
    }

    public void setValues(BasicInfoHolder holder){
        attributes.setValues(holder.attributes);
        skills.setValues(holder.skills);
        details.setValues(holder.details);
    }
    public void replaceFragment(Fragment fragment,FragmentManager fragmentManagerMain){
        FragmentTransaction fragmentTransaction = fragmentManagerMain.beginTransaction();
        fragmentTransaction.replace(R.id.basicInfoFragment,fragment);
        fragmentTransaction.commit();
    }
    /*
    //region UpdateStats
    public void Update(){
        String text=str.getText().toString();
        UpdateSTR(text);
        text=con.getText().toString();
        UpdateCON(text);
        text=dex.getText().toString();
        UpdateDEX(text);
        text=intel.getText().toString();
        UpdateINT(text);
        text=wis.getText().toString();
        UpdateWIS(text);
        text=cha.getText().toString();
        UpdateCHA(text);
    }
    private void UpdateSTR(String text){
        if(!text.isEmpty()) {
            strVal = Integer.parseInt(text);
            athletics.setText(text);
        }
    }
    private void UpdateDEX(String text){
        if(!text.isEmpty()){
            dexVal = Integer.parseInt(text);

            acrobatics.setText(text);
            sleightOfHand.setText(text);
            stealth.setText(text);
        }
    }
    private void UpdateCON(String text){
        if(!text.isEmpty()){
            conVal = Integer.parseInt(text);
        }
    }
    private void UpdateINT(String text){
        if(!text.isEmpty()){
            intVal = Integer.parseInt(text);
            arcana.setText(text);
            history.setText(text);
            investigation.setText(text);
            nature.setText(text);
            religion.setText(text);
        }
    }
    private void UpdateWIS(String text){
        if(!text.isEmpty()){
            wisVal=Integer.parseInt(text);
            animalHandling.setText(text);
            insight.setText(text);
            medicine.setText(text);
            perception.setText(text);
            survival.setText(text);
        }
    }
    private void UpdateCHA(String text){
        if(!text.isEmpty()){
            chaVal=Integer.parseInt(text);
            deception.setText(text);
            intimidation.setText(text);
            performance.setText(text);
            persuasion.setText(text);
        }
    }
//endregion*/
}