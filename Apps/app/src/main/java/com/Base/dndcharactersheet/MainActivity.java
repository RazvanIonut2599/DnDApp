package com.Base.dndcharactersheet;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
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
import com.Base.dndcharactersheet.HolderClasses.BasicInfo.BasicInfoHolder;
import com.Base.dndcharactersheet.HolderClasses.Combat.CombatHolder;
import com.Base.dndcharactersheet.HolderClasses.Inventory.InventoryHolder;
import com.Base.dndcharactersheet.HolderClasses.Journal.JournalHolder;
import com.Base.dndcharactersheet.HolderClasses.MainInformationHolder;
import com.Base.dndcharactersheet.HolderClasses.Spells.SpellInfoHolder;
import com.Base.dndcharactersheet.HolderClasses.Spells.SpellsHolder;
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
        basicInfoF=new BasicInfoFragment(this,new BasicInfoHolder());
        combatF=new CombatFragment(this,new CombatHolder());
        inventoryF=new InventoryFragment(this,new InventoryHolder());
        journalF=new JournalFragment(this,new JournalHolder());
        spellsF=new SpellsFragment(this,new SpellsHolder());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inflater= this.getLayoutInflater();

        Intent recieverIntent=getIntent();
        characterFileName = recieverIntent.getStringExtra("CharacterFile");
        if(characterFileName==null)
            characterFileName="";
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
                {
                    f.MakeEditable();
                    editButton.setText("Save changes");
                }
                else
                {
                    editButton.setText("Edit");
                    f.MakeNotEditable();
                    Save(basicInfoF.getHolder(), combatF.getHolder(), inventoryF.getHolder(), journalF.getHolder(), spellsF.getHolder());
                }
            }
        });
       /* saveButton=(Button)findViewById(R.id.buttonSave);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save(basicInfoF.getHolder(), combatF.getHolder(), inventoryF.getHolder(), journalF.getHolder(), spellsF.getHolder());
            }
        });
*/
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
                editable=false;
            }
        });

        inventoryF.buttonInventory=(Button)findViewById(R.id.buttonInventory);
        inventoryF.buttonInventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(inventoryF);editable=false;
            }
        });

        journalF.buttonJournal=(Button)findViewById(R.id.buttonJournal);
        journalF.buttonJournal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(journalF);editable=false;
            }
        });

        spellsF.buttonSpells=(Button)findViewById(R.id.buttonSpells);
        spellsF.buttonSpells.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(spellsF);editable=false;
            }
        });
        replaceFragment(basicInfoF);
        //endregion
        if(!characterFileName.isEmpty())
            Load();
    }
    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainViewFragment,fragment);
        fragmentTransaction.commit();
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

                String properties,description,title,subtitle;
                for (int i=0;i<max;i++){
                    JSONObject spell=jsonArray.getJSONObject(i);
                    title=spell.getString("title");
                    subtitle=spell.getString("subtitle");
                    properties=spell.getString("properties");
                    description=spell.getString("description");
                    spellsF.addAvailableSpell(new SpellInfoHolder(title,description,properties,subtitle));
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

    }

    private void Save(BasicInfoHolder basicInfo, CombatHolder combatHolder, InventoryHolder inventoryHolder, JournalHolder journalHolder, SpellsHolder spellsHolder)
    {
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
    private void Load()
    {
        FileInputStream fis=null;
        try {
            fis=openFileInput(characterFileName);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br=new BufferedReader(isr);
            StringBuilder sb =new StringBuilder();

            String json;
            while((json = br.readLine()) !=null){
                    sb.append(json).append("\n");
            }
            Gson gson=new Gson();
            MainInformationHolder holder=gson.fromJson(sb.toString(),MainInformationHolder.class);
            basicInfoF.setValues(holder.basicInfoHolder);
            combatF.setValues(holder.combatHolder);
            inventoryF.setValues(holder.inventoryHolder);
            journalF.setValues(holder.journalHolder);
            spellsF.setValues(holder.spellsHolder);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(fis!=null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}