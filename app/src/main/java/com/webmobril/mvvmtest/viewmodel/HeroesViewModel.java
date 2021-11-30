package com.webmobril.mvvmtest.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.webmobril.mvvmtest.model.Hero;
import com.webmobril.mvvmtest.repository.HeroRepository;

import java.util.List;

public class HeroesViewModel extends ViewModel {
    public LiveData<List<Hero>> heroList;
    private HeroRepository heroRepository;

    public HeroesViewModel (){
  heroRepository=HeroRepository.getInstance();
    }

    public LiveData<List<Hero>> getHeroRequestViewModel(){
  return heroRepository.getMutableHeroRepository();
    }
}
