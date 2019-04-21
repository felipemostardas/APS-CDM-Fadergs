package com.aps_cdm_fadergs.aps_cdm_fadergs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.util.List;


public class CompraActivity extends AppCompatActivity {

    ListView lvLista;
    List<Produto> lista;
    //    ArrayAdapter adapter;
    AdapterCompra adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lvLista = (ListView) findViewById(R.id.lvProduto);

    }
    private void carregarLista(){

        lista = ProdutoDAO.listar(this);
//        adapter = new ArrayAdapter(this,
//                android.R.layout.simple_list_item_1, lista );
        adapter = new AdapterCompra(this, lista);
        lvLista.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarLista();
    }


}
