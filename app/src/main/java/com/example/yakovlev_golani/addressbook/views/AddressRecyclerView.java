package com.example.yakovlev_golani.addressbook.views;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

public class AddressRecyclerView extends RecyclerView {
    public AddressRecyclerView(Context context) {
        super(context);
        init();
    }

    public AddressRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AddressRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);
        setLayoutManager(layoutManager);
    }
}
