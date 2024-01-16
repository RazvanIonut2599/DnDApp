package com.Base.dndcharactersheet.ListViewAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.Base.dndcharactersheet.HolderClasses.CharacterHolder;
import com.Base.dndcharactersheet.R;

import java.util.List;

public class CharacterAdapter extends BaseAdapter {
    Context context;
    List<CharacterHolder> characterList;
    LayoutInflater inflater;
    public CharacterAdapter(Context ctx,List<CharacterHolder> characterList){
        this.context=ctx;
        this.characterList=characterList;
        inflater=LayoutInflater.from(ctx);
    }
    @Override
    public int getCount() {
        return characterList.size();
    }

    @Override
    public Object getItem(int position) {
        return characterList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=inflater.inflate(R.layout.listview_character,null);
        TextView txtView =(TextView) convertView.findViewById(R.id.characterName);
        txtView.setText(characterList.get(position).characterName);
        return convertView;
    }
}
