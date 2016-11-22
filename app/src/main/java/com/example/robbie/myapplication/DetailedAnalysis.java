package com.example.robbie.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class DetailedAnalysis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_analysis);
        ImageView iv = (ImageView)findViewById(R.id.image_view2);
       iv.setImageBitmap(CameraActivity.getImage());
      //  iv.setImageResource(R.drawable.image_name);
    }
}
