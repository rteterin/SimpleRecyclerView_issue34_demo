package com.test.test;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jaychang.srv.SimpleCell;
import com.jaychang.srv.SimpleRecyclerView;
import com.jaychang.srv.SimpleViewHolder;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SimpleRecyclerView simpleRecyclerView = findViewById(R.id.recyclerView);
        simpleRecyclerView.setLoadMoreView(R.layout.load_more);
        simpleRecyclerView.addCell(new Cell("test1"));
        simpleRecyclerView.addCell(new Cell("test2"));
        simpleRecyclerView.addCell(new Cell("test3"));

        findViewById(R.id.showLoadMore).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpleRecyclerView.setLoadingMore(true);
            }
        });

        findViewById(R.id.hideLoadMore).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpleRecyclerView.setLoadingMore(false);
            }
        });

        findViewById(R.id.showHideLoadMore).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simpleRecyclerView.setLoadingMore(true);
                simpleRecyclerView.setLoadingMore(false);
            }
        });
    }

    static class Cell extends SimpleCell<String, Cell.ViewHolder> {

        Cell(@NonNull String item) {
            super(item);
        }

        @Override
        protected int getLayoutRes() {
            return R.layout.cell;
        }

        @NonNull
        @Override
        protected ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, @NonNull View view) {
            return new ViewHolder(view);
        }

        @Override
        protected void onBindViewHolder(@NonNull ViewHolder viewHolder,
                                        int i,
                                        @NonNull Context context,
                                        Object o) {

            viewHolder.textView.setText(getItem());
        }

        static class ViewHolder extends SimpleViewHolder {
            private TextView textView;

            ViewHolder(@NonNull View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.textView);
            }
        }
    }
}
