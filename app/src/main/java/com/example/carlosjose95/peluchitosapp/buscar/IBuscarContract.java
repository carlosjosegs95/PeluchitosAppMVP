package com.example.carlosjose95.peluchitosapp.buscar;

public interface IBuscarContract {
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
    }

    interface interactor {
        void enviarDatos(String nombre);
        void mostrarPeluche(String nombre, String cantidad, String precio);
        void mensajePeluche(String msj);
    }
}
