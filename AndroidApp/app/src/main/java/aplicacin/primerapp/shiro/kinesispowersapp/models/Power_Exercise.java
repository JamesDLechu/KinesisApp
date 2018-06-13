package aplicacin.primerapp.shiro.kinesispowersapp.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Shiro on 12/01/2018.
 */

public class Power_Exercise implements Parcelable {
    private String number;
    private String description;

    public Power_Exercise(String number, String description){
        this.number= number;
        this.description= description;
    }

    public String getPowerExerciseNumber(){
        return this.number;
    }

    public String getPowerExerciseDescription(){
        return this.description;
    }

    protected Power_Exercise(Parcel in) {
        number = in.readString();
        description = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(number);
        dest.writeString(description);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Power_Exercise> CREATOR = new Parcelable.Creator<Power_Exercise>() {
        @Override
        public Power_Exercise createFromParcel(Parcel in) {
            return new Power_Exercise(in);
        }

        @Override
        public Power_Exercise[] newArray(int size) {
            return new Power_Exercise[size];
        }
    };
}
