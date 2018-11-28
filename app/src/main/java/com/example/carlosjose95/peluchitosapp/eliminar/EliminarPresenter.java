package com.example.carlosjose95.peluchitosapp.eliminar;

public class EliminarPresenter implements IEliminarContract.presenter {

    private IEliminarContract.view eliminarView;
    private IEliminarContract.interactor eliminarInteractor;

    public EliminarPresenter(IEliminarContract.view eliminarView) {
        this.eliminarView = eliminarView;
        eliminarInteractor = new EliminarInteractor(this);
    }

    @Override
    public void enviarDatos(String nombre) {
        eliminarInteractor.enviarDatos(nombre);
    }

    @Override
    public void mostrarError(String error) {
        eliminarView.mostrarError(error);
    }

    @Override
    public void mostrarPeluche(String nombre, String cantidad, String precio) {
        eliminarView.mostrarPeluche(nombre, cantidad, precio);
    }

    @Override
    public void mensajePeluche(String msj) {
        eliminarView.mensajePeluche(msj);
    }

    @Override
    public void eliminarPeluche(String nombre) {
        eliminarInteractor.eliminarPeluche(nombre);
    }
}
