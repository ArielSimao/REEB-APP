package andre.reebvfatecfinal.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class GerenciaBanco extends SQLiteOpenHelper {
    // dados do banco
    private static final String NOME_BANCO = "db_reeb";
    private static final int VERSAO_BANCO = 1;

    // tabelas
    private static final String TB_RECEITA =
            "CREATE TABLE receita ( " +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "date TEXT, " +
                    "lote TEXT, " +
                    "tipo TEXT " +
                    ");";
    private static final String TB_INGREDIENTE =
            "CREATE TABLE ingrediente ( " +
                    "nome TEXT , " +
                    "qtd REAL, " +
                    "porcentagem REAL, " +
                    "id_rec INTEGER REFERENCES receita(id)" +
                    ");";


    public GerenciaBanco(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // criação do banco
        db.execSQL(TB_RECEITA);
        db.execSQL(TB_INGREDIENTE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Setup inicial do banco. Ignorando upgrade
    }

}
