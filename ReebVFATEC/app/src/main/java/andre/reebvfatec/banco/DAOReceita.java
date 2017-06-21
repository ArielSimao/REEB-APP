package andre.reebvfatec.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import andre.reebvfatec.pojo.BeanReceita;

/**
 * Created by DjAriel on 21/06/17.
 */

public class DAOReceita {
    private SQLiteDatabase banco;
    private GerenciaBanco gerenciaBanco;

    // Colunas
    public static final String DATA = "data";
    public static final String LOTE = "lote";
    public static final String TIPO = "tipo";

    public static final String[] todasAsColunas =
            {
                    DATA, LOTE, TIPO
            };

    // Tabela
    public static final String TABELA_RECEITA = "receita";

    public DAOReceita(Context contexto)
    {
        gerenciaBanco = new GerenciaBanco(contexto);
    }

    public void open() throws SQLException
    {
        banco = gerenciaBanco.getWritableDatabase();
    }

    public void close()
    {
        gerenciaBanco.close();
    }

    public void insert(BeanReceita item)
    {
        ContentValues valores = new ContentValues();
        valores.put(DATA, item.getData());
        valores.put(LOTE, item.getLote());
        valores.put(TIPO, item.getTipo());


        banco.insert(TABELA_RECEITA, null, valores);
    }

    public void update(BeanReceita item)
    {
        ContentValues valores = new ContentValues();

        valores.put(DATA, item.getData());
        valores.put(LOTE, item.getLote());
        valores.put(TIPO, item.getTipo());

        banco.update(TABELA_RECEITA, valores, DATA + " = " + item.getData(), null);
    }


    public List<BeanReceita> selectTodos()
    {
        List<BeanReceita> itens = new ArrayList<BeanReceita>();
        Cursor cursor = banco.query(TABELA_RECEITA,
                todasAsColunas, null, null, null, null, DATA);
        cursor.moveToFirst();
        while(!cursor.isAfterLast())
        {
            BeanReceita item = cursorToItem(cursor);
            itens.add(item);
            cursor.moveToNext();
        }
        cursor.close();
        return itens;
    }

    public BeanReceita selectUm(BeanReceita item)
    {
        Cursor cursor = banco.query(
                TABELA_RECEITA,
                todasAsColunas,
                DATA + " = " + item.getData(),
                null, null, null, null);
        cursor.moveToFirst();
        return cursorToItem(cursor);
    }

    private BeanReceita cursorToItem(Cursor cursor)
    {
        BeanReceita item = new BeanReceita();

        item.setData(cursor.getString(0));
        item.setLote(cursor.getString(1));
        item.setTipo(cursor.getString(2));

        return item;
    }
}
