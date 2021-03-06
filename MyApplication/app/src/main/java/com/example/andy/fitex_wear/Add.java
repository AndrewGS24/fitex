package com.example.andy.fitex_wear;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;

public class Add extends Activity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);
            }
        });
    }

    public void onExerciseClick(View view) {
        Intent intent = new Intent(this, Exercise.class);
        this.startActivity(intent);
    }

    public void onFruitClick(View view) {
        Intent intent = new Intent(this, Fruit.class);
        this.startActivity(intent);
    }
}
