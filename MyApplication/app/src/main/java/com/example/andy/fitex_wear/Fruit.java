package com.example.andy.fitex_wear;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;

public class Fruit extends Activity {

    private TextView mTextView;
    private double fruitCount;
    private TextView cupCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);
            }
        });
        fruitCount = 0;
        cupCount = (TextView) stub.findViewById(R.id.cupCount);
    }
    public void onUpClick(View view) {
        fruitCount += .5;
        updateMsg();
    }

    public void onDownClick(View view) {
        if (fruitCount > 0) {
            fruitCount -= .5;
            updateMsg();
        }
    }

    private void updateMsg()
    {
        cupCount.setText(fruitCount + " cups");
    }
}
