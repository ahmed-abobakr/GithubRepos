package com.andlausy.githubrepos.repo_details.views.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andlausy.githubrepos.R;
import com.andlausy.githubrepos.repo_details.data.models.Subscriber;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RepositorySubscriberAdapter extends RecyclerView.Adapter<RepositorySubscriberAdapter.RepositorySubscriberHolder> {

    List<Subscriber> subscribers;

    @NonNull
    @Override
    public RepositorySubscriberHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_repo_subscriber,
                    parent, false);
        return new RepositorySubscriberHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RepositorySubscriberHolder holder, int position) {
        Picasso.get().load(subscribers.get(position).getAvatarUrl()).into(holder.imgAvatar);
        holder.txtName.setText(subscribers.get(position).getLogin());
    }

    @Override
    public int getItemCount() {
        if(subscribers == null)
            return 0;
        else
            return subscribers.size();
    }

    public void setSubscribers(List<Subscriber> subscribers) {
        this.subscribers = subscribers;
        notifyDataSetChanged();
    }

    public class RepositorySubscriberHolder extends RecyclerView.ViewHolder {

        ImageView imgAvatar;
        TextView txtName;

        public RepositorySubscriberHolder(@NonNull View itemView) {
            super(itemView);

            imgAvatar = itemView.findViewById(R.id.adapter_repo_subscriber_img);
            txtName = itemView.findViewById(R.id.adapter_repo_subscriber_txt_name);
        }
    }
}
