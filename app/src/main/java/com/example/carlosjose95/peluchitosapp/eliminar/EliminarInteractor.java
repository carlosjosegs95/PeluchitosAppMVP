package com.example.carlosjose95.peluchitosapp.eliminar;

public class EliminarInteractor implements IEliminarContract.interactor {

    private IEliminarContract.presenter eliminarPresenter;
    private IEliminarRepository eliminarRepository;

    public EliminarInteractor(IEliminarContract.presenter eliminarPresenter) {
        this.eliminarPresenter = eliminarPresenter;
        eliminarRepository = new EliminarRepository(this);
    }

    @Override
    public void enviarDatos(String nombre) {
        if (nombre.equals("")){
            eliminarPresenter.mostrarError("ERROR: Debe digitar el nombre del peluche");
        } else {
            eliminarRepository.buscarDatos(nombre);
        }
    }

    @Override
    public void mostrarPeluche(String nombre, String cantidad, String precio) {
        eliminarPresenter.mostrarPeluche(nombre, cantidad, precio);
    }

    @Override
    public void mensajePeluche(String msj) {
        eliminarPresenter.mensajePeluche(msj);
    }

    @Override
    public void eliminarPeluche(String nombre) {
        if (nombre.equals("")) {
            eliminarPresenter.mostrarError("Busca el peluche que deseas eliminar");
        } else {
            eliminarRepository.eliminarDatos(nombre);
        }
    }
}
