package com.pallefire.cyy_b34;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText et;
    Button b1;
    WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = (EditText) findViewById(R.id.et1);
        webView = (WebView) findViewById(R.id.wv);
        b1 = (Button) findViewById(R.id.bt1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = et.getText().toString();
                String url = "https://www.youtube.com/results?search_query="+ str1;
                System.out.println("selected Links "+url);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("url", str1);
                startActivity(intent);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.loadUrl(url);
                webView.setWebViewClient(new WebViewClient());}
            });
        webView.setWebViewClient(new WebViewClient(){
            public void OnPageFinished (WebView view, String url){
                super.onPageFinished(view,url);
                webView.loadUrl(url);
                    Toast.makeText(getApplicationContext(), "done", Toast.LENGTH_SHORT).show();
            }
        });
        webView.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView view,String url){
                    return true;
                }
        });
        }}


//AIzaSyAZ46IMIrKsCqMYvtZybVG5rRZ47GkL_L8