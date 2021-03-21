package com.bot.t105590006_hw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
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
    private EditText mWebsiteEditText;
    private EditText mLocationEditText;
    private EditText mShareTextEditText;

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
        mWebsiteEditText = findViewById(R.id.main_edit_uri);
        mLocationEditText = findViewById(R.id.main_edit_loc);
        mShareTextEditText = findViewById(R.id.main_edit_share);
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

    public void openWebsite(View view) { //從editText取得網址來開啟網頁
        //從editText取得網址字串
        String url = mWebsiteEditText.getText().toString();
        //使用URI建立Intent
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        //如果成功: 開啟；失敗: 回傳LOG-Debug
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }
    public void openLocation(View view) { //從editText取得地址來開啟
    //從editText取得地址字串
        String loc = mLocationEditText.getText().toString();
        //使用URI建立Intent
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc); //"geo:0,0?q=" -> 地址模式
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        //如果成功: 開啟；失敗: 回傳LOG-Debug
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }
    public void shareText(View view) {
        String txt = mShareTextEditText.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                .setText(txt)
                .startChooser();
    }
    public void toCam(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //如果成功: 開啟；失敗: 回傳LOG-Debug
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        else {
            Log.d("ImplicitIntents", "Can't open cam intent!");
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