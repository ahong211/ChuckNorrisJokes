package com.albert.mvp_dagger_retrofit;

/**
 * Created by Albert on 7/2/17.
 */

public interface BasePresenter<V extends BaseView> {
    void attachView(V view);

    void detachView();
}
