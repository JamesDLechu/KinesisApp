package aplicacin.primerapp.shiro.kinesispowersapp;

/**
 * Created by Shiro on 09/01/2018.
 */

public class Contact {
    String name;
    String phone;

    public Contact() {
    }

    public Contact(String name, String phone) {
        this.name= name;
        this.phone= phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
