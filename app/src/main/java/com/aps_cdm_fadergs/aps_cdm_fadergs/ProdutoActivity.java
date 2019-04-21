package com.aps_cdm_fadergs.aps_cdm_fadergs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ProdutoActivity extends AppCompatActivity {

    private EditText etNome, etValor, etQuantidade;
    private Button btnAdicionar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);


        etNome =(EditText) findViewById(R.id.etNome);
        etValor =(EditText) findViewById(R.id.etValor);
        etQuantidade =(EditText) findViewById(R.id.etQuantidade);
        btnAdicionar = (Button) findViewById(R.id.btnAdicionar);

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Salvar();
            }
        });



    }

    private void Salvar(){
        Produto produto = new Produto();

        produto.setNome(etNome.getText().toString());
        produto.setValor(etValor.getText().toString());
        produto.setQuantidade(etQuantidade.getText().toString());

        this.finish();


    }
}
