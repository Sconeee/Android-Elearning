package com.example.elearning;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.cart.utils.CartStorage;
import com.example.home.bean.GoodsBean;
import com.example.utils.Constants;

public class GoodsInfoActivity extends Activity implements View.OnClickListener {

    private ImageButton ibGoodInfoBack;
    private ImageButton ibGoodInfoMore;
    private ImageView ivGoodInfoImage;
    private TextView tvGoodInfoName;
    private TextView tvGoodInfoDesc;
    private TextView tvGoodInfoPrice;
    private WebView wbGoodInfoMore;
    private LinearLayout llGoodsRoot;
    private TextView tvGoodInfoCallcenter;
    private TextView tvGoodInfoCollection;
    private TextView tvGoodInfoCart;
    private Button btnGoodInfoAddcart;

    private TextView tv_more_share;
    private TextView tv_more_search;
    private TextView tv_more_home;
    private Button btn_more;
    private LinearLayout ll_root;
    private GoodsBean goodsBean;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2020-01-04 16:24:09 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        ibGoodInfoBack = (ImageButton)findViewById( R.id.ib_good_info_back );
        ibGoodInfoMore = (ImageButton)findViewById( R.id.ib_good_info_more );
        ivGoodInfoImage = (ImageView)findViewById( R.id.iv_good_info_image );
        tvGoodInfoName = (TextView)findViewById( R.id.tv_good_info_name );
        tvGoodInfoDesc = (TextView)findViewById( R.id.tv_good_info_desc );
        tvGoodInfoPrice = (TextView)findViewById( R.id.tv_good_info_price );
        wbGoodInfoMore = (WebView)findViewById( R.id.wb_good_info_more );
        llGoodsRoot = (LinearLayout)findViewById( R.id.ll_goods_root );
        tvGoodInfoCallcenter = (TextView)findViewById( R.id.tv_good_info_callcenter );
        tvGoodInfoCollection = (TextView)findViewById( R.id.tv_good_info_collection );
        tvGoodInfoCart = (TextView)findViewById( R.id.tv_good_info_cart );
        btnGoodInfoAddcart = (Button)findViewById( R.id.btn_good_info_addcart );

        tv_more_share = findViewById(R.id.tv_more_share);
        tv_more_search = findViewById(R.id.tv_more_search);
        tv_more_home = findViewById(R.id.tv_more_home);
        btn_more = findViewById(R.id.btn_more);
        ll_root = findViewById(R.id.ll_root);

        ibGoodInfoBack.setOnClickListener( this );//返回
        ibGoodInfoMore.setOnClickListener( this );//更多（右上角）
        btnGoodInfoAddcart.setOnClickListener( this );//加入学习
        tvGoodInfoCallcenter.setOnClickListener(this);//联系老师
        tvGoodInfoCollection.setOnClickListener(this);//收藏课程
        tvGoodInfoCart.setOnClickListener(this);//我的课程

        tv_more_share.setOnClickListener(this);//分享
        tv_more_search.setOnClickListener(this);//搜索
        tv_more_home.setOnClickListener(this);//首页

    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2020-01-04 16:24:09 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if ( v == ibGoodInfoBack ) {
            finish();
        } else if ( v == ibGoodInfoMore ) {
            Toast.makeText(this,"更多",Toast.LENGTH_SHORT).show();
            if (ll_root.getVisibility() == View.VISIBLE) {
                ll_root.setVisibility(View.GONE);
            } else {
                ll_root.setVisibility(View.VISIBLE);
            }
        } else if ( v == btnGoodInfoAddcart ) {
            CartStorage.getInstance().addData(goodsBean);
            Toast.makeText(this,"已加入学习",Toast.LENGTH_SHORT).show();
        }else if(v==tvGoodInfoCallcenter){
            Toast.makeText(this,"联系老师",Toast.LENGTH_SHORT).show();
        }else if(v==tvGoodInfoCollection){
            Toast.makeText(this,"收藏课程",Toast.LENGTH_SHORT).show();
        }else if(v==tvGoodInfoCart){
            Toast.makeText(this,"我的课程",Toast.LENGTH_SHORT).show();
        }else if(v==tv_more_share){
            Toast.makeText(this,"分享",Toast.LENGTH_SHORT).show();
        }else if(v==tv_more_search){
            Toast.makeText(this,"搜索",Toast.LENGTH_SHORT).show();
        }else if(v==tv_more_home){
            Toast.makeText(this,"首页",Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_info);
        findViews();
        //接收数据
        goodsBean = (GoodsBean) getIntent().getSerializableExtra("goodsBean");
        if (goodsBean != null) {
            //Toast.makeText(this, "goodsBean=="+goodsBean.toString(), Toast.LENGTH_SHORT).show();
            setDataForView(goodsBean);
        }
    }

    private void setDataForView(GoodsBean goodsBean) {
        //设置图片
//        iv_good_info_image
        Glide.with(this).load(Constants.BASE_URL_IMAGE+goodsBean.getFigure()).into(ivGoodInfoImage);
        //设置文本
        tvGoodInfoName.setText(goodsBean.getName());
        //设置教师
        tvGoodInfoPrice.setText(goodsBean.getCover_price());

        setWebViewData(goodsBean.getProduct_id());
    }

    private void setWebViewData(String product_id) {
        if(product_id != null){
            wbGoodInfoMore.loadUrl("http://study.163.com/");
            //设置支持JavaScript
            WebSettings webSettings = wbGoodInfoMore.getSettings();
            webSettings.setUseWideViewPort(true);//支持双击页面变大变小
            webSettings.setJavaScriptEnabled(true);//设置支持JavaScript
            //优先使用缓存
            webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
            wbGoodInfoMore.setWebViewClient(new WebViewClient(){

                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                    view.loadUrl(url);
                    return true;
                }
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        view.loadUrl(request.getUrl().toString());
                    }
                    return true;
                }
            });
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
