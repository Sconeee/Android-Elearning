package com.example.elearining;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.base.BaseFragment;
import com.example.home.fragment.HomeFragment;
import com.example.type.fragment.TypeFragment;
import com.example.user.fragment.UserFragment;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {

    private RadioGroup rg_main;
    private ArrayList<BaseFragment> fragments;
    private int position=0;//页面位置
    private Fragment tempFragment;//缓存的fragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg_main=(RadioGroup)findViewById(R.id.rg_main);

        initFragment();
        initListener();

        rg_main.check(R.id.rb_home);

    }

    private void initListener(){
        rg_main.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb_home:
                        position=0;
                        break;
                    case R.id.rb_type:
                        position=1;
                        break;
                    case R.id.rb_user:
                        position=2;
                        break;
                    default:
                        position=0;
                        break;
                }
                BaseFragment baseFragment=getFragment(position);
                switchFragment(tempFragment,baseFragment);//上次显示的和正要显示的
            }
        });
    }

    private void initFragment(){
        fragments=new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new TypeFragment());
        fragments.add(new UserFragment());
    }

    private BaseFragment getFragment(int position){
        if (fragments!=null&&fragments.size()>0){
            BaseFragment baseFragment=fragments.get(position);
            return baseFragment;
        }
        return null;
    }

    private void switchFragment(Fragment fromFragment, BaseFragment nextFragment) {
        if (tempFragment != nextFragment) {
            tempFragment = nextFragment;
            if (nextFragment != null) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                //判断nextFragment是否添加
                if (!nextFragment.isAdded()) {
                    //隐藏当前Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.add(R.id.framelayout, nextFragment).commit();
                } else {
                    //隐藏当前Fragment
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.show(nextFragment).commit();
                }
            }
        }
    }
}
