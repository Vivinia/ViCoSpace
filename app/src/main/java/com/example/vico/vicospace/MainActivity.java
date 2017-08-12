package com.example.vico.vicospace;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Intent intent;

    private TextView tvLoveDays,tvLoveHoursMinutesSeconds;

    private String[] alertdialogItemList={"每日说","纪念日","照片","文章"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //初始化控件
        info();

        //立即调用该方法
        handler.post(runnable);
    }

    //立即调用方法
        Handler handler = new Handler();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(runnable,1000);
                //计算相恋时间
                culLoveDate();
            }
        };

    //初始化控件
    private void info() {
        tvLoveDays= (TextView) findViewById(R.id.tvLoveDays);
        tvLoveHoursMinutesSeconds= (TextView) findViewById(R.id.tvLoveHoursMinutesSeconds);
    }

    //计算相恋时间
    private void culLoveDate() {
        SimpleDateFormat dfs=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long between = 0;
        try {
            Date begin = dfs.parse("2015-04-11 09:09:09");  //设置开始计算时间
            Date end = new Date(System.currentTimeMillis());//获取当前时间
            between = (end.getTime() - begin.getTime());// 得到两者的秒数
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        long day = between / (24 * 60 * 60 * 1000);
        long hour = (between / (60 * 60 * 1000) - day * 24);
        long min = ((between / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long sec = (between / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        String loveDays="已相恋："+day+"天";
        String loveHoursMinutesSeconds=hour+"时"+min+"分"+sec+"秒";
        tvLoveDays.setText(loveDays);
        tvLoveHoursMinutesSeconds.setText(loveHoursMinutesSeconds);
    }

    public void selectInsert(View view){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setItems(alertdialogItemList, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"我点击了"+alertdialogItemList[i],Toast.LENGTH_SHORT).show();
                switch (i){
                    case 0:
                        intent=new Intent(MainActivity.this,InsertDailySaidActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent=new Intent(MainActivity.this,InsertMemoryDateActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent=new Intent(MainActivity.this,InsertPictureActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent=new Intent(MainActivity.this,InsertArticleActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.actionMessage) {
            return true;
        }else if(id == R.id.actionPrivateLetter) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
