package ffs.company.webviewfelipeb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        webView = (WebView) findViewById(R.id.webview);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.addJavascriptInterface(this, "ffs");
        webView.loadUrl("file:///android_asset/meu.html");
    }
    @JavascriptInterface
    public void showToast(String intervalo) {
        Toast.makeText(this,
                "Intervalo:"+intervalo,
                Toast.LENGTH_SHORT).show();
    }
}
