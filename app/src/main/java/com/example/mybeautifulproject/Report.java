package com.example.mybeautifulproject;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import javax.annotation.Nullable;

public class Report extends ListActivity {
    private ListView listView;
    private ArrayList<String> money = new ArrayList<>();
//    @Override
//    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
//        Log.d("tag 2", "on create");
//        super.onCreate(savedInstanceState, persistentState);
//        setContentView(R.layout.activity_report);
//
//    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("tag 2", "ghabl as list");
        listView = getListView();
        Log.d("tag 3", "bad as list");
        Toast.makeText(Report.this, "salam 2", Toast.LENGTH_LONG).show();
        viewList();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(Report.this, MainActivity.transactionBox.get() , Toast.LENGTH_LONG).show();
            }
        });

    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.d("tag 2", "ghabl as list");
//        listView = getListView();
//        Log.d("tag 3", "bad as list");
//        Toast.makeText(Report.this, "salam 2", Toast.LENGTH_LONG).show();
//        viewList();
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                //Toast.makeText(Report.this, MainActivity.transactionBox.get() , Toast.LENGTH_LONG).show();
//            }
//        });
//    }

    public void viewList(){
        for (Transaction t : MainActivity.transactionBox.getAll()){
            money.add(t.getMoney());
        }
        //Toast.makeText(Report.this, ((int) MainActivity.transactionBox.count()), Toast.LENGTH_LONG).show();
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, money));
    }
}
