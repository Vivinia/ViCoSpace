package com.example.vico.vicospace;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class InsertMemoryDateActivity extends AppCompatActivity {

    private TextView tvInsertMemortDate;

    private Calendar cal;
    private int nowYear,nowMonth,nowDay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_memory_date);

        //初始化
        init();

        //获取日期
        getDate();

    }

    //获取日期
    private void getDate() {
        cal= Calendar.getInstance();
        nowYear=cal.get(Calendar.YEAR);   //获取当年年份
        nowMonth=cal.get(Calendar.MONTH);
        nowDay=cal.get(Calendar.DAY_OF_MONTH);
        tvInsertMemortDate.setText(nowYear+":"+nowMonth+":"+nowDay);
    }

    //初始化
    private void init() {
        tvInsertMemortDate= (TextView) findViewById(R.id.tvInsertMemortDate);
    }

    //点击事件
    public void insertMemoryDateClick(View view){
        switch (view.getId()){
            case R.id.tvInsertMemortDate:
                //打开对话框
                showSelectDialog();
                break;
        }
    }

    //打开对话框
    private void showSelectDialog() {
        OnDateSetListener listener=new OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                tvInsertMemortDate.setText(year+":"+(++month)+":"+day);
            }
        };
        DatePickerDialog dialog=new DatePickerDialog(InsertMemoryDateActivity.this,0,listener,nowYear,nowMonth,nowDay);
        dialog.show();
    }
}
