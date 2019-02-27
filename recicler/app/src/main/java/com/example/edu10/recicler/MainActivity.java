package com.example.edu10.recicler;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        BlankFragment frag = new BlankFragment();
        fm.beginTransaction().replace(R.id.fragment_container, frag).commit();


    }
}
