package com.medical.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DoctorActivity extends AppCompatActivity {

    int isChild;
    List<String> doctors = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        isChild = getIntent().getIntExtra("isChild",0); //получение данных о возрасте
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        Window win = getWindow();
        win.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if(isChild == 1) doctors.add("Педиатр"); //заполнение контейнера со специалистами
        else doctors.add("Терапевт");
        doctors.add("Кардиолог");
        doctors.add("Эндокринологолог");
        doctors.add("Хирург");
        doctors.add("Невролог");
        doctors.add("Гастроэнтеролог");
        doctors.add("Гинеколог");
        doctors.add("Уролог");
        LinearLayout linearLayout = findViewById(R.id.linearLayoutDoctors);
        for (int i= 0;i<doctors.size();i++){ //вывод на экран специалистов
            TextView textView = new TextView(this);
            textView.setText(doctors.get(i));
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,28);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            textView.setOnClickListener(v -> { //обработчик нажатия на надпись с названием специалиста
                Intent intent = new Intent(DoctorActivity.this,SurveyActivity.class);
                intent.putExtra("Doctor",textView.getText().toString()); //отправка данных о том, какой специалист был выбран
                intent.putExtra("isChild",isChild); //отправка данных о возрасте пользователя
                startActivity(intent);
            });
            linearLayout.addView(textView,layoutParams);

        }
    }

}