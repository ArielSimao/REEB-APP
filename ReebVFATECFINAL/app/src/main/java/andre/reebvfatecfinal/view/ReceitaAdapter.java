package andre.reebvfatecfinal.view;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.TwoLineListItem;

import java.util.List;

import andre.reebvfatecfinal.R;
import andre.reebvfatecfinal.pojo.BeanReceita;

/**
 * Created by DjAriel on 26/06/17.
 */

public class ReceitaAdapter extends ArrayAdapter<BeanReceita> {

    int layoutResourceId;
    List<BeanReceita> receitas;
    Activity context;

    public ReceitaAdapter(Activity context, List<BeanReceita> objects) {
        super(context, R.layout.frag_list_receita, objects);
        this.layoutResourceId = R.layout.frag_list_receita;
        this.receitas = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder h;
        if(view == null){
            LayoutInflater inflater = context.getLayoutInflater();
            view = inflater.inflate(layoutResourceId, parent, false);

            h = new ViewHolder();
            h.um = (TextView) view.findViewById(R.id.frag_list_receita_text1);
            h.dois = (TextView) view.findViewById(R.id.frag_list_receita_text2);
            h.tres = (TextView) view.findViewById(R.id.frag_list_receita_text3);

            view.setTag(h);
        }else{
            h = (ViewHolder) view.getTag();
        }

        BeanReceita rec = receitas.get(position);
        h.um.setText(rec.getLote());
        h.dois.setText(rec.getTipo());
        h.tres.setText(rec.getData());

        return view;
    }

    static class ViewHolder {
        TextView um;
        TextView dois;
        TextView tres;
    }
}
