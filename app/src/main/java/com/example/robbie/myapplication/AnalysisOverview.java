package com.example.robbie.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AnalysisOverview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis_overview);
        Button nextButton =
                (Button) this.findViewById(R.id.button3);
        nextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intentDetailed = new Intent(AnalysisOverview.this,DetailedAnalysis.class);
                startActivity(intentDetailed);
            }
        });

    }
}
