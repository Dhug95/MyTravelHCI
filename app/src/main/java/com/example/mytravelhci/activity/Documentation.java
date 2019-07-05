package com.example.mytravelhci.activity;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mytravelhci.R;
import com.mukesh.MarkdownView;

public class Documentation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documentation);
        MarkdownView markdownView = (MarkdownView) findViewById(R.id.markdown_view);
        //markdownView.loadMarkdown("## Hello Markdown");
        markdownView.loadMarkdownFromAssets("readme.md");
    }
}
