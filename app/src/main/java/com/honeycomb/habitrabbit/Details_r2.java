package com.honeycomb.habitrabbit;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

public class Details_r2 extends AppCompatActivity {

    public MyApp appData;
    public LineChart lineChart;
    public c_Habit h;
    public NumberPicker np;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_r2);

        appData = (MyApp)this.getApplicationContext();
        lineChart = (LineChart)findViewById(R.id.chart1);
        h = appData.currentHabit;
        TextView tvDesc = (TextView)findViewById(R.id.tvDesc);
        tvDesc.setText(h.desc);
        List<Integer> metrics = appData._mController.dbsrv.GetMetrics(h.name);
        // data point entries for last 6 metrics
        ArrayList<Entry> entries = new ArrayList<>();
        ArrayList<String> labels = new ArrayList<>();
        int counter = 0;
        for(int i : metrics) {
            entries.add(new Entry((float)i,counter));
            labels.add("W" + counter);
            counter++;
        }
        LineDataSet dataset = new LineDataSet(entries, h.metric);
        dataset.setDrawFilled(true);

        //line data
        LineData data = new LineData(labels, dataset);
        lineChart.setData(data);
        lineChart.setDescription("Metric Tracking");
        lineChart.animateY(3000);


        np = (NumberPicker)findViewById(R.id.np);
        np.setMinValue(0);
        np.setMaxValue(100);
        np.setWrapSelectorWheel(false);
    }

    public void AddMetric(View v) {
        int metric = np.getValue();
        boolean saved = appData._mController.dbsrv.AddMetric(h.name, metric);
        if (saved) {
            recreate(); //reload this page dude! - jgunter
        } else {
            AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
            dlgAlert.setMessage("Failure");
            dlgAlert.setTitle("Failed to add metric, please review and try again");
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
}
