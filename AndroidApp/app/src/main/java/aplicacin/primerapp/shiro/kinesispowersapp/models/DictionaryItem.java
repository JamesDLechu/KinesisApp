package aplicacin.primerapp.shiro.kinesispowersapp.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Shiro on 09/01/2018.
 */

public class DictionaryItem implements Parcelable {
    private String name;
    private String description;

    public DictionaryItem(String name, String description){
        this.name= name;
        this.description= description;
    }

    public String getDiccionaryItemName(){
        return this.name;
    }

    public String getDiccionaryItemDescription(){
        return this.description;
    }

    protected DictionaryItem(Parcel in) {
        name = in.readString();
        description = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<DictionaryItem> CREATOR = new Parcelable.Creator<DictionaryItem>() {
        @Override
        public DictionaryItem createFromParcel(Parcel in) {
            return new DictionaryItem(in);
        }

        @Override
        public DictionaryItem[] newArray(int size) {
            return new DictionaryItem[size];
        }
    };
}
