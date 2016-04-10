package com.honeycomb.habitrabbit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter{

    List<c_Habit> habits;
    Context context;

    private static LayoutInflater inflater=null;
    public CustomListAdapter(Home_r2 homeActivity, List<c_Habit> habits) {
        this.habits = habits;
        context=homeActivity;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return habits.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder
    {
        TextView tv;
        TextView tv2;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.homelist, null);
        holder.tv =(TextView) rowView.findViewById(R.id.ltv1);
        holder.tv2 =(TextView) rowView.findViewById(R.id.ltv2);
        holder.img=(ImageView) rowView.findViewById(R.id.limg);
        holder.tv.setText(habits.get(position).name);
        holder.tv2.setText(habits.get(position).metric);
        holder.img.setImageResource(R.drawable.addhabit);
        return rowView;
    }

}