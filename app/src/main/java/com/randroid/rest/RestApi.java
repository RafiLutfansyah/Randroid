package com.randroid.rest;

import com.randroid.model.Model;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {
    @GET("contohjson")
    Call<Model> getDataAdmin();
}
