package com.example.andy.fitex_wear;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextClock;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView mTextView;
    private TextClock mTextClock;
    private ProgressBar pBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);
                //mTextClock = (TextClock) stub.findViewById(R.id.textClock);
                pBar = (ProgressBar) stub.findViewById(R.id.progressWheel);
                pBar.setSecondaryProgress(20);
            }
        });
    }

    public void onRankClick(View view) {
        Intent intent = new Intent(this, Rank.class);
        this.startActivity(intent);
    }

    public void onMessageClick(View view) {
        Intent intent = new Intent(this, Message.class);
        this.startActivity(intent);
    }

    public void onTeamClick(View view) {
        Intent intent = new Intent(this, Team.class);
        this.startActivity(intent);
    }

    public void onAddClick(View view) {
        Intent intent = new Intent(this, Add.class);
        this.startActivity(intent);
    }
}

//import android.os.Bundle;
//import android.support.wearable.activity.WearableActivity;
//import android.support.wearable.view.BoxInsetLayout;
//import android.view.View;
//import android.widget.Button;
//import android.widget.GridLayout;
//import android.widget.TextView;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Locale;
//
//public class MainActivity extends WearableActivity {
//
//    private static final SimpleDateFormat AMBIENT_DATE_FORMAT =
//            new SimpleDateFormat("HH:mm", Locale.US);
//
//    private GridLayout mContainerView;
//    private TextView mTextView;
//    private TextView mClockView;
//    private Button mButton;
//    private boolean lol;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_andy);
//        setAmbientEnabled();
//
//        mContainerView = (GridLayout) findViewById(R.id.bam);
//        mTextView = (TextView) findViewById(R.id.thething);
//        //mClockView = (TextView) findViewById(R.id.clock);
//        mButton = (Button) findViewById(R.id.dothething);
//        lol = false;
//        mButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                System.out.print("Whoot Whoot!");
//                if (lol) {
//                    mTextView.setText("Hello World!");
//                } else {
//                    mTextView.setText("Goodbye World!");
//                }
//                lol = !lol;
//            }
//        });
//    }
//
//    @Override
//    public void onEnterAmbient(Bundle ambientDetails) {
//        super.onEnterAmbient(ambientDetails);
//        updateDisplay();
//    }
//
//    @Override
//    public void onUpdateAmbient() {
//        super.onUpdateAmbient();
//        updateDisplay();
//    }
//
//    @Override
//    public void onExitAmbient() {
//        updateDisplay();
//        super.onExitAmbient();
//    }
//
//    private void updateDisplay() {
//        if (isAmbient()) {
//            mContainerView.setBackgroundColor(getResources().getColor(android.R.color.black));
//            mTextView.setTextColor(getResources().getColor(android.R.color.white));
//            //mClockView.setVisibility(View.VISIBLE);
//
//            //mClockView.setText(AMBIENT_DATE_FORMAT.format(new Date()));
//        } else {
//            mContainerView.setBackground(null);
//            mTextView.setTextColor(getResources().getColor(android.R.color.black));
//            //mClockView.setVisibility(View.GONE);
//        }
//    }
//
//
//}