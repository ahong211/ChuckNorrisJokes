package com.albert.mvp_dagger_retrofit.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.albert.mvp_dagger_retrofit.R;
import com.albert.mvp_dagger_retrofit.injection.MainActivity.DaggerMainComponent;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG";

    @Inject
    MainContract.Presenter presenter;

    @BindView(R.id.joke_TextView)
    TextView jokeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        DaggerMainComponent.create().inject(this);

        presenter.attachView(this);
        presenter.loadJoke();
    }

    @Override
    public void showError(String error) {
        Log.d(TAG, "showError: ERROR!!");
    }

    @Override
    public void showJoke(String joke) {
        jokeTextView.setText(joke);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @OnClick(R.id.anotherJokeButton)
    void doMagic() {
        presenter.loadJoke();
    }
}
