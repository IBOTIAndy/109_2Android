package com.bot.t105590006_hw;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

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
        /*04.3: Menus and pickers*/
        Toolbar toolbar = findViewById(R.id.hw06_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();    //取得manifests內的xml設定
        actionBar.setDisplayHomeAsUpEnabled(true);      //設定返回按鈕(顯示(display)返回home(home_as_up)啟用(enabled))
        actionBar.setDisplayShowTitleEnabled(true); //顯示titel
        actionBar.setHomeButtonEnabled(true);   //

        toolbar.inflateMenu(R.menu.menu_homework06);    //指定使用哪個menu
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {  //設定一系列當menu item被按下時的反應
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){  //被選到的item id
                    case R.id.hw06_item_shopping_car:
                        //要做的事
                        return true;
                    case R.id.hw06_item_settings:
                        Toast toast;
                        return true;
                    default:
                        Log.d(this.getClass().getName(), getString(R.string.menuItemDefault));
                }
                return Homework06.super.onOptionsItemSelected(item);    //還不知道這行的用處
            }
        });
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

    /* 04.3: Menus and pickers */
    public void processDatePickerResult(int year, int month, int day){
        String month_string = Integer.toString(month + 1);  //因為month的一月是0 所以要+1
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (year_string + "/" + month_string + "/" + day_string);
        Toast.makeText(this, "Date: " + dateMessage, Toast.LENGTH_SHORT).show();
    }

    public void showDatePicker(View view){
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
        Toast toast;
    }
    /* 04.3: Menus and pickers end */
}