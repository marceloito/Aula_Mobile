package br.com.dlweb.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        criarBDConsulta();

        Button clickAdicionar = findViewById(R.id.btnAdicionar);
        clickAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AdicionarAlunoActivity.class);
                startActivity(i);
            }
        });

        Button clickListar = findViewById(R.id.btnListar);
        clickListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ListarAlunoActivity.class);
                startActivity(i);
            }
        });
    }

    private void criarBDMedico () {
        db = openOrCreateDatabase("medicos.db", Context.MODE_PRIVATE, null);
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE IF NOT EXISTS medico (");
        sql.append("_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ");
        sql.append("nome VARCHAR(50), ");
        sql.append("crm VARCHAR(20), ");
        sql.append("logradouro VARCHAR(100), ");
        sql.append("numero MEDIUMINT(8), ");
        sql.append("cidade VARCHAR(30), ");
        sql.append("uf VARCHAR(20), ");
        sql.append("celular VARCHAR(20), ");
        sql.append("fixo VARCHAR(20)");
        sql.append(");");
        try {
            db.execSQL(sql.toString());
        } catch (SQLException e) {
            Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
        db.close();
    }

    private void criarBDPaciente () {
        db = openOrCreateDatabase("paciente.db", Context.MODE_PRIVATE, null);
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE IF NOT EXISTS paciente (");
        sql.append("_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ");
        sql.append("nome VARCHAR(50), ");
        sql.append("grp_sanguineo TINYINT(1), ");
        sql.append("logradouro VARCHAR(100), ");
        sql.append("numero MEDIUMINT(8), ");
        sql.append("cidade VARCHAR(30), ");
        sql.append("uf VARCHAR(2), ");
        sql.append("celular VARCHAR(20), ");
        sql.append("fixo VARCHAR(20)");
        sql.append(");");
        try {
            db.execSQL(sql.toString());
        } catch (SQLException e) {
            Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
        db.close();
    }

    private void criarBDConsulta () {
        db = openOrCreateDatabase("consulta.db", Context.MODE_PRIVATE, null);
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE TABLE IF NOT EXISTS paciente (");
        sql.append("_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ");
        sql.append("paciente_id INTEGER NOT NULL, ");
        sql.append("medico_id INTEGER NOT NULL, ");
        sql.append("data_hora_inicio DATETIME, ");
        sql.append("data_hora_fim DATETIME, ");
        sql.append("observacao VARCHAR(200), ");
        sql.append("FOREIGN KEY(paciente_id) REFERENCES paciente(id), ");
        sql.append("FOREIGN KEY(medico_id) REFERENCES medico(id)");
        sql.append(");");
        try {
            db.execSQL(sql.toString());
        } catch (SQLException e) {
            Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
        db.close();
    }

}
