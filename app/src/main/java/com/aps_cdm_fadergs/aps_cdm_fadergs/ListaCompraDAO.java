package com.aps_cdm_fadergs.aps_cdm_fadergs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import static com.aps_cdm_fadergs.aps_cdm_fadergs.ListaCompra.getNome;

public class ListaCompraDAO {

    public static final void inserir(ListaCompra listaCompra, Context context){
        Banco banco = new Banco(context);
        ContentValues valores = new ContentValues();
        valores.put("nome", banco.getNome());
        SQLiteDatabase db = banco.getWritableDatabase();
        db.insert("listas", null, valores);
    }

    public static final void excluir(int idProduto, Context context){
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getWritableDatabase();
        db.delete("produtos", "id = "+idProduto, null);
    }

    public static final List<Produto> listar(Context context){
        List<Produto> lista = new ArrayList<>();
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getReadableDatabase();
        String sql = "SELECT * FROM anotacoes ORDER BY id DESC ";
        Cursor cursor = db.rawQuery(sql, null);
        if ( cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do{
                Produto produto = new Produto();

                produto.setId(cursor.getInt(0));
                produto.setNome(cursor.getString(1));
                produto.setValor(cursor.getString(2));


                lista.add(produto);


            }while ( cursor.moveToNext() );
        }
        return lista;
    }
}
