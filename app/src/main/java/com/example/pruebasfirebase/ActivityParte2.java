package com.example.pruebasfirebase;

import android.support.constraint.solver.widgets.Snapshot;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

public class ActivityParte2 extends AppCompatActivity {
    TextView tvJugadores;
    DatabaseReference dbRef;
    ListView lvJugadores;
    ArrayList<CJugador> lista_jugadores = new ArrayList<CJugador>();

    long tam=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parte2);
        tvJugadores = (TextView) findViewById(R.id.tvJugadores);
        lvJugadores = (ListView) findViewById(R.id.lvJugadores);

        dbRef = FirebaseDatabase.getInstance().getReference()
                .child("jugadores");


        dbRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {
                cargarDatosDB(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {
                tvJugadores.setText("Se ha modificado el jugador con id: " + dataSnapshot.getKey() + ": " + dataSnapshot.getValue());

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                tvJugadores.setText("Se ha eliminado el jugador con id: " + dataSnapshot.getKey() + ": " + dataSnapshot.getValue());

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {
                tvJugadores.setText("Se ha movido el jugador con id: " + dataSnapshot.getKey() + ": " + dataSnapshot.getValue());

            }


            @Override
            public void onCancelled(DatabaseError databaseError) {
                tvJugadores.setText("Error! " + databaseError.toException());
            }


        });




    }

    private void cargarDatosDB(DataSnapshot dataSnapshot){
        lista_jugadores.add(dataSnapshot.getValue(CJugador.class));
        AdaptadorJugador adapter = new AdaptadorJugador(getApplicationContext(), lista_jugadores);
        lvJugadores.setAdapter(adapter);
    }
}
