package com.Base.dndcharactersheet.ListViewAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.Base.dndcharactersheet.HolderClasses.JournalEntryHolder;
import com.Base.dndcharactersheet.R;

import java.util.List;

public class JournalEntryAdapter  extends BaseAdapter {
    Context context;
    List<JournalEntryHolder> journalEntryList;
    LayoutInflater inflater;

    public JournalEntryAdapter(Context ctx, List<JournalEntryHolder> journalEntryList){
        this.context=ctx;
        this.journalEntryList=journalEntryList;
        inflater=LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return journalEntryList.size();
    }

    @Override
    public Object getItem(int position) {
        return journalEntryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_journal_entry_list_view, null);
        TextView txtView =(TextView) convertView.findViewById(R.id.journalEntryTitle);
        txtView.setText(journalEntryList.get(position).Title);
        return convertView;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}
