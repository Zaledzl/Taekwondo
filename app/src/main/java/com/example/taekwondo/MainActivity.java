package com.example.taekwondo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.taekwondo.datastorage.DataStorageActivity;

public class MainActivity extends AppCompatActivity {

    private Button mBtnUI,mBtnDataControl,button13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnUI = findViewById(R.id.btn_ui);
        mBtnDataControl = findViewById(R.id.btn_data_control);
        button13 = findViewById(R.id.button13);
        OnClick onClick = new OnClick();
        mBtnUI.setOnClickListener(onClick);
        mBtnDataControl.setOnClickListener(onClick);
        button13.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_ui:
                    intent = new Intent(MainActivity.this, UIActivity.class);
                    break;
                case R.id.btn_data_control:
                    intent = new Intent(MainActivity.this, DataControlActivity.class);
                    break;
                case R.id.button13:
                    intent = new Intent(MainActivity.this, DataStorageActivity  .class);
                    break;
            }
            startActivity(intent);
        }
    }
}
