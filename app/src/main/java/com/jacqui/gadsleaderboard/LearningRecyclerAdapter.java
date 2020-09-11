package com.jacqui.gadsleaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LearningRecyclerAdapter extends RecyclerView.Adapter<LearningRecyclerAdapter.ViewHolder> {

    private  ArrayList<LearningHours> learningHours = new ArrayList<>();
    private Context context;
    private LayoutInflater layoutInflater;

    public LearningRecyclerAdapter(Context context, ArrayList<LearningHours> learningHours){
        this.learningHours = learning                                                                                                                                                           Hours;
        this.context = context;
    }

    @NonNull
    @Override
    public LearningRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new LearningRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LearningRecyclerAdapter.ViewHolder holder, int position) {
        holder.learnerName.setText(learningHours.get(position).getName());
        holder.learnerDetails.setText(learningHours.get(position).getHours() + " " + "learning hours" + ", " +  learningHours.get(position).getCountry());
        Picasso.get().load(learningHours.get(position).getBadgeUrl()).into(holder.learnerBadge);
    }

    @Override
    public int getItemCount() {
        return learningHours.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView learnerBadge;
        private TextView learnerName, learnerDetails;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            learnerBadge = (ImageView)itemView.findViewById(R.id.learnerBadge);
            learnerName = (TextView)itemView.findViewById(R.id.learnerName);
            learnerDetails = (TextView)itemView.findViewById(R.id.learnerDetails);

        }
    }
}
