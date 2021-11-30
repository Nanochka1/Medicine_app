package com.medical.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends Activity {
    private final int SPLASH_SCREEN_LENGTH = 5000; //время в миллисекундах, на которые выводится заставка

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {//Вывод заставки
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        Window win = getWindow();
        win.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final Handler handler = new Handler();
        final Runnable r = new Runnable() {
            @Override
            public void run() {

                Intent mainIntent = new Intent(SplashScreen.this,MainActivity.class);
                SplashScreen.this.startActivity(mainIntent);//Запуск экрана выбора возраста
                SplashScreen.this.finish();
            }
        };
        handler.postDelayed(r,SPLASH_SCREEN_LENGTH);

    }
}
