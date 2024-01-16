package com.Base.dndcharactersheet.Fragments.PopupFragments.BasicInfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.Base.dndcharactersheet.Fragments.MainFragments.BasicInfoFragment;
import com.Base.dndcharactersheet.HolderClasses.BasicInfo.SkillsHolder;
import com.Base.dndcharactersheet.MainActivity;
import com.Base.dndcharactersheet.R;

import InterfacesOrAbstracts.FragmentBase;

public class SkillFragment extends FragmentBase {
    public BasicInfoFragment parentView;
    public Button buttonEditProficiencies;

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
    public SkillsHolder dataHolder;

    public SkillFragment(MainActivity parent,BasicInfoFragment basicInfoView){
        super(R.layout.fragment_basicinfo_skills,parent);
        this.parentView=basicInfoView;
        this.dataHolder=new SkillsHolder();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        athletics.setText(dataHolder.athletics);
        acrobatics.setText(dataHolder.acrobatics);
        sleightOfHand.setText(dataHolder.sleightOfHand);
        stealth.setText(dataHolder.stealth);
        arcana.setText(dataHolder.arcana);
        history.setText(dataHolder.history);
        investigation.setText(dataHolder.investigation);
        nature.setText(dataHolder.nature);
        religion.setText(dataHolder.religion);
        animalHandling.setText(dataHolder.animalHandling);
        insight.setText(dataHolder.insight);
        medicine.setText(dataHolder.medicine);
        perception.setText(dataHolder.perception);
        survival.setText(dataHolder.survival);
        deception.setText(dataHolder.deception);
        intimidation.setText(dataHolder.intimidation);
        performance.setText(dataHolder.performance);
        persuasion.setText(dataHolder.persuasion);
        created=true;
        MakeNotEditable();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View skillViewVar = inflater.inflate(R.layout.fragment_basicinfo_skills,container,false);
        
         //region skills
        athletics      =(EditText) skillViewVar.findViewById(R.id.editAthletics);
        acrobatics     =(EditText) skillViewVar.findViewById(R.id.editAcrobatics);
        sleightOfHand  =(EditText) skillViewVar.findViewById(R.id.editSleightOfHand);
        stealth        =(EditText) skillViewVar.findViewById(R.id.editStealth);
        arcana         =(EditText) skillViewVar.findViewById(R.id.editArcana);
        history        =(EditText) skillViewVar.findViewById(R.id.editHistory);
        investigation  =(EditText) skillViewVar.findViewById(R.id.editInvestigation);
        nature         =(EditText) skillViewVar.findViewById(R.id.editNature);
        religion       =(EditText) skillViewVar.findViewById(R.id.editReligion);
        animalHandling =(EditText) skillViewVar.findViewById(R.id.editAnimalHandling);
        insight        =(EditText) skillViewVar.findViewById(R.id.editInsight);
        medicine       =(EditText) skillViewVar.findViewById(R.id.editMedicine);
        perception     =(EditText) skillViewVar.findViewById(R.id.editPerception);
        survival       =(EditText) skillViewVar.findViewById(R.id.editSurvival);
        deception      =(EditText) skillViewVar.findViewById(R.id.editDeception);
        intimidation   =(EditText) skillViewVar.findViewById(R.id.editIntimidation);
        performance    =(EditText) skillViewVar.findViewById(R.id.editPerformance);
        persuasion     =(EditText) skillViewVar.findViewById(R.id.editPersuasion);
        //endregion

        return skillViewVar;
    }

    @Override
    public void MakeEditable() {
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
    }

    @Override
    public void MakeNotEditable() {
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
    }

    public SkillsHolder getHolder(){
        if(athletics!=null)
            return new SkillsHolder(athletics.getText().toString(),acrobatics.getText().toString(),
                        sleightOfHand.getText().toString(),stealth.getText().toString(),
                        arcana.getText().toString(),history.getText().toString(),
                        investigation.getText().toString(),nature.getText().toString(),
                        religion.getText().toString(),medicine.getText().toString(),
                        perception.getText().toString(),survival.getText().toString(),
                        deception.getText().toString(),intimidation.getText().toString(),
                        performance.getText().toString(),persuasion.getText().toString(),
                        animalHandling.getText().toString(),insight.getText().toString()
            );
        else
            return dataHolder;

    }

    public void setValues(SkillsHolder holder){
        this.dataHolder=holder;
    }
}
