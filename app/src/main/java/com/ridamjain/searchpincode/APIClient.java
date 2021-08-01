package com.ridamjain.searchpincode;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIClient {
    @GET("pincode/{PINCODE}")
    Call<List<postData>> getData(@Path("PINCODE") int post);
}
