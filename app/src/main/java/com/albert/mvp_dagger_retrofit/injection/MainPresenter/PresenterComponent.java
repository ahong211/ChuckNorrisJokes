package com.albert.mvp_dagger_retrofit.injection.MainPresenter;

import com.albert.mvp_dagger_retrofit.activity.MainPresenter;

import dagger.Component;

@Component (modules = PresenterModule.class)
public interface PresenterComponent {
    void inject(MainPresenter mainPresenter);
}
