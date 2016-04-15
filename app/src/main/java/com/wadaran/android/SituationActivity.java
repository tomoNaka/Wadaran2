package com.wadaran.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SituationActivity extends AppCompatActivity {

    public Button bGokon;
    public Button bDate;
    public Button bNomikai;
    public AsyncHttpTask situationHttpTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_situation);

        bGokon = (Button)findViewById(R.id.button_gokon);
        bDate = (Button)findViewById(R.id.button_date);
        bNomikai = (Button)findViewById(R.id.button_nomi);

        bGokon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                situationHttpTask = new AsyncHttpTask(SituationActivity.this);
                situationHttpTask.execute(Constants.S_GOKON);
            }
        });
    }
}
