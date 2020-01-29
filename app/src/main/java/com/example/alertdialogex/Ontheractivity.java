package com.example.alertdialogex;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Ontheractivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onther);
        final WebView webview=findViewById(R.id.webview);


        Button btnclick=findViewById(R.id.buttonclick);
        btnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              final EditText edittexturl=findViewById(R.id.editTextenterUrl);
                String url=edittexturl.getText().toString();
                if(url.equals(""))
                {
                    AlertDialog.Builder alertdialogbuilder1 = new AlertDialog.Builder(Ontheractivity.this);
                    alertdialogbuilder1.setTitle("Edit text is empty please enter it").create().show();
                    alertdialogbuilder1.setPositiveButton("Ok" , new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    }).create().show();

                }
                else
                    {
                    webview.loadUrl(url);
                }

        }
    });
}
}
