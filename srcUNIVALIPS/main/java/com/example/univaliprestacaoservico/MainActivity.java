package com.example.univaliprestacaoservico;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase bancoDeDados; // Para lembrar de inserir o banco de dados depois porque não manjo de B.D. haha :( .

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Este botão é para acessar a intent de Prestação de Serviço.*/
        Button botaoPS = findViewById(R.id.botaoPS);
        botaoPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PrestServicoActivity.class);
                startActivity(i);
            }
        });

        /* Apenas inseri este botão no aplicativo para seguir as instruções do trabalho.
        *  Também não fiz a implementação dos outros botões porque não ví muita necessidade
        *  no momento, se sobrar um tempo a gente usa esses botões para alguma outra função...
        *  O que esse botão faz:
        *  Ele imprimi um mensagem do tipo Toast indicando que o botão é só para teste.*/
        Button botaoServico01 = findViewById(R.id.botaoServico01);
        botaoServico01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Este botão é um teste...", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
