package com.andlausy.githubrepos;


import android.os.Bundle;

import com.andlausy.githubrepos.base.mvp.view.BaseViewOnlyActivity;

public class MainActivity extends BaseViewOnlyActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
