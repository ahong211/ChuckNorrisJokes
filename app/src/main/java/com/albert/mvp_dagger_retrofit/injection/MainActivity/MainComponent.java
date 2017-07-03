package com.albert.mvp_dagger_retrofit.injection.MainActivity;

import com.albert.mvp_dagger_retrofit.activity.MainActivity;

import dagger.Component;

@Component (modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
