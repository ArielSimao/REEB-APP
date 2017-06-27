package andre.reebvfatecfinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import andre.reebvfatecfinal.banco.DAOReceita;
import andre.reebvfatecfinal.pojo.BeanReceita;
import andre.reebvfatecfinal.view.ReceitaAdapter;

public class Dados extends Activity {


    private Button btnVoltar;
    private ListView lstDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);

        btnVoltar = (Button)findViewById(R.id.btnVoltar); //Temos que trazer as views que fazem o movimento, no caso os botões
        lstDados = (ListView) findViewById(R.id.lstDados);

        Intent it = getIntent();

        Bundle params = it.getExtras();

        String tipo = params.getString("tipo");
        String valor = params.getString("valor");

        DAOReceita dr = new DAOReceita(getBaseContext());
        dr.open();

        List<BeanReceita> receitas = null;
        if(tipo.equals("data")){
            receitas = dr.selectTodosPorData(valor);
        }else if(tipo.equals("lote")){
            receitas = dr.selectTodosPorLote(valor);
        }
        else if(tipo.equals("tipo")){
            receitas = dr.selectTodosPorTipo(valor);
        }

        dr.close();

        if(receitas == null)
        {
            finish();
        }


        lstDados.setAdapter(new ReceitaAdapter(this, receitas));

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
}

