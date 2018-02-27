package com.example.pruebasfirebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class ActivityEjercicioFinalFormulario extends AppCompatActivity {

    EditText etNombre, etDNI, etProfesion;
    Button btnInsertar, btnModificar;

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

        }

    }

    public void accInsertar(View view) {



    }

    public void accModificar(View view) {



    }

}