package Views.MainViews;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

public class BasicInfoView extends InterfacesOrAbstracts.View {

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

    public BasicInfoView(){
        str.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                UpdateSTR(str.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        con.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                UpdateCON(con.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        dex.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                UpdateDEX(dex.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        intel.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                UpdateINT(intel.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        wis.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                UpdateWIS(wis.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        cha.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                UpdateCHA(cha.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
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
//endregion
}
