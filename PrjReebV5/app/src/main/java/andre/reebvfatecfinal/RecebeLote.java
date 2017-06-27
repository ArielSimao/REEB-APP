package andre.reebvfatecfinal;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RecebeLote extends Activity {


    public Button btnVoltar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recebelote);


        btnVoltar=(Button)findViewById(R.id.btnVoltar);


        btnVoltar.setOnClickListener(new View.OnClickListener() {// depois do new clicamos ctrl space e ele mostra as opções
            @Override
            public void onClick(View view) {

                finish();
            }
        });

    }

}
