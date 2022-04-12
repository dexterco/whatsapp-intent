package com.example.whatsappintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
Button btn;
EditText msg;
TextView error;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button);
        msg= (EditText) findViewById(R.id.msg);
        error = (TextView) findViewById(R.id.error);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (msg.getText().toString().isEmpty()){
                    error.setText("Please Write your damn message first!");
                }else {
                    error.setText("");
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    String damnMsg = msg.getText().toString();
                    sendIntent.putExtra(Intent.EXTRA_TEXT, damnMsg);
                    sendIntent.setType("text/plain");
                    sendIntent.setPackage("com.whatsapp");
                    startActivity(Intent.createChooser(sendIntent, "Share with"));
                }
            }
        });
    }


}