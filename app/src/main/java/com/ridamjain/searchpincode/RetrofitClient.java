package com.ridamjain.searchpincode;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;
    private static String BASEURL = "https://api.postalpincode.in/";
    public static Retrofit getRetrofitInstance()
    {
        if(retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

}
