package com.example.robbie.myapplication;

import android.app.Dialog;
import android.content.DialogInterface;
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

//                final CharSequence[] items = {"Red", "Green", "Blue"};
                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                builder.setTitle("Pick a color");
                builder.setCancelable(false);
                //  builder.setPositiveButton(R.string.dialog_action_dismiss, null);

//                // creating a single choice item menu (radio buttons list)
//                // -1 indicates that no item should be selected by default
//                // pass index argument starting from 0 to preselect an item if required
//                builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int item) {
//                        Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
//                    }
//                });
//
                AlertDialog alert = builder.create();
                alert.show();

            }
        });


      //  iv.setImageResource(R.drawable.image_name);
    }
}
