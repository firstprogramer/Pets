package com.example.pets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Choose_category extends AppCompatActivity {
    private HashMap<String,List<String>> listHash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_category);



        ArrayList<String> header_List = new ArrayList<String>();
        listHash = new HashMap<>();

        header_List.add("Health");
        header_List.add("Education");
        header_List.add("Police");
        header_List.add("Environment");

        List<String> Health = new ArrayList<String>();
        Health.add("Birth certivicate");
        Health.add("elak ala eldowla");
        Health.add("ay haga");

        List<String> Education = new ArrayList<String>();
        Education.add("education one");
        Education.add("elak ala eldowla");
        Education.add("education 3");

        List<String> police = new ArrayList<String>();
        police.add("police one");
        police.add("police two");
        police.add("police three");

        List<String> Environment = new ArrayList<String>();
        Environment.add("Environment one");
        Environment.add("Environment two");
        Environment.add("Environment three");

        listHash.put(header_List.get(0),Health);
        listHash.put(header_List.get(1),Education);
        listHash.put(header_List.get(2),police);
        listHash.put(header_List.get(3),Environment);

        ExpandableListView listView = findViewById(R.id.exView);
        Expand_Adapter listAdapter = new Expand_Adapter(this,header_List,listHash);
        listView.setAdapter(listAdapter);



       /* RecyclerView recyclerView = findViewById(R.id.category_recycler);
        // next 2 lines not use in case listView
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        ArrayList<Category_class> category_List = new ArrayList<Category_class>();

        category_List.add(new Category_class("Health"));
        category_List.add(new Category_class("Police"));
        category_List.add(new Category_class("Education"));
        category_List.add(new Category_class("Environment"));
        category_List.add(new Category_class("Finance"));
        category_List.add(new Category_class("Tourism"));

        CategoryAdapter categoryAdapter = new CategoryAdapter(this,category_List);
        recyclerView.setAdapter(categoryAdapter);*/

    }
}
