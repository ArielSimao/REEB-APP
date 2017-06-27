package andre.reebvfatecfinal.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import andre.reebvfatecfinal.RecebeData;
import andre.reebvfatecfinal.pojo.BeanReceita;


public class DAOReceita {
    private SQLiteDatabase banco;
    private GerenciaBanco gerenciaBanco;

    // Colunas
    public static final String ID = "id";
    public static final String DATA = "date";
    public static final String LOTE = "lote";
    public static final String TIPO = "tipo";

    public static final String[] todasAsColunas =
            {
                    ID, DATA, LOTE, TIPO
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

    public BeanReceita insert(BeanReceita item)
    {
        ContentValues valores = new ContentValues();
        valores.put(DATA, item.getData());
        valores.put(LOTE, item.getLote());
        valores.put(TIPO, item.getTipo());

        long vr = banco.insert(TABELA_RECEITA, null, valores);

        //List<BeanReceita> brs = this.selectTodos();

        Cursor c = banco.query(TABELA_RECEITA, todasAsColunas, "id = " + vr, null,null,null,null);
        c.moveToFirst();
        BeanReceita rec = cursorToItem(c);
        c.close();

        return rec;
    }

    public void update(BeanReceita item)
    {
        ContentValues valores = new ContentValues();

        valores.put(DATA, item.getData());
        valores.put(LOTE, item.getLote());
        valores.put(TIPO, item.getTipo());

        banco.update(TABELA_RECEITA, valores, ID + " = " + item.getId(), null );
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

    public List<BeanReceita> selectTodosPorData(String data)
    {
        List<BeanReceita> itens = new ArrayList<BeanReceita>();
        Cursor cursor = banco.query(
                TABELA_RECEITA,
                todasAsColunas,
                DATA + " = ?",
                new String[] {data},
                null, null, null);
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


    public List<BeanReceita> selectTodosPorLote(String lote) {
        List<BeanReceita> itens = new ArrayList<BeanReceita>();
        Cursor cursor = banco.query(
                TABELA_RECEITA,
                todasAsColunas,
                LOTE + " = ?",
                new String[] {lote},
                null, null, null);
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

    public List<BeanReceita> selectTodosPorTipo(String tipo) {
        List<BeanReceita> itens = new ArrayList<BeanReceita>();
        Cursor cursor = banco.query(
                TABELA_RECEITA,
                todasAsColunas,
                TIPO + " = ?",
                new String[] {tipo},
                null, null, null);
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


    //Agrupando as datas que são iguais
    public List<String> selectTodasDatas(){

        List<String> itens = new ArrayList<String>();
        Cursor cursor = banco.query(
                TABELA_RECEITA,
                new String[]{DATA},
                null,null,DATA,null,null
        );
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){//mostrando as datas selecionadas na tela

            itens.add(cursor.getString(0));
            cursor.moveToNext();
        }

        cursor.close();
        return itens;
    }

    //lista lotes
    public List<String> selectTodosLotes(){

        List<String> itens = new ArrayList<String>();
        Cursor cursor = banco.query(
                TABELA_RECEITA,
                new String[]{LOTE},
                null,null,null,null,null
        );
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){//mostrando as datas selecionadas na tela

            itens.add(cursor.getString(0));
            cursor.moveToNext();
        }

        cursor.close();
        return itens;
    }

    //Agrupando os tipos que são iguais
    public List<String> selectTodosTipos(){

        List<String> itens = new ArrayList<String>();
        Cursor cursor = banco.query(
                TABELA_RECEITA,
                new String[]{TIPO},
                null,null,TIPO,null,null
        );
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){//mostrando as datas selecionadas na tela

            itens.add(cursor.getString(0));
            cursor.moveToNext();
        }

        cursor.close();
        return itens;
    }

    private BeanReceita cursorToItem(Cursor cursor)
    {
        BeanReceita item = new BeanReceita();


        item.setId(cursor.getInt(0));
        item.setData(cursor.getString(1));
        item.setLote(cursor.getString(2));
        item.setTipo(cursor.getString(3));

        return item;
    }


}
