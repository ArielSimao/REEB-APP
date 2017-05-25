package andre.prjreebv3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DjAriel on 24/05/17.
 */

public class DataBaseAdapter extends SQLiteOpenHelper{

    private static final int DATABES_VERSION = 1;
    protected static final  String DATABASE_NAME = "REEB.DB";
    public DataBaseAdapter(Context context,) {
        super(context, DATABASE_NAME, null, DATABES_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sql = " CREATE TABLE receitas" + "(data DATE"+"lote VARCHAR(10))";

        db.execSQl(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

            String sql = "DROP TABLE IF EXISTS receitas";
            db.execSQl(sql);
            onCreate(db);
    }
}
