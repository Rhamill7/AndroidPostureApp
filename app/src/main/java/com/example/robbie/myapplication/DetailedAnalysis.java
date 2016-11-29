package com.example.robbie.myapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class DetailedAnalysis extends AppCompatActivity {

    CameraActivity ca = new CameraActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_analysis);
        ImageView iv = (ImageView)findViewById(R.id.image_view2);
        iv.setImageBitmap(ca.getImage());

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "ImageClicked",
                        Toast.LENGTH_SHORT).show();

                // TODO Auto-generated method stub
                AlertDialog.Builder alert = new AlertDialog.Builder(DetailedAnalysis.this);
                alert.setTitle("OH NO!");
                alert.setMessage("You have forward head posture! Click OK to learn how to fix it! " +
                        "Click CANCEL to go back and take another picture!");
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.exrx.net/Kinesiology/Posture.html"));
                                startActivity(browserIntent);
                            }
                        });
                alert.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                       finish();
                    }
                });
                alert.show();

            }
        });


      //  iv.setImageResource(R.drawable.image_name);
    }
}
