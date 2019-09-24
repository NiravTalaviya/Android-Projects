package com.example.stmart;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.zxing.WriterException;

import org.w3c.dom.Text;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class image extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        final Intent it=getIntent();
        String s = it.getStringExtra("download");
        ImageView v = findViewById(R.id.showproduct);
        Glide.with(this).load(s).into(v);
        String inputValue=(it.getStringExtra("name")+" "+it.getStringExtra("price"));


        QRGEncoder qrgEncoder = new QRGEncoder(inputValue, null, QRGContents.Type.TEXT,100);
        ImageView qrImage=findViewById(R.id.qr);
        try {
            Bitmap bitmap = qrgEncoder.encodeAsBitmap();
            qrImage.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }


        Button b = findViewById(R.id.getdetail);
        final Context c = this;
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(c,productdetail.class);
                intent.putExtra("name",it.getStringExtra("name"));
                intent.putExtra("price",it.getStringExtra("price"));
                startActivity(intent);
            }
        });



    }

}
