package com.example.progapp_03092019_implicitintent_felipeb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.acoes));
        setListAdapter(adapter);
    }

    private void discar{
        Uri uri = Uri.parse("Tel:993580614");
        Intent intent = new Intent(Intent.ACTION_CALL, uri);
        dipararIntent(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
            discar();
        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Uri uri = null;
        Intent intent = null;
        switch(position){
            //Abrindo Uma Url
            case 0:
                uri = Uri.parse("htpps//www.nglauber.com.br");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                dispararIntent(intent);
                break;
            case 1:
                if()
        }
    }
}
