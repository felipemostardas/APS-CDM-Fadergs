package com.aps_cdm_fadergs.aps_cdm_fadergs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ListaCompraDAO {

    public static final void inserir(ListaCompra listaCompra, Context context){
        Banco banco = new Banco(context);
        ContentValues valores = new ContentValues();
        valores.put("nome", listaCompra.getNome());
        SQLiteDatabase db = banco.getWritableDatabase();
        db.insert("listas", null, valores);
    }

    public static final void excluir(int idLista, Context context){
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getWritableDatabase();
        db.delete("listas", "id = "+idLista, null);
    }

    public static final List<ListaCompra> listar(Context context){
        List<ListaCompra> lista = new ArrayList<>();
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getReadableDatabase();
        String sql = "SELECT * FROM listas ORDER BY id DESC ";
        Cursor cursor = db.rawQuery(sql, null);
        if ( cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do{
                ListaCompra listaCompra = new ListaCompra();

                listaCompra.setId(cursor.getInt(0));
                listaCompra.setNome(cursor.getString(1));


                lista.add(listaCompra);


            }while ( cursor.moveToNext() );
        }
        return lista;
    }
}
