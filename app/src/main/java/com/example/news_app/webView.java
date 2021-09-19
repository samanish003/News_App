package com.example.news_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.progressindicator.CircularProgressIndicator;

public class webView extends AppCompatActivity {

    Toolbar toolbar;
    WebView webView;
    TextView tittle;

    BottomSheetDialog bottomSheetDialog;
    ProgressBar progressBar;



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.share:
                shareClicked();
                break;
            case R.id.download:
                Toast.makeText(this, "download selected", Toast.LENGTH_SHORT).show();
                break;

        }
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        tittle = findViewById(R.id.title);
        Intent intent = getIntent();
        toolbar= findViewById(R.id.toolbar);
        webView = findViewById(R.id.webview);
        progressBar = findViewById(R.id.progressBar);
        setSupportActionBar(toolbar);
        tittle.setText(intent.getStringExtra("title"));
        progressBar.setVisibility(View.VISIBLE);


        String url = intent.getStringExtra("url");
        webView.setWebViewClient(new WebViewClient());
        System.out.println("url----- "+url);


        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
            }
        });

        if(url.contains("https")) {
            webView.loadUrl(url);
            progressBar.setVisibility(View.GONE);
        } else {
            webView.loadUrl(url.replace("http", "https"));
            progressBar.setVisibility(View.GONE);
        }
    }

    void shareClicked(){
        Toast.makeText(this, "share selected", Toast.LENGTH_SHORT).show();
        bottomSheetDialog = new BottomSheetDialog(this);
        View view = getLayoutInflater().inflate(R.layout.bottom_sheet_layout, null);
        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.show();
    }
}