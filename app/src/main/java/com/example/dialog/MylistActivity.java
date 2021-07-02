package com.example.dialog;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MylistActivity extends AppCompatActivity {
    ArrayList<String> data = new ArrayList<>();
    MyListAdapter adapter;
    RecyclerView recyclerView;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mylist);

        init();
    }

    private void init(){
        data.add("사과");
        data.add("바나나");
        data.add("체리");
        data.add("블루베리");

        //recyclerview
        adapter = new MyListAdapter(this, data);
        recyclerView = findViewById(R.id.recyclerlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        et = findViewById(R.id.etFruit);
    }

    public void onAdd(View view) {
        String newFruit = et.getText().toString();
        data.add(newFruit);
        adapter.notifyDataSetChanged();
    }
}