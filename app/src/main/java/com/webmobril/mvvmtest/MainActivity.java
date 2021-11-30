package com.webmobril.mvvmtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.webmobril.mvvmtest.adapter.HeroesAdapter;
import com.webmobril.mvvmtest.model.Hero;
import com.webmobril.mvvmtest.viewmodel.HeroesViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    HeroesAdapter adapter;

    List<Hero> heroList;
    HeroesViewModel heroesViewModel=new HeroesViewModel();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //recyclerView.setHasFixedSize(true);
        recyclerView=findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getRecyclerData();
    }

    private void getRecyclerData(){
     heroesViewModel.getHeroRequestViewModel().observe(this, new Observer<List<Hero>>() {
         @Override
         public void onChanged(List<Hero> heroes) {
             adapter = new HeroesAdapter(MainActivity.this, heroList);
             recyclerView.setAdapter(adapter);
         }
     });
    }
}