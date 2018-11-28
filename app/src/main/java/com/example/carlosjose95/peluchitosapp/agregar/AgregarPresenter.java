package com.example.carlosjose95.peluchitosapp.agregar;

public class AgregarPresenter implements IAgregarContract.presenter {

    private IAgregarContract.interactor agregarInteractor;
    private IAgregarContract.view agregarView;

    public AgregarPresenter(IAgregarContract.view agregarView) {
        this.agregarView = agregarView;
        agregarInteractor = new AgregarInteractor(this);
    }

    @Override
    public void enviarDatos(String nombre, String cantidad, String precio) {
        agregarInteractor.enviarDatos(nombre, cantidad, precio);
    }

    @Override
    public void mostrarError(String error) { agregarView.mostrarError(error); }

    @Override
    public void mostrarMensajeExitoso(String msj) {
        agregarView.mostrarMensajeExitoso(msj);
    }

    @Override
    public void pelucheRepetido(String msj) { agregarView.pelucheRepetido(msj); }
}
