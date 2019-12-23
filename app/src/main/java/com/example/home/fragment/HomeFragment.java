package com.example.home.fragment;

import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.base.BaseFragment;
import com.example.elearining.R;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Request;

public class HomeFragment extends BaseFragment {

    private RecyclerView rvHome;
    //private ImageView ib_top;//置顶按钮
    private TextView tv_search_home;
    private TextView tv_message_home;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_home,null);
        tv_search_home = view.findViewById(R.id.tv_search_home);
        tv_message_home = view.findViewById(R.id.tv_message_home);

        initListener();
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        String url = "http://www.csdn.net/";
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback()
                {
                    //当请求失败回调
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    //当联网成功回调
                    @Override
                    public void onResponse(String response, int id) {

                    }
                });
    }

    private void initListener() {
        //搜索监听
        tv_search_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"搜索",Toast.LENGTH_SHORT).show();
            }
        });
        //消息监听
        tv_message_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"进入消息中心",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
