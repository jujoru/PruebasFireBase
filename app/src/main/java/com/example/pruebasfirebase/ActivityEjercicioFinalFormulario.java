package com.example.pruebasfirebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ActivityEjercicioFinalFormulario extends AppCompatActivity {

    EditText etNombre, etDNI, etProfesion;
    Button btnInsertar, btnModificar;
    DatabaseReference dbRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio_final_formulario);


        etNombre = (EditText) findViewById(R.id.emp_etNombre);
        etDNI = (EditText) findViewById(R.id.emp_etDNI);
        etProfesion = (EditText) findViewById(R.id.emp_etProfesion);

        btnInsertar = (Button) findViewById(R.id.emp_btnInsertar);
        btnModificar = (Button) findViewById(R.id.emp_btnModificar);

        Bundle b = getIntent().getExtras();

        if (b != null) {
            CEmpleado empleado = b.getParcelable(ActivityEjercicioFinalListView.EXTRA_EMPLEADO);

            etNombre.setText(empleado.getNombre().toString());
            etDNI.setText(empleado.getDni().toString());
            etProfesion.setText(empleado.getProfesion().toString());

            btnInsertar.setEnabled(false);


        } else {

            btnModificar.setEnabled(false);
            etDNI.setEnabled(false);
        }

    }

    public void accInsertar(View view) {
        /*
        String nombre = etNombre.getText().toString();
        String dni = etDNI.getText().toString();
        String profesion = etProfesion.getText().toString();

        if(nombre.equals("")||dni.equals("")||profesion.equals("")){
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

*/
    }

    public void accModificar(View view) {
//holitaaaa


    }

}