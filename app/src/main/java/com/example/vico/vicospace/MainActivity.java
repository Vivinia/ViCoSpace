package com.example.vico.vicospace;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Intent intent;

    private String[] alertdialogItemList={"每日说","纪念日","照片","文章"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //设置标题
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("已相恋：0天0小时0分0秒");
        getSupportActionBar().setElevation(0);
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
