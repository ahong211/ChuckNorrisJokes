package com.albert.mvp_dagger_retrofit.injection.MainPresenter;

import com.albert.mvp_dagger_retrofit.helper.RetrofitController;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {
    @Provides
    RetrofitController provideRetrofitController() {
        return new RetrofitController();
    }
}
