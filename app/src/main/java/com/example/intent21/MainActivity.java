package com.example.intent21;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button b;
    EditText e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = findViewById(R.id.b1);
        e = findViewById(R.id.e1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, activity_second.class);
                String s = e.getText().toString();
                i.putExtra("message", s);//s is the key value we send the string we previously defined
                //when many message are there each message is identified by an identifier
                //first:Identifier 2nd:the actual message
                i.putExtra("num1", 20);
                //startActivity(i);//used only to send and not receive
                startActivityForResult(i, 1);//we can handle the reply to this request using this request code
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {//1,11,i2
        super.onActivityResult(requestCode, resultCode, data);
        //if we have multiple request we need to check which request it is
        if(requestCode == 1 && resultCode == 11)
        {
            String s3 = data.getStringExtra("msg");
            e.setText(s3);
        }
    }
}