package com.albert.mvp_dagger_retrofit.activity;

import com.albert.mvp_dagger_retrofit.helper.RetrofitController;
import com.albert.mvp_dagger_retrofit.injection.MainPresenter.DaggerPresenterComponent;
import com.albert.mvp_dagger_retrofit.models.JokeEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;


public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;
    private String jokeData;

    @Inject
    RetrofitController controller;

    public MainPresenter() {
        DaggerPresenterComponent.create().inject(this);
    }


    @Override
    public void attachView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void loadJoke() {
        controller.start();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void jokeEventHandler(JokeEvent event) {
        jokeData = event.getJokeString();
        this.view.showJoke(jokeData);
    }


    public void start() {
        EventBus.getDefault().register(this);
    }

    public void stop() {
        EventBus.getDefault().unregister(this);
    }

}
