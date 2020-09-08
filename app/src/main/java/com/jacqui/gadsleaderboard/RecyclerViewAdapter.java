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

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<LearningHours> learningHours = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapter(Context context, ArrayList<LearningHours> learningHours){
        this.learningHours = learningHours;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.learning_layout, parent);
        return new RecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.learnerName.setText(learningHours.get(position).getName());
        holder.learnerScore.setText(learningHours.get(position).getHours());

        Picasso.get().load(learningHours.get(position).getBadgeUrl()).into(holder.learnerBadge);
    }

    @Override
    public int getItemCount() {
        return learningHours.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView learnerBadge;
        private TextView learnerName, learnerScore;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            learnerBadge = (ImageView)itemView.findViewById(R.id.learnerBadge);
            learnerName = (TextView)itemView.findViewById(R.id.learnerName);
            learnerScore = (TextView)itemView.findViewById(R.id.learnerScore);
        }
    }
}
