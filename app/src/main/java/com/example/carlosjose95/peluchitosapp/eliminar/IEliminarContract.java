package com.example.carlosjose95.peluchitosapp.eliminar;

public interface IEliminarContract {
    interface view {
        void mostrarError(String error);
        void mostrarPeluche(String nombre, String cantidad, String precio);
        void mensajePeluche(String msj);
    }

    interface presenter {
        void enviarDatos(String nombre);
        void mostrarError(String error);
        void mostrarPeluche(String nombre, String cantidad, String precio);
        void mensajePeluche(String msj);
        void eliminarPeluche(String nombre);
    }

    interface interactor {
        void enviarDatos(String nombre);
        void mostrarPeluche(String nombre, String cantidad, String precio);
        void mensajePeluche(String msj);
        void eliminarPeluche(String nombre);
    }
}
