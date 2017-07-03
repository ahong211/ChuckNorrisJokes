package com.albert.mvp_dagger_retrofit.injection.RetrofitController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;

@Module
public class RetrofitControllerModule {
    @Provides
    Gson provideGsonBuilder() {
        return new GsonBuilder().setLenient().create();
    }
}
