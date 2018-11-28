package com.example.carlosjose95.peluchitosapp.buscar;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.carlosjose95.peluchitosapp.PeluchitosApp;
import com.example.carlosjose95.peluchitosapp.Persistency.PeluchesSQLiteHelper;

public class BuscarRepository implements IBuscarRepository {

    private IBuscarContract.interactor buscarInteractor;

    public BuscarRepository(IBuscarContract.interactor buscarInteractor) {
        this.buscarInteractor = buscarInteractor;
    }

    @Override
    public void buscarDatos(String nombre) {
        PeluchesSQLiteHelper peluchesSQLiteHelper;
        SQLiteDatabase dbPeluches;

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
            buscarInteractor.mostrarPeluche(c.getString(1), c.getString(2), c.getString(3));
        } else {
            buscarInteractor.mensajePeluche("El peluche no está registrado");
        }
    }
}
