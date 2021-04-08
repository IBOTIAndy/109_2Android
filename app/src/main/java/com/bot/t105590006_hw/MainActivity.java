package com.bot.t105590006_hw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = "Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(LOG_TAG, "------");
        Log.d(LOG_TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null) {
            Log.d(LOG_TAG, "loading save instance.");
            //放入需要讀取的資料.
//            mShowCount.setText(savedInstanceState.getString("textViewCount"));
//            mCount = Integer.parseInt(mShowCount.getText().toString());
//            cheekText();
            Log.d(LOG_TAG, "loading computed.");
        }
        Log.d(LOG_TAG, "MainActivity layout is complete.");
    }

    public void onSaveInstanceState(Bundle outState) {
        Log.d("MainActivity", "This is 109_2HW04 log statement. Bundle");
        super.onSaveInstanceState(outState);
//        outState.putString("textViewCount", mShowCount.getText().toString());
    }

    private void showToast_toHW(String needWhat){
        Toast toast = Toast.makeText(this, "whating to creat \"" + needWhat + "\".", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void toHW01(View view) {
        showToast_toHW("toHW01");
//        Intent intent = new Intent(this, Homework01.class); //指定要切換的activity給intent
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        } else {
//            Log.d("OpenHomework", "Can't open HW04!");
//        }
    }


    public void toHW02(View view) {
        showToast_toHW("toHW02");
//        Intent intent = new Intent(this, Homework02.class); //指定要切換的activity給intent
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        } else {
//            Log.d("OpenHomework", "Can't open HW04!");
//        }
    }


    public void toHW03(View view) {
        showToast_toHW("toHW03");
//        Intent intent = new Intent(this, Homework03.class); //指定要切換的activity給intent
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        } else {
//            Log.d("OpenHomework", "Can't open HW04!");
//        }
    }

    public void toHW04(View view) {
        Intent intent = new Intent(this, Homework04.class); //指定要切換的activity給intent
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("OpenHomework", "Can't open HW04!");
        }
    }

    public void toHW05(View view){
        Intent intent = new Intent(this, Homework05.class); //指定要切換的activity給intent
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("OpenHomework", "Can't open HW05!");
        }
//        Bundle bundle = new Bundle(); //使用bundle來傳遞資料
//        bundle.putString("count", Integer.toString(mCount)); //將count數字存入bundle內
//        intent.putExtras(bundle); //將bundle包進intent
//        startActivity(intent); //啟動intent建立Activity
    }

    public void toHW06(View view) {
        Intent intent = new Intent(this, Homework06.class); //指定要切換的activity給intent
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("OpenHomework", "Can't open HW04!");
        }
    }

    //查看各個狀態
    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }
    public void onPause(){
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }
    public void onRestart(){
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }
    public void onResume(){
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }
    public void onStop(){
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }
    public void onDestroy(){
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }
}