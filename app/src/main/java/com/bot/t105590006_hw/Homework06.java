package com.bot.t105590006_hw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class Homework06 extends AppCompatActivity {
    /* 04.2: Input controls */
    CheckBox box01;
    CheckBox box02;
    CheckBox box03;
    CheckBox box04;
    CheckBox box05;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework06);

        /* 04.2: Input controls */
        box01 = (CheckBox)findViewById(R.id.hw06_checkBox_01);
        box02 = (CheckBox)findViewById(R.id.hw06_checkBox_02);
        box03 = (CheckBox)findViewById(R.id.hw06_checkBox_03);
        box04 = (CheckBox)findViewById(R.id.hw06_checkBox_04);
        box05 = (CheckBox)findViewById(R.id.hw06_checkBox_05);
        if(savedInstanceState != null){
            Log.d(this.getClass().getName(), getString(R.string.loadSaveState));
            boxLoad(box01, savedInstanceState.getString("box01"));
            boxLoad(box02, savedInstanceState.getString("box02"));
            boxLoad(box03, savedInstanceState.getString("box03"));
            boxLoad(box04, savedInstanceState.getString("box04"));
            boxLoad(box05, savedInstanceState.getString("box05"));
        }
    }
    private void boxLoad(CheckBox box, String saveState){
        if(saveState == "true") {
            box.setSelected(true);
        }
        else{
            box.setSelected(false);
        }
    }

    private String boxBackUp(CheckBox box){
        if(box.isChecked()){
            return "true";
        }
        return "false";
    }

    public void onSaveInstanceState(Bundle outState) {
        Log.d(this.getClass().getName(), "backUp");
        super.onSaveInstanceState(outState);
        outState.putString("box01", boxBackUp(box01));
        outState.putString("box02", boxBackUp(box02));
        outState.putString("box03", boxBackUp(box03));
        outState.putString("box04", boxBackUp(box04));
        outState.putString("box05", boxBackUp(box05));
    }

    /* 04.2: Input controls */
    private String checkCheckBox(CheckBox box){
        if(box.isChecked()){
            return " " + box.getText().toString();
        }
        return "";
    }

    public void onSubmit(View view){
        String message="";
        message += getString(R.string.hw06_toast_title);
        message += checkCheckBox(box01);
        message += checkCheckBox(box02);
        message += checkCheckBox(box03);
        message += checkCheckBox(box04);
        message += checkCheckBox(box05);
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
    /* 04.2: Input controls end */
}