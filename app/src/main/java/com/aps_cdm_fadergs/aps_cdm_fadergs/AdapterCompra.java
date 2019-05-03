package com.aps_cdm_fadergs.aps_cdm_fadergs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterCompra extends BaseAdapter {

    private Context context;
    private List<ListaCompra> lista;
    private LayoutInflater inflater;

    public AdapterCompra(Context context, List<ListaCompra> lista){
        this.context = context;
        this.lista = lista;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lista.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Suporte item;

        if( convertView == null ){
            convertView = inflater.inflate
                    (R.layout.layout_compra, null);
            item = new Suporte();
            item.tvCodigo = (TextView)
                    convertView.findViewById(R.id.tvListaCodigo);
            item.tvProduto = (TextView)
                    convertView.findViewById(R.id.tvListaProduto);

            convertView.setTag(item);
        }else {
            item = (Suporte) convertView.getTag();
        }

        ListaCompra listacompra = lista.get( position );
        item.tvCodigo.setText( String.valueOf( listacompra.getId() ) );
        item.tvProduto.setText(  listacompra.getNome()  );
        return convertView;
    }

    private class Suporte{
        TextView tvCodigo, tvProduto;
    }

}










