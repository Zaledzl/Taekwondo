package com.example.taekwondo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * MainActivity  这是主 Activity。它是应用的入口点。当您构建和运行应用时，系统会启动此 Activity 的实例并加载其布局。
 * activity_main.xml   此 XML 文件定义了 Activity 界面的布局。它包含一个 TextView 元素，其中具有“Hello, World!”文本
 * AndroidManifest.xml   清单文件描述了应用的基本特性并定义了每个应用组件。
 */
public class MainActivity extends AppCompatActivity {

    //您的键是一个公共常量 EXTRA_MESSAGE，因为下一个 Activity 将使用该键检索文本值。为 Intent extra 定义键时，最好使用应用的软件包名称作为前缀。这样可以确保这些键是独一无二的，万一您的应用需要与其他应用进行交互。
    public static final String EXTRA_MESSAGE = "com.example.taekwondo.MESSAGE";

    //首先声明控件
    private Button mBtnTextView;
    private Button button3;
    private TextView textView6;
    private Button btnImageView;
    private Button button5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //onCreate 是启动
        super.onCreate(savedInstanceState);
        //设置界面的形式
        setContentView(R.layout.activity_main);
        //先用变量绑定按钮
        mBtnTextView = findViewById(R.id.btn_textview);
        //按钮监听点击 函数
        mBtnTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到TextView演示界面
                Intent intent  = new Intent(MainActivity.this,TextViewActivity.class);
                startActivity(intent);
            }
        });
        button3 = findViewById(R.id.button3);
        textView6 = findViewById(R.id.textView6);
        btnImageView = findViewById(R.id.btnImageView);
        button5 = findViewById(R.id.button5);
        //先根据控件ID找到控件，然后调用setListener
        setListener();
    }

    //设置监听器 给每一个事件设置点击事件
    private void setListener(){
        //onclick实现了OnClick类
        OnClick onclick = new OnClick();
        button3.setOnClickListener(onclick);
        textView6.setOnClickListener(onclick);
        btnImageView.setOnClickListener(onclick);
        button5.setOnClickListener(onclick);
    }

    //OnClick 实现了 ONClickListener接口
    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View v){
            Intent intent = null;
            switch (v.getId()){
                case R.id.textView6:
                    intent = new Intent(MainActivity.this,EditTextActivity.class);
                    break;
                case R.id.button3:
                    intent = new Intent(MainActivity.this,ButtonActivity.class);
                    break;
                case R.id.btnImageView:
                    intent = new Intent(MainActivity.this,ImageViewActivity.class);
                    break;
                case R.id.button5:
                    intent = new Intent(MainActivity.this, ZaleTestActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }

    /** Called when the user taps the Send button */
    /**Intent 是在相互独立的组件（如两个 Activity）之间提供运行时绑定功能的对象。Intent 表示应用执行某项操作的意图。
     */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();

        //putExtra() 方法将 EditText 的值添加到 Intent。Intent 能够以名为“extra”的键值对形式携带数据类型。
        intent.putExtra(EXTRA_MESSAGE, message);

        //startActivity() 方法将启动一个由 Intent 指定的 DisplayMessageActivity 实例
        startActivity(intent);
    }


}
