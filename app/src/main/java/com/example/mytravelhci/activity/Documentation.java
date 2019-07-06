package com.example.mytravelhci.activity;


import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mytravelhci.R;
import com.mukesh.MarkdownView;

import java.io.File;

public class Documentation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documentation);

        //MarkdownView markdownView = findViewById(R.id.markdown_view);
        //markdownView.loadMarkdownFromAssets("documentation.md");

        WebView webView = findViewById(R.id.webView1);
        WebSettings webSetting = webView.getSettings();
        webSetting.setBuiltInZoomControls(true);
        webSetting.setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl("file:///android_asset/documentation.html");
    }

    private class WebViewClient extends android.webkit.WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
}
