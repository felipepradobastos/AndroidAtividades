package ffs.com.a20190916_string;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SegundaAtividade extends AppCompatActivity {
    Button button2;
    EditText edtxt;
    public static final String EXTRA_STRING ="string";
    public static final String EXTRA_RESULTADO="result";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_atividade);
        button2 = (Button) findViewById(R.id.Button2activity);
        edtxt = (EditText) findViewById(R.id.ETstring);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = edtxt.getText().toString();
                Intent resultado = new Intent();
                resultado.putExtra(EXTRA_RESULTADO, result);
                setResult(RESULT_OK, resultado);
                finish();

            }
        });
    }
}
