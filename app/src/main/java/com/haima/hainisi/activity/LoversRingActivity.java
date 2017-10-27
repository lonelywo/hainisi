package com.haima.hainisi.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.haima.hainisi.R;
import com.haima.hainisi.base.BaseActivity;

/**
 * Created by Administrator on 2017/10/26.
 */

public class LoversRingActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_qldj;
    }
}
