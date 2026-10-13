package com.example.turco;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class BancoHelper extends SQLiteOpenHelper {

    public BancoHelper(Context context) {
        super(context, "meuapp.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE usuarios (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "data TEXT, jogador1 TEXT, jogador2 TEXT," +
                " pontos1 INTEGER, pontos2 INTEGER, vencedor TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        onCreate(db);
    }

    public List<Historico> listarHistorico() {
        List<Historico> historicoList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM usuarios", null);

        try {
            while (cursor.moveToNext()) {
                String nome1 = cursor.getString(cursor.getColumnIndexOrThrow("jogador1"));
                String nome2 = cursor.getString(cursor.getColumnIndexOrThrow("jogador2"));
                String data = cursor.getString(cursor.getColumnIndexOrThrow("data"));
                String vencedor = cursor.getString(cursor.getColumnIndexOrThrow("vencedor"));
                int ponto1 = cursor.getInt(cursor.getColumnIndexOrThrow("pontos1"));
                int ponto2 = cursor.getInt(cursor.getColumnIndexOrThrow("pontos2"));

                Historico historico = new Historico(nome1, data, vencedor, ponto2, ponto1, nome2);

                historicoList.add(historico);
            }
        } finally {
            cursor.close();
        }

        return historicoList;
    }
}