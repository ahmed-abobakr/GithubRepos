package com.andlausy.githubrepos.base.mvp.view;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.andlausy.githubrepos.MainActivity;
import com.andlausy.githubrepos.R;
import com.andlausy.githubrepos.base.mvp.view.widget.BlockingLoadingView;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import dagger.android.AndroidInjection;
import dagger.android.support.DaggerAppCompatActivity;

public class BaseViewOnlyActivity extends DaggerAppCompatActivity implements BaseView {

    @Inject
    BlockingLoadingView mBlockLoadingView;



    private List<String> fragments;
    private MaterialDialog createNewRequestSuccessDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        fragments = new ArrayList<>();
    }

    @Override
    public void showBlockLoading() {
        mBlockLoadingView.showBlockLoading();
    }

    @Override
    public void hideBlockLoading() {
        mBlockLoadingView.hideBlockingLoading();
    }

    @Override
    public void showAuthError() {
        Toast.makeText(this, R.string.auth_error_meesage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showNetworkError() {
        Toast.makeText(this, R.string.network_error_message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showUnknownError() {
        Toast.makeText(this, R.string.unknown_error_message, Toast.LENGTH_LONG).show();
    }

    protected void loadFragment(Fragment fragment, int id, String tag){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(id, fragment);
        transaction.addToBackStack(tag);
        if(fragments.size() > 0) {
            for (String str : fragments) {
                if (str.equalsIgnoreCase(tag)) {
                    break;
                } else {
                    if (fragments.indexOf(str) == (fragments.size() - 1))
                        fragments.add(tag);
                }
            }
        }else {
            fragments.add(tag);
        }

        transaction.commit();
    }

    protected void setTitle(String title){
        setTitle(title);
    }

    @Override
    public void onBackPressed() {


        if(getSupportActionBar() != null)
            this.getSupportActionBar().setSubtitle(null);
        if(fragments.size() > 1) {
            fragments.remove((fragments.size() - 1));
            getFragmentManager().popBackStackImmediate(fragments.get((fragments.size() - 1)), 0);
        }else
            super.finish();



    }



}
