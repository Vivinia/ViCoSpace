package com.example.vico.vicospace;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class InsertMemoryDateActivity extends AppCompatActivity {

    private TextView tvInsertMemortDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_memory_date);

        init();

    }

    private void init() {
        tvInsertMemortDate= (TextView) findViewById(R.id.tvInsertMemortDate);
    }
    public void insertMemoryDateClick(View view){
        switch (view.getId()){
            case R.id.tvInsertMemortDate:
                showSelectDialog();
                break;
        }
    }

    private void showSelectDialog() {
    }
}
