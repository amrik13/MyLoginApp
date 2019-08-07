package com.amriksinghpadam.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText uname, pwd;
    private TextView responseText;
    private Button submit_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getSupportActionBar().hide();
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        uname = findViewById(R.id.login_userName);
        pwd = findViewById(R.id.login_password);
        submit_btn = findViewById(R.id.submitBtn);

        View.OnClickListener submit_btn_listener = new View.OnClickListener() {
            public void onClick(View v) {

                String trimmed_uName = uname.getText().toString().trim();
                String trimmed_pwd = pwd.getText().toString().trim();

                if (!trimmed_uName.isEmpty() && !trimmed_pwd.isEmpty()) {
                    if (trimmed_uName.equals("bob") && trimmed_pwd.equals("123")) {
                        Intent intent = new Intent(MainActivity.this, Home.class);

                        Bundle extras = new Bundle();
                        extras.putString("msg", trimmed_uName);
                        intent.putExtras(extras);

//                            OR (Second Option)
//                        intent.putExtra("string",trimmed_uName); extra method of single line
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, getResources().getString(R.string.invalid_input_toast), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.empty_input_toast), Toast.LENGTH_SHORT).show();
                }
            }
        };
        submit_btn.setOnClickListener(submit_btn_listener);

        super.onRestart();
        Log.d("lifecycle","onCreate invoked");
    }
    protected void onStart() {
        super.onStart();
        Log.d("lifecycle","onStart invoked");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle","onResume invoked");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle","onPause invoked");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("lifecycle","onStop invoked");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("lifecycle","onRestart invoked");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle","onDestroy invoked");
    }
}
