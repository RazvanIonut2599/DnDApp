package com.Base.dndcharactersheet.Fragments.PopupFragments.Combat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.Base.dndcharactersheet.Fragments.MainFragments.CombatFragment;
import com.Base.dndcharactersheet.HolderClasses.Combat.AttackHolder;
import com.Base.dndcharactersheet.ListViewAdapters.AttackAdapter;
import com.Base.dndcharactersheet.MainActivity;
import com.Base.dndcharactersheet.R;

import InterfacesOrAbstracts.FragmentBase;

public class AddAttackFragment extends FragmentBase {
    public CombatFragment parentView;
    public Button buttonDoneAddAttack;
    public EditText editAttackType;
    public EditText editAttackDamage;
    public EditText editAttackBonus;
    public EditText editAttackName;
    private String name;
    private String bonus;
    private String damage;
    private String type;

    public AddAttackFragment(MainActivity parent,CombatFragment combatView){
        super(R.layout.fragment_combat_addattack,parent);
        this.parentView=combatView;
        this.name="";
        this.bonus="";
        this.damage="";
        this.type="";
    }
    public AddAttackFragment(MainActivity parent,CombatFragment combatView,String name,String bonus,String damage,String type){
        super(R.layout.fragment_combat_addattack,parent);
        this.parentView=combatView;
        this.name=name;
        this.bonus=bonus;
        this.damage=damage;
        this.type=type;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View addAttackVar = inflater.inflate(R.layout.fragment_combat_addattack,container,false);
        buttonDoneAddAttack = (Button) addAttackVar.findViewById(R.id.buttonDoneAddAttack);
        editAttackType =(EditText) addAttackVar.findViewById(R.id.editAttackType);
        editAttackDamage=(EditText) addAttackVar.findViewById(R.id.editAttackDamage);
        editAttackBonus=(EditText) addAttackVar.findViewById(R.id.editAttackBonus);
        editAttackName=(EditText) addAttackVar.findViewById(R.id.editAttackName);

        editAttackBonus.setText(bonus);
        editAttackName.setText(name);
        editAttackDamage.setText(damage);
        editAttackType.setText(type);

        buttonDoneAddAttack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=editAttackName.getText().toString();
                String bonus=editAttackBonus.getText().toString();
                String damage=editAttackDamage.getText().toString();
                String type=editAttackType.getText().toString();

                if(!name.isEmpty() && !bonus.isEmpty() && !damage.isEmpty() && !type.isEmpty()){
                    if(parentView.attackExists(name))
                        parentView.setAttackUpdated(name,bonus,damage,type);
                    else
                        parentView.attacksList.add(new AttackHolder(name,bonus,damage,type));

                    ((AttackAdapter)(parentView.attacksListView.getAdapter())).notifyDataSetChanged();
                    mainActivity.replaceFragment(parentView);
                }
            }
        });

        return addAttackVar;
    }

    @Override
    public void MakeEditable() {

    }

    @Override
    public void MakeNotEditable() {

    }
}
