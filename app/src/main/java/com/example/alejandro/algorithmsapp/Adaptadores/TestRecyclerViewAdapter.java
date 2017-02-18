package com.example.alejandro.algorithmsapp.Adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alejandro.algorithmsapp.Algorithm;
import com.example.alejandro.algorithmsapp.R;

import java.util.List;

/**
 * Created by Administrador on 13/02/17.
 */

public class TestRecyclerViewAdapter extends RecyclerView.Adapter<TestRecyclerViewAdapter.TestRecyclerViewHolder> {

    List<Algorithm> contents;

    public TestRecyclerViewAdapter(List<Algorithm> contents) {
        this.contents = contents;
    }

    public static class TestRecyclerViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView title;
        public TextView description;

        public TestRecyclerViewHolder(View v) {
            super(v);
            image = (ImageView) v.findViewById(R.id.image);
            title = (TextView) v.findViewById(R.id.title);
            description = (TextView) v.findViewById(R.id.description);
        }
    }

    @Override
    public int getItemCount() {
        return contents.size();
    }

    @Override
    public TestRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.algorithm_card_small,parent,false);
        return new TestRecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TestRecyclerViewHolder holder, int position) {
        holder.image.setImageResource(contents.get(position).getImage());
        holder.title.setText(contents.get(position).getTitle());
        holder.description.setText(contents.get(position).getDescription());
    }

}
