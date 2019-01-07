package com.andlausy.githubrepos.search.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andlausy.githubrepos.R;
import com.andlausy.githubrepos.search.data.models.Item;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SearchReposAdapter extends RecyclerView.Adapter<SearchReposAdapter.SearchReposHolder> {

    List<Item> itemList;
    RepoItemClickListener listener;

    @NonNull
    @Override
    public SearchReposHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_search_repos,
                    parent, false);
        return new SearchReposHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchReposHolder holder, int position) {
        Picasso.get().load(itemList.get(position).getOwner().getAvatarUrl()).into(holder.imgAvatar);
        holder.txtName.setText(itemList.get(position).getName());
        holder.txtDesc.setText(String.format(holder.itemView.getContext().getResources().getString(R.string.description_s),
                        itemList.get(position).getDescription()));
        holder.txtForks.setText(String.format(holder.itemView.getContext().getResources().getString(R.string.forks_s),
                    itemList.get(position).getForks().toString()));

        holder.itemView.setOnClickListener(view -> listener.repoClicked(itemList.get(position).getName(),
                    itemList.get(position).getSubscribersUrl()));
    }

    @Override
    public int getItemCount() {
        if (itemList == null)
            return 0;
        else
            return itemList.size();
    }

    public void setItemList(List<Item> itemList, RepoItemClickListener listener) {
        this.itemList = itemList;
        this.listener = listener;
        notifyDataSetChanged();
    }

    public class SearchReposHolder extends RecyclerView.ViewHolder {

        public ImageView imgAvatar;
        public TextView txtName, txtDesc, txtForks;

        public SearchReposHolder(@NonNull View itemView) {
            super(itemView);

            imgAvatar = itemView.findViewById(R.id.adapter_search_repos_img_avatar);
            txtName = itemView.findViewById(R.id.adapter_search_repos_text_name);
            txtDesc = itemView.findViewById(R.id.adapter_search_repos_text_desc);
            txtForks = itemView.findViewById(R.id.adapter_search_repos_text_forks);
        }
    }

    public interface RepoItemClickListener{
        void repoClicked(String repoName, String subscriberURL);
    }
}
