package com.medical.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SurveyActivity extends AppCompatActivity {

    String getEx;
    int  isChild;

    void addToLinearSurvey(String nameSurvey){
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearSurvey);
        TextView textView = new TextView(this);
        textView.setText(nameSurvey);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,28);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT); //обработка нажатия на обследование
        textView.setOnClickListener(v -> {
            Intent intent = new Intent(SurveyActivity.this,MedicalServicesActivity.class); //запуск окна с мед.сервисами
            startActivity(intent);
        });
        linearLayout.addView(textView,layoutParams);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        Window win = getWindow();
        win.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getEx = getIntent().getStringExtra("Doctor");
        isChild = getIntent().getIntExtra("isChild",0);
        TextView textView = (TextView) findViewById(R.id.textViewSurvay2);
        textView.setVisibility(View.VISIBLE);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearSurvey);
        linearLayout.setVisibility(View.VISIBLE);
        linearLayout.removeAllViews();
        //вывод обследований в зависимости от выбранного специалиста
        if(getEx.equals("Педиатр")){
            addToLinearSurvey("Общий анализ крови");
            addToLinearSurvey("Общий анализ мочи");
        }
        if(getEx.equals("Терапевт")){
            addToLinearSurvey("Общий анализ крови");
            addToLinearSurvey("Общий анализ мочи");
            addToLinearSurvey("Биохимия развернутая");
            addToLinearSurvey("Коагулограмма срининг");
            addToLinearSurvey("С - реактивный белок");
            addToLinearSurvey("ТТГ, Т4, Т3");
            addToLinearSurvey("Флюорография");
        }
        if (getEx.equals("Кардиолог")){
            addToLinearSurvey("Общий анализ крови");
            addToLinearSurvey("Общий анализ мочи");
            if(isChild==0){
                addToLinearSurvey("Биохимия развернутая");
                addToLinearSurvey("Коагулограмма срининг");
                addToLinearSurvey("С - реактивный белок");
                addToLinearSurvey("ТТГ, Т4, Т3");
            }
            addToLinearSurvey("ЭКГ");
        }
        if(getEx.equals("Эндокринологолог")){
            addToLinearSurvey("Общий анализ крови");
            addToLinearSurvey("Общий анализ мочи");
            if(isChild==0){
                addToLinearSurvey("Биохимия развернутая");
                addToLinearSurvey("Коагулограмма срининг");
                addToLinearSurvey("С - реактивный белок");
                addToLinearSurvey("ТТГ, Т4, Т3");
            }
            addToLinearSurvey("УЗИ щитовидной железы");
        }
        if(getEx.equals("Хирург")){
            addToLinearSurvey("Общий анализ крови");
            addToLinearSurvey("Общий анализ мочи");
            if(isChild==0){
                addToLinearSurvey("Биохимия развернутая");
                addToLinearSurvey("Коагулограмма срининг");
                addToLinearSurvey("С - реактивный белок");
                addToLinearSurvey("ТТГ, Т4, Т3");
            }
        }
        if(getEx.equals("Невролог")){
            addToLinearSurvey("Общий анализ крови");
            addToLinearSurvey("Общий анализ мочи");
            if(isChild==0){
                addToLinearSurvey("Биохимия развернутая");
                addToLinearSurvey("Коагулограмма срининг");
                addToLinearSurvey("С - реактивный белок");
                addToLinearSurvey("ТТГ, Т4, Т3");
            }
            addToLinearSurvey("МРТ/КТ позвоночника");
            addToLinearSurvey("МРТ/КТ головы");

        }
        if(getEx.equals("Гастроэнтеролог")){
            addToLinearSurvey("Общий анализ крови");
            addToLinearSurvey("Общий анализ мочи");
            if(isChild==0){
                addToLinearSurvey("Биохимия развернутая");
                addToLinearSurvey("Коагулограмма срининг");
                addToLinearSurvey("С - реактивный белок");
                addToLinearSurvey("ТТГ, Т4, Т3");
            }
            addToLinearSurvey("УЗИ органов брюшной полости");

        }
        if(getEx.equals("Гинеколог")){
            addToLinearSurvey("Общий анализ крови");
            addToLinearSurvey("Общий анализ мочи");
            if(isChild==0){
                addToLinearSurvey("Биохимия развернутая");
                addToLinearSurvey("Коагулограмма срининг");
                addToLinearSurvey("С - реактивный белок");
                addToLinearSurvey("ТТГ, Т4, Т3");
            }
            addToLinearSurvey("УЗИ малого таза");

        }
        if(getEx.equals("Уролог")){
            addToLinearSurvey("Общий анализ крови");
            addToLinearSurvey("Общий анализ мочи");
            if(isChild==0){
                addToLinearSurvey("Биохимия развернутая");
                addToLinearSurvey("Коагулограмма срининг");
                addToLinearSurvey("С - реактивный белок");
                addToLinearSurvey("ТТГ, Т4, Т3");
            }
            addToLinearSurvey("УЗИ мочевыделительной системы");

        }
    }


}