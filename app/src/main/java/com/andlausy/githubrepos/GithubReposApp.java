package com.andlausy.githubrepos;

import com.andlausy.githubrepos.base.di.component.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class GithubReposApp extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        //return DaggerAppComponent.builder().create(this);
        return DaggerAppComponent.builder().application(this).build();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        DaggerAppComponent.builder().application(this).build()
                .inject(this);
    }
}
