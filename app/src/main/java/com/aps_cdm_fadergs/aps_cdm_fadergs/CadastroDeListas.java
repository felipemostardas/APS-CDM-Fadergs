package com.aps_cdm_fadergs.aps_cdm_fadergs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CadastroDeListas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_de_listas);

        


    }

    private void salvar(){

        ListaCompra listaCompra = new ListaCompra();
        listaCompra.setNome();


    }

}
