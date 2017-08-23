package com.demo.www.tdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ScanerActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scaner);
        initView();
    }

    private void initView() {
        list = new ArrayList<>();
        list.add("功能0");
        list.add("功能1");
        list.add("功能2");
        recyclerView = (RecyclerView) findViewById(R.id.recycler_con);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        HomeAdapter ad = new HomeAdapter(this,list);
        recyclerView.setAdapter(ad);
    }
}
