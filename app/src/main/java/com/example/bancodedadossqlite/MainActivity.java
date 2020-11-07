package com.example.bancodedadossqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            //Criar banco de dados
            SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

            //criar tabela
//            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas (id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3))");

//            bancoDados.execSQL("DROP TABLE pessoas");

            //Inserir dados
//            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Mario', 40)");
//            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Pedro', 50)");

//              bancoDados.execSQL("UPDATE pessoas SET idade = 19, nome = 'Mariana Silva' where nome = 'Mariana'");
            bancoDados.execSQL("DELETE FROM pessoas");

            //Recuperar pessoas
//            String consulta = "SELECT nome, idade FROM pessoas " +
//                    "WHERE nome = 'Mariana' AND idade = 18";

//            String consulta = "SELECT nome, idade FROM pessoas " +
//                    "WHERE idade >= 32";

//            String consulta = "SELECT nome, idade FROM pessoas " +
//                    "WHERE idade IN(18,32)";

//            String consulta = "SELECT nome, idade FROM pessoas " +
//                    "WHERE idade BETWEEN 18 AND 26";

//            String filtro = 'mar';
//            String consulta = "SELECT nome, idade FROM pessoas " +
//                    "WHERE nome LIKE '%'" + filtro + "'%'";

//            String consulta = "SELECT nome, idade FROM pessoas " +
//                    "WHERE  1=1 order by idade ASC LIMIT 3";

            String consulta = "SELECT id, nome, idade FROM pessoas " +
                    "WHERE  1=1 order by idade ";


            Cursor cursor = bancoDados.rawQuery(consulta, null);

            //indices da tebela
            int indiceId = cursor.getColumnIndex("id");
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();
            while (cursor != null) {

                String id = cursor.getString(indiceId);
                String nome = cursor.getString(indiceNome);
                String idade = cursor.getString(indiceIdade);

                Log.i("RESULTADO - id ", id + " NOME:  " +  nome + " IDADE:  " + idade);
                cursor.moveToNext();
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}