package andre.reebvfatec;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DjAriel on 21/06/17.
 */

public class DataBaseAdapter extends SQLiteOpenHelper{

    private  static final int DATABASE_VERSION = 1; //versao do banco de dados
    protected static final String DATABASE_NAME = "REEB.DB"; //nome do banco de dados



    public DataBaseAdapter(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) { //comando em puro sql para criar a tabela

        String sql = " CREATE TABLE receita " +
                        "( data TEXT, " +
                        "lote TEXT, " +
                        "tipo TEXT, " +
                        "i0 TEXT, " +
                        "q0 TEXT, " +
                        "p0 TEXT, " +
                        "i1 TEXT, " +
                        "q1 TEXT, " +
                        "p1 TEXT, " +
                        "i2 TEXT, " +
                        "q2 TEXT, " +
                        "p2 TEXT, " +
                        "i3 TEXT, " +
                        "q3 TEXT, " +
                        "p3 TEXT, " +
                        "i4 TEXT, " +
                        "q4 TEXT, " +
                        "p4 TEXT, " +
                        "i5 TEXT, " +
                        "q5 TEXT, " +
                        "p5 TEXT, " +
                        "i6 TEXT, " +
                        "q6 TEXT, " +
                        "p6 TEXT, " +
                        "i7 TEXT, " +
                        "q7 TEXT, " +
                        "p7 TEXT, " +
                        "i8 TEXT, " +
                        "q8 TEXT, " +
                        "p8 TEXT, " +
                        "i9 TEXT, " +
                        "q9 TEXT, " +
                        "p9 TEXT, " +
                        "total TEXT) ";

        sqLiteDatabase.execSQL(sql); //executa o comando sql

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    //verifica se a auteracoes na tabela, se sim dela e cria novammente
        String sql = "DROP TABLE IF EXISTS receita";
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);

    }
}
