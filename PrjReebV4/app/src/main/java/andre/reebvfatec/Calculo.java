package andre.reebvfatec;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calculo extends Activity {

    public TextView edtLote;
    public TextView edtData2;
    public TextView tipoSpinner2;//variavel Tipo de cerveja escolhido

    public TextView tipo;

    public TextView edtIngred;
    public TextView edtIngred1;
    public TextView edtIngred2;
    public TextView edtIngred3;
    public TextView edtIngred4;
    public TextView edtIngred5;
    public TextView edtIngred6;
    public TextView edtIngred7;
    public TextView edtIngred8;
    public TextView edtIngred9;


    public TextView edtQtd;
    public TextView edtQtd1;
    public TextView edtQtd2;
    public TextView edtQtd3;
    public TextView edtQtd4;
    public TextView edtQtd5;
    public TextView edtQtd6;
    public TextView edtQtd7;
    public TextView edtQtd8;
    public TextView edtQtd9;

    public TextView somaTotal;


    private TextView edtPorcentagem0;
    private TextView edtPorcentagem1;
    private TextView edtPorcentagem2;
    private TextView edtPorcentagem3;
    private TextView edtPorcentagem4;
    private TextView edtPorcentagem5;
    private TextView edtPorcentagem6;
    private TextView edtPorcentagem7;
    private TextView edtPorcentagem8;
    private TextView edtPorcentagem9;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);



        edtData2 = (TextView) findViewById(R.id.edtData2);
        edtLote = (TextView) findViewById(R.id.edtLote);
        tipoSpinner2 = (TextView) findViewById(R.id.tipoSpinner2);


        edtIngred = (TextView) findViewById(R.id.edtIngred);
        edtIngred1 = (TextView) findViewById(R.id.edtIngred1);
        edtIngred2 = (TextView) findViewById(R.id.edtIngred2);
        edtIngred3 = (TextView) findViewById(R.id.edtIngred3);
        edtIngred4 = (TextView) findViewById(R.id.edtIngred4);
        edtIngred5 = (TextView) findViewById(R.id.edtIngred5);
        edtIngred6 = (TextView) findViewById(R.id.edtIngred6);
        edtIngred7 = (TextView) findViewById(R.id.edtIngred7);
        edtIngred8 = (TextView) findViewById(R.id.edtIngred8);
        edtIngred9 = (TextView) findViewById(R.id.edtIngred9);


        edtQtd = (TextView) findViewById(R.id.edtQtd);
        edtQtd1 = (TextView) findViewById(R.id.edtQtd1);
        edtQtd2 = (TextView) findViewById(R.id.edtQtd2);
        edtQtd3 = (TextView) findViewById(R.id.edtQtd3);
        edtQtd4 = (TextView) findViewById(R.id.edtQtd4);
        edtQtd5 = (TextView) findViewById(R.id.edtQtd5);
        edtQtd6 = (TextView) findViewById(R.id.edtQtd6);
        edtQtd7 = (TextView) findViewById(R.id.edtQtd7);
        edtQtd8 = (TextView) findViewById(R.id.edtQtd8);
        edtQtd9 = (TextView) findViewById(R.id.edtQtd9);


        edtPorcentagem0 = (TextView) findViewById(R.id.edtPorcentagem);
        edtPorcentagem1 = (TextView) findViewById(R.id.edtPorcentagem1);
        edtPorcentagem2 = (TextView) findViewById(R.id.edtPorcentagem2);
        edtPorcentagem3 = (TextView) findViewById(R.id.edtPorcentagem3);
        edtPorcentagem4 = (TextView) findViewById(R.id.edtPorcentagem4);
        edtPorcentagem5 = (TextView) findViewById(R.id.edtPorcentagem5);
        edtPorcentagem6 = (TextView) findViewById(R.id.edtPorcentagem6);
        edtPorcentagem7 = (TextView) findViewById(R.id.edtPorcentagem7);
        edtPorcentagem8 = (TextView) findViewById(R.id.edtPorcentagem8);
        edtPorcentagem9 = (TextView) findViewById(R.id.edtPorcentagem9);

        somaTotal = (TextView) findViewById(R.id.qtdTotal);


        Intent it= getIntent();
        Bundle parametros = it.getExtras();

        if(parametros !=null) {


            double Valor = Double.parseDouble(parametros.getString("edtQtd"));
            double Valor1 = Double.parseDouble(parametros.getString("edtQtd1"));
            double Valor2 = Double.parseDouble(parametros.getString("edtQtd2"));
            double Valor3 = Double.parseDouble(parametros.getString("edtQtd3"));
            double Valor4 = Double.parseDouble(parametros.getString("edtQtd4"));
            double Valor5 = Double.parseDouble(parametros.getString("edtQtd5"));
            double Valor6 = Double.parseDouble(parametros.getString("edtQtd6"));
            double Valor7 = Double.parseDouble(parametros.getString("edtQtd7"));
            double Valor8 = Double.parseDouble(parametros.getString("edtQtd8"));
            double Valor9 = Double.parseDouble(parametros.getString("edtQtd9"));

            double total = (Valor + Valor1 + Valor2 + Valor3 + Valor4 + Valor5 + Valor6 + Valor7 + Valor8 + Valor9);


            double porcentagem0 = ((Valor * 100)/total);
            double porcentagem1 = ((Valor1 * 100)/total);
            double porcentagem2 = ((Valor2 * 100)/total);
            double porcentagem3 = ((Valor3 * 100)/total);
            double porcentagem4 = ((Valor4 * 100)/total);
            double porcentagem5 = ((Valor5 * 100)/total);
            double porcentagem6 = ((Valor6 * 100)/total);
            double porcentagem7 = ((Valor7 * 100)/total);
            double porcentagem8 = ((Valor8 * 100)/total);
            double porcentagem9 = ((Valor9 * 100)/total);


            somaTotal.setText(String.valueOf(total));

            edtPorcentagem0.setText(String.format("%.2f",porcentagem0));
            edtPorcentagem1.setText(String.format("%.2f",porcentagem1));
            edtPorcentagem2.setText(String.format("%.2f",porcentagem2));
            edtPorcentagem3.setText(String.format("%.2f",porcentagem3));
            edtPorcentagem4.setText(String.format("%.2f",porcentagem4));
            edtPorcentagem5.setText(String.format("%.2f",porcentagem5));
            edtPorcentagem6.setText(String.format("%.2f",porcentagem6));
            edtPorcentagem7.setText(String.format("%.2f",porcentagem7));
            edtPorcentagem8.setText(String.format("%.2f",porcentagem8));
            edtPorcentagem9.setText(String.format("%.2f",porcentagem9));




            edtData2.setText(parametros.getString("edtData2"));

            String j = (String) parametros.get("edtLote");//uso o getString porque é um texto

            edtLote.setText(j);

            String l = (String) parametros.get("tipoSpinner");//uso o getString porque é um texto

            tipoSpinner2.setText(l);



            String a = (String) parametros.get("edtIngred");
            edtIngred.setText(a);

            String b = (String) parametros.get("edtIngred1");
            edtIngred1.setText(b);

            String c = (String) parametros.get("edtIngred2");
            edtIngred2.setText(c);

            String d = (String) parametros.get("edtIngred3");
            edtIngred3.setText(d);

            String e = (String) parametros.get("edtIngred4");
            edtIngred4.setText(e);

            String f = (String) parametros.get("edtIngred5");
            edtIngred5.setText(f);

            String g = (String) parametros.get("edtIngred6");
            edtIngred6.setText(g);

            String h = (String) parametros.get("edtIngred7");
            edtIngred7.setText(h);

            String i = (String) parametros.get("edtIngred8");
            edtIngred8.setText(i);

            String m = (String) parametros.get("edtIngred9");
            edtIngred9.setText(m);




            String aa =(String)parametros.get("edtQtd");
            edtQtd.setText(aa);

            String bb =(String)parametros.get("edtQtd1");
            edtQtd1.setText(bb);

            String cc =(String)parametros.get("edtQtd2");
            edtQtd2.setText(cc);

            String dd =(String)parametros.get("edtQtd3");
            edtQtd3.setText(dd);

            String ee =(String)parametros.get("edtQtd4");
            edtQtd4.setText(ee);

            String ff =(String)parametros.get("edtQtd5");
            edtQtd5.setText(ff);

            String gg =(String)parametros.get("edtQtd6");
            edtQtd6.setText(gg);

            String hh =(String)parametros.get("edtQtd7");
            edtQtd7.setText(hh);

            String ii =(String)parametros.get("edtQtd8");
            edtQtd8.setText(ii);

            String jj =(String)parametros.get("edtQtd9");
            edtQtd9.setText(jj);



        }else{

            Toast.makeText(getBaseContext(),"Entre com um valor válido", Toast.LENGTH_LONG).show();
        }

    }

}

