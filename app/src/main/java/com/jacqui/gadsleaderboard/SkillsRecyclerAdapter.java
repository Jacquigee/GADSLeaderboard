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

class SkillsRecyclerAdapter extends RecyclerView.Adapter<SkillsRecyclerAdapter.ViewHolder> {

    private  ArrayList<SkillIQ> skillIq= new ArrayList<>();
    private Context context;
    private LayoutInflater layoutInflater;

    public SkillsRecyclerAdapter(Context context, ArrayList<SkillIQ> skillsIq){
        this.skillIq = skillIq;
        this.context = context;
    }

    @NonNull
    @Override
    public SkillsRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent);
        return new SkillsRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillsRecyclerAdapter.ViewHolder holder, int position) {
        holder.learnerName.setText(skillIq.get(position).getName());
        holder.learnerDetails.setText(skillIq.get(position).getScore() + "learning hours" + skillIq.get(position).getCountry());
        Picasso.get().load(skillIq.get(position).getBadgeUrl()).into(holder.learnerBadge);
    }

    @Override
    public int getItemCount() {
        return skillIq.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
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
