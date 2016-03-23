package com.honeycomb.habitrabbit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Home_r2 extends AppCompatActivity {
    public MyApp appData;
    public ListView lsvHabits;
    public List<c_Habit> habits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_r2);

        appData = (MyApp)this.getApplicationContext();

        habits = new ArrayList<>();
        habits = appData._mController.dbsrv.GetAllHabits();

        lsvHabits = (ListView)findViewById(R.id.lsvHabits); // grab listview object from view
        registerForContextMenu(lsvHabits);

        ArrayAdapter lv_adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, habits);
        lsvHabits.setAdapter(lv_adapter);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v.getId() == R.id.lsvHabits) {
            getMenuInflater().inflate(R.menu.delete_menu, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Delete_Context:
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                int index = info.position;
                ViewDetailsForHabit(index);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    public void ViewDetailsForHabit(int index) {
        appData.currentHabit = habits.get(index);
        Intent intent = new Intent(getApplicationContext(), Details_r2.class);
        startActivity(intent);
    }

    public void AddNewHabit(View v) {
        Intent intent = new Intent(getApplicationContext(), Add_r2.class);
        startActivity(intent);
    }

}
