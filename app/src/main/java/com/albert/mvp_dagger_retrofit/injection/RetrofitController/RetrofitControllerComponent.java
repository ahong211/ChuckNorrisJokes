package com.albert.mvp_dagger_retrofit.injection.RetrofitController;

import com.albert.mvp_dagger_retrofit.helper.RetrofitController;

import dagger.Component;

@Component (modules = RetrofitControllerModule.class)
public interface RetrofitControllerComponent {
    void inject(RetrofitController retrofitController);
}
