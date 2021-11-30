package com.webmobril.mvvmtest.network;


import com.webmobril.mvvmtest.model.Hero;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApiService {

    @GET("marvel")
    Call<List<Hero>> getHeroes();

}
