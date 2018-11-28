package com.example.carlosjose95.peluchitosapp.agregar;

public interface IAgregarContract {

    interface view {
        void mostrarError(String error);
        void mostrarMensajeExitoso(String msj);
        void pelucheRepetido(String msj);
    }

    interface presenter {
        void enviarDatos(String nombre, String cantidad, String precio);
        void mostrarError(String error);
        void mostrarMensajeExitoso(String msj);
        void pelucheRepetido(String msj);
    }

    interface interactor {
        void enviarDatos(String nombre, String cantidad, String precio);
        void mostrarMensajeExitoso(String msj);
        void pelucheRepetido(String msj);
    }
}
