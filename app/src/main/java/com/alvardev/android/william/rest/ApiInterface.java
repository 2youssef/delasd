package com.alvardev.android.william.rest;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("testc.json")
    Call<MyResponse> getJson();

    @GET("game.json")
    Call<MyGame> getJsonGame();

    /** POST example **/
//    @FormUrlEncoded
//    @POST("postJson.json")
//    Call<MyResponsePost> getJsonPost(@Field("parameter") String dni);//parameters
}
