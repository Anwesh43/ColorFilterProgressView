package com.anwesome.ui.colorfilterprogressviewdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

import com.anwesome.ui.colorfilterprogressview.CFPVList;
import com.anwesome.ui.colorfilterprogressview.ColorFilterProgressView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.forest2);
        CFPVList cfpvList = new CFPVList(this);
        for(int i=0;i<25;i++) {
            cfpvList.addImage(bitmap);
        }
        cfpvList.show();
    }
}
