package com.Base.dndcharactersheet;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.Base.dndcharactersheet.HolderClasses.CharacterHolder;
import com.Base.dndcharactersheet.ListViewAdapters.CharacterAdapter;

import java.io.File;
import java.util.ArrayList;

public class CharacterSelectActivity extends AppCompatActivity {
    LayoutInflater inflater;
    public Button addCharacter;
    public ArrayList<CharacterHolder> characterList;
    public ListView characterListView;

    public CharacterSelectActivity(){
        characterList = new ArrayList<CharacterHolder>();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CharacterSelectActivity currentActivity = this;
        setContentView(R.layout.activity_character_select);
        inflater = this.getLayoutInflater();

        addCharacter=(Button)findViewById(R.id.addCharacter);
        addCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(currentActivity, MainActivity.class);
                i.putExtra("CharacterFile","");
                startActivity(i);
            }
        });

        characterListView = (ListView)findViewById(R.id.listViewCharacters);
        characterListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CharacterHolder clickedItem=(CharacterHolder)parent.getItemAtPosition(position);
                if(clickedItem!=null) {
                    Intent i = new Intent(currentActivity, MainActivity.class);
                    i.putExtra("CharacterFile",clickedItem.filename);
                    startActivity(i);
                }
            }
        });
        CharacterAdapter adapter =new CharacterAdapter(this.getApplicationContext(),this.characterList);
        characterListView.setAdapter(adapter);

        File directory = new File(getFilesDir().toString());
        File[] files=directory.listFiles();
        if(files !=null)
            for (int i=0;i<files.length;i++) {
                characterList.add(new CharacterHolder(files[i].getName(),files[i].getName().replace(".txt","")));
            }
    }
}