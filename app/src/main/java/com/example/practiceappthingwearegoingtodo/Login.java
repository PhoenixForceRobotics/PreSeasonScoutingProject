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
import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {

    int i;
    EditText password;
    Spinner users;
    String user;
    String enteredPass;
    Button submit;
    Boolean validated;
    Boolean correct;

    private List<String> usernames = new ArrayList<>();
    private List<String> passwords = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Context context = this;

        users = findViewById(R.id.usernamesSpinner);
        password = findViewById(R.id.editText);
        submit = findViewById(R.id.submit);

        //creates passwords and users
        addUsersPasswords();
        usernames.add(0,"Select user");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, usernames);
        //set the spinners adapter to the previously created one.
        users.setAdapter(adapter);

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { validateUser(); }

        });


    }


    public void validateUser () {
        correct = false;
        i = 1;
        while (correct == false) {


            enteredPass = password.getText().toString();
            Log.d("Get Password:", "Password Recieved");
            user = users.getSelectedItem().toString();
            Log.d("Get users:", "Users Recieved");
            //navigates either way also fix for
           // Log.d("passwords:", passwords.get(0));
            //Log.d("Username", usernames.get(0));
            //Log.d("EnteredUsername", user);
           // Log.d("EnteredPass", enteredPass);
            //find entered user in database dont need to check if exists then


            enteredPass = passwords.get(i);
            Log.d("Entered Pass:", "Entered pass log");
            //Integer.parse int somehow works -lord andrews fault
            if (Integer.parseInt(enteredPass) == Integer.parseInt(String.valueOf(passwords.get(i)))) {
                correct = true;
                Log.d("made it here", user);
                mainPage();


            }
            i = i + 1;
        }

    }
    public void mainPage() {

        Intent intent = new Intent(this, MainPage.class);
        startActivity(intent);
    }
    public void addUsersPasswords()  {
        Log.d("login", "added passwords and users ran");

        usernames.add("Noam Sorlie");
        usernames.add("Gabriel Adams");
        usernames.add("Syed Ali");
        usernames.add("Conner ???");
        usernames.add("Malia ???");


        passwords.add("6969");
        passwords.add("6969");
        passwords.add("6969");
        passwords.add("6969");
        passwords.add("6969");





    }
}
