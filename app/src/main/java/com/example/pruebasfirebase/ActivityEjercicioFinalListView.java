package com.example.pruebasfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ActivityEjercicioFinalListView extends AppCompatActivity {

    static final String EXTRA_EMPLEADO="EMPLEADO";

    ListView lvEmpleados;
    ArrayList <CEmpleado> listaEmpleados = new  ArrayList<CEmpleado>();


    DatabaseReference dbRef;
    ValueEventListener valueEventListener;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio_final_list_view);
        lvEmpleados = (ListView) findViewById(R.id.main_lvEmpleados);
        cargarDatosFirebase();



    }

    public void accNuevoEmpleado(View view) {

        Intent i = new Intent(getApplicationContext(), ActivityEjercicioFinalFormulario.class);
        startActivity(i);

    }


    private void cargarDatosFirebase(){
        dbRef = FirebaseDatabase.getInstance().getReference()
                .child("empleados");

        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listaEmpleados.clear();
                for (DataSnapshot empleadosDataSnapshot: dataSnapshot.getChildren()) {
                    cargarListView(empleadosDataSnapshot);
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

        listaEmpleados.add(dataSnapshot.getValue(CEmpleado.class));
        AdaptadorEmpleado adapter = new AdaptadorEmpleado(getApplicationContext(),
                listaEmpleados);
        lvEmpleados.setAdapter(adapter);


        lvEmpleados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                CEmpleado empleado = ((CEmpleado) parent.getItemAtPosition(position));

                Intent i = new Intent(getApplicationContext(), ActivityEjercicioFinalFormulario.class);
                i.putExtra(EXTRA_EMPLEADO, empleado);

                startActivity(i);

            }
        });

        lvEmpleados.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                CEmpleado empleado = ((CEmpleado) parent.getItemAtPosition(position));
                Bundle b=new Bundle();
                b.putString("DNI",empleado.getDni());
                FragmentManager fragmentManager = getSupportFragmentManager();
                DialogConfirmacion dialogo = new DialogConfirmacion();
                dialogo.setArguments(b);
                dialogo.show(fragmentManager, "dialogConfirmacino");

                return true;
            }
        });

    }

}