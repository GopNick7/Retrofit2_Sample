package com.chi.nikita.retrofitsample.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StreamerResponse {

    @SerializedName("time")
    @Expose
    private Double time;
    @SerializedName("streamers")
    @Expose
    private List<StreamerModel> streamerModels = null;

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public List<StreamerModel> getStreamerModels() {
        return streamerModels;
    }

    public void setStreamerModels(List<StreamerModel> streamerModels) {
        this.streamerModels = streamerModels;
    }
}