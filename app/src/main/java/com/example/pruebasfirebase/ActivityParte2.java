package com.example.pruebasfirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ActivityParte2 extends AppCompatActivity {
    TextView tvJugadores;
    DatabaseReference dbRef;
    ArrayList<CJugador> lista_jugadores = new ArrayList<CJugador>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parte2);
        tvJugadores= (TextView)findViewById(R.id.tvJugadores);

        dbRef = FirebaseDatabase.getInstance().getReference()
                        .child("jugadores");

        ChildEventListener childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {

                String valorTv = tvJugadores.getText().toString();
                tvJugadores.setText(valorTv+"\nonChildAdded: {" + dataSnapshot.getKey() + ": " + dataSnapshot.getValue() + "}");


                CJugador j =dataSnapshot.getValue(CJugador.class);
                lista_jugadores.add(j);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {
                String valorTv = tvJugadores.getText().toString();
                tvJugadores.setText(valorTv+"\nonChildChanged: {" + dataSnapshot.getKey() + ": " + dataSnapshot.getValue() + "}");
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                String valorTv = tvJugadores.getText().toString();
                tvJugadores.setText(valorTv+"\nonChildRemoved: {" + dataSnapshot.getKey() + ": " + dataSnapshot.getValue() + "}");
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {
                String valorTv = tvJugadores.getText().toString();
                tvJugadores.setText(valorTv+"\nonChildMoved: {" + dataSnapshot.getKey() + ": " + dataSnapshot.getValue() + "}");
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {
                tvJugadores.setText("Error! "+databaseError.toException());
            }
        };

        dbRef.addChildEventListener(childEventListener);

        lista_jugadores.size();
    }
}
