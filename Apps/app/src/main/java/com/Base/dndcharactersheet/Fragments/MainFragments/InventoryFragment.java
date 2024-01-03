package com.Base.dndcharactersheet.Fragments.MainFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.Base.dndcharactersheet.HolderClasses.InventoryHolder;
import com.Base.dndcharactersheet.MainActivity;
import com.Base.dndcharactersheet.R;

import InterfacesOrAbstracts.FragmentBase;

public class InventoryFragment extends FragmentBase {
    public Button buttonInventory;
    public EditText inventory;
    public InventoryFragment(MainActivity parent){
        super(R.layout.fragment_inventory,parent);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inventoryVar = inflater.inflate(R.layout.fragment_inventory,container,false);

        inventory=(EditText) inventoryVar.findViewById(R.id.editInventory);
        MakeNotEditable();
        return inventoryVar;
    }

    @Override
    public void MakeEditable() {
        inventory.setEnabled(true);
    }

    @Override
    public void MakeNotEditable() {
        inventory.setEnabled(false);
    }

    public InventoryHolder getHolder(){
        return new InventoryHolder(
                inventory.getText().toString()
        );
    }
}