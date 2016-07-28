package com.abc.app.memberapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImageActivity extends Activity implements View.OnClickListener{
    ImageView iv_mid;
    Button bt_prev, bt_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        iv_mid = (ImageView) findViewById(R.id.iv_mid);
        bt_next = (Button) findViewById(R.id.bt_next);
        bt_prev = (Button) findViewById(R.id.bt_prev);

        bt_next.setOnClickListener(this);
        bt_prev.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_next :
                iv_mid.setImageResource(R.drawable.desert);
                bt_prev.setVisibility(View.VISIBLE);
                bt_next.setVisibility(View.INVISIBLE);
                break;

            case R.id.bt_prev :
                iv_mid.setImageResource(R.drawable.hydrangeas);
                bt_next.setVisibility(View.VISIBLE);
                bt_prev.setVisibility(View.INVISIBLE);
                break;
        }
    }
}