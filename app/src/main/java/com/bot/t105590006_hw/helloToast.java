package com.bot.t105590006_hw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class helloToast extends AppCompatActivity {
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_toast);

        Bundle bundle = getIntent().getExtras();
        mShowCount = (TextView) findViewById(R.id.hello_count);
        if (mShowCount != null) {
            mShowCount.setText(bundle.getString("count"));
        }
    }
}