package br.pro.appherois_2020_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class AdapterHeroi extends BaseAdapter {

    private List<Heroi> listaHerois;
    private LayoutInflater inflater;

    public AdapterHeroi(Context context, List<Heroi> lista ){
        this.listaHerois = lista;
        this.inflater = LayoutInflater.from( context );
    }

    @Override
    public int getCount() {
        return listaHerois.size();
    }

    @Override
    public Object getItem(int position) {
        return listaHerois.get( position );
    }

    @Override
    public long getItemId(int position) {
        return listaHerois.get( position ).getId() ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
