package com.example.taekwondo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DialogActivity extends AppCompatActivity {

    private Button mBtnDialog1,mBtnDialog2,mBtnDialog3,mBtnDialog4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        mBtnDialog1 = findViewById(R.id.btn_dialog1);
        mBtnDialog2 = findViewById(R.id.btn_dialog2);
        mBtnDialog3 = findViewById(R.id.btn_dialog3);
        mBtnDialog4 = findViewById(R.id.btn_dialog4);
        OnClick onClick = new OnClick();
        mBtnDialog1.setOnClickListener(onClick);
        mBtnDialog2.setOnClickListener(onClick);
        mBtnDialog3.setOnClickListener(onClick);
        mBtnDialog4.setOnClickListener(onClick);

    }

    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {

            switch(v.getId()){
                case R.id.btn_dialog1:
                    AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);
                    builder.setTitle("杜宗伦").setMessage("你好呀").setIcon(R.drawable.st).setPositiveButton("GREAT", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(DialogActivity.this,"great",Toast.LENGTH_SHORT).show();
                        }
                    }).setNeutralButton("Good", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(DialogActivity.this,"good",Toast.LENGTH_SHORT).show();
                        }
                    }).setNegativeButton("BAD", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(DialogActivity.this,"bad",Toast.LENGTH_SHORT).show();
                        }
                    }).show();
                    break;
                case R.id.btn_dialog2:
                    final String[] array2 = new String[]{"男","女"};
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(DialogActivity.this);
                    builder2.setTitle("选择性别").setItems(array2, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(DialogActivity.this,array2[which],Toast.LENGTH_SHORT).show();
                        }
                    }).show();
                    break;
                case R.id.btn_dialog3:
                    final String[] array3 = new String[]{"男","女"};
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(DialogActivity.this);
                    builder3.setTitle("选择性别");
                    builder3.setSingleChoiceItems(array3, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(DialogActivity.this,array3[which],Toast.LENGTH_SHORT).show();
                        }
                    }).show();
                    break;
                case R.id.btn_dialog4:
                    final String[] array4 = new String[]{"唱歌","跳舞","写代码"};
                    boolean[] isSelected = new boolean[]{false,false,true};
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(DialogActivity.this);
                    builder4.setTitle("选择兴趣").setMultiChoiceItems(array4,isSelected, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            Toast.makeText(DialogActivity.this,array4[which]+":"+isChecked,Toast.LENGTH_SHORT).show();
                        }
                    }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //
                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //
                        }
                    }).show();
                    break;
            }
        }
    }
}
