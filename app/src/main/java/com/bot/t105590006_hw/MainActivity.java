package com.bot.t105590006_hw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = "Activity";
    private int mCount=0;
    private TextView mShowCount;
    private EditText mEditText;
    private View zeroButton;
    private View countButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(LOG_TAG, "------");
        Log.d(LOG_TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.main_tview_count);
        mEditText = findViewById(R.id.main_edit_text);
//        zeroButton = findViewById(R.id.button_zero);
        countButton = findViewById(R.id.main_button_count);
//        zeroButton.setBackgroundColor(getResources().getColor(R.color.darker_gray));
        if(savedInstanceState != null) {
            Log.d(LOG_TAG, "loading save instance.");
            mShowCount.setText(savedInstanceState.getString("textViewCount"));
            mCount = Integer.parseInt(mShowCount.getText().toString());
            cheekText();
            Log.d(LOG_TAG, "loading computed.");
        }
        Log.d(LOG_TAG, "MainActivity layout is complete.");
    }


    public void onSaveInstanceState(Bundle outState) {
        Log.d("MainActivity", "This is 109_2HW04 log statement. Bundle");
        super.onSaveInstanceState(outState);
        outState.putString("textViewCount", mShowCount.getText().toString());
    }


    public void showToast(View view){
        Toast toast = Toast.makeText(this, "toast count: " + mShowCount.getText().toString(), Toast.LENGTH_SHORT);
        toast.show();
    }
    public void sayHello(View view){ //將畫面切換到helloToast
        Intent intent = new Intent(this, helloToast.class); //指定要切換的activity給intent
        Bundle bundle = new Bundle(); //使用bundle來傳遞資料
        bundle.putString("count", Integer.toString(mCount)); //將count數字存入bundle內
        intent.putExtras(bundle); //將bundle包進intent
        startActivity(intent); //啟動intent建立Activity
    }
    public void resetCount(View view){
        mCount = 0;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
            zeroButton.setBackgroundColor(getResources().getColor(R.color.darker_gray));
            cheekText();
        }
    }
    public void addCount(View view){
        ++mCount;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
            if(zeroButton != null) {
                zeroButton.setBackgroundColor(getResources().getColor(R.color.purple_500));
            }
            cheekText();
        }
    }
    private void cheekText(){
        if (mCount%2 == 1){ //odd
            countButton.setBackgroundColor(getResources().getColor(R.color.teal_700));
        }
        else{   //even
            countButton.setBackgroundColor(getResources().getColor(R.color.bule));
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