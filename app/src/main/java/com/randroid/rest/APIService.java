package com.randroid.rest;

import com.randroid.model.Post;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {

    @FormUrlEncoded
    @POST("/Insert")
    Call<Post> savePost(@Field("username") String username,
                        @Field("password") String password);
}
