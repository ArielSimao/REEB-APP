package andre.reebvfatecfinal.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import andre.reebvfatecfinal.pojo.BeanIngrediente;
import andre.reebvfatecfinal.pojo.BeanReceita;


public class DAOIngrediente {
    private SQLiteDatabase banco;
    private GerenciaBanco gerenciaBanco;

    // Colunas
    public static final String ID_REC = "id_rec";
    public static final String NOME = "nome";
    public static final String QTD = "qtd";
    public static final String PCT = "porcentagem";

    public static final String[] todasAsColunas =
            {
                    NOME,QTD,PCT,ID_REC
            };
    public static final String TABELA_INGREDIENTE = "ingrediente";

    public DAOIngrediente(Context contexto)
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

    public void insere(BeanReceita rec, BeanIngrediente ing){

        ContentValues valores = new ContentValues();

        valores.put(NOME, ing.getNome());
        valores.put(QTD, ing.getQuantidade());
        valores.put(PCT, ing.getPorcentagem());
        valores.put(ID_REC, rec.getId());

        long vr = banco.insert(TABELA_INGREDIENTE, null, valores);
    }

    public void insere(BeanReceita rec, List<BeanIngrediente> ings){

        for (BeanIngrediente ing : ings) {
            insere(rec,ing);
        }
    }

    public List<BeanIngrediente> selectTodos(BeanReceita rec)
    {
        List<BeanIngrediente> itens = new ArrayList<BeanIngrediente>();
        Cursor cursor = banco.query(TABELA_INGREDIENTE,
                //inserir order by de acordo com o tipo que busca que desseja
                // data lote tipo

                todasAsColunas, null, null, null, null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast())
        {
            BeanIngrediente item = cursorToItem(cursor);
            itens.add(item);
            cursor.moveToNext();
        }
        cursor.close();
        return itens;
    }

    private BeanIngrediente cursorToItem(Cursor cursor)
    {
        BeanIngrediente item = new BeanIngrediente();

        item.setNome(cursor.getString(0));
        item.setQuantidade(cursor.getFloat(1));
        item.setPorcentagem(cursor.getFloat(2));
        item.setIdReceita(cursor.getInt(3));

        return item;
    }
}