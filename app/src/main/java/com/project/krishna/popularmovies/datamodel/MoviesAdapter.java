package com.project.krishna.popularmovies.datamodel;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.project.krishna.popularmovies.R;

import java.util.List;

/**
 * Created by Krishna on 11/13/17.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.PosterViewHolder> {
    List<Movies> moviesList;
    Context context;


    public MoviesAdapter(Context c,List<Movies> movies){
        moviesList=movies;
        context=c;
    }

    @Override
    public PosterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context c=parent.getContext();
        int layout_poster=R.layout.movies_list;
        LayoutInflater layoutInflater=LayoutInflater.from(c);
        View root=layoutInflater.inflate(layout_poster,parent,false);

        return new PosterViewHolder(root);
    }

    @Override
    public void onBindViewHolder(PosterViewHolder holder, int position) {
        String posterURL=moviesList.get(position).getPosterURL();
        Glide.with(context)
                .load(posterURL)
                .into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }


    public  class PosterViewHolder extends RecyclerView.ViewHolder{
        ImageView poster;
        public PosterViewHolder(View itemView) {

            super(itemView);
            poster=(ImageView)itemView.findViewById(R.id.iv_poster);
        }

    }
}