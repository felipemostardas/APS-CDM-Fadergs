package com.aps_cdm_fadergs.aps_cdm_fadergs;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class ListaProdutosActivity extends AppCompatActivity {
    ListView lvLista;
    List<Produto> lista;
    AdapterProduto adapter;
    int codLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produtos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        codLista = getIntent().getExtras().getInt("codLista");

        lvLista = (ListView) findViewById(R.id.lvProdutos);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaProdutosActivity.this, ProdutoActivity.class);
                startActivity(intent);
            }
        });

        lvLista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                final Produto produtoSelecionado = lista.get(position);
                AlertDialog.Builder alerta = new AlertDialog.Builder(ListaProdutosActivity.this);
                alerta.setTitle("Excluir Produto...");
                alerta.setMessage("Confirma a exclusão do produto " + produtoSelecionado.getNome() + "?");
                alerta.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ProdutoDAO.excluir(produtoSelecionado.getId(), ListaProdutosActivity.this);
                        carregarLista();
                    }
                });

                alerta.setNeutralButton("Cancelar", null);
                alerta.show();

                return true;
            }
        });
    }

    private void carregarLista(){
        lista = ProdutoDAO.listar(this, codLista);
        adapter = new AdapterProduto(this, lista);
        lvLista.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        carregarLista();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_lista_produtos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
