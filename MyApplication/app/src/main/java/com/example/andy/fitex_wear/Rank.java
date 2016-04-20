package com.example.andy.fitex_wear;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.support.wearable.view.WearableListView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Rank extends Activity implements WearableListView.ClickListener {

    private TextView mTextView;
    private WearableListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);

        //Default
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);
                lv = (WearableListView) stub.findViewById(R.id.listViewRank);
                lv.setAdapter(new MyAdapter(Rank.this));
                lv.setClickListener(Rank.this);
            }
        });
    }

    @Override
    public void onClick(WearableListView.ViewHolder viewHolder) {

    }

    @Override
    public void onTopEmptyRegionClick() {

    }

    private static ArrayList<String> listItems;
    static {
        listItems = new ArrayList<String>();
        listItems.add("Monday");
        listItems.add("Tuesday");
        listItems.add("Wednesday");
        listItems.add("Thursday");
        listItems.add("Friday");
    }

    private class MyAdapter extends WearableListView.Adapter {
        private final LayoutInflater mInflater;

        private MyAdapter(Context context) {
            mInflater = LayoutInflater.from(context);
        }

        @Override
        public WearableListView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new WearableListView.ViewHolder(
                    mInflater.inflate(R.layout.custom_row, null));
        }

        @Override
        public void onBindViewHolder(WearableListView.ViewHolder holder, int position) {
            TextView view = (TextView) holder.itemView.findViewById(R.id.textView);
            view.setText(position + ". " + listItems.get(position).toString());
            holder.itemView.setTag(position);
        }

        @Override
        public int getItemCount() {
            return listItems.size();
        }
    }
}
