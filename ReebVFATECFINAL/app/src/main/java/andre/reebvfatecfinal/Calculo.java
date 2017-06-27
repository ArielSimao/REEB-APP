package andre.reebvfatecfinal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import andre.reebvfatecfinal.banco.DAOIngrediente;
import andre.reebvfatecfinal.banco.DAOReceita;
import andre.reebvfatecfinal.pojo.BeanIngrediente;
import andre.reebvfatecfinal.pojo.BeanReceita;

public class Calculo extends Activity {

    public TextView edtLote;
    public TextView edtData2;
    public TextView tipoSpinner2;//variavel Tipo de cerveja escolhido



    public Button btnSalvar;


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


    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);



        edtData2 = (TextView) findViewById(R.id.edtData2);
        edtLote = (TextView) findViewById(R.id.edtLote);
        tipoSpinner2 = (TextView) findViewById(R.id.tipoSpinner2);



        btnSalvar = (Button) findViewById(R.id.btnSalvar);





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
        final Bundle parametros = it.getExtras();

        if(parametros !=null) {


            double Valor = Double.parseDouble(parametros.getString("qtd-0"));
            double Valor1 = Double.parseDouble(parametros.getString("qtd-1"));
            double Valor2 = Double.parseDouble(parametros.getString("qtd-2"));
            double Valor3 = Double.parseDouble(parametros.getString("qtd-3"));
            double Valor4 = Double.parseDouble(parametros.getString("qtd-4"));
            double Valor5 = Double.parseDouble(parametros.getString("qtd-5"));
            double Valor6 = Double.parseDouble(parametros.getString("qtd-6"));
            double Valor7 = Double.parseDouble(parametros.getString("qtd-7"));
            double Valor8 = Double.parseDouble(parametros.getString("qtd-8"));
            double Valor9 = Double.parseDouble(parametros.getString("qtd-9"));

            final double total = (Valor + Valor1 + Valor2 + Valor3 + Valor4 + Valor5 + Valor6 + Valor7 + Valor8 + Valor9);


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


            final Context self = this;


            btnSalvar.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {



                    DAOReceita dr  = new DAOReceita(self);
                    dr.open();

                    DAOIngrediente di = new DAOIngrediente(self);
                    di.open();

                    BeanReceita rec = new BeanReceita();
                    rec.setData(parametros.getString("data"));
                    rec.setLote(parametros.getString("lote"));
                    rec.setTipo(parametros.getString("tipo"));

                    rec = dr.insert(rec);






                    for (int i = 0; i < 10; i++) {
                        BeanIngrediente ing = new BeanIngrediente();

                        ing.setIdReceita(rec.getId());
                        ing.setNome(parametros.getString("ingred-"+i));
                        ing.setQuantidade(Float.valueOf(parametros.getString("qtd-"+i)));
                        float pct = (ing.getQuantidade()*100f) / (float)total;
                        ing.setPorcentagem(pct);

                        di.insere(rec, ing);
                    }

                    dr.close();
                    di.close();
                    finish();

                }
            });


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




            edtData2.setText(parametros.getString("data"));

            String j = (String) parametros.get("lote");//uso o getString porque é um texto

            edtLote.setText(j);

            String l = (String) parametros.get("tipo");//uso o getString porque é um texto

            tipoSpinner2.setText(l);



            String a = (String) parametros.get("ingred-0");
            edtIngred.setText(a);

            String b = (String) parametros.get("ingred-1");
            edtIngred1.setText(b);

            String c = (String) parametros.get("ingred-2");
            edtIngred2.setText(c);

            String d = (String) parametros.get("ingred-3");
            edtIngred3.setText(d);

            String e = (String) parametros.get("ingred-4");
            edtIngred4.setText(e);

            String f = (String) parametros.get("ingred-5");
            edtIngred5.setText(f);

            String g = (String) parametros.get("ingred-6");
            edtIngred6.setText(g);

            String h = (String) parametros.get("ingred-7");
            edtIngred7.setText(h);

            String i = (String) parametros.get("ingred-8");
            edtIngred8.setText(i);

            String m = (String) parametros.get("ingred-9");
            edtIngred9.setText(m);




            String aa =(String)parametros.get("qtd-0");
            edtQtd.setText(aa);

            String bb =(String)parametros.get("qtd-1");
            edtQtd1.setText(bb);

            String cc =(String)parametros.get("qtd-2");
            edtQtd2.setText(cc);

            String dd =(String)parametros.get("qtd-3");
            edtQtd3.setText(dd);

            String ee =(String)parametros.get("qtd-4");
            edtQtd4.setText(ee);

            String ff =(String)parametros.get("qtd-5");
            edtQtd5.setText(ff);

            String gg =(String)parametros.get("qtd-6");
            edtQtd6.setText(gg);

            String hh =(String)parametros.get("qtd-7");
            edtQtd7.setText(hh);

            String ii =(String)parametros.get("qtd-8");
            edtQtd8.setText(ii);

            String jj =(String)parametros.get("qtd-9");
            edtQtd9.setText(jj);



        }else{

            Toast.makeText(getBaseContext(),"Entre com um valor válido", Toast.LENGTH_LONG).show();
        }



        btnVoltar = (Button) findViewById(R.id.btnVoltar);  //Temos que trazer as views que fazem o movimento, no caso os botões



        btnVoltar.setOnClickListener(new View.OnClickListener() {// depois do new clicamos ctrl space e ele mostra as opções
            @Override
            public void onClick(View view) {


                finish();
            }
        });


    }

}

