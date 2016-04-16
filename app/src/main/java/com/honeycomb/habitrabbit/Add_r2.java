package com.honeycomb.habitrabbit;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Add_r2 extends AppCompatActivity {

    public MyApp appData;
    public EditText txtName;
    public EditText txtDesc;
    public EditText txtColour;
    public EditText txtMetric;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_r2);
        appData = (MyApp)this.getApplicationContext();
        txtName = (EditText)findViewById(R.id.txtName);
        txtDesc = (EditText)findViewById(R.id.txtDesc);
        txtColour = (EditText)findViewById(R.id.txtColour);
        txtMetric = (EditText)findViewById(R.id.txtMetric);
    }

    public void SaveHabit(View v) {
        c_Habit h = new c_Habit();
        h.name = txtName.getText().toString();
        h.desc = txtDesc.getText().toString();
        h.colour = txtColour.getText().toString();
        h.metric = txtMetric.getText().toString();
        boolean saved = appData._mController.dbsrv.AddHabit(h);

        if (saved) {
            //if the record was added successfully, then show the main page again - jgunter
            Intent intent = new Intent(getApplicationContext(), Home_r2.class);
            startActivity(intent);
        }
        else {
            AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
            dlgAlert.setMessage("Failure");
            dlgAlert.setTitle("Failed to add habit, please review and try again");
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
