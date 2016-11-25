package com.example.robbie.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;

public class CameraActivity extends Activity {
    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView;
    boolean image = false;
    private static Bitmap photoImage;
    private final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        this.imageView = (ImageView)this.findViewById(R.id.image_view);
        Button photoButton = (Button) this.findViewById(R.id.button);
        photoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });

        Button analysisButton = (Button) this.findViewById(R.id.button2);
        analysisButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (image = true){

                    Intent DrawableActivity = new Intent(CameraActivity.this, DrawableActivity.class);
                    startActivity(DrawableActivity);

            //    Intent analysisOverView = new Intent(CameraActivity.this, AnalysisOverview.class);
              //  startActivity(analysisOverView);
                }
                else {
                  //show dialog shit here
                   // dialog.show();
                }
            }
        });
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            setPhoto(photo);
            imageView.setImageBitmap(photo);
            image = true;


        }
    }

  /*  @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            if (surfaceHolder.getSurface().isValid()) {
                Canvas canvas = surfaceHolder.lockCanvas();
                canvas.drawColor(Color.RED);
                canvas.drawCircle(event.getX(), event.getY(), 50, paint);
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
        return false;
    }*/

    public void setPhoto(Bitmap photo){
        this.photoImage =  photo;
    }
    public static Bitmap getImage(){
        return photoImage;
    }
} /*  Button button;
    ImageView imageView;
    String bob;
    static final int CAM_REQUEST = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        button = (Button) findViewById(R.id.button);
        imageView = (ImageView) findViewById(R.id.image_view);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getFile();
                camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(camera_intent, CAM_REQUEST);

            }
        });

    }

    private File getFile() {
      //  File folder = new File("storage/emulated/0/DCIM/camera_app");
        String storageDir = Environment.getExternalStorageDirectory().getAbsolutePath();
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = timeStamp +"cam_image.jpg";
        File folder = new File(storageDir+"/posture_App");

       // OutputStream output = new FileOutputStream(imageFile);
        if (!folder.exists()) {
            folder.mkdir();
        }

        File image_file = new File(folder,fileName );

        bob = folder + fileName;
        Log.d("MyAPP", "Iamhere");
        return image_file;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //String path = "storage/emulated/0/DCIM/camera_app/cam_image.jpg";
        imageView.setImageDrawable(Drawable.createFromPath(bob));
    }
}
*/

