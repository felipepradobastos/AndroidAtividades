package ffs.com.progapp_01092019_parcelablesativfelipebastos;

import android.content.Intent;
import android.os.Parcel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etdescription;
    EditText etquant;
    EditText etvalorunit;
    Button btnenviar;
    Produto produto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnenviar = (Button) findViewById(R.id.btnenviar3);
        etdescription = (EditText) findViewById(R.id.etdescription);
        etquant = (EditText) findViewById(R.id.etquantidade);
        etvalorunit = (EditText) findViewById(R.id.etvalorunit);
        btnenviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                produto = new Produto(etdescription.getText().toString(),Double.parseDouble(etvalorunit.getText().toString()),Integer.parseInt(etquant.getText().toString()));
                Bundle bundle1 = new Bundle();
                bundle1.putParcelable("Produto", produto);
                Intent i = new Intent(getApplicationContext(), SecondActivity.class);
                i.putExtras(bundle1);
                startActivity(i);
            }
        });
    }

}
