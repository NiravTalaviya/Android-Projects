package com.example.stmart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class productdetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productdetail);

        final Intent it=getIntent();
        TextView txt=findViewById(R.id.productname);
        txt.setText("Product Name : "+it.getStringExtra("name"));
        TextView ttxt=findViewById(R.id.protprice);
        ttxt.setText("Price : "+it.getStringExtra("price"));
    }
}
