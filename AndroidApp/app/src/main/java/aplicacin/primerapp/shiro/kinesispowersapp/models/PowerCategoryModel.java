package aplicacin.primerapp.shiro.kinesispowersapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Shiro on 06/01/2018.
 */

public class PowerCategoryModel implements Parcelable {
    private String name;
    private ArrayList<PowerModel> powers;
    private int image;

    public PowerCategoryModel(String name, int image, ArrayList<PowerModel> powers) {
        this.name = name;
        this.image = image;
        this.powers= powers;
    }

    public String getPowerCategoryModelName() {
        return name;
    }

    public ArrayList<PowerModel> getPowerCategoryModelListItems(){
        return this.powers;
    }

    public int getPowerCategoryModelImage() {
        return image;
    }

    protected PowerCategoryModel(Parcel in) {
        name = in.readString();
        if (in.readByte() == 0x01) {
            powers = new ArrayList<PowerModel>();
            in.readList(powers, PowerModel.class.getClassLoader());
        } else {
            powers = null;
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
        if (powers == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(powers);
        }
        dest.writeInt(image);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<PowerCategoryModel> CREATOR = new Parcelable.Creator<PowerCategoryModel>() {
        @Override
        public PowerCategoryModel createFromParcel(Parcel in) {
            return new PowerCategoryModel(in);
        }

        @Override
        public PowerCategoryModel[] newArray(int size) {
            return new PowerCategoryModel[size];
        }
    };
}
