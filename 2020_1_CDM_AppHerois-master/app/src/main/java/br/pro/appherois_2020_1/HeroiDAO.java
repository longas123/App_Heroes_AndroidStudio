package br.pro.appherois_2020_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class HeroiDAO {


    public static void inserir(Context contex, Heroi heroi){
        Banco banco = new Banco(contex);

        ContentValues valores = new ContentValues();
        valores.put( "nome", heroi.getNome() );
        valores.put( "grupo", heroi.getGrupo() );

        SQLiteDatabase db = banco.getWritableDatabase();

        db.insert("herois", null, valores);
    }

    public static void editar(Context contex, Heroi heroi){
        Banco banco = new Banco(contex);

        ContentValues valores = new ContentValues();
        valores.put( "nome", heroi.getNome() );
        valores.put( "grupo", heroi.getGrupo() );

        SQLiteDatabase db = banco.getWritableDatabase();
        db.update("herois", valores, " id = "+ heroi.getId(), null);
    }

    public static void excluir(Context context, int idHeroi) {
        Banco banco = new Banco(context);

        SQLiteDatabase db = banco.getWritableDatabase();
        db.execSQL("DELETE FROM herois WHERE id = " + idHeroi);

     //   db.delete("herois", " id = " + idHeroi, null);
    }

    public static List<Heroi> listar(Context context){
        List<Heroi> lista = new ArrayList<Heroi>();

        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM herois ORDER BY nome", null);
        // id, nome, grupo
        if( cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do{
                Heroi heroi = new Heroi();
                heroi.setId( cursor.getInt(0) );
                heroi.setNome( cursor.getString(1) );
                heroi.setGrupo( cursor.getString(2) );
                lista.add( heroi );
            }while ( cursor.moveToNext() );
        }
        return lista;
    }

    public static Heroi getHeroiById(Context context, int idHeroi){
  //      List<Heroi> lista = new ArrayList<Heroi>();

        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM herois WHERE id = " + idHeroi, null);
        // id, nome, grupo
        if( cursor.getCount() > 0 ){
            cursor.moveToFirst();
       //     do{
            Heroi heroi = new Heroi();
            heroi.setId( cursor.getInt(0) );
            heroi.setNome( cursor.getString(1) );
            heroi.setGrupo( cursor.getString(2) );
       //         lista.add( heroi );
      //      }while ( cursor.moveToNext() );
            return heroi;
        }else {
            return null;
        }
    }



}

















