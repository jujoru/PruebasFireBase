package com.example.pruebasfirebase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Nino Ruano on 22/02/2018.
 */

public class AdaptadorJugador extends ArrayAdapter<CJugador> {

    Context c;
    ArrayList<CJugador> lista_jugadores;

    public AdaptadorJugador(Context context,   ArrayList<CJugador> lista_jugadores) {
        super(context, R.layout.item_jugador, lista_jugadores);
        this.c=context;
        this.lista_jugadores=lista_jugadores;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.item_jugador,null);

        TextView itemTvPrincipal=(TextView)item.findViewById(R.id.itemTvPrincipal);
        itemTvPrincipal.setText(lista_jugadores.get(position).getNombre()+" "+lista_jugadores.get(position).getDorsal());

        TextView itemTvSecundario=(TextView)item.findViewById(R.id.itemTvSecundario);
        itemTvSecundario.setText(lista_jugadores.get(position).getPosicion());


        return item;
    }
}
