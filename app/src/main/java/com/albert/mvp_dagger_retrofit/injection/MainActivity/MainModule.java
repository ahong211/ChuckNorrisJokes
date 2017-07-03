package com.albert.mvp_dagger_retrofit.injection.MainActivity;

import com.albert.mvp_dagger_retrofit.activity.MainContract;
import com.albert.mvp_dagger_retrofit.activity.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    @Provides
    MainContract.Presenter providesPresenter() {
        return new MainPresenter();
    }
}
