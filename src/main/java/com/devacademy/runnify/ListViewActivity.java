package com.devacademy.runnify;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Date;

/**
 * Created by darke on 09.12.2015.
 */
public class ListViewActivity extends Activity {

    private ArrayList<ListData> datas = new ArrayList<ListData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        populateData();
        populateListView();
    }

    public void populateData(){
        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(R.mipmap.ic_round_clock);
        ids.add(R.mipmap.ic_clock);
        ids.add(R.mipmap.ic_normal_face);
        ids.add(R.mipmap.ic_road1);
        Date d = new Date();
        // just for the sake of date.. must replace when I got time ->irony
        datas.add(new ListData(new Date(215, 11, 9),"7.72 km", "8'58", "1:09:18", ids));
        ArrayList<Integer> ids2 = new ArrayList<Integer>();
        ids2.add(R.mipmap.ic_round_clock);
        ids2.add(R.mipmap.ic_clock);
        ids.add(R.mipmap.ic_smile_face);
        ids.add(R.mipmap.ic_road2);
        datas.add(new ListData(new Date(215, 10, 23), "6.34 km", "6'56", "43:57", ids2));
        datas.add(new ListData(new Date(215, 10, 19), "11.81 km", "6'34", "1:17:36", ids2));
        datas.add(new ListData(new Date(215, 10, 16), "5.90 km", "6'12", "36:36", ids2));
    }
    
    public void populateListView(){
        ArrayAdapter<ListData> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.listView);
        list.setAdapter(adapter);
    }


    private class MyListAdapter extends ArrayAdapter<ListData>{

        public MyListAdapter(){

            super(ListViewActivity.this, R.layout.item_view, datas);

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = convertView;
            if (itemView==null){
                itemView = getLayoutInflater().inflate(R.layout.item_view, parent, false);
            }

            ListData currentData = datas.get(position);

            TextView textViewData = (TextView) findViewById(R.id.data);
            textViewData.setText(currentData.getDate().toString());

            TextView textViewKm = (TextView) findViewById(R.id.km);
            textViewKm.setText(currentData.getKm());

            ImageView imageViewSmile = (ImageView) findViewById(R.id.emoji);
            imageViewSmile.setImageResource(currentData.getIconid().get(0));

            ImageView imageViewRoad = (ImageView) findViewById(R.id.road);
            imageViewRoad.setImageResource(currentData.getIconid().get(1));

            ImageView imageViewSun = (ImageView) findViewById(R.id.sun);
            imageViewSun.setImageResource(currentData.getIconid().get(2));

            ImageView imageViewClock = (ImageView) findViewById(R.id.clock);
            imageViewClock.setImageResource(currentData.getIconid().get(3));

            TextView textViewRoundTime = (TextView) findViewById(R.id.textView);
            textViewRoundTime.setText(currentData.getTimeRound());

            ImageView imageViewChronometer = (ImageView) findViewById(R.id.chronometer);
            imageViewChronometer.setImageResource(currentData.getIconid().get(4));

            TextView textViewTotalTime = (TextView) findViewById(R.id.totalTime);
            textViewTotalTime.setText(currentData.getTotalTime());




            return itemView;
        }
    }







}
