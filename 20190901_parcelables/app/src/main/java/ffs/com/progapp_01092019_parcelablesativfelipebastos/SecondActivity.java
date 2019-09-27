package ffs.com.progapp_01092019_parcelablesativfelipebastos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {
    TextView info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent it = getIntent();
        Produto produto = (Produto) it.getParcelableExtra("Produto");
        info =(TextView) findViewById(R.id.TVinformacoes);
        info.setText("Descrição: "+produto.getDescription()+"\nValor Total: "+produto.valortotal());

    }
}
