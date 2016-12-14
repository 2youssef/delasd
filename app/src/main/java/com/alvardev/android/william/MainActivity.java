package com.alvardev.android.william;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.alvardev.android.william.rest.ApiClient;
import com.alvardev.android.william.rest.ApiInterface;
import com.alvardev.android.william.rest.MyGame;
import com.alvardev.android.william.rest.MyResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView info;
    private TextView other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        info = (TextView) findViewById(R.id.info);
        other = (TextView) findViewById(R.id.other);
        getJsonFromApi();
        getJsonGame();

    }

    private void getJsonFromApi(){
        ApiInterface apiService = ApiClient.INSTANCE.create(ApiInterface.class);
        Call<MyResponse> callFromAPI = apiService.getJson();
        callFromAPI.enqueue(new Callback<MyResponse>() {
            @Override
            public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                if(response.body() != null){
                    info.setText(response.body().getNome() + " " + response.body().getSobrenome());
                }else{
                    info.setText("erro");
                }
            }

            @Override
            public void onFailure(Call<MyResponse> call, Throwable t) {
                info.setText("erro");
            }
        });
    }

    private void getJsonGame(){
        ApiInterface apiService = ApiClient.INSTANCE.create(ApiInterface.class);
        Call<MyGame> callFromAPI = apiService.getJsonGame();
        callFromAPI.enqueue(new Callback<MyGame>() {
            @Override
            public void onResponse(Call<MyGame> call, Response<MyGame> response) {
                if(response.body() != null){
                    other.setText(response.body().getGame());
                }else{
                    other.setText("erro");
                }
            }

            @Override
            public void onFailure(Call<MyGame> call, Throwable t) {
                other.setText("erro");
            }
        });
    }
}
