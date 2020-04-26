package com.example.taekwondo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {

    private RadioGroup mRg1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        mRg1 = findViewById(R.id.rg_1);
        mRg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = group.findViewById(checkedId);
                Toast.makeText(ButtonActivity.this,radioButton.getText(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void showToast(View view){
        Toast.makeText(this, "How can I do that?", Toast.LENGTH_SHORT).show();
    }

    public void showToast2(View view){
        Toast.makeText(this, "杜宗伦加油", Toast.LENGTH_SHORT).show();
    }
}
