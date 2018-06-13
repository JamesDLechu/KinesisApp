package aplicacin.primerapp.shiro.kinesispowersapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shiro on 07/01/2018.
 */

public class PowerModel implements Parcelable {
    private String name;
    private String definition;
    private ArrayList<Power_Exercise> exercises;
    private int image;

    public PowerModel(String name, String definition, ArrayList<Power_Exercise> exercises, int image) {
        this.name = name;
        this.definition = definition;
        this.exercises = exercises;
        this.image = image;
    }

    public String getPowerModelName() {
        return name;
    }

    public String getPowerModelDefinition() {
        return definition;
    }

    public ArrayList<Power_Exercise> getPowerModelExercises() {
        return exercises;
    }

    public int getPowerModelImage() {
        return image;
    }

    protected PowerModel(Parcel in) {
        name = in.readString();
        definition = in.readString();
        if (in.readByte() == 0x01) {
            exercises = new ArrayList<Power_Exercise>();
            in.readList(exercises, Power_Exercise.class.getClassLoader());
        } else {
            exercises = null;
        }
        image = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(definition);
        if (exercises == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(exercises);
        }
        dest.writeInt(image);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<PowerModel> CREATOR = new Parcelable.Creator<PowerModel>() {
        @Override
        public PowerModel createFromParcel(Parcel in) {
            return new PowerModel(in);
        }

        @Override
        public PowerModel[] newArray(int size) {
            return new PowerModel[size];
        }
    };
}
