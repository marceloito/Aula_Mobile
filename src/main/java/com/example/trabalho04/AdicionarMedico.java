package com.example.trabalho04;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


class AdicionarMedico extends AppCompatActivity {
    SQLiteDatabase db;
    EditText etNome;
    EditText etCRM;
    EditText etLogradouro;
    EditText etNumero;
    EditText etCidade;
    Spinner spUF;
    EditText etCelular;
    EditText etFixo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_medico); // porque não funciona?

        etNome = findViewById(R.id.etNomeMedico);
        etCRM = findViewById(R.id.etCRM);
        etLogradouro = findViewById(R.id.etLogradouroMed);
        etNumero = findViewById(R.id.etNumeroMed);
        etCidade = findViewById(R.id.etCidadeMed);
        spUF = findViewById(R.id.spUfMed);
        etCelular = findViewById(R.id.etCelularMed);
        etFixo = findViewById(R.id.etFixoMed);

        String[] spUFmed = new String[]{
                "Selecione UF: ",
                "AC", "AL", "AM",
                "AP", "BA", "CE", "DF", "ES",
                "GO", "MA", "MG", "MS", "MT",
                "PA", "PB", "PE", "PI", "PR",
                "RJ", "RN", "RO", "RR", "RS",
                "SC", "SE", "SP", "TO"
        };
        ArrayAdapter<String> spArrayAdapUF =
                new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, spUFmed);
                spUF.setAdapter(spArrayAdapUF);

        Button btnSalvarMed = findViewById(R.id.btnSalvarMedico);
        btnSalvarMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarBD();
            }
        });
    }
    private void salvarBD(){
        String nome = etNome.getText().toString().trim();
        String crm = etCRM.getText().toString().trim();
        String logradouro = etLogradouro.getText().toString().trim();
        String numero = etNumero.getText().toString().trim();
        String cidade = etCidade.getText().toString().trim();
        String uf = spUF.getSelectedItem().toString();
        String celular = etCelular.getText().toString().trim();
        String fixo = etFixo.getText().toString().trim();

        if (nome.equals("")){
            Toast.makeText(getApplicationContext(), "Obrigatório informar o Nome!", Toast.LENGTH_LONG).show();
        }else if(crm.equals("")){
            Toast.makeText(getApplicationContext(), "Obrigatório informar o CRM!", Toast.LENGTH_LONG).show();
        }else if(logradouro.equals("")){
            Toast.makeText(getApplicationContext(), "Obrigatório informar o Logradouro!", Toast.LENGTH_LONG).show();
        }else if(numero.equals("")){
            Toast.makeText(getApplicationContext(), "Obrigatório informar o Número!", Toast.LENGTH_LONG).show();
        }else if(cidade.equals("")){
            Toast.makeText(getApplicationContext(), "Obrigatório informar a Cidade!", Toast.LENGTH_LONG).show();
        }else if(uf.equals("Escolha uma opção: ")) {
            Toast.makeText(getApplicationContext(), "Obrigatório informar a UF!", Toast.LENGTH_LONG).show();
        }else if(celular.equals("")){
            Toast.makeText(getApplicationContext(), "Obrigatório informar o telefone Celular!", Toast.LENGTH_LONG).show();
        }else if(fixo.equals("")){
            Toast.makeText(getApplicationContext(), "Obrigatório informar o telefone Fixo!", Toast.LENGTH_LONG).show();
        }else {
            db = openOrCreateDatabase("consulta.db", Context.MODE_PRIVATE, null);
            StringBuilder sql = new StringBuilder();

            sql.append("INSERT INTO medico(nome, crm, logradouro, numero, cidade, uf, celular, fixo) VALUES(");
            sql.append(" ' " + nome + " ' ,");
            sql.append(" ' " + crm + " ' ,");
            sql.append(" ' " + logradouro + " ' ,");
            sql.append(numero + ",");
            sql.append(" ' " + cidade + " ' ,");
            sql.append(" ' " + uf + " ' ,");
            sql.append(celular + " ,");
            sql.append(fixo);
            sql.append(");");

            try {
                db.execSQL(sql.toString());
                Toast.makeText(getApplicationContext(), "Novo médico adicionado.", Toast.LENGTH_LONG).show();
            } catch (SQLException e) {
                Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
            etNome.setText("");
            etCRM.setText("");
            etLogradouro.setText("");
            etNumero.setText("");
            etCidade.setText("");
            spUF.setSelection(0);
            etCelular.setText("");
            etFixo.setText("");
            db.close();
        }
    }
}
