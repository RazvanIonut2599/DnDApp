package com.Base.dndcharactersheet.ListViewAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.Base.dndcharactersheet.HolderClasses.Spells.SpellInfoHolder;
import com.Base.dndcharactersheet.R;

import java.util.List;

public class SpellAdapter extends BaseAdapter {
    Context context;
    List<SpellInfoHolder> spellList;
    LayoutInflater inflater;

    public SpellAdapter(Context ctx,List<SpellInfoHolder> spells){
        this.context=ctx;
        this.spellList=spells;
        inflater=LayoutInflater.from(ctx);

    }

    @Override
    public int getCount() {
        return spellList.size();
    }

    @Override
    public Object getItem(int position) {
        return spellList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.listview_spell,null);
        TextView txtView =(TextView) convertView.findViewById(R.id.spellTitle);
        txtView.setText(spellList.get(position).title);

        TextView txt2View =(TextView) convertView.findViewById(R.id.spellsubTitle);
        txt2View.setText(spellList.get(position).subtitle);

        return convertView;
    }
    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}
