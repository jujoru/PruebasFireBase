package com.example.pruebasfirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ActivityParte3 extends AppCompatActivity {

    Spinner spJugadores;
    EditText etNombre, etDorsal, etPosicion, etSueldo;

    DatabaseReference dbRef;
    ValueEventListener valueEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parte3);

        spJugadores = (Spinner)findViewById(R.id.spJugadores);
        etNombre = (EditText)findViewById(R.id.etNombre);
        etDorsal = (EditText)findViewById(R.id.etDorsal);
        etPosicion = (EditText)findViewById(R.id.etPosicion);
        etSueldo = (EditText)findViewById(R.id.etSueldo);

        String [] jugadoresId = {"j1","j2","j3","j4","j5","j6","j7"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_expandable_list_item_1,jugadoresId);
        spJugadores.setAdapter(adapter);


    }


    public void buscar(View view){
        String idSeleccionada = spJugadores.getSelectedItem().toString();

        dbRef = FirebaseDatabase.getInstance().getReference()
                .child("jugadores/"+idSeleccionada);

        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                CJugador jug = dataSnapshot.getValue(CJugador.class);
                etNombre.setText(jug.getNombre());
                etDorsal.setText(jug.getDorsal()+"");
                etPosicion.setText(jug.getPosicion());
                etSueldo.setText(jug.getSueldo()+"");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("ActivityParte3:Mostrar","DATABASE ERROR");
            }
        };
        dbRef.addListenerForSingleValueEvent(valueEventListener);

    }

    public void guardar(View view){
        String nombre = etNombre.getText().toString();
        String strDorsal = etDorsal.getText().toString();
        String posicion = etPosicion.getText().toString();
        String strSueldo = etSueldo.getText().toString();

        if(nombre.equals("")||strDorsal.equals("")||posicion.equals("")||strSueldo.equals("")){
            Toast.makeText(getApplicationContext(),"Rellena todos los campos",Toast.LENGTH_LONG).show();
        }else{
            int dorsal = Integer.parseInt(strDorsal);
            double sueldo = Double.parseDouble(strSueldo);
            CJugador nuevoJugador=new CJugador(dorsal,nombre,posicion,sueldo);
            dbRef = FirebaseDatabase.getInstance().getReference()
                    .child("jugadores");


            //String nueva_clave = dbRef.push().setValue(nuevoJugador, new DatabaseReference.CompletionListener(){
            dbRef.child("j8").setValue(nuevoJugador, new DatabaseReference.CompletionListener(){
                public void onComplete(DatabaseError error, DatabaseReference ref) {
                    if(error == null) {
                        Toast.makeText(getApplicationContext(),
                                "INSERTADO CORRECTAMENTE",
                                Toast.LENGTH_LONG).show();
                        limpiarFormulario();
                    }else {
                        Toast.makeText(getApplicationContext(),
                                "NO SE PUEDE INSETAR EL JUGADOR",
                                Toast.LENGTH_LONG).show();
                    }
                }
            });

        }
    }

    public void modificar(View view){
        String nombre = etNombre.getText().toString();
        String strDorsal = etDorsal.getText().toString();
        String posicion = etPosicion.getText().toString();
        String strSueldo = etSueldo.getText().toString();

        if(nombre.equals("")||strDorsal.equals("")||posicion.equals("")||strSueldo.equals("")){
            Toast.makeText(getApplicationContext(),"Rellena todos los campos",Toast.LENGTH_LONG).show();
        }else{
            int dorsal = Integer.parseInt(strDorsal);
            double sueldo = Double.parseDouble(strSueldo);
            CJugador nuevoJugador=new CJugador(dorsal,nombre,posicion,sueldo);
            dbRef = FirebaseDatabase.getInstance().getReference()
                    .child("jugadores");

            String idSeleccionada = spJugadores.getSelectedItem().toString();

            dbRef.child(idSeleccionada).setValue(nuevoJugador, new DatabaseReference.CompletionListener(){
                public void onComplete(DatabaseError error, DatabaseReference ref) {
                    if(error == null) {
                        Toast.makeText(getApplicationContext(),
                                "INSERTADO CORRECTAMENTE",
                                Toast.LENGTH_LONG).show();
                        limpiarFormulario();
                    }else {
                        Toast.makeText(getApplicationContext(),
                                "NO SE PUEDE INSETAR EL JUGADOR",
                                Toast.LENGTH_LONG).show();
                    }
                }
            });

        }
    }

    public void eliminar(View view){
        
        dbRef = FirebaseDatabase.getInstance().getReference()
                .child("jugadores");

        String idSeleccionada = spJugadores.getSelectedItem().toString();
        dbRef.child(idSeleccionada).removeValue(new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError error, DatabaseReference databaseReference) {
                if(error == null) {
                    Toast.makeText(getApplicationContext(),
                            "ELIMINADO CORRECTAMENTE",
                            Toast.LENGTH_LONG).show();
                    limpiarFormulario();
                }else {
                    Toast.makeText(getApplicationContext(),
                            "NO SE PUEDE ELIMINAR EL JUGADOR",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void limpiarFormulario(){
        etNombre.setText("");
        etDorsal.setText("");
        etPosicion.setText("");
        etSueldo.setText("");
    }
}
