package com.andlausy.githubrepos.repo_details.views.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.andlausy.githubrepos.R;
import com.andlausy.githubrepos.base.mvp.view.BaseFragment;
import com.andlausy.githubrepos.base.mvp.view.BaseViewOnlyFragment;
import com.andlausy.githubrepos.repo_details.data.models.Subscriber;
import com.andlausy.githubrepos.repo_details.views.adapters.RepositorySubscriberAdapter;
import com.andlausy.githubrepos.repo_details.views.presenters.RepositoryDetailContract;
import com.andlausy.githubrepos.repo_details.views.presenters.RepositoryDetailPresenterImpl;
import com.andlausy.githubrepos.utils.Constants;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class RepositoryDetailFragment extends BaseFragment<RepositoryDetailPresenterImpl>
        implements RepositoryDetailContract.RepositoryDetailView {

    @Inject
    RepositoryDetailPresenterImpl presenter;
    @Inject
    RepositorySubscriberAdapter adapter;

    @BindView(R.id.fragment_repo_detail_txt_name)
    TextView txtName;
    @BindView(R.id.fragment_repo_detail_txt_num_subscribers)
    TextView txtNumOfSubscribers;
    @BindView(R.id.fragment_repo_detail_recycler)
    RecyclerView subscribersRecycler;

    @Override
    protected int getLayout() {
        return R.layout.fragment_repository_detail;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        presenter.start(getArguments().getString(Constants.REPO_NAME), getArguments().getString(Constants.REPO_SUBSCRIBERS_URL));
    }

    @Override
    public RepositoryDetailPresenterImpl initPresenter() {
        return presenter;
    }

    @Override
    public void showRepoName(String name) {
        txtName.setText(name);
    }

    @Override
    public void setSubscribersList(List<Subscriber> subscribersList) {
        txtNumOfSubscribers.setText(String.format(getString(R.string.num_of_subscribers_s),
                    String.valueOf(subscribersList.size())));

        subscribersRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        subscribersRecycler.setAdapter(adapter);
        adapter.setSubscribers(subscribersList);
    }
}
