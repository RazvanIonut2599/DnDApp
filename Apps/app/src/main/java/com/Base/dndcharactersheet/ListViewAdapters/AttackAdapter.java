package com.Base.dndcharactersheet.ListViewAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.Base.dndcharactersheet.HolderClasses.AttackHolder;
import com.Base.dndcharactersheet.R;

import java.util.List;

public class AttackAdapter extends BaseAdapter {
    Context context;
    List<AttackHolder> attacksList;
    LayoutInflater inflater;
    public AttackAdapter(Context ctx,List<AttackHolder> attacksList){
        this.context=ctx;
        this.attacksList=attacksList;
        inflater=LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return attacksList.size();
    }

    @Override
    public Object getItem(int position) {
        return attacksList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_attack_list_view, null);
        TextView txtView =(TextView) convertView.findViewById(R.id.attackName);
        txtView.setText(attacksList.get(position).name);
        TextView txt2View =(TextView) convertView.findViewById(R.id.attackBonus);
        txt2View.setText(attacksList.get(position).bonus);
        TextView txt3View =(TextView) convertView.findViewById(R.id.attackDamage);
        txt3View.setText(attacksList.get(position).damage);
        TextView txt4View =(TextView) convertView.findViewById(R.id.attackDamageType);
        txt4View.setText(attacksList.get(position).type);
        return convertView;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}
