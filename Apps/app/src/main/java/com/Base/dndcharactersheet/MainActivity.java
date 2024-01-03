package com.Base.dndcharactersheet;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.Base.dndcharactersheet.Fragments.MainFragments.BasicInfoFragment;
import com.Base.dndcharactersheet.Fragments.MainFragments.CombatFragment;
import com.Base.dndcharactersheet.Fragments.MainFragments.InventoryFragment;
import com.Base.dndcharactersheet.Fragments.MainFragments.JournalFragment;
import com.Base.dndcharactersheet.Fragments.MainFragments.SpellsFragment;
import com.Base.dndcharactersheet.HolderClasses.BasicInfoHolder;
import com.Base.dndcharactersheet.HolderClasses.CombatHolder;
import com.Base.dndcharactersheet.HolderClasses.InventoryHolder;
import com.Base.dndcharactersheet.HolderClasses.JournalHolder;
import com.Base.dndcharactersheet.HolderClasses.MainInformationHolder;
import com.Base.dndcharactersheet.HolderClasses.SpellsHolder;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import InterfacesOrAbstracts.FragmentBase;

public class MainActivity extends AppCompatActivity {
    public String characterFileName;
    public boolean editable=false;
    public Button editButton;
    public Button saveButton;
    LayoutInflater inflater;
    //region fragments
    protected BasicInfoFragment basicInfoF;
    protected CombatFragment combatF;
    protected InventoryFragment inventoryF;
    protected JournalFragment journalF;
    protected SpellsFragment spellsF;
    //endregion
    public MainActivity(){
        basicInfoF=new BasicInfoFragment(this);
        combatF=new CombatFragment(this);
        inventoryF=new InventoryFragment(this);
        journalF=new JournalFragment(this);
        spellsF=new SpellsFragment(this);
        characterFileName ="Lev.txt";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inflater= this.getLayoutInflater();

        LoadSpellsJson();
        //region fragment setup
        editButton=(Button)findViewById(R.id.buttonEditMode);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editable=!editable;
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentBase f=(FragmentBase) fragmentManager.findFragmentById(R.id.mainViewFragment);
                if(editable)
                    f.MakeEditable();
                else
                    f.MakeNotEditable();
            }
        });
        saveButton=(Button)findViewById(R.id.buttonSave);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save(basicInfoF.getHolder(),
                        combatF.getHolder(),
                        inventoryF.getHolder(),
                        journalF.getHolder(),
                        spellsF.getHolder()
                        );
            }
        });

        basicInfoF.buttonBasicInfo = (Button)findViewById(R.id.buttonBasicInfo);
        basicInfoF.buttonBasicInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(basicInfoF);
            }
        });

        combatF.buttonCombat=(Button)findViewById(R.id.buttonCombat);
        combatF.buttonCombat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(combatF);
            }
        });

        inventoryF.buttonInventory=(Button)findViewById(R.id.buttonInventory);
        inventoryF.buttonInventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(inventoryF);
            }
        });

        journalF.buttonJournal=(Button)findViewById(R.id.buttonJournal);
        journalF.buttonJournal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(journalF);
            }
        });

        spellsF.buttonSpells=(Button)findViewById(R.id.buttonSpells);
        spellsF.buttonSpells.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(spellsF);
            }
        });
        replaceFragment(basicInfoF);
        //endregion


    }
    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainViewFragment,fragment);
        fragmentTransaction.commit();

    }
    private void closeKeyboard(){
        View view=this.getCurrentFocus();
        if(view!=null){
            InputMethodManager imm=(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }
    private void LoadSpellsJson(){
            try {
                InputStream inputStream = getAssets().open("spells.json");
                int size=inputStream.available();
                byte[] buffer=new byte[size];
                inputStream.read(buffer);
                inputStream.close();

                String json;
                int max;

                json=new String(buffer, StandardCharsets.UTF_8);
                JSONArray jsonArray=new JSONArray(json);
                max=jsonArray.length();

                String tags,contents;
                for (int i=0;i<max;i++){
                    JSONObject spell=jsonArray.getJSONObject(i);
                    tags=spell.getString("tags");
                    contents=spell.getString("contents");
                    Log.e("tag","loadJson tags: \n"+tags+"\ncontents\n"+contents);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

    }

    private void Save(
            BasicInfoHolder basicInfo,
            CombatHolder combatHolder,
            InventoryHolder inventoryHolder,
            JournalHolder journalHolder,
            SpellsHolder spellsHolder
    ){
        Gson gson=new Gson();
        MainInformationHolder mainInfo = new MainInformationHolder(basicInfo,combatHolder,inventoryHolder,journalHolder,spellsHolder);
        String info = gson.toJson(mainInfo);

        FileOutputStream fos=null;
        try{
        fos = openFileOutput(characterFileName,MODE_PRIVATE);
        fos.write(info.getBytes());

            Toast.makeText(this,"Saved "+characterFileName +" in "+getFilesDir(),Toast.LENGTH_LONG).show();
            Log.d("Saved","Saved "+characterFileName +" in "+getFilesDir());

        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(fos!=null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    private void Load( BasicInfoHolder basicInfo,
                       CombatHolder combatHolder,
                       InventoryHolder inventoryHolder,
                       JournalHolder journalHolder,
                       SpellsHolder spellsHolder)
    {
        FileInputStream fis=null;
        try {
            fis=openFileInput(characterFileName);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br=new BufferedReader(isr);
            StringBuilder sb =new StringBuilder();

            String json;
            while((json =br.readLine()) !=null){
                    sb.append(json).append("\n");

                    //split text into parts
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}