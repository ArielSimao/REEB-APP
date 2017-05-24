package andre.prjreebv3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Receita extends Activity {

    private Button btnVoltar;

    Spinner sistema;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receita);


        btnVoltar = (Button) findViewById(R.id.btnVoltar);  //Temos que trazer as views que fazem o movimento, no caso os botões



        btnVoltar.setOnClickListener(new View.OnClickListener() {// depois do new clicamos ctrl space e ele mostra as opções
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getBaseContext(), Menu.class);//volta para a tela Menu
                startActivity(it);


            }
        });

        sistema = (Spinner) findViewById(R.id.Spinner1);//criando uma caixa de opcoes

        ArrayAdapter adapter = ArrayAdapter.createFromResource(//jogando dendro de um Array estilos de cervejas
                this, R.array.estilos, android.R.layout.simple_dropdown_item_1line);// O array esta em strings.xml
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        sistema.setAdapter(adapter);
    }

    ;

}

