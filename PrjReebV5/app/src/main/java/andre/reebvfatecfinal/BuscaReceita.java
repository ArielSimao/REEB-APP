package andre.reebvfatecfinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BuscaReceita extends Activity {

    private Button btnData;
    private Button btnLote;
    private Button btnTipo;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca_receita);

        btnData = (Button) findViewById(R.id.btnData);
        btnLote = (Button) findViewById(R.id.btnLote);
        btnTipo = (Button) findViewById(R.id.btnTipo);
        btnVoltar = (Button) findViewById(R.id.btnVoltar);

        btnData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//declarando o metodo onClick
                Intent it = new Intent(getBaseContext(),RecebeData.class);

                startActivity(it);
            }
        });

        btnLote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//declarando o metodo onClick
                Intent it = new Intent(getBaseContext(),RecebeLote.class);
                Bundle parr = new Bundle();

                parr.putString("tipo","data");
                parr.putString("valor","edtData2");//pega onde eu coloca a seleção do spinner

                it.putExtras(parr);
                startActivity(it);
            }
        });

        btnTipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//declarando o metodo onClick
                Intent it = new Intent(getBaseContext(),RecebeTipo.class);
                Bundle parr = new Bundle();

                parr.putString("tipo","data");
                parr.putString("valor","edtData2");//pega onde eu coloca a seleção do spinner

                it.putExtras(parr);
                startActivity(it);
            }
        });


        btnVoltar.setOnClickListener(new View.OnClickListener() {// depois do new clicamos ctrl space e ele mostra as opções
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getBaseContext(), MainActivity.class);//volta para a tela Dados
                startActivity(it);
            }
        });
    }
}
