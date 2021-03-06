package com.example.pruebasfirebase;

import android.support.constraint.solver.widgets.Snapshot;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

public class ActivityParte2 extends AppCompatActivity {

    TextView tvJugadores;
    ListView lvJugadores;

    DatabaseReference dbRef;
    ValueEventListener valueEventListener;

    ArrayList<CJugador> lista_jugadores = new ArrayList<CJugador>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parte2);

        tvJugadores = (TextView) findViewById(R.id.tvJugadores);
        lvJugadores = (ListView) findViewById(R.id.lvJugadores);

        cargarDatosFirebase();

    }



    private void cargarDatosFirebase(){
       // dbRef = FirebaseDatabase.getInstance().getReference()
       //         .child("jugadores");
        dbRef = FirebaseDatabase.getInstance().getReference()
                .child("libro");
        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                lista_jugadores.clear();




               for (DataSnapshot jugadoresDataSnapshot: dataSnapshot.getChildren()) {
                    cargarListView(jugadoresDataSnapshot);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("ActivityParte2","DATABASE ERROR");
            }
        };
        dbRef.addValueEventListener(valueEventListener);
        //dbRef.addListenerForSingleValueEvent(valueEventListener);
    }



    private void cargarListView (DataSnapshot dataSnapshot){

        Libro l = dataSnapshot.getValue(Libro.class);

        l.getAuthor();
       /* lista_jugadores.add(dataSnapshot.getValue(CJugador.class));
        AdaptadorJugador adapter = new AdaptadorJugador(getApplicationContext(),
                lista_jugadores);
        lvJugadores.setAdapter(adapter);

        lvJugadores.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CJugador cJugador = ((CJugador)parent.getItemAtPosition(position));
                Toast.makeText(getApplicationContext(),
                        "El sueldo de "+cJugador.getNombre()+" es de "+cJugador.getSueldo(),
                        Toast.LENGTH_LONG).show();
            }
        });

        lvJugadores.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                return false;
            }
        });*/

    }

}
