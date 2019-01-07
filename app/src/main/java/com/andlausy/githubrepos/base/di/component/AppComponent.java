package com.andlausy.githubrepos.base.di.component;

import com.andlausy.githubrepos.GithubReposApp;
import com.andlausy.githubrepos.base.di.builder.ActivityBuilder;
import com.andlausy.githubrepos.base.di.builder.FragmentBuilder;
import com.andlausy.githubrepos.base.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, AppModule.class, ActivityBuilder.class, FragmentBuilder.class})
public interface AppComponent extends AndroidInjector<GithubReposApp>{

    void inject(GithubReposApp app);

    @Component.Builder
    interface Builder  {
        @BindsInstance
        Builder application(GithubReposApp application);

        AppComponent build();
    }
}
