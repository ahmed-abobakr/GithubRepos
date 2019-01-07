package com.andlausy.githubrepos.main.view.activites;


import android.os.Bundle;

import com.andlausy.githubrepos.R;
import com.andlausy.githubrepos.base.mvp.view.BaseViewOnlyActivity;
import com.andlausy.githubrepos.search.view.fragments.SearchFragment;

public class MainActivity extends BaseViewOnlyActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new SearchFragment(), R.id.frame_container, "search");
    }
}
