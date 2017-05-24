package andre.prjreebv3;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BuscaProcessosLote extends Activity {

    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca_processos_lote);

        btnVoltar = (Button) findViewById(R.id.btnVoltar);




        btnVoltar.setOnClickListener(new View.OnClickListener() {// depois do new clicamos ctrl space e ele mostra as opções
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getBaseContext(),BuscaProcessos.class);//volta para a tela Busca Receitas
                startActivity(it);
            }
        });

    }
}
