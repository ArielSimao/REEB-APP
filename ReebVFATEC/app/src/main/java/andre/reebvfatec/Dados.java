package andre.reebvfatec;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import andre.reebvfatec.pojo.BeanReceita;

public class Dados extends Activity {


    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);

        btnVoltar=(Button)findViewById(R.id.btnVoltar); //Temos que trazer as views que fazem o movimento, no caso os botões

        btnVoltar.setOnClickListener(new View.OnClickListener() {// depois do new clicamos ctrl space e ele mostra as opções
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getBaseContext(), MainActivity.class);//volta para a tela Menu
                startActivity(it);
            }
        });

    }
}
