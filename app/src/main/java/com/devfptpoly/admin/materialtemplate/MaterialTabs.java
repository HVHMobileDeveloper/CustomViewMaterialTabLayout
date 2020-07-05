package com.devfptpoly.admin.materialtemplate;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class MaterialTabs extends HorizontalScrollView {

    private LinearLayout linearChild;
    private Context context;
    private List<AppCompatButton> tabs = new ArrayList<>();

    /**
     * attributes
     */
    private int countsTabs;
    private int bg_normal_color;
    private int bg_selected_color;

    public MaterialTabs(Context context) {
        super(context);
    }

    public MaterialTabs(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public MaterialTabs(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        this.context = context;
        TypedArray typedArray = this.setAttribute(attrs);
        typedArray.recycle();

        linearChild = new LinearLayout(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        linearChild.setLayoutParams(params);
        linearChild.setOrientation(LinearLayout.HORIZONTAL);
        this.addView(linearChild);
        this.setHorizontalScrollBarEnabled(false);
        this.onSetTabs();
        this.onSetCurrent(0);
    }

    private TypedArray setAttribute(AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MaterialTabs);
        this.countsTabs = typedArray.getInteger(R.styleable.MaterialTabs_mt_items, 0);
        this.bg_normal_color = typedArray.getColor(R.styleable.MaterialTabs_mt_bg_normal, ContextCompat.getColor(context, R.color.white));
        this.bg_selected_color = typedArray.getColor(R.styleable.MaterialTabs_mt_bg_selected, ContextCompat.getColor(context, R.color.colorPrimary));
        return typedArray;
    }

    private void onSetTabs() {
        int withScreen = Resources.getSystem().getDisplayMetrics().widthPixels;

        if (countsTabs > 0) {
            for (int i = 0; i < countsTabs; i++) {
                final AppCompatButton btn = new AppCompatButton(context);
                btn.setText(String.valueOf(i + 1));
                int finalIndex = i;
                btn.setOnClickListener(v -> {
                    int scrollX = (btn.getLeft() - (withScreen / 2)) + (btn.getWidth() / 2);
                    this.smoothScrollTo(scrollX, 0);
                    onSetCurrent(finalIndex);
                });
                btn.setTag(i);
                tabs.add(btn);
                linearChild.addView(btn);
            }
        }
    }

    private void onSetCurrent(int index) {
        for (AppCompatButton tab : tabs) {
            final boolean isSelected = (Integer) tab.getTag() == index;
            final int bgColor = isSelected ? bg_selected_color : bg_normal_color;
            final int tvColor = isSelected ? bg_normal_color : bg_selected_color;
            tab.setBackgroundColor(bgColor);
            tab.setTextColor(tvColor);
        }
    }

}