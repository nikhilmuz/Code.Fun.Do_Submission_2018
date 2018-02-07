package ga.nikhilkumar.smartlib.sampledata;

/**
 * Created by Dell on 2/7/2018.
 */

public class Users {
        public String email;
        public String name;
        public String password;

        public Users(){}

        public Users(String name, String email,String password) {
            this.email=email;
            this.name=name;
            this.password=password;
        }
}
