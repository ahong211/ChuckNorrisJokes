package com.albert.mvp_dagger_retrofit.helper;


import android.util.Log;

import com.albert.mvp_dagger_retrofit.activity.RetrofitEndPoints;
import com.albert.mvp_dagger_retrofit.injection.RetrofitController.DaggerRetrofitControllerComponent;
import com.albert.mvp_dagger_retrofit.models.JokeEvent;
import com.albert.mvp_dagger_retrofit.models.Jokes;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitController implements Callback<Jokes>{

    public static final String BASE_URL = "http://api.icndb.com/";
    public static final String TAG = RetrofitController.class.getSimpleName() + "_TAG";

    @Inject
    Gson gson;

    public RetrofitController() {

    }

    public void start() {
        DaggerRetrofitControllerComponent.create().inject(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RetrofitEndPoints endPoints = retrofit.create(RetrofitEndPoints.class);
        Call<Jokes> call = endPoints.getJoke();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<Jokes> call, Response<Jokes> response) {
        EventBus.getDefault().post(new JokeEvent(response.body().getValue().getJoke()));
    }

    @Override
    public void onFailure(Call<Jokes> call, Throwable t) {
        Log.d(TAG, "onFailure: FAILURE");
    }
}
