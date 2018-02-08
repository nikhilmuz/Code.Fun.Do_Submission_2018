package ga.nikhilkumar.smartlib.sampledata;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

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

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("email", email);
        result.put("name", name);
        result.put("pwd", password);
        return result;
    }
}
