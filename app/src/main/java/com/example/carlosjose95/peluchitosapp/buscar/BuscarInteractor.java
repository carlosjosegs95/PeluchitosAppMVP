package com.example.carlosjose95.peluchitosapp.buscar;

public class BuscarInteractor implements IBuscarContract.interactor {

    private IBuscarContract.presenter buscarPresenter;
    private IBuscarRepository buscarRepository;

    public BuscarInteractor(IBuscarContract.presenter buscarPresenter) {
        this.buscarPresenter = buscarPresenter;
        buscarRepository = new BuscarRepository(this);
    }

    @Override
    public void enviarDatos(String nombre) {
        if (nombre.equals("")){
            buscarPresenter.mostrarError("ERROR: Debe digitar el nombre del peluche");
        } else {
            buscarRepository.buscarDatos(nombre);
        }
    }

    @Override
    public void mostrarPeluche(String nombre, String cantidad, String precio) {
        buscarPresenter.mostrarPeluche(nombre, cantidad, precio);
    }

    @Override
    public void mensajePeluche(String msj) {
        buscarPresenter.mensajePeluche(msj);
    }

}
