package ffs.com.a20190916_progapp_felipeb_atividade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ETlogin;
    EditText ETpassword;
    Button BTNcadastrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ETlogin = (EditText) findViewById(R.id.ETlogin);
        ETpassword = (EditText) findViewById(R.id.ETpassword);
        BTNcadastrar = (Button) findViewById(R.id.BTNcadastrar);
        BTNcadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ETlogin.getText().toString().equals("senai") && ETpassword.getText().toString().equals("senai")){
                    Intent i = new Intent(getApplicationContext(), Cadastro.class);
                    startActivity(i);
                }else{
                    Toast.makeText(MainActivity.this, "Credênciais Invalidas", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
