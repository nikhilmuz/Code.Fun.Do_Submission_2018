package ga.nikhilkumar.smartlib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import ga.nikhilkumar.smartlib.sampledata.Users;

public class RegisterActivity extends AppCompatActivity {
    EditText name,email,password;
Button login,register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
login=(Button)findViewById(R.id.login);
register=(Button)findViewById(R.id.register);
name=(EditText)findViewById(R.id.name);
email=(EditText)findViewById(R.id.email);
password=(EditText)findViewById(R.id.pwd);
register.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        DatabaseReference mDatabase;
        mDatabase = FirebaseDatabase.getInstance().getReference();
        Users newuser= new Users(String.valueOf(name.getText()),String.valueOf(email.getText()),String.valueOf(password.getText()));
        String key = mDatabase.child("posts").push().getKey();
        Map<String, Object> postValues = newuser.toMap();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/users/" + key, postValues);
        mDatabase.updateChildren(childUpdates);
        Toast.makeText(RegisterActivity.this, "Account Created Successfully", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
});
login.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
});
    }
}
