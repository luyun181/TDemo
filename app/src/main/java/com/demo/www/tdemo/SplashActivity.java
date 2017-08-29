package com.demo.www.tdemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_splash);
        mContext = this;
        new CountDownTimer(2000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
               Intent intent = setComponent();
//                startActivity(intent);
                startActivity(new Intent(mContext,MainActivity.class));
                finish();
            }
        }.start();
    }
    public Intent setComponent(){
        ComponentName component = new ComponentName(
                "com.lkl.cloudpos.payment",
                "com.lkl.cloudpos.payment.activity.MainMenuActivity");
        Intent intent = new Intent();
        intent.setComponent(component);
        return intent;
    }
}
