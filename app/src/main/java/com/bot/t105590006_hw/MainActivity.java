package com.bot.t105590006_hw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mCount=0;
    private TextView mShowCount;
    private View zeroButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
        zeroButton = findViewById(R.id.button_zero);
        zeroButton.setBackgroundColor(getResources().getColor(R.color.darker_gray));

        Log.i("MainActivity", "This is 109_2HW1 log statement. MainActivity layout is complete.");
    }


    public void showToast(View view){
        Toast toast = Toast.makeText(this, "toast count: " + mShowCount.getText().toString(), Toast.LENGTH_SHORT);
        toast.show();
    }
    public void resetCount(View view){
        mCount = 0;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
            zeroButton.setBackgroundColor(getResources().getColor(R.color.darker_gray));

    }
    public void addCount(View view){
        ++mCount;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
            zeroButton.setBackgroundColor(getResources().getColor(R.color.purple_500));
        }
    }
}