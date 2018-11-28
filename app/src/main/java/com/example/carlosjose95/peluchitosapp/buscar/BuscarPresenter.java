package com.example.carlosjose95.peluchitosapp.buscar;

public class BuscarPresenter implements IBuscarContract.presenter {

    private IBuscarContract.interactor buscarInteractor;
    private IBuscarContract.view buscarView;

    public BuscarPresenter(IBuscarContract.view buscarView) {
        this.buscarView = buscarView;
        buscarInteractor = new BuscarInteractor(this);
    }

    @Override
    public void enviarDatos(String nombre) {
        buscarInteractor.enviarDatos(nombre);
    }

    @Override
    public void mostrarError(String error) {
        buscarView.mostrarError(error);
    }

    @Override
    public void mostrarPeluche(String nombre, String cantidad, String precio) {
        buscarView.mostrarPeluche(nombre, cantidad, precio);
    }

    @Override
    public void mensajePeluche(String msj) {
        buscarView.mensajePeluche(msj);
    }
}
