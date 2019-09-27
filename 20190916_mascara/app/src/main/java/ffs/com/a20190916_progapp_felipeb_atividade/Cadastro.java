package ffs.com.a20190916_progapp_felipeb_atividade;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Cadastro extends AppCompatActivity implements TextView.OnEditorActionListener {

    EditText ETNome;
    Button BTNConfirmCadastro;
    EditText ETEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        final EditText ETCpf = (EditText) findViewById(R.id.ETcpf);
        ETEmail = (EditText) findViewById(R.id.ETemail);
        ETNome = (EditText) findViewById(R.id.ETnome);
        BTNConfirmCadastro = (Button) findViewById(R.id.BTNcadconfirm);

        BTNConfirmCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Cadastro.this, "Cadastrado com Sucesso !", Toast.LENGTH_SHORT).show();
            }
        });


        ETCpf.addTextChangedListener(new TextWatcher() {
            boolean isUpdating;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(isUpdating) {
                    isUpdating = false;
                    return;
                }
                boolean hasMask =
                        s.toString().indexOf('.') > -1 ||
                                s.toString().indexOf('-') > -1;

                String str = s.toString()
                        .replaceAll("[.]", "")
                        .replaceAll("[-]","");

                if(count > before){
                    if (str.length() > 9) {
                        str = str.substring(0,3) + '.' +
                                str.substring(3,6) + '.' +
                                str.substring(6,9) + "-" +
                                str.substring(9);
                    } else if (str.length() > 6) {
                        str = str.substring(0, 3) + '.' +
                              str.substring(3,6) + "." +
                              str.substring(6);
                    } else if (str.length()>3){
                        str = str.substring(0,3) + "."+
                              str.substring(3);
                    }
                    isUpdating = true;
                    ETCpf.setText(str);
                    ETCpf.setSelection(ETCpf.getText().length());
                } else {
                    isUpdating = true;
                    ETCpf.setText(str);
                    ETCpf.setSelection(Math.max(0, Math.min(hasMask ?
                            start - before : start, str.length())));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        return false;
    }
}
