package com.example.trabalho04;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;


public class ListarMedicoActivity extends AppCompatActivity {
    SQLiteDatabase db;
    ListView lvMedicos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_medico); // ?
    }

    private void listarConsultas () {
        db = openOrCreateDatabase("medico.db", Context.MODE_PRIVATE, null);
        db.close();
    }
}

