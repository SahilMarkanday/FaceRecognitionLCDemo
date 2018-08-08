package com.facerecognitionlcdemo.marka.facerecognitionlcdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import org.json.JSONException;
import org.opencv.core.Mat;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class AdminActivity extends AppCompatActivity {
    private static final String TAG = AdminActivity.class.getSimpleName();
    private Toast mToast;
    Button reg;
    Button remove;
    Button adminlogout;
    private ArrayList<Mat> images;
    private ArrayList<String> imagesLabels;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        reg = (Button)findViewById(R.id.reg);
        remove = (Button)findViewById(R.id.remove);
        adminlogout = (Button)findViewById(R.id.adminlogout);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(AdminActivity.this, FaceRecognitionAppActivity.class);
                startActivity(i);
            }
        });
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Cleared training set");
                images.clear(); // Clear both arrays, when new instance is created
                imagesLabels.clear();
                showToast("Training set cleared", Toast.LENGTH_SHORT);

            }
        });
        adminlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
    private void showToast(String message, int duration) {
        if (duration != Toast.LENGTH_SHORT && duration != Toast.LENGTH_LONG)
            throw new IllegalArgumentException();
        if (mToast != null && mToast.getView().isShown())
            mToast.cancel(); // Close the toast if it is already open
        mToast = Toast.makeText(this, message, duration);
        mToast.show();
    }
}
