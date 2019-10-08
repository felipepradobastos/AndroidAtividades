package ffs.company.menuactivityfelipeb;

import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ffs.company.menuactivityfelipeb.Model.Aluno;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_ALUNO=1;


    Button btnCadastrarAluno;
    Button btnPesquisarAluno;
    Button btnEditarAluno;
    TextView tvCompany;

    Aluno alunotocad;

    private static final int REQUEST_STRING=1;


    List<Aluno> listaAlunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadastrarAluno = (Button) findViewById(R.id.btnCadastrarAluno);
        btnPesquisarAluno = (Button) findViewById(R.id.btnPesquisarAluno);
        btnEditarAluno = (Button) findViewById(R.id.btnEditarAluno);
        tvCompany = (TextView) findViewById(R.id.tvcompany);

        if(listaAlunos != null){

        }else{
            listaAlunos = new ArrayList<>();
        }

        btnCadastrarAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toCadastroAluno = new Intent(getApplicationContext(), CadAlunoActivity.class);
                toCadastroAluno.putExtra(CadAlunoActivity.EXTRA_ALUNO, alunotocad);
                startActivityForResult(toCadastroAluno, REQUEST_STRING);
            }
        });

        btnEditarAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        btnPesquisarAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toPesquisarAluno = new Intent(getApplicationContext(), PesquisarAluno.class);
                Bundle toPesquisarbundle = new Bundle();
                toPesquisarbundle.putParcelableArrayList("ListaAluno", (ArrayList<? extends Parcelable>) listaAlunos);
                toPesquisarAluno.putExtras(toPesquisarbundle);
                startActivity(toPesquisarAluno);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == REQUEST_STRING){
            alunotocad = data.getParcelableExtra(CadAlunoActivity.EXTRA_RESULTADO);
            listaAlunos.add(alunotocad);
            tvCompany.setText(alunotocad.getNome());
        }
    }
}
