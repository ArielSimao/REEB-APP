package andre.reebvfatec;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;

public class Dados extends Activity {

    private ListView lstDados;
    private List<BeanDados>listDados = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);



    }
}
