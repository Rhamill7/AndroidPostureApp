package com.example.robbie.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import android.widget.Toast;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;

import static java.lang.Float.valueOf;

public class CameraActivity extends Activity {
    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView;
    boolean image = false;
    private static Bitmap photoImage;
  //  private final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int RESULT_LOAD_IMG =1;
    Bitmap bitmap;
    Canvas canvas;
    Paint paint ;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        this.imageView = (ImageView)this.findViewById(R.id.image_view);


        //-------------------------------------------------------------

        bitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        canvas.drawCircle(50, 50, 10, paint);
        imageView.setImageBitmap(bitmap);

        //---------------------------------------------------------------

        Button photoButton = (Button) this.findViewById(R.id.button);
        photoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });

/*
        Button galleryButton = (Button) this.findViewById(R.id.button4);
        galleryButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Create intent to Open Image applications like Gallery, Google Photos
                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        // Start the Intent
                startActivityForResult(galleryIntent, RESULT_LOAD_IMG);//RESULT_LOAD_IMG);
            }
        });
*/


        Button analysisButton = (Button) this.findViewById(R.id.button2);
        analysisButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (image == true){

                  //  Intent DrawableActivity = new Intent(CameraActivity.this, DrawableActivity.class);
                  //  startActivity(DrawableActivity);

               Intent analysisOverView = new Intent(CameraActivity.this, AnalysisOverview.class);
              startActivity(analysisOverView);
                }
                else {
                    Toast.makeText(CameraActivity.this, "You haven't picked an Image",
                            Toast.LENGTH_LONG).show();
                  //show dialog shit here
                   // dialog.show();
                }
            }
        });


        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    // textView.setText("Touch coordinates : " +
                    //       String.valueOf(event.getX()) + "x" + String.valueOf(event.getY()));
                    canvas = new Canvas(bitmap);
                    paint = new Paint(Paint.ANTI_ALIAS_FLAG);
                    paint.setColor(Color.BLUE);
                    // canvas.drawCircle(50, 50, 10, paint);


                    // if (surfaceHolder.getSurface().isValid()) {
                    //   Canvas canvas = surfaceHolder.lockCanvas();
                    //canvas.drawColor(Color.RED);
                    canvas.drawCircle(50, 50, 50, paint);
                    imageView.setImageBitmap(bitmap);
                    Log.d("colour", String.valueOf(event.getX()));
                    canvas.drawCircle((int) event.getX(),(int)(event.getY()), 10, paint);

                }
                return true;
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Log.d("bob", "got to here :( ");
            bitmap = (Bitmap) data.getExtras().get("data");
            setPhoto(bitmap);
            imageView.setImageBitmap(bitmap);
//            canvas = new Canvas(bitmap);
//            paint = new Paint(Paint.ANTI_ALIAS_FLAG);
//            paint.setColor(Color.RED);
//            canvas.drawCircle(50, 50, 10, paint);
//            imageView.setImageBitmap(bitmap);
            image = true;


        }

            //super.onActivityResult(requestCode, resultCode, data);
            else if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK && null != data) {
                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };
                Cursor cursor = getContentResolver().query(selectedImage,filePathColumn, null, null, null);
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String picturePath = cursor.getString(columnIndex);
            Log.d("bob", picturePath);
                cursor.close();
              //  ImageView imageView = (ImageView) findViewById(R.id.imageView);
            Log.d("bob", "tits");
                imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));


                } else {
                    Toast.makeText(this, "You haven't picked an Image",
                            Toast.LENGTH_LONG).show();
                }


    }


/*
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(event.getAction() == MotionEvent.ACTION_DOWN && image == true) {
            canvas = new Canvas(bitmap);
            paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            paint.setColor(Color.BLUE);
           // canvas.drawCircle(50, 50, 10, paint);


            // if (surfaceHolder.getSurface().isValid()) {
             //   Canvas canvas = surfaceHolder.lockCanvas();
                //canvas.drawColor(Color.RED);
           // canvas.drawCircle(50, 50, 50, paint);
            canvas.drawCircle(event.getX(), event.getY(), 50, paint);
            imageView.setImageBitmap(bitmap);
            //    surfaceHolder.unlockCanvasAndPost(canvas);
          //  }
        }
        return false;
    }*/

    public void setPhoto(Bitmap photo){
        this.photoImage =  photo;
    }
    public  Bitmap getImage(){
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

