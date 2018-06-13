package aplicacin.primerapp.shiro.kinesispowersapp.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import aplicacin.primerapp.shiro.kinesispowersapp.R;
import aplicacin.primerapp.shiro.kinesispowersapp.models.Movie;

/**
 * Created by Shiro on 11/01/2018.
 */

public class MoviesRecyclerAdapter extends RecyclerView.Adapter<MoviesRecyclerAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Movie> moviesList;
    private OnMovieClickListener onMovieClickListener;

    public interface OnMovieClickListener{
        void onMovieClick(Movie movie);
    }

    public void setOnMovieClickListener(OnMovieClickListener onMovieClickListener){
        this.onMovieClickListener= onMovieClickListener;
    }

    public MoviesRecyclerAdapter(Context context, ArrayList<Movie> moviesList){
        this.context= context;
        this.moviesList= moviesList;
    }

    @Override
    public MoviesRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.movies_list_adapter, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MoviesRecyclerAdapter.ViewHolder holder, int position) {
        final Movie movie= moviesList.get(position);

        holder.movieName.setText(movie.getMovieName());
        Glide.with(context)
                .load(ContextCompat.getDrawable(context, movie.getMoviePicture()))
                .into(holder.moviePicture);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onMovieClickListener.onMovieClick(movie);
            }
        });
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView movieName;
        ImageView moviePicture;

        public ViewHolder(View itemView) {
            super(itemView);

            movieName= itemView.findViewById(R.id.textViewMoviesAndSeriesAdapter);
            moviePicture= itemView.findViewById(R.id.imageViewMoviesAndSeriesAdapter);
        }
    }
}
