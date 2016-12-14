package com.alvardev.android.william.rest;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL = "https://raw.githubusercontent.com/AlvarDev/HostJson/master/";
    public final static Retrofit INSTANCE = new Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
