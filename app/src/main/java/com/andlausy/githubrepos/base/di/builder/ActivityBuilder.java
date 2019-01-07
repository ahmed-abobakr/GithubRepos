package com.andlausy.githubrepos.base.di.builder;

import com.andlausy.githubrepos.base.mvp.view.BaseViewOnlyActivity;
import com.andlausy.githubrepos.base.mvp.view.di.BaseViewOnlyActivityModule;
import com.andlausy.githubrepos.main.view.di.MainModule;
import com.andlausy.githubrepos.main.view.activites.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    /*@ContributesAndroidInjector(modules = BaseViewOnlyActivityModule.class)
    abstract BaseViewOnlyActivity bindBaseViewOnlyActivity();*/

    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity bindMainActivity();


}
