package com.haima.hainisi.activity;

import com.haima.hainisi.utils.DataUtil;
import com.lzy.okgo.OkGo;

import org.litepal.LitePalApplication;

/**
 * Created by Administrator on 2017/10/26.
 */

public class MyApp extends LitePalApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        DataUtil.init(this);//初始化数据存储工具类
        OkGo.init(this);
    }
}
