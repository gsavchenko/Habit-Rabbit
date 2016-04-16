package com.honeycomb.habitrabbit;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditHabit_r2 extends AppCompatActivity {

    private MyApp appData;
    private c_Habit currentHabit;

    private EditText h_name;
    private EditText h_desc;
    private EditText h_colour;
    private EditText h_metric;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_habit_r2);

        this.appData = (MyApp) this.getApplicationContext();
        this.currentHabit = this.appData.currentHabit;

        this.h_name = (EditText) findViewById(R.id.txtNameE);
        this.h_desc = (EditText) findViewById(R.id.txtDescE);
        this.h_colour = (EditText) findViewById(R.id.txtColourE);
        this.h_metric = (EditText) findViewById(R.id.txtMetricE);

        this.h_name.setText(this.currentHabit.name);
        this.h_desc.setText(this.currentHabit.desc);
        this.h_colour.setText(this.currentHabit.colour);
        this.h_metric.setText(this.currentHabit.metric);
    }

    public void UpdateHabit(View v) {
        String name = this.h_name.getText().toString();
        String desc = this.h_desc.getText().toString();
        String colour = this.h_colour.getText().toString();
        String metric = this.h_metric.getText().toString();
        c_Habit newHabit = new c_Habit(name, desc, colour, metric);
        boolean updated = appData._mController.dbsrv.UpdateHabit(this.currentHabit, newHabit);
        if (updated) {
            Intent intent = new Intent(getApplicationContext(), Home_r2.class);
            startActivity(intent);
        } else {
            AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
            dlgAlert.setMessage("Failure");
            dlgAlert.setTitle("Failed to update habit, please review and try again");
            dlgAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            dlgAlert.setCancelable(false);
            dlgAlert.create().show();
        }
    }

    public void ShowSettings(View v) {
        Intent intent = new Intent(getApplicationContext(), Settings_r2.class);
        startActivity(intent);
    }

    public void AddNewHabit(View v) {
        Intent intent = new Intent(getApplicationContext(), Add_r2.class);
        startActivity(intent);
    }
}