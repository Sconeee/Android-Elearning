package com.example.home.fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSON;
import com.example.base.BaseFragment;
import com.example.elearning.R;
import com.example.home.adapter.HomeFragmentAdapter;
import com.example.home.bean.ResultBeanData;
import com.example.utils.Constants;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HomeFragment extends BaseFragment {

    private static final String TAG = HomeFragment.class.getSimpleName();

    private RecyclerView rvHome;
    private TextView tv_search_home;
    private TextView tv_message_home;
    private HomeFragmentAdapter adapter;
    private ResultBeanData.ResultBean resultBean;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_home,null);
        rvHome = view.findViewById(R.id.rv_home);
        tv_search_home = view.findViewById(R.id.tv_search_home);
        tv_message_home = view.findViewById(R.id.tv_message_home);

        initListener();
        return view;
    }

    @Override
    public void initData() {
        super.initData();
        getDataFromNet();//联网请求主页数据
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
    private void getDataFromNet(){
        String url = Constants.HOME_URL;

        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback()
                {
                    //当请求失败回调
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.e(TAG,"联网失败");
                    }
                    //当联网成功回调
                    @Override
                    public void onResponse(String response, int id) {
                        //解析数据
                        Log.e(TAG,"联网成功");
                        processData(response);
                    }
                });
    }

    private void processData(String json) {
        ResultBeanData resultBeanData = JSON.parseObject(json,ResultBeanData.class);
        resultBean = resultBeanData.getResult();
        if (resultBean!=null){
            //有数据 设置适配器
            adapter = new HomeFragmentAdapter(mContext,resultBean);
            rvHome.setAdapter(adapter);
            //设置布局管理
            rvHome.setLayoutManager(new GridLayoutManager(mContext,1));
        }
        else{
            //没有数据
        }
    }
}
