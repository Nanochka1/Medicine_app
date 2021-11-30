package com.medical.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton imageButtonChild = (ImageButton) findViewById(R.id.imageButtonChild);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        Window win = getWindow();
        win.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        imageButtonChild.setOnClickListener(new View.OnClickListener() { //обработчик нажатия кнопки ребенка
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DoctorActivity.class);
                intent.putExtra("isChild",1);//отправка данных на следующий экран о возрасте, 1 - ребенок, 0 - взрослый
                startActivity(intent);//запуск окна выбора специалиста
            }
        });
        ImageButton imageButtonOld = (ImageButton) findViewById(R.id.imageButtonOld);
        imageButtonOld.setOnClickListener(new View.OnClickListener() { //обработчик нажатия кнопки взрослого
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DoctorActivity.class);
                intent.putExtra("isChild",0); //отправка данных на следующий экран о возрасте, 1 - ребенок, 0 - взрослый
                startActivity(intent);//запуск окна выбора специалиста
            }
        });
    }
}