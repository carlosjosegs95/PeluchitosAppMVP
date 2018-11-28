package com.example.carlosjose95.peluchitosapp.agregar;

public class AgregarInteractor implements IAgregarContract.interactor {

    private IAgregarContract.presenter agregarPresenter;
    private IAgregarRepository agregarRepository;

    public AgregarInteractor(IAgregarContract.presenter agregarPresenter) {
        this.agregarPresenter = agregarPresenter;
        agregarRepository = new AgregarRepository(this);
    }

    @Override
    public void enviarDatos(String nombre, String cantidad, String precio) {
        if (nombre.equals("") || cantidad.equals("") || precio.equals("")){
            agregarPresenter.mostrarError("ERROR: Debe digitar todos los campos");
        } else {
            agregarRepository.guardarDatos(nombre, cantidad, precio);
        }
    }

    @Override
    public void mostrarMensajeExitoso(String msj) {
        agregarPresenter.mostrarMensajeExitoso(msj);
    }

    @Override
    public void pelucheRepetido(String msj) { agregarPresenter.pelucheRepetido(msj); }
}
