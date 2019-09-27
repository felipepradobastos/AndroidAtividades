package ffs.com.a20190916_string;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button1;
    private static final int REQUEST_STRING=1;
    String string;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent b = getIntent();
        String str = b.getStringExtra("str");
        Log.d("STRING ACTIVITY", "String Recebida: "+str);
        setContentView(R.layout.activity_main);
        button1= (Button) findViewById(R.id.ButtonFirstAct);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SegundaAtividade.class);
                i.putExtra(SegundaAtividade.EXTRA_STRING, string);
                startActivityForResult(i, REQUEST_STRING);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == REQUEST_STRING){
            string = data.getStringExtra(SegundaAtividade.EXTRA_RESULTADO);
            Log.d("MENSAGEM DA ATIVIDADE", "onActivityResult: "+string);
        }
    }
}
