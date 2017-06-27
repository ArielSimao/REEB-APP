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
        super(context, android.R.layout.simple_list_item_2, objects);
        this.layoutResourceId = android.R.layout.simple_list_item_2;
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
            h.um = (TextView) view.findViewById(android.R.id.text1);
            h.dois = (TextView) view.findViewById(android.R.id.text2);

            view.setTag(h);
        }else{
            h = (ViewHolder) view.getTag();
        }

        BeanReceita rec = receitas.get(position);
        h.um.setText(rec.getLote());
        h.dois.setText(rec.getTipo());

        return view;
    }

    static class ViewHolder {
        TextView um;
        TextView dois;
    }
}
