package andre.reebvfatecfinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import andre.reebvfatecfinal.banco.DAOReceita;
import andre.reebvfatecfinal.pojo.BeanReceita;

public class RecebeData extends Activity {


    public Button btnVoltar;
    public ListView lvDatas;
    public TextView txtTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recebedata);


        lvDatas = (ListView)findViewById(R.id.lstData);
        txtTitulo = (TextView) findViewById(R.id.txt_title);

        Intent it = getIntent();
        Bundle b = it.getExtras();

        final String tipo = b.getString("tipo");

        DAOReceita dr = new DAOReceita(getBaseContext());
        dr.open();


        List<String> valores = null;

        if(tipo.equals("data")){
            txtTitulo.setText(R.string.titulo_data);
            valores = dr.selectTodasDatas();
        }else if(tipo.equals("lote")){
            txtTitulo.setText(R.string.titulo_lote);
            valores = dr.selectTodosLotes();
        }
        else if(tipo.equals("tipo")){
            txtTitulo.setText(R.string.titulo_tipo);
            valores = dr.selectTodosTipos();
        }

        ArrayAdapter<String> adapter = new
                ArrayAdapter<String>(getBaseContext(),
                android.R.layout.simple_list_item_1, valores);


        dr.close();
        lvDatas.setAdapter(adapter);

        btnVoltar=(Button)findViewById(R.id.act_recebedata_btn_voltar);

        lvDatas.setOnItemClickListener(new ListView.OnItemClickListener(){


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                String dado = (String)parent.getItemAtPosition(position);

                Bundle parr = new Bundle();

                parr.putString("tipo", tipo);
                parr.putString("valor", dado);//pega onde eu coloca a seleção do spinner

                Intent it = new Intent(getBaseContext(),Dados.class);
                it.putExtras(parr);

                startActivity(it);
                finish();
            }
        });


        btnVoltar.setOnClickListener(new View.OnClickListener() {// depois do new clicamos ctrl space e ele mostra as opções
            @Override
            public void onClick(View view) {

                finish();
            }
        });


    }

}
