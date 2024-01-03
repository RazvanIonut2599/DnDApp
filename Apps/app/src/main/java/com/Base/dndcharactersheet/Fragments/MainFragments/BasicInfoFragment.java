package com.Base.dndcharactersheet.Fragments.MainFragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.Base.dndcharactersheet.HolderClasses.BasicInfoHolder;
import com.Base.dndcharactersheet.MainActivity;
import com.Base.dndcharactersheet.R;

import InterfacesOrAbstracts.FragmentBase;

public class BasicInfoFragment extends FragmentBase {
    public Button buttonBasicInfo;
    //region Info
    public EditText editTextName;
    public EditText editTextClass;
    public EditText editTextLevel;
    //endregion

    //region Stats
    public EditText str; private int strVal;
    public EditText dex;private int dexVal;
    public EditText intel;private int intVal;
    public EditText con;private int conVal;
    public EditText wis;private int wisVal;
    public EditText cha;private int chaVal;
    //endregion

    //region Skills
    public EditText athletics;
    public EditText acrobatics;
    public EditText sleightOfHand;
    public EditText stealth;
    public EditText arcana;
    public EditText history;
    public EditText investigation;
    public EditText nature;
    public EditText religion;
    public EditText medicine;
    public EditText perception;
    public EditText survival;
    public EditText deception;
    public EditText intimidation;
    public EditText performance;
    public EditText persuasion;
    public EditText animalHandling;
    public EditText insight;
    //endregion

    //region Features
    public EditText features;
    //endregion

    public BasicInfoFragment(MainActivity parent){
        super(R.layout.fragment_basic_info,parent);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View infoViewVar = inflater.inflate(R.layout.fragment_basic_info,container,false);

        editTextName=(EditText) infoViewVar.findViewById(R.id.editTextName);
        editTextClass=(EditText) infoViewVar.findViewById(R.id.editTextClass);

        //region stats
        str    =(EditText) infoViewVar.findViewById(R.id.editSTR);
        dex    =(EditText) infoViewVar.findViewById(R.id.editDEX);
        con    =(EditText) infoViewVar.findViewById(R.id.editCON);
        intel  =(EditText) infoViewVar.findViewById(R.id.editINT);
        wis    =(EditText) infoViewVar.findViewById(R.id.editWIS);
        cha    =(EditText) infoViewVar.findViewById(R.id.editCHA);

        //endregion

        //region skills
        athletics      =(EditText) infoViewVar.findViewById(R.id.editAthletics);
        acrobatics     =(EditText) infoViewVar.findViewById(R.id.editAcrobatics);
        sleightOfHand  =(EditText) infoViewVar.findViewById(R.id.editSleightOfHand);
        stealth        =(EditText) infoViewVar.findViewById(R.id.editStealth);
        arcana         =(EditText) infoViewVar.findViewById(R.id.editArcana);
        history        =(EditText) infoViewVar.findViewById(R.id.editHistory);
        investigation  =(EditText) infoViewVar.findViewById(R.id.editInvestigation);
        nature         =(EditText) infoViewVar.findViewById(R.id.editNature);
        religion       =(EditText) infoViewVar.findViewById(R.id.editReligion);
        animalHandling =(EditText) infoViewVar.findViewById(R.id.editAnimalHandling);
        insight        =(EditText) infoViewVar.findViewById(R.id.editInsight);
        medicine       =(EditText) infoViewVar.findViewById(R.id.editMedicine);
        perception     =(EditText) infoViewVar.findViewById(R.id.editPerception);
        survival       =(EditText) infoViewVar.findViewById(R.id.editSurvival);
        deception      =(EditText) infoViewVar.findViewById(R.id.editDeception);
        intimidation   =(EditText) infoViewVar.findViewById(R.id.editIntimidation);
        performance    =(EditText) infoViewVar.findViewById(R.id.editPerformance);
        persuasion     =(EditText) infoViewVar.findViewById(R.id.editPersuasion);
        //endregion

        features   =(EditText) infoViewVar.findViewById(R.id.editFeatures);
        MakeNotEditable();
        return infoViewVar;
    }

    @Override
    public void MakeEditable() {
        editTextName.setEnabled(true);
        editTextClass.setEnabled(true);

        str.setEnabled(true);
        dex.setEnabled(true);
        intel.setEnabled(true);
        con.setEnabled(true);
        wis.setEnabled(true);
        cha.setEnabled(true);

        athletics.setEnabled(true);
        acrobatics.setEnabled(true);
        sleightOfHand.setEnabled(true);
        stealth.setEnabled(true);
        arcana.setEnabled(true);
        history.setEnabled(true);
        investigation.setEnabled(true);
        nature.setEnabled(true);
        religion.setEnabled(true);
        medicine.setEnabled(true);
        perception.setEnabled(true);
        survival.setEnabled(true);
        deception.setEnabled(true);
        intimidation.setEnabled(true);
        performance.setEnabled(true);
        persuasion.setEnabled(true);
        animalHandling.setEnabled(true);
        insight.setEnabled(true);

        features.setEnabled(true);
    }
    @Override
    public void MakeNotEditable() {
        editTextName.setEnabled(false);
        editTextClass.setEnabled(false);

        str.setEnabled(false);
        dex.setEnabled(false);
        intel.setEnabled(false);
        con.setEnabled(false);
        wis.setEnabled(false);
        cha.setEnabled(false);

        athletics.setEnabled(false);
        acrobatics.setEnabled(false);
        sleightOfHand.setEnabled(false);
        stealth.setEnabled(false);
        arcana.setEnabled(false);
        history.setEnabled(false);
        investigation.setEnabled(false);
        nature.setEnabled(false);
        religion.setEnabled(false);
        medicine.setEnabled(false);
        perception.setEnabled(false);
        survival.setEnabled(false);
        deception.setEnabled(false);
        intimidation.setEnabled(false);
        performance.setEnabled(false);
        persuasion.setEnabled(false);
        animalHandling.setEnabled(false);
        insight.setEnabled(false);

        features.setEnabled(false);
    }

    public BasicInfoHolder getHolder(){
        String name =editTextName.getText().toString();
        return new BasicInfoHolder(
                name,
                editTextClass.getText().toString(),
                "0",
                str.getText().toString(),dex.getText().toString(),intel.getText().toString(),
                con.getText().toString(),wis.getText().toString(),cha.getText().toString(),
                athletics.getText().toString(),acrobatics.getText().toString(),
                sleightOfHand.getText().toString(),stealth.getText().toString(),
                arcana.getText().toString(),history.getText().toString(),
                investigation.getText().toString(),nature.getText().toString(),
                religion.getText().toString(),medicine.getText().toString(),
                perception.getText().toString(),survival.getText().toString(),
                deception.getText().toString(),intimidation.getText().toString(),
                performance.getText().toString(),persuasion.getText().toString(),
                animalHandling.getText().toString(),insight.getText().toString(),
                features.getText().toString()
        );
    }

    
    /*//region UpdateStats
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