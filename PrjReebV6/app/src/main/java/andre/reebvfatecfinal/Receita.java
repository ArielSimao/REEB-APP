package andre.reebvfatecfinal;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;

public class Receita extends Activity implements View.OnClickListener {

    public Button btnVoltar;
    public Button btnCalc;//Botão calcular faz o cálculo e vai para a outra activity
    public Button btnData;

    public TextView txtData;// variavel data
    public EditText edtLote;// variavel Lote de receita
    public Spinner spTipo; //variavel Tipo de cerveja que acumula a selecao
    public TextView tipoSpinner2; // variavel que recebe e mostra a selecao na outra tela
    private int Ano, Mes, Dia;



    public EditText edtIngred;//Entrada do Nome da primeira MP
    public EditText edtIngred1;
    public EditText edtIngred2;
    public EditText edtIngred3;
    public EditText edtIngred4;
    public EditText edtIngred5;
    public EditText edtIngred6;
    public EditText edtIngred7;
    public EditText edtIngred8;
    public EditText edtIngred9;


    public EditText edtQtd;//Entrada da Quantidade da primeira MP entrada em Kg
    public EditText edtQtd1;
    public EditText edtQtd2;
    public EditText edtQtd3;
    public EditText edtQtd4;
    public EditText edtQtd5;
    public EditText edtQtd6;
    public EditText edtQtd7;
    public EditText edtQtd8;
    public EditText edtQtd9;

    public TextView edtTotal;//soma total da MP entrada


    private TextView edtPorcentagem; // Resultado a ser passado para a tela calculo
    private TextView edtPorcentagem1;
    private TextView edtPorcentagem2;
    private TextView edtPorcentagem3;
    private TextView edtPorcentagem4;
    private TextView edtPorcentagem5;
    private TextView edtPorcentagem6;
    private TextView edtPorcentagem7;
    private TextView edtPorcentagem8;
    private TextView edtPorcentagem9;

    private TextView edtPorcentagemTotal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receita);

        btnData = (Button) findViewById(R.id.btnData);//declaracao do botao data
        txtData = (TextView) findViewById(R.id.txtData);//armazenamento da data - tipo texto
        edtLote =(EditText) findViewById(R.id.edtLote);


        edtIngred = (EditText) findViewById(R.id.edtIngred);//Nome MP
        edtIngred1 = (EditText) findViewById(R.id.edtIngred1);
        edtIngred2 = (EditText) findViewById(R.id.edtIngred2);
        edtIngred3 = (EditText) findViewById(R.id.edtIngred3);
        edtIngred4 = (EditText) findViewById(R.id.edtIngred4);
        edtIngred5 = (EditText) findViewById(R.id.edtIngred5);
        edtIngred6 = (EditText) findViewById(R.id.edtIngred6);
        edtIngred7 = (EditText) findViewById(R.id.edtIngred7);
        edtIngred8 = (EditText) findViewById(R.id.edtIngred8);
        edtIngred9 = (EditText) findViewById(R.id.edtIngred9);


        edtQtd = (EditText) findViewById(R.id.edtQtd);//Quantidade MP
        edtQtd1 = (EditText) findViewById(R.id.edtQtd1);
        edtQtd2 = (EditText) findViewById(R.id.edtQtd2);
        edtQtd3 = (EditText) findViewById(R.id.edtQtd3);
        edtQtd4 = (EditText) findViewById(R.id.edtQtd4);
        edtQtd5 = (EditText) findViewById(R.id.edtQtd5);
        edtQtd6 = (EditText) findViewById(R.id.edtQtd6);
        edtQtd7 = (EditText) findViewById(R.id.edtQtd7);
        edtQtd8 = (EditText) findViewById(R.id.edtQtd8);
        edtQtd9 = (EditText) findViewById(R.id.edtQtd9);



        edtPorcentagem = (TextView) findViewById(R.id.edtPorcentagem);//Valor Porcentagem MP
        edtPorcentagem1 = (TextView) findViewById(R.id.edtPorcentagem1);
        edtPorcentagem2 = (TextView) findViewById(R.id.edtPorcentagem2);
        edtPorcentagem3 = (TextView) findViewById(R.id.edtPorcentagem3);
        edtPorcentagem4 = (TextView) findViewById(R.id.edtPorcentagem4);
        edtPorcentagem5 = (TextView) findViewById(R.id.edtPorcentagem5);
        edtPorcentagem6 = (TextView) findViewById(R.id.edtPorcentagem6);
        edtPorcentagem7 = (TextView) findViewById(R.id.edtPorcentagem7);
        edtPorcentagem8 = (TextView) findViewById(R.id.edtPorcentagem8);
        edtPorcentagem9 = (TextView) findViewById(R.id.edtPorcentagem9);

        edtPorcentagemTotal = (TextView) findViewById(R.id.edtPorcentagemTotal);



        spTipo = (Spinner)
                findViewById(R.id.spTipo);//spinner que mostra a opções de tipo de cerveja
        tipoSpinner2 = (TextView)findViewById(R.id.tipoSpinner2);//variável que vai acumular e passar o valor para a outra activity


        btnData.setOnClickListener(this);//dando acao ao botao para abrir a data


        btnCalc=(Button)findViewById(R.id.btnCalc);//botao calcular chama a outra tela e faz o cálculo da %



        btnCalc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {




                Intent it = new Intent(Receita.this, Calculo.class);// intent que vai para a tela Cálculo
                Bundle parametros = new Bundle();//pacote onde eu vou colocar e passar as variáveis data e lote

                parametros.putString("data",txtData.getText().toString());

                parametros.putString("lote",edtLote.getText().toString());//tenho que por o txtData

                //parametros.putString("nome do parametro ou variável da outra activity que eu quero recuperar",variavel que eu quero passar para a outra tela.getText().toString());

                String item = spTipo.getSelectedItem().toString();

                parametros.putString("tipo",item);

                parametros.putString("ingred-0",edtIngred.getText().toString());
                parametros.putString("ingred-1",edtIngred1.getText().toString());
                parametros.putString("ingred-2",edtIngred2.getText().toString());
                parametros.putString("ingred-3",edtIngred3.getText().toString());
                parametros.putString("ingred-4",edtIngred4.getText().toString());
                parametros.putString("ingred-5",edtIngred5.getText().toString());
                parametros.putString("ingred-6",edtIngred6.getText().toString());
                parametros.putString("ingred-7",edtIngred7.getText().toString());
                parametros.putString("ingred-8",edtIngred8.getText().toString());
                parametros.putString("ingred-9",edtIngred9.getText().toString());


                parametros.putString("qtd-0",edtQtd.getText().toString());
                parametros.putString("qtd-1",edtQtd1.getText().toString());
                parametros.putString("qtd-2",edtQtd2.getText().toString());
                parametros.putString("qtd-3",edtQtd3.getText().toString());
                parametros.putString("qtd-4",edtQtd4.getText().toString());
                parametros.putString("qtd-5",edtQtd5.getText().toString());
                parametros.putString("qtd-6",edtQtd6.getText().toString());
                parametros.putString("qtd-7",edtQtd7.getText().toString());
                parametros.putString("qtd-8",edtQtd8.getText().toString());
                parametros.putString("qtd-9",edtQtd9.getText().toString());



               // parametros.putString("edtPorcentagem", edtPorcentagem.);
                


                it.putExtras(parametros);

                startActivity(it);

            };

        });


        ArrayAdapter adapter =
                ArrayAdapter.createFromResource(this,
                        R.array.estilos,
                        android.R.layout.simple_dropdown_item_1line);// O array esta em strings.xml

        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        spTipo.setAdapter(adapter);


        AdapterView.OnItemSelectedListener escolha = new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                /*
                String texto;
                texto = spTipo.getSelectedItem().toString();
                int a;
                a = spTipo.getSelectedItemPosition();
                   */
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }

        };

        spTipo.setOnItemSelectedListener(escolha);


        btnVoltar=(Button)findViewById(R.id.btnVoltar); //Temos que trazer as views que fazem o movimento, no caso os botões

        btnVoltar.setOnClickListener(new View.OnClickListener() {// depois do new clicamos ctrl space e ele mostra as opções
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getBaseContext(), MainActivity.class);//volta para a tela Menu
                startActivity(it);
            }
        });

    };


    @Override
    public void onClick(View v) {
        if (v == btnData) {
            final Calendar c = Calendar.getInstance();//instancia  de calendar
            Dia = c.get(Calendar.DAY_OF_MONTH);
            Mes = c.get(Calendar.MONTH);
            Ano = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int YEAR, int MONTH, int DAY_OF_MONTH){
                    txtData.setText(DAY_OF_MONTH + "/" + (MONTH+1) + "/" + YEAR);
                }
            }

                    , Dia, Mes, Ano);

            datePickerDialog.show();

        };

    }



}
