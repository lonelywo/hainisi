package com.renma.hainisi.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.renma.hainisi.R;
import com.renma.hainisi.base.BaseActivity;

/**
 * Created by Administrator on 2017/10/27.
 */

public class ShopCarActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_shopcar;
    }
}
