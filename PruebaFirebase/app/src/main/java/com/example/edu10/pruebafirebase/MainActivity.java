package com.example.edu10.pruebafirebase;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        List<Usuarios> userList = new ArrayList<>();

        FragmentManager fm = getSupportFragmentManager();
        BlankFragment frag = new BlankFragment();
        fm.beginTransaction().replace(R.id.fragment_container, frag,"tag_id").commit();


    }

    void escribirFirebase(Usuarios user){

        FirebaseDatabase.getInstance().getReference().child("user").push().setValue(user);


    }
    void leerFirebase(){

        //FibaseDatabase.getInstance().getReference()child.addchildEventListener(new childEven
        ChildEventListener childEventListener = FirebaseDatabase.getInstance().getReference()
                .child("users").addChildEventListener(new ChildEventListener() {
                    //Implementamos los metodos

                    @Override
                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                        Usuarios item = dataSnapshot.getValue(Usuarios.class);
                        //Aqui buscamos al Fragment de Usuarios y llamamos a la función
                        //addUserToList que añade un nuevo usuario al ArrayList
                        //y actualiza el Adapter del RecyclerView

                        FragmentRecicler usersFragment = (FragmentRecicler) getSupportFragmentManager().findFragmentByTag("USERS");
                        usersFragment.añadirAlaLista(item);
                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });

    }



    @Override
    public void login( final String email , final String password) {

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.i("Firebase 00", "createUserWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(getApplicationContext(), "Authentication succed.",
                                        Toast.LENGTH_SHORT).show();



                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w("Firebase 00", "createUserWithEmail:failure", task.getException());
                                Toast.makeText(getApplicationContext(), "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();

                            }

                            // ...
                        }
                    });


        }


    private void cargar_usersFragment() {

        //Proceso habitual de cargar un fragment, pero añadiendo un TAG al fragment
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = new BlankFragment();
        fm.beginTransaction().replace(R.id.fragment_container, fragment , "tag_id").addToBackStack("tag_id").commit();

    }

    private void cargar_listaFragment() {

        //Proceso habitual de cargar un fragment, pero añadiendo un TAG al fragment
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = new FragmentRecicler();
        fm.beginTransaction().replace(R.id.fragment_container, fragment , "USERS").addToBackStack("USERS").commit();

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        //Debo inflar el recurso de tipo Menu que debo tener generado

        //en res/menu

        getMenuInflater().inflate(R.menu.menutoolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }


    //Este método será invocado cada vez que alguien pulse


    //alguno de los items del menu


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Escojo que hacer en función del botón pulsado
        switch (item.getItemId()){
            case R.id.menu1:
                cargar_listaFragment();
                break;


            //Este botón de momento no tiene utilidad ;-

           /** case R.id.msgMenu:

                break;**/
        }

        return super.onOptionsItemSelected(item);


    }



}




