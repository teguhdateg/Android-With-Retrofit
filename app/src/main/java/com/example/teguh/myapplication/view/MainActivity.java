package com.example.teguh.myapplication.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.teguh.myapplication.R;
import com.example.teguh.myapplication.model.Info;
import com.example.teguh.myapplication.model.Result;
import com.example.teguh.myapplication.service.GetCountryDataService;
import com.example.teguh.myapplication.service.RetrofitInstance;

import java.lang.reflect.Array;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Result> results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getCountries();
    }

    public Object getCountries() {

        GetCountryDataService getCountryDataService=RetrofitInstance.getService();
        Call<Info> call=getCountryDataService.getResult();

        call.enqueue(new Callback<Info>() {
            @Override
            public void onResponse(Call<Info> call, Response<Info> response) {
                Info info=response.body();

                if(info !=null && info.getRestResponse() != null){

                    results=(ArrayList<Result>) info.getRestResponse().getResult();

                    for(Result r:results){
                        Log.i("testing123","****************************"+  r.getName());
                    }
                }

            }

            @Override
            public void onFailure(Call<Info> call, Throwable t) {

            }
        });

        return results;
    }


}
