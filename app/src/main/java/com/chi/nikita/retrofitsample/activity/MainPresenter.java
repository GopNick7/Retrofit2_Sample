package com.chi.nikita.retrofitsample.activity;

import com.chi.nikita.retrofitsample.Presenter;
import com.chi.nikita.retrofitsample.View;

public interface MainPresenter<T extends View> extends Presenter<T> {

    void onAllDataLoaded();
}
