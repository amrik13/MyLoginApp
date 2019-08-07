package com.amriksinghpadam.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Home extends AppCompatActivity
{
    ToggleButton toggleBtn;
    private TextView uNameText;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();
        String uname = intent.getStringExtra("msg");

        uNameText = (TextView)findViewById(R.id.homeText);
        uNameText.setText("User: "+uname);

        toggleBtn = findViewById(R.id.toggle_btn);

        CompoundButton.OnCheckedChangeListener toggleListener = new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                if(!toggleBtn.getTextOn().toString().isEmpty())
                Toast.makeText(Home.this,"System is--"+compoundButton.getText(),Toast.LENGTH_SHORT).show();;
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.amriksinghpadam.com"));
                startActivity(intent);
            }
        };

        toggleBtn.setOnCheckedChangeListener(toggleListener);

    }
}
