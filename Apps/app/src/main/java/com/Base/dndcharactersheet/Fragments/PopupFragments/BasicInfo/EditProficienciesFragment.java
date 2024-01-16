package com.Base.dndcharactersheet.Fragments.PopupFragments.BasicInfo;


import android.widget.EditText;
import android.widget.RadioButton;

import androidx.fragment.app.Fragment;
import com.Base.dndcharactersheet.R;

public class EditProficienciesFragment extends Fragment {
    //region Skills
    public RadioButton athletics;
    public RadioButton acrobatics;
    public RadioButton sleightOfHand;
    public RadioButton stealth;
    public RadioButton arcana;
    public RadioButton history;
    public RadioButton investigation;
    public RadioButton nature;
    public RadioButton religion;
    public RadioButton medicine;
    public RadioButton perception;
    public RadioButton survival;
    public RadioButton deception;
    public RadioButton intimidation;
    public RadioButton performance;
    public RadioButton persuasion;
    public RadioButton animalHandling;
    public RadioButton insight;
    //endregion
    public EditText features;
    public EditProficienciesFragment(){super(R.layout.fragment_basicinfo_skills_proficiencies);}
}
