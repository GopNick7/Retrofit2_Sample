package com.chi.nikita.retrofitsample.activity;

import android.support.annotation.NonNull;
import android.util.Log;

import com.chi.nikita.retrofitsample.data.model.StreamerResponse;
import com.chi.nikita.retrofitsample.data.net.RetrofitManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenterImpl implements MainPresenter<MainView> {

    private MainView view;

    @Override
    public void bindView(final @NonNull MainView view) {
        this.view = view;
    }

    @Override
    public void unbindView() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onAllDataLoaded() {

        final StringBuilder name = new StringBuilder();

        RetrofitManager.getInstance().getRestApi().getStreamer().enqueue(new Callback<StreamerResponse>() {
            @Override
            public void onResponse(final @NonNull Call<StreamerResponse> call, final @NonNull Response<StreamerResponse> response) {
                if (response.isSuccessful()) {
                    final StreamerResponse streamerResponse = response.body();

                    if (streamerResponse != null) {
                        for (int i = 0; i < streamerResponse.getStreamerModels().size(); i++) {
                            name.append(streamerResponse.getStreamerModels().get(i).getName()).append("\n");

                        }
                    } else {
                        name.append("StreamerResponse is null");
                    }
                }
                view.showData(name);
            }

            @Override
            public void onFailure(final @NonNull Call<StreamerResponse> call, final @NonNull Throwable t) {
                Log.d("TAG", "You catch some error: [" + t + "]");
            }
        });
    }
}
