package ffs.company.menuactivityfelipeb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ffs.company.menuactivityfelipeb.Model.Aluno;

public class PesquisarAluno extends AppCompatActivity {

    List<Aluno> listaPesquisa;
    List<String> listaString;
    TextView tvPesqNome;
    TextView tvPesqCPF;
    TextView tvPesqEmail;
    TextView tvPesqIdade;



    AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisar_aluno);

        tvPesqCPF = (TextView) findViewById(R.id.tvPesqCPF);
        tvPesqEmail = (TextView) findViewById(R.id.tvPesqEmail);
        tvPesqIdade = (TextView) findViewById(R.id.tvPesqIdade);
        tvPesqNome = (TextView) findViewById(R.id.tvPesqNome);


        listaPesquisa = getIntent().getExtras().getParcelableArrayList("ListaAlunos");

        /*for(int i=0;i<listaPesquisa.size();i++){
            listaString.add(listaPesquisa.get(i).getNome());
        }

        PesquisarAdapter adapter = new PesquisarAdapter(this, android.R.layout.simple_dropdown_item_1line, listaString);

        autoCompleteTextView.setAdapter(adapter);


        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.atctv);
        */



    }
}
