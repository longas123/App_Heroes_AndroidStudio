package br.pro.appherois_2020_1;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

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

        ItemSuporte item;

        if( convertView == null ){
            convertView = inflater.inflate(R.layout.layout_lista, null);
            item = new ItemSuporte();
            item.tvNome = (TextView) convertView.findViewById(R.id.llTvNome);
            item.tvGrupo = (TextView) convertView.findViewById(R.id.llTvGrupo);
            item.fundoTela = convertView.findViewById(R.id.llLayout);

            convertView.setTag( item );

        }else{
            item = (ItemSuporte) convertView.getTag();
        }

        Heroi heroi = listaHerois.get( position );
        item.tvNome.setText( heroi.getNome() );
        item.tvGrupo.setText( heroi.getGrupo() );

        if( position % 2 == 0 ){
            item.fundoTela.setBackgroundColor( Color.WHITE );
        }else {
            item.fundoTela.setBackgroundColor( Color.rgb( 230, 230, 230) );
        }


        return convertView;
    }

    private class ItemSuporte{
        TextView tvNome, tvGrupo;
        LinearLayout fundoTela;
    }


}
