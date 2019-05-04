package com.aps_cdm_fadergs.aps_cdm_fadergs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroDeListas extends AppCompatActivity {
    private EditText etNome;
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_de_listas);
        etNome = (EditText) findViewById(R.id.etNomeLista);
        btnSalvar = (Button) findViewById(R.id.btnSalvarLista);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });


    }

    private void salvar(){

        ListaCompra listaCompra = new ListaCompra();

        listaCompra.setNome(etNome.getText().toString());

        ListaCompraDAO.inserir(listaCompra,this );
        this.finish();

    }

}
