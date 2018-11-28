package com.example.carlosjose95.peluchitosapp.agregar;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.carlosjose95.peluchitosapp.PeluchitosApp;
import com.example.carlosjose95.peluchitosapp.Persistency.PeluchesSQLiteHelper;

public class AgregarRepository implements IAgregarRepository {

    private IAgregarContract.interactor agregarInteractor;

    public AgregarRepository(IAgregarContract.interactor agregarInteractor) {
        this.agregarInteractor = agregarInteractor;
    }

    @Override
    public void guardarDatos(String nombre, String cantidad, String precio) {

        PeluchesSQLiteHelper peluchesSQLiteHelper;
        SQLiteDatabase dbPeluches;
        ContentValues dataBD;

        peluchesSQLiteHelper = new PeluchesSQLiteHelper(
                PeluchitosApp.getmContext(),
                "peluchesBD",
                null,
                1);

        dbPeluches = peluchesSQLiteHelper.getWritableDatabase();

        Cursor c = dbPeluches.rawQuery(
                "SELECT * FROM peluches WHERE nombre = '"+nombre+"'",
                null);

        if(c.moveToFirst()){
            agregarInteractor.pelucheRepetido("El peluche ya existe, por favor cambia el nombre");
            dbPeluches.close();
        } else {
            dataBD = new ContentValues();
            dataBD.put("nombre", nombre);
            dataBD.put("cantidad", cantidad);
            dataBD.put("precio", precio);

            dbPeluches.insert("peluches", null, dataBD);
            dbPeluches.close();

            agregarInteractor.mostrarMensajeExitoso("Peluche guardado con exito");
        }
    }
}
