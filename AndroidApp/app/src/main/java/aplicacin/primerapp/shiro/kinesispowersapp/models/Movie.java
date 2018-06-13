package aplicacin.primerapp.shiro.kinesispowersapp.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Shiro on 11/01/2018.
 */

public class Movie implements Parcelable {
    private String name;
    private String description;
    private int picture;

    public Movie(String name, String description, int picture){
        this.name= name;
        this.description= description;
        this.picture= picture;
    }

    public String getMovieName(){
        return this.name;
    }

    public String getMovieDescription(){
        return this.description;
    }

    public int getMoviePicture(){
        return this.picture;
    }

    protected Movie(Parcel in) {
        name = in.readString();
        description = in.readString();
        picture = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeInt(picture);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
