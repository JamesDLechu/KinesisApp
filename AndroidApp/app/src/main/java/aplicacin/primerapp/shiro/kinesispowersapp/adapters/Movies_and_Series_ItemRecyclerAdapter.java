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

import aplicacin.primerapp.shiro.kinesispowersapp.R;
import aplicacin.primerapp.shiro.kinesispowersapp.models.Movie;

/**
 * Created by Shiro on 13/01/2018.
 */

public class Movies_and_Series_ItemRecyclerAdapter
        extends RecyclerView.Adapter<Movies_and_Series_ItemRecyclerAdapter.ViewHolder> {

    private Context context;
    private Movie movie;

    public Movies_and_Series_ItemRecyclerAdapter(Context context, Movie movie){
        this.context= context;
        this.movie= movie;
    }

    @Override
    public Movies_and_Series_ItemRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.movies_and_series_item_adapter, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Movies_and_Series_ItemRecyclerAdapter.ViewHolder holder, int position) {
        Movie movie= this.movie;

        holder.movieDescription.setText(movie.getMovieDescription());
        Glide.with(context)
                .load(ContextCompat.getDrawable(context, movie.getMoviePicture()))
                .into(holder.moviePic);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView moviePic;
        TextView movieDescription;

        public ViewHolder(View itemView) {
            super(itemView);

            moviePic= itemView.findViewById(R.id.imageViewMoviesAndSeries_ItemAdapter);
            movieDescription= itemView.findViewById(R.id.textViewMoviesAndSeries_ItemDescriptionAdapter);
        }
    }
}
