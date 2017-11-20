package com.chi.nikita.retrofitsample.data.net;

import android.support.annotation.NonNull;

import com.chi.nikita.retrofitsample.BuildConfig;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 14.11.2017.
 */

public class RetrofitManager {

    private static final String TAG = RetrofitManager.class.getSimpleName();

    /**
     * Instance RetrofitManager's
     *
     * @return {@link RetrofitManager}
     */
    public static RetrofitManager getInstance() {
        if (ourInstance == null) {
            ourInstance = new RetrofitManager();
        }
        return ourInstance;
    }

    private static RetrofitManager ourInstance;

    private RetrofitManager() {

    }

    /**
     * @return {@link RestApi} interface with endpoints
     */
    public RestApi getRestApi() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.SERVER_URL)
                .client(initClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(RestApi.class);
    }

    private OkHttpClient initClient() {
        final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .addNetworkInterceptor(interceptor)
                .addNetworkInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(@NonNull final Chain chain) throws IOException {
                        Request request;
                        Request original = chain.request();
                        Request.Builder requestBuilder = original.newBuilder()
                                .addHeader("Content-Type", "application/json");
                        request = requestBuilder.build();
                        return chain.proceed(request);
                    }
                })
                .build();
    }
}
