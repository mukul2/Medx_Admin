package com.winkcoo.medx.admin.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.winkcoo.medx.admin.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.winkcoo.medx.admin.data.data.IMAGE_BASE;

public class ImageViewFullScreen extends AppCompatActivity {
    @BindView(R.id.img)
    ImageView img;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view_full_screen);
        ButterKnife.bind(this);
        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            String j =(String) b.get("link");
            Glide.with(context).load(IMAGE_BASE + j).into(img);
            Toast.makeText(context, j, Toast.LENGTH_SHORT).show();



        }
    }
}