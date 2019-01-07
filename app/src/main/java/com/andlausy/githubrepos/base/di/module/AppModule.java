package com.andlausy.githubrepos.base.di.module;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.andlausy.githubrepos.GithubReposApp;
import com.andlausy.githubrepos.base.data.BaseCloud;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.android.DaggerApplication;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    private final String BASE_URL = "https://api.github.com";

    @Provides
    @Singleton
    Context provideContext(GithubReposApp application) {
        return application;
    }

    @Provides
    OkHttpClient okHttpClient(Cache cache, HttpLoggingInterceptor httpLoggingInterceptor){
        OkHttpClient.Builder builder = new OkHttpClient.Builder().addInterceptor(chain -> {
            Request request = chain.request();
            Request.Builder requestBuilder = request.newBuilder();
            return chain.proceed(requestBuilder.build());
        }).addInterceptor(httpLoggingInterceptor)
                .cache(cache);
        return builder.build();
    }

    @Provides
    Cache cache(File cacheFile){
        return new Cache(cacheFile, 10 * 100 * 1000);//10MB
    }


    @Provides
    @Singleton
    File file(Context context){
        File file = new File(context.getCacheDir(), "HttpCache");
        file.mkdirs();
        return file;
    }

    @Provides
    HttpLoggingInterceptor httpLoggingInterceptor(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d(OkHttpClient.class.getSimpleName(), message);
            }
        });

        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }



    @Provides
    @Singleton
    BaseCloud baseCloud(Retrofit retrofit){
        return new BaseCloud(retrofit);
    }



    @Provides
    @Singleton
    Retrofit providesRetrofit(OkHttpClient client,
                              GsonConverterFactory factory){
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(factory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    Gson gson(){
        GsonBuilder builder = new GsonBuilder();
        return builder.create();
    }

    @Provides
    GsonConverterFactory gsonConverterFactory(Gson gson){
        return GsonConverterFactory.create(gson);
    }




}
