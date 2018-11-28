package com.example.carlosjose95.peluchitosapp.eliminar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carlosjose95.peluchitosapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EliminarFragment extends Fragment implements IEliminarContract.view{

    private EditText eParametro;
    private TextView tNombre, tCantidad, tPrecio;
    private Button bBuscar, bEliminar;
    private IEliminarContract.presenter eliminarPresenter;

    public EliminarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_eliminar, container, false);

        eliminarPresenter = new EliminarPresenter(this);

        eParametro = view.findViewById(R.id.eParametro1);
        tNombre = view.findViewById(R.id.tNombre1);
        tCantidad = view.findViewById(R.id.tCantidad1);
        tPrecio = view.findViewById(R.id.tPrecio1);
        bBuscar = view.findViewById(R.id.bBuscar1);
        bEliminar = view.findViewById(R.id.bEliminar1);

        bBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarPresenter.enviarDatos(eParametro.getText().toString());
            }
        });

        bEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eliminarPresenter.eliminarPeluche(tNombre.getText().toString());
            }
        });

        return view;
    }

    @Override
    public void mostrarError(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void mostrarPeluche(String nombre, String cantidad, String precio) {
        tNombre.setText(nombre);
        tCantidad.setText(cantidad);
        tPrecio.setText(precio);
    }

    @Override
    public void mensajePeluche(String msj) {
        Toast.makeText(getContext(), msj, Toast.LENGTH_SHORT).show();
    }
}
