package com.Base.dndcharactersheet;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.Base.dndcharactersheet.Fragments.MainFragments.BasicInfoFragment;
import com.Base.dndcharactersheet.Fragments.MainFragments.CombatFragment;
import com.Base.dndcharactersheet.Fragments.MainFragments.InventoryFragment;
import com.Base.dndcharactersheet.Fragments.PopupFragments.JournalEntryFragment;
import com.Base.dndcharactersheet.Fragments.MainFragments.JournalFragment;
import com.Base.dndcharactersheet.Fragments.MainFragments.SpellsFragment;

import Views.MainViews.BasicInfoView;
import Views.MainViews.CombatView;
import Views.MainViews.InventoryView;
import Views.MainViews.JournalView;
import Views.MainViews.SpellsView;
import Views.PopupViews.JournalEntryView;

public class MainActivity extends AppCompatActivity {
    public boolean editable=false;
    //region fragments
    protected BasicInfoFragment basicInfoF;
    protected CombatFragment combatF;
    protected InventoryFragment inventoryF;
    protected JournalFragment journalF;
    protected SpellsFragment spellsF;
    //endregion
    //region view properties
    private BasicInfoView infoView;
    private CombatView combatView;
    private InventoryView inventoryView;
    private JournalView journalView;
    private SpellsView spellsView;
    //endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        basicInfoF=new BasicInfoFragment();
        replaceFragment(basicInfoF);

        combatF=new CombatFragment();
        inventoryF=new InventoryFragment();
        journalF=new JournalFragment();
        spellsF=new SpellsFragment();

        infoView=new BasicInfoView();
        setupBasicInfo();
        infoView.MakeNotEditable();

        combatView=new CombatView();
        setupCombat();
        combatView.MakeNotEditable();

        inventoryView=new InventoryView();
        setupInventory();
        inventoryView.MakeNotEditable();

        journalView=new JournalView();
        setupJournal();
        journalView.MakeNotEditable();

        spellsView=new SpellsView();
        setupSpells();
        spellsView.MakeNotEditable();


    }
    //Region setup
    private void setupBasicInfo(){
        infoView.buttonBasicInfo = (Button)findViewById(R.id.buttonBasicInfo);
        infoView.buttonBasicInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(basicInfoF);
            }
        });
        infoView.editTextName=findViewById(R.id.editTextName);
        infoView.editTextClass=findViewById(R.id.editTextClass);
        //region stats
        infoView.str=findViewById(R.id.editSTR);
        infoView.dex=findViewById(R.id.editDEX);
        infoView.con=findViewById(R.id.editCON);
        infoView.intel=findViewById(R.id.editINT);
        infoView.wis=findViewById(R.id.editWIS);
        infoView.cha=findViewById(R.id.editCHA);
        //endregion
        //region skills
        infoView.athletics=findViewById(R.id.editAthletics);
        infoView.acrobatics=findViewById(R.id.editAcrobatics);
        infoView.sleightOfHand=findViewById(R.id.editSleightOfHand);
        infoView.stealth=findViewById(R.id.editStealth);
        infoView.arcana=findViewById(R.id.editArcana);
        infoView.history=findViewById(R.id.editHistory);
        infoView.investigation=findViewById(R.id.editInvestigation);
        infoView.nature=findViewById(R.id.editNature);
        infoView.religion=findViewById(R.id.editReligion);
        infoView.animalHandling=findViewById(R.id.editAnimalHandling);
        infoView.insight=findViewById(R.id.editInsight);
        infoView.medicine=findViewById(R.id.editMedicine);
        infoView.perception=findViewById(R.id.editPerception);
        infoView.survival=findViewById(R.id.editSurvival);
        infoView.deception=findViewById(R.id.editDeception);
        infoView.intimidation=findViewById(R.id.editIntimidation);
        infoView.performance=findViewById(R.id.editPerformance);
        infoView.persuasion=findViewById(R.id.editPersuasion);
        //endregion
        infoView.features=findViewById(R.id.editFeatures);
        infoView.Update();
    }
    private void setupCombat(){
        combatView.buttonCombat = (Button)findViewById(R.id.buttonCombat);
        combatView.buttonCombat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(combatF);
            }
        });
    }
    private void setupInventory(){
        inventoryView.buttonInventory =(Button) findViewById(R.id.buttonInventory);
        inventoryView.buttonInventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(inventoryF);
            }
        });
        inventoryView.inventory=findViewById(R.id.editInventory);
    }
    private void setupJournal(){
        journalView.buttonJournal=(Button) findViewById(R.id.buttonJournal);
        journalView.buttonJournal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(journalF);
            }
        });
        journalView.addJournalEntry=(Button) findViewById(R.id.buttonAddJournalEntry);
        journalView.buttonJournal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                JournalEntryFragment newEntryFragment= new JournalEntryFragment();
                JournalEntryView newEntryView = new JournalEntryView();
                newEntryView.buttonDoneJournalEntry =(Button) findViewById(R.id.buttonDoneJournalEntry);
                newEntryView.editJournalEntry=findViewById(R.id.editJournalEntry);

                newEntryView.buttonDoneJournalEntry.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                replaceFragment(newEntryFragment);
            }
        });
    }
    private void setupSpells(){
        spellsView.buttonSpells = (Button) findViewById(R.id.buttonSpells);
        spellsView.buttonSpells.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(spellsF);
            }
        });
    }
    //endregion
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainViewFragment,fragment);
        fragmentTransaction.commit();

    }
}