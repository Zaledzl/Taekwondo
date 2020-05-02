package com.example.taekwondo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    private WebView mWvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        mWvMain = findViewById(R.id.wv);
        //加载本地HTML
//        mWvMain.loadUrl("file:///android_asset/UESTC.html");
        mWvMain.getSettings().setJavaScriptEnabled(true);
        mWvMain.loadUrl("https://m.baidu.com");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK&&mWvMain.canGoBack()){
            mWvMain.goBack();
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }
}
