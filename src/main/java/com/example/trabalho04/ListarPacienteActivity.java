package com.example.trabalho04;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;


public class ListarPacienteActivity extends AppCompatActivity {
    SQLiteDatabase db;
    ListView lvPaciente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_paciente); // ?
    }

    private void listarConsultas () {
        db = openOrCreateDatabase("paciente.db", Context.MODE_PRIVATE, null);
        db.close();
    }
}
