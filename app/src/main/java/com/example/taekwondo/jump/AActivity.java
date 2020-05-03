package com.example.taekwondo.jump;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.taekwondo.R;

public class AActivity extends AppCompatActivity {

    private Button mBtnJumpp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Log.d("AActivity","-----onCreate-----");
        Log.d("AActivity","taskid:"+getTaskId()+"hashcode:"+hashCode());
        logtaskName();
        mBtnJumpp = findViewById(R.id.btn_jumpp);
        mBtnJumpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显式跳转1    intent 意图
                Intent intent = new Intent(AActivity.this,BActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name","杜宗伦");
                bundle.putInt("number",88);
                intent.putExtras(bundle);
                startActivity(intent);
//                startActivityForResult(intent,0);

                //显式跳转2
//                Intent intent = new Intent();
//                intent.setClass(AActivity.this,BActivity.class);
//                startActivity(intent);

                //显式跳转3
//                Intent intent = new Intent();
//                intent.setClassName(AActivity.this,"com.example.taekwondo.jump.BActivity");
//                startActivity(intent);

                //显式跳转4
//                Intent intent1 = new Intent();
//                intent.setComponent(new ComponentName(AActivity.this,"com.example.taekwondo.jump.BActivity"));
//                startActivity(intent);

                //隐式调用
//                Intent intent = new Intent();
//                intent.setAction("com.skypan.test.BActivity");
//                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(AActivity.this,data.getExtras().getString("title"),Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("AActivity","-----onCreate-----");
        Log.d("AActivity","taskid:"+getTaskId()+"hashcode:"+hashCode());
        logtaskName();
    }

    private void logtaskName(){
        try {
            ActivityInfo info = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d("AActivity",info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
