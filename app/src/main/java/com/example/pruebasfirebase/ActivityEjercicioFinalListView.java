package com.example.pruebasfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityEjercicioFinalListView extends AppCompatActivity {

    static final String EXTRA_EMPLEADO="EMPLEADO";

    ListView lvEmpleados;
    ArrayList <CEmpleado> listaEmpleados = new  ArrayList<CEmpleado>();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio_final_list_view);

        cargarDatos();

        lvEmpleados = (ListView) findViewById(R.id.main_lvEmpleados);
        AdaptadorEmpleado adapterEmpleado = new AdaptadorEmpleado(this, listaEmpleados);
        lvEmpleados.setAdapter(adapterEmpleado);

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

                Toast.makeText(getApplicationContext(), "Holis", Toast.LENGTH_SHORT).show();

                return true;
            }
        });


    }

    public void accNuevoEmpleado(View view) {

        Intent i = new Intent(getApplicationContext(), ActivityEjercicioFinalFormulario.class);
        startActivity(i);

    }

    private void cargarDatos (){

        listaEmpleados.add(new CEmpleado("Pepe", "333222111A", "Profesor"));
        listaEmpleados.add(new CEmpleado("Juan", "999888444A", "Medico"));
        listaEmpleados.add(new CEmpleado("Marta", "123321123j", "Administrativa"));
        listaEmpleados.add(new CEmpleado("Carlos", "000999888f", "Cocinero"));
        listaEmpleados.add(new CEmpleado("Marta", "123123999J", "Pintora"));
        listaEmpleados.add(new CEmpleado("Pepe", "rwrgwr", "srignwr"));
        listaEmpleados.add(new CEmpleado("Pepe", "rwrgwr", "srignwr"));
        listaEmpleados.add(new CEmpleado("Pepe", "rwrgwr", "srignwr"));

    }

}