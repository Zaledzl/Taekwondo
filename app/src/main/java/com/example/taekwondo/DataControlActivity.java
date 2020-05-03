package com.example.taekwondo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.taekwondo.fragment.AFragment;
import com.example.taekwondo.fragment.ContainerActivity;
import com.example.taekwondo.jump.AActivity;

public class DataControlActivity extends AppCompatActivity {

    private Button mBtnJump,button11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_control);
        mBtnJump = findViewById(R.id.btn_jump);
        button11 = findViewById(R.id.button11);
        //先根据控件ID找到控件，然后调用setListener
        setListener();
    }

    //设置监听器 给每一个事件设置点击事件
    private void setListener(){
        //onclick实现了OnClick类
        OnClick onclick = new OnClick();
        mBtnJump.setOnClickListener(onclick);
        button11.setOnClickListener(onclick);
    }

    //OnClick 实现了 ONClickListener接口
    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v){
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_jump:
                    intent = new Intent(DataControlActivity.this, AActivity.class);
                    break;
                case R.id.button11:
                    intent = new Intent(DataControlActivity.this, ContainerActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
