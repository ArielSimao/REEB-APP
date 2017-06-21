package andre.reebvfatec;

import android.content.ContentValues;
import android.content.Context;

/**
 * Created by DjAriel on 21/06/17.
 */

public class ReceitaController extends DataBaseAdapter{

    // conecta camada de controle com camada de concistencia
    public ReceitaController(Context context) {
        super(context);
    }

    public boolean create(Receita receita){
        ContentValues values = new ContentValues();

                values.put("data", receita.edtLote);


                return true;
    }
}
