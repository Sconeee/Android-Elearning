package com.example.type.fragment;

import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.base.BaseFragment;

public class TypeFragment extends BaseFragment {
    private TextView textView;
    @Override
    public View initView() {
        textView=new TextView(mContext);
        textView.setText("分类页面内容");
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(25);
        return textView;
    }
}
