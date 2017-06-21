package andre.reebvfatec;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button btnRec;
    private Button btnDados;
    private static Button btnSair;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnRec = (Button) findViewById(R.id.btnRec);//botão receita encontrado via id
        btnSair = (Button) findViewById(R.id.btnSair);
        btnDados = (Button) findViewById(R.id.btnDados);


        btnRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//declarando o metodo onClick
                Intent it = new Intent(getBaseContext(), Receita.class);
                startActivity(it);
            }
        });


        /*
        btnDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getBaseContext(),Dados.class);
                startActivity(it);
            }
        });

        */


        btnSair.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
                a_builder.setMessage("Tem certeza que deseja sair do REEB ??")
                        .setCancelable(false)
                        .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = a_builder.create();
                alert.setTitle("Atenção !!!");
                alert.show();
            }

        });

    }
}
