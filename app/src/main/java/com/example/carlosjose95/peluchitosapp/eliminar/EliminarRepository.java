package com.example.carlosjose95.peluchitosapp.eliminar;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.carlosjose95.peluchitosapp.PeluchitosApp;
import com.example.carlosjose95.peluchitosapp.Persistency.PeluchesSQLiteHelper;

public class EliminarRepository implements IEliminarRepository {

    private IEliminarContract.interactor eliminarInteractor;

    public EliminarRepository(IEliminarContract.interactor eliminarInteractor) {
        this.eliminarInteractor = eliminarInteractor;
    }

    @Override
    public void buscarDatos(String name) {
        PeluchesSQLiteHelper peluchesSQLiteHelper;
        SQLiteDatabase dbPeluches;

        peluchesSQLiteHelper = new PeluchesSQLiteHelper(
                PeluchitosApp.getmContext(),
                "peluchesBD",
                null,
                1);

        dbPeluches = peluchesSQLiteHelper.getWritableDatabase();

        Cursor c = dbPeluches.rawQuery(
                "SELECT * FROM peluches WHERE nombre = '"+name+"'",
                null);

        if(c.moveToFirst()){
            eliminarInteractor.mostrarPeluche(c.getString(1), c.getString(2), c.getString(3));
        } else {
            eliminarInteractor.mensajePeluche("El peluche no está registrado");
        }

    }

    @Override
    public void eliminarDatos(String name) {
        PeluchesSQLiteHelper peluchesSQLiteHelper;
        SQLiteDatabase dbPeluches;

        peluchesSQLiteHelper = new PeluchesSQLiteHelper(
                PeluchitosApp.getmContext(),
                "peluchesBD",
                null,
                1);

        dbPeluches = peluchesSQLiteHelper.getWritableDatabase();

        dbPeluches.delete("peluches",
                "nombre = '" + name + "'",
                null);

        eliminarInteractor.mensajePeluche("Peluche eliminado con éxito");
        eliminarInteractor.mostrarPeluche("", "", "");

    }
}
