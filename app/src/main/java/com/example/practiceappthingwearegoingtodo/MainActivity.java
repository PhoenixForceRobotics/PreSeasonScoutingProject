package com.example.practiceappthingwearegoingtodo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText password;
    Spinner users;
    String user;
    String enteredPass;
    Button submit;
    Boolean validated;
    private List<String> usernames = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        usernames.add("Gabriel");
        usernames.add("Noam");
        usernames.add("Syed");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Context context = this;

        users = findViewById(R.id.users_spinner);
        password = findViewById(R.id.editText);
        submit = findViewById(R.id.Submit);


        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                validateUser();

            }

        });
        usernames =
        usernames.add(0,"Select user");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, usernames);
        //set the spinners adapter to the previously created one.
        users.setAdapter(adapter);

    }
    public void validateUser () {
        AdvisoryDataBase ADB = AdvisoryDataBase.getDatabase(this);
        List<String> passwords = ADB.loginDao().getPassWords();
        List<String> usernames = ADB.loginDao().getUsernames();


        enteredPass = password.getText().toString();
        user = users.getSelectedItem().toString();
        //navigates either way also fix for
        Log.d("passwords:", passwords.get(0));
        Log.d("Username", usernames.get(0));
        Log.d("EnteredUsername", user);
        Log.d("EnteredPass", enteredPass);
        //find entered user in database dont need to check if exists then

        int l = usernames.size();

        List<Login> correctPass = new ArrayList<>();
        correctPass = ADB.loginDao().findUser(user);
        String whyAndrew = String.valueOf(correctPass.get(0).getPassWord());
        Log.d("Why Andrew", whyAndrew);
        //Integer.parse int somehow works -lord andrews fault
        if(Integer.parseInt(enteredPass) == Integer.parseInt(String.valueOf(correctPass.get(0).getPassWord()))){
            Log.d("made it here", user);
            mainPage();


        }

    }
    public void mainPage() {
        Log.d("login", "saveuser ran");

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }
}