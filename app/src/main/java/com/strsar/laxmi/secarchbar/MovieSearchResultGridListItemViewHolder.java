package com.strsar.laxmi.secarchbar;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Movie;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.strsar.laxmi.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieSearchResultGridListItemViewHolder extends RecyclerView.ViewHolder {
    private final static double posterRatio = 1.3825;
    final View view;
    private Movie movie;
    private int moviePosition = -1;
    private ColorDrawable placeHolderColorDrawable;

    @BindView(R.id.movie_poster)
    ImageView moviePoster;
    @BindView(R.id.movie_title_label)
    TextView movieNameLabel;


    Movie getMovie() {
        return movie;
    }

    void setMovie(Movie movie, Context context) {
        this.movie = movie;
        movieNameLabel.setText(movie.getTitle());
        if (movie.getColorMeta() != null && movie.getColorMeta().getPosterBest() != null && movie.getColorMeta().getPosterBest().size() > 0) {
            String hexColor = String.format("#%06X", (0xFFFFFF & movie.getColorMeta().getPosterBest().get(0)));
            placeHolderColorDrawable.setColor(Color.parseColor(hexColor));
            Picasso.with(context).load(movie.getPoster().getUrl2x()).placeholder(placeHolderColorDrawable).into(moviePoster);
        } else {
            Picasso.with(context).load(movie.getPoster().getUrl2x()).into(moviePoster);
        }

        public int getMoviePosition () {
            return moviePosition;
        }

        public void setMoviePosition ( int moviePosition){
            this.moviePosition = moviePosition;
        }

        MovieSearchResultGridListItemViewHolder(View view) {
            super(view);
            this.view = view;
            ButterKnife.bind(this, view);

            placeHolderColorDrawable = new ColorDrawable();
            int imageWidth = (CinemanApplication.getCurrentAppInstance().getScreenWidth() - ((int) view.getResources().getDimension(R.dimen.grid_list_item_spacing) * (MovieGridListFragment.GRID_COLUMN_COUNT + 1))) / MovieGridListFragment.GRID_COLUMN_COUNT;
            int desiredHeight = (int) (imageWidth * posterRatio);
            if (moviePoster.getLayoutParams().height != desiredHeight) {
                moviePoster.getLayoutParams().height = desiredHeight;
                moviePoster.requestLayout();
            }
        }

        @Override
        public String toString () {
            return super.toString() + " '" + movieNameLabel.getText() + "'";
        }
    }
}