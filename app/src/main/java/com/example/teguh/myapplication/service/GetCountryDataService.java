package com.example.teguh.myapplication.service;

import com.example.teguh.myapplication.model.Info;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetCountryDataService {



        @GET("country/get/all")
        Call<Info> getResult();

}
