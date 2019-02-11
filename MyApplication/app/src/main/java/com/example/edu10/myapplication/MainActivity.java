package com.example.edu10.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //El fragment que usemos necesitamos declararlo
        Fragment fragment = new BlankFragment();
        //Primero declaramos el frament manager
        FragmentManager fragmentManager = getSupportFragmentManager();
        //Segundo  hacemos un Fragment transaction y un begin
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
        //despues el replace, el primer parametro es el identificador del xml, el segundo es el fragmento que cargara
        fragmentTransaction.replace(R.id.frag1,fragment);
        //por ultimo el commit
        fragmentTransaction.commit();



    }
}
