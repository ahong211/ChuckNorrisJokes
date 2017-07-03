package com.albert.mvp_dagger_retrofit.activity;

import com.albert.mvp_dagger_retrofit.BasePresenter;
import com.albert.mvp_dagger_retrofit.BaseView;

/**
 * Created by Albert on 7/2/17.
 */

public interface MainContract {
    interface View extends BaseView {
        void showJoke(String joke);
    }

    interface Presenter extends BasePresenter<View> {
        void loadJoke();

        void start();

        void stop();
    }

}
