package com.example.pruebasfirebase;

/**
 * Created by NINO on 27/02/2018.
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;


public class AdaptadorEmpleado extends ArrayAdapter {

    ArrayList<CEmpleado> empleados = new ArrayList<CEmpleado>();
    Context c;

    public AdaptadorEmpleado(Context c, ArrayList<CEmpleado> empleados) {

        super(c, R.layout.item_empleado, empleados);
        this.c = c;
        this.empleados = empleados;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.item_empleado, null);

        TextView tvNombre = (TextView) item.findViewById(R.id.item_tvNombre);
        tvNombre.setText(empleados.get(position).getNombre());


        TextView tvDNI = (TextView) item.findViewById(R.id.item_tvDNI);
        tvDNI.setText(empleados.get(position).getDni());


        TextView tvProfesion = (TextView) item.findViewById(R.id.item_tvProfesion);
        tvProfesion.setText(empleados.get(position).getProfesion());

        return item;
    }
}