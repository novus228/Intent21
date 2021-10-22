package com.example.intent21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class activity_second extends AppCompatActivity {
    TextView t;
    EditText e1;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        t=findViewById(R.id.tv);
        e1=findViewById(R.id.t1);
        b = findViewById(R.id.b1);
        Intent a = getIntent();//receiving the intent sent from the activity_main
        String s1 = a.getStringExtra("message");//no 2nd parameter cause we get empty string
        int n1 = a.getIntExtra("num1",0);//in case we don't send any value (nothing passed) the default
        //value is used that is why we have 2 parameters
        t.setText(s1+n1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent();//without any parameter cause its a response message
                String s2 = e1.getText().toString();
                i2.putExtra("msg",s2);
                setResult(11,i2);//we set the intent for a result hence we need to send it
//                and we send the intent data
                finish();
            }
        });
    }
}