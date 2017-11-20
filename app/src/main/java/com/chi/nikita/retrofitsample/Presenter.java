package com.chi.nikita.retrofitsample;


public interface Presenter<T extends View>{

    void bindView(T view);

    void unbindView();

    void onDestroy();
}
