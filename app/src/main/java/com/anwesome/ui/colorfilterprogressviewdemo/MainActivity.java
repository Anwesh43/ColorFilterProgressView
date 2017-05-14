package com.anwesome.ui.colorfilterprogressviewdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

import com.anwesome.ui.colorfilterprogressview.ColorFilterProgressView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.forest2);
        ColorFilterProgressView colorFilterProgressView = new ColorFilterProgressView(this,bitmap);
        addContentView(colorFilterProgressView,new ViewGroup.LayoutParams(300,300));
    }
}
