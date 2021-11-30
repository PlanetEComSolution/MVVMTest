package com.webmobril.mvvmtest.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static String BaseUrl = "https://simplifiedcoding.net/demos/";

    public static String image_url="http://13.234.173.11/bluewren/";
    private static Retrofit retrofit_login=new Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(new OkHttpClient.Builder()
                    .build())
            .build();

    public static RestApiService getLogin(){
        return retrofit_login.create(RestApiService.class);
    }
}
