package com.andlausy.githubrepos;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class GithubReposApp extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerApplication::onCreate;
    }
}
