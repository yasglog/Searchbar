package com.example.recyclecard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity
{
    RecyclerView rec;
    myadapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        setTitle("Recycler and card view demo");
        rec= (RecyclerView) findViewById(R.id.recview);
        rec.setLayoutManager(new LinearLayoutManager(this));
        adapter =new myadapter(dataqu(),getApplicationContext());
        rec.setAdapter(adapter);
    }
    public ArrayList<Model>dataqu()
    {
        ArrayList<Model>holder=new ArrayList<>();
        Model obj1=new Model();
        obj1.setA(6);
        //obj1.setName("yash");
        holder.add(obj1);

        Model obj2=new Model();
        obj2.setA(5);
       // obj2.setName("ramesh");
        holder.add(obj2);

        Model obj3=new Model();
        obj3.setA(4);
        //obj3.setName("gaikwad");
        holder.add(obj3);

        Model obj4=new Model();
        obj4.setA(3);
        //obj4.setName("kajal");
        holder.add(obj4);

        Model obj5=new Model();
        obj5.setA(2);
        //obj5.setName("savita");
        holder.add(obj5);

        return holder;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu,menu);
        //MenuItem item=(MenuItem)menu.findItem(R.id.search_menu) ;
        MenuItem item=menu.findItem(R.id.search_menu);
        SearchView searchView=(SearchView)item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}