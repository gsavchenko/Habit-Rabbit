package com.honeycomb.habitrabbit;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.awt.font.TextAttribute;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CustomListAdapter extends BaseAdapter {

    List<c_Habit> habits;
    Context context;
    MyApp appData;

    private static LayoutInflater inflater = null;

    public CustomListAdapter(Home_r2 homeActivity, List<c_Habit> habits) {
        this.habits = habits;
        context = homeActivity;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        appData = (MyApp) context.getApplicationContext();
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

    public class Holder {
        TextView tv;
        TextView tv2;
        ImageView img;
        ImageView editImg;
        Button btn1;
        Button btn2;
        Button btn3;
        Button btn4;
        Button btn5;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.homelist, null);
        //find holder objects
        holder.tv = (TextView) rowView.findViewById(R.id.ltv1);
        holder.tv2 = (TextView) rowView.findViewById(R.id.ltv2);
        holder.img = (ImageView) rowView.findViewById(R.id.limg);
        holder.editImg = (ImageView) rowView.findViewById(R.id.limg2);
        holder.btn1 = (Button) rowView.findViewById(R.id.btn1);
        holder.btn2 = (Button) rowView.findViewById(R.id.btn2);
        holder.btn3 = (Button) rowView.findViewById(R.id.btn3);
        holder.btn4 = (Button) rowView.findViewById(R.id.btn4);
        holder.btn5 = (Button) rowView.findViewById(R.id.btn5);

        //set holder objects
        holder.tv.setText(habits.get(position).name);
        holder.tv2.setText(habits.get(position).metric);
        holder.img.setImageResource(getDisplayPicture(holder.tv.getText().toString()));
        holder.editImg.setImageResource(R.drawable.edit);
        Calendar c = Calendar.getInstance();
        c.get(Calendar.DAY_OF_MONTH);
        holder.btn1.setText(getCalculatedDate("dd", -2));
        holder.btn2.setText(getCalculatedDate("dd", -1));
        holder.btn3.setText(getCalculatedDate("dd", 0));
        holder.btn4.setText(getCalculatedDate("dd", 1));
        holder.btn5.setText(getCalculatedDate("dd", 2));

        holder.editImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appData.currentHabit = habits.get(position);
                Intent intent = new Intent(context, EditHabit_r2.class);
                context.startActivity(intent);
            }
        });

        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appData.currentHabit = habits.get(position);
                Intent intent = new Intent(context, Details_r2.class);
                context.startActivity(intent);
            }
        });

        holder.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getTextAlignment() == View.TEXT_ALIGNMENT_GRAVITY) {
                    v.getBackground().setColorFilter(Color.parseColor("#00ff00"), PorterDuff.Mode.DARKEN);
                    v.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                } else if (v.getTextAlignment() == View.TEXT_ALIGNMENT_CENTER) {
                    v.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                    v.getBackground().setColorFilter(Color.parseColor("#ff0000"), PorterDuff.Mode.DARKEN);
                } else {
                    v.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
                    v.getBackground().setColorFilter(Color.parseColor("#f3f3f3"), PorterDuff.Mode.DARKEN);
                }
            }
        });

        holder.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getTextAlignment() == View.TEXT_ALIGNMENT_GRAVITY) {
                    v.getBackground().setColorFilter(Color.parseColor("#00ff00"), PorterDuff.Mode.DARKEN);
                    v.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                } else if (v.getTextAlignment() == View.TEXT_ALIGNMENT_CENTER) {
                    v.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                    v.getBackground().setColorFilter(Color.parseColor("#ff0000"), PorterDuff.Mode.DARKEN);
                } else {
                    v.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
                    v.getBackground().setColorFilter(Color.parseColor("#f3f3f3"), PorterDuff.Mode.DARKEN);
                }
            }
        });

        holder.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getTextAlignment() == View.TEXT_ALIGNMENT_GRAVITY) {
                    v.getBackground().setColorFilter(Color.parseColor("#00ff00"), PorterDuff.Mode.DARKEN);
                    v.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                } else if (v.getTextAlignment() == View.TEXT_ALIGNMENT_CENTER) {
                    v.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                    v.getBackground().setColorFilter(Color.parseColor("#ff0000"), PorterDuff.Mode.DARKEN);
                } else {
                    v.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
                    v.getBackground().setColorFilter(Color.parseColor("#f3f3f3"), PorterDuff.Mode.DARKEN);
                }
            }
        });

        holder.btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getTextAlignment() == View.TEXT_ALIGNMENT_GRAVITY) {
                    v.getBackground().setColorFilter(Color.parseColor("#00ff00"), PorterDuff.Mode.DARKEN);
                    v.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                } else if (v.getTextAlignment() == View.TEXT_ALIGNMENT_CENTER) {
                    v.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                    v.getBackground().setColorFilter(Color.parseColor("#ff0000"), PorterDuff.Mode.DARKEN);
                } else {
                    v.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
                    v.getBackground().setColorFilter(Color.parseColor("#f3f3f3"), PorterDuff.Mode.DARKEN);
                }
            }
        });

        holder.btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getTextAlignment() == View.TEXT_ALIGNMENT_GRAVITY) {
                    v.getBackground().setColorFilter(Color.parseColor("#00ff00"), PorterDuff.Mode.DARKEN);
                    v.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                } else if (v.getTextAlignment() == View.TEXT_ALIGNMENT_CENTER) {
                    v.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                    v.getBackground().setColorFilter(Color.parseColor("#ff0000"), PorterDuff.Mode.DARKEN);
                } else {
                    v.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
                    v.getBackground().setColorFilter(Color.parseColor("#f3f3f3"), PorterDuff.Mode.DARKEN);
                }
            }
        });
        return rowView;
    }

    public static String getCalculatedDate(String dateFormat, int days) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat s = new SimpleDateFormat(dateFormat);
        cal.add(Calendar.DAY_OF_YEAR, days);
        return s.format(new Date(cal.getTimeInMillis()));
    }

    public int getDisplayPicture(String habitName) {
        int returnVal = R.drawable.other;
        if (habitName.toLowerCase().contains("smok") || habitName.toLowerCase().contains("cig")) {
            returnVal = R.drawable.smoker;
        } else if (habitName.toLowerCase().contains("drink") || habitName.toLowerCase().contains("alcoh")) {
            returnVal = R.drawable.drinking;
        } else if (habitName.toLowerCase().contains("eat") || habitName.toLowerCase().contains("health")) {
            returnVal = R.drawable.health;
        }
        return returnVal;
    }
}