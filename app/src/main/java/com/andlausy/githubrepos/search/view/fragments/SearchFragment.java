package com.andlausy.githubrepos.search.view.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import com.andlausy.githubrepos.R;
import com.andlausy.githubrepos.base.mvp.view.BaseActivity;
import com.andlausy.githubrepos.base.mvp.view.BaseFragment;
import com.andlausy.githubrepos.base.mvp.view.BaseViewOnlyActivity;
import com.andlausy.githubrepos.base.mvp.view.BaseViewOnlyFragment;
import com.andlausy.githubrepos.repo_details.views.fragments.RepositoryDetailFragment;
import com.andlausy.githubrepos.search.data.models.Item;
import com.andlausy.githubrepos.search.view.adapters.SearchReposAdapter;
import com.andlausy.githubrepos.search.view.presenter.SearchContract;
import com.andlausy.githubrepos.search.view.presenter.SearchPresenterImpl;
import com.andlausy.githubrepos.utils.Constants;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

public class SearchFragment extends BaseFragment<SearchPresenterImpl> implements SearchContract.SearchView,
        SearchReposAdapter.RepoItemClickListener {

    @Inject
    SearchPresenterImpl presenter;
    @Inject
    SearchReposAdapter adapter;

    @BindView(R.id.fragment_search_edit)
    AppCompatEditText editSearch;
    @BindView(R.id.fragment_search_recycler)
    RecyclerView searchRecycler;


    @Override
    protected int getLayout() {
        return R.layout.fragment_search;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        searchRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        searchRecycler.setAdapter(adapter);

    }

    @OnClick(R.id.fragment_search_button)
    public void onSearchClick(View view){
        presenter.search(editSearch.getText().toString());
    }

    @Override
    public SearchPresenterImpl initPresenter() {
        return presenter;
    }

    @Override
    public void showEmptySearchErrorMessage() {
        editSearch.setError(getString(R.string.empty_search_error_message));
    }

    @Override
    public void setSearchData(List<Item> searchData) {
        adapter.setItemList(searchData, this);
    }

    @Override
    public void repoClicked(String repoName, String subscriberURL) {
        RepositoryDetailFragment fragment = new RepositoryDetailFragment();
        Bundle args = new Bundle();
        args.putString(Constants.REPO_NAME, repoName);
        args.putString(Constants.REPO_SUBSCRIBERS_URL, subscriberURL);
        fragment.setArguments(args);
        ((BaseViewOnlyActivity) getActivity()).loadFragment(fragment, R.id.frame_container, "repo_detail");
    }
}
