package com.chi.nikita.retrofitsample.data.net;

import com.chi.nikita.retrofitsample.data.model.StreamerResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {

    @GET("bins/2go22")
    Call<StreamerResponse> getStreamer();

}
