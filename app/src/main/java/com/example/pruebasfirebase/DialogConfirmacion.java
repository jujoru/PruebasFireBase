package com.example.pruebasfirebase;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by NINO on 12/02/2018.
 */

public class DialogConfirmacion extends DialogFragment {
    static String dni="";
    DatabaseReference dbRef;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());
        Bundle b = getArguments();

        if(b!=null){
              dni = b.getString("DNI");
        }

        builder.setMessage("¿Deseas elimninar el empleado con dni "+dni+"?")
                .setTitle("ELIMINAR")
                .setPositiveButton("Si", new DialogInterface.OnClickListener()  {
                    public void onClick(DialogInterface dialog, int id) {

                        dbRef = FirebaseDatabase.getInstance().getReference()
                                .child("empleados");
                        dbRef.child(dni).removeValue(new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(DatabaseError error, DatabaseReference databaseReference) {
                                if(error == null) {
                                    Toast.makeText(getActivity(), "Se ha eliminado el emlpeado", Toast.LENGTH_SHORT).show();

                                }else {

                                }
                            }
                        });
                        dialog.cancel();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        return builder.create();
    }
}