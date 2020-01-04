package com.example.cart.fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.base.BaseFragment;
import com.example.cart.utils.CartStorage;
import com.example.home.bean.GoodsBean;

import java.util.List;

import static android.content.ContentValues.TAG;

public class CartFragment extends BaseFragment {
    private TextView textView;
    @Override
    public View initView() {
        textView=new TextView(mContext);
        textView.setText("我的课程页面内容");
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(25);
        return textView;
    }
    @Override
    public void initData() {
        super.initData();
        Log.e(TAG, "我的课程的Fragment的数据被初始化了");
        textView.setText("我的课程内容");
        List<GoodsBean> goodsbeanList =  CartStorage.getInstance().getAllData();
        for (int i=0;i<goodsbeanList.size();i++){
            Log.e("TAG",goodsbeanList.get(i).toString());
        }
    }
}
