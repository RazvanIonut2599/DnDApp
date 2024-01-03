package com.Base.dndcharactersheet.Fragments.MainFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.Base.dndcharactersheet.Fragments.PopupFragments.AddAttackFragment;
import com.Base.dndcharactersheet.HolderClasses.AttackHolder;
import com.Base.dndcharactersheet.HolderClasses.CombatHolder;
import com.Base.dndcharactersheet.ListViewAdapters.AttackAdapter;
import com.Base.dndcharactersheet.MainActivity;
import com.Base.dndcharactersheet.R;

import java.util.ArrayList;

import InterfacesOrAbstracts.FragmentBase;

public class CombatFragment extends FragmentBase {
    public Button buttonCombat;
    public Button addAttack;
    public EditText maxHp;
    public EditText currentHp;
    public EditText tempHp;
    public EditText hitDice;
    public EditText movement;
    public EditText initiative;

    public ArrayList<AttackHolder> attacksList;
    public ListView attacksListView;


    public CombatFragment(MainActivity parent){
        super(R.layout.fragment_combat,parent);
        attacksList=new ArrayList<AttackHolder>();
        attacksList.add(new AttackHolder("Sword","+4","1d6+4","Piercing"));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View combatVar = inflater.inflate(R.layout.fragment_combat,container,false);
        CombatFragment parentFragment=this;
        addAttack    =(Button) combatVar.findViewById(R.id.buttonAddAttack);
        maxHp        =(EditText) combatVar.findViewById(R.id.editMaxHealth);
        currentHp    =(EditText) combatVar.findViewById(R.id.editCurrentHealth);
        tempHp       =(EditText) combatVar.findViewById(R.id.editTempHealth);
        hitDice      =(EditText) combatVar.findViewById(R.id.editHitDice);
        movement     =(EditText) combatVar.findViewById(R.id.editMovement);
        initiative   =(EditText) combatVar.findViewById(R.id.editInitiative);
        attacksListView =(ListView) combatVar.findViewById(R.id.listViewAttacks);
        AttackAdapter attackAdapter = new AttackAdapter(mainActivity.getApplicationContext(),this.attacksList);
        attacksListView.setAdapter(attackAdapter);
        addAttack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.replaceFragment(new AddAttackFragment(mainActivity,parentFragment));
            }
        });
        MakeNotEditable();
        return combatVar;
    }

    @Override
    public void MakeEditable() {
        maxHp.setEnabled(true);
        currentHp.setEnabled(true);
        tempHp.setEnabled(true);
        hitDice.setEnabled(true);
        movement.setEnabled(true);
        initiative.setEnabled(true);
    }

    @Override
    public void MakeNotEditable() {
        maxHp.setEnabled(false);
        currentHp.setEnabled(false);
        tempHp.setEnabled(false);
        hitDice.setEnabled(false);
        movement.setEnabled(false);
        initiative.setEnabled(false);
    }

    public boolean attackExists(String name){
        for(AttackHolder attack:attacksList){
            if(attack.name.equalsIgnoreCase(name))
                return true;

        }
        return false;
    }
    public void setAttackUpdated(String name,String bonus,String damage,String type){
        for(AttackHolder attack:attacksList){
            if(attack.name.equalsIgnoreCase(name)) {
                attack.damage=damage;
                attack.bonus=bonus;
                attack.type=type;
                return;
            }

        }
    }

    public CombatHolder getHolder(){
        return new CombatHolder(
                maxHp.getText().toString(),
                currentHp.getText().toString(),
                tempHp.getText().toString(),
                hitDice.getText().toString(),
                movement.getText().toString(),
                initiative.getText().toString(),
                attacksList
        );
    }
}
