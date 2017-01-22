package com.randroid.rest;

public class BaseURL {

    public BaseURL() {}

    public static final String BaseURL = "http://rafilut.com/";

    public static APIService getBaseURL() {

        return RetrofitClient.getClient(BaseURL).create(APIService.class);
    }
}