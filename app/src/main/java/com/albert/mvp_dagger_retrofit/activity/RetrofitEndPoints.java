package com.albert.mvp_dagger_retrofit.activity;


import com.albert.mvp_dagger_retrofit.models.Jokes;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitEndPoints {
    @GET("jokes/random/")
    Call<Jokes> getJoke();
}
