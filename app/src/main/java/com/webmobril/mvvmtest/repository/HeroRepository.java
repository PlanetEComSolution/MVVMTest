package com.webmobril.mvvmtest.repository;

import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.webmobril.mvvmtest.model.Hero;
import com.webmobril.mvvmtest.network.ApiClient;
import com.webmobril.mvvmtest.network.RestApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HeroRepository {

    private static HeroRepository heroRepository;
    private static RestApiService apiService;

    private HeroRepository() {
        apiService = ApiClient.getLogin();
    }

    public static HeroRepository getInstance() {
        if (heroRepository == null) {
            heroRepository = new HeroRepository();
        }
        return heroRepository;
    }

    public LiveData<List<Hero>> getMutableHeroRepository() {
        final MutableLiveData<List<Hero>> heroResponseMutableData = new MutableLiveData<>();
        Call<List<Hero>> call = apiService.getHeroes();
        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                if (response.isSuccessful()) {
                    heroResponseMutableData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                //Toast.makeText()
            }
        });
return heroResponseMutableData;
    }

}
