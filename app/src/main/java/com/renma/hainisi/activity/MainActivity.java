package com.renma.hainisi.activity;


import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.widget.DrawerLayout;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.renma.hainisi.R;
import com.renma.hainisi.adapter.MenuAdapter;
import com.renma.hainisi.adapter.UltraPagerAdapter;
import com.renma.hainisi.base.BaseActivity;
import com.tmall.ultraviewpager.UltraViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.uvp_content)
    UltraViewPager uvpContent;
    @BindView(R.id.iv_open_drawer)
    ImageView ivOpenDrawer;
    @BindView(R.id.list_menu)
    ListView listMenu;
    @BindView(R.id.tv_chinese)
    TextView tvChinese;
    @BindView(R.id.tv_nouse)
    TextView tvNouse;
    @BindView(R.id.tv_fanti)
    TextView tvFanti;
    @BindView(R.id.rl_left)
    RelativeLayout rlLeft;
    @BindView(R.id.dl_main)
    DrawerLayout dlMain;
    @BindView(R.id.ll_line)
    LinearLayout llLine;
    @BindView(R.id.imgbn_people)
    ImageView imgbnPeople;
    @BindView(R.id.imgbn_car)
    ImageView imgbnCar;
    List<String> mList = new ArrayList<>();
    List<String> menuList = new ArrayList<>();
    private long exitTime=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initdata();
        initListen();

    }

    private void initListen() {

        listMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setSelected(true);

                if (position == 0) {
                    startActivity(new Intent(MainActivity.this, SelectionofDiamondsActivity.class));
                }if (position == 1){
                    startActivity(new Intent(MainActivity.this,ChoiceStyleActivity.class));
                }if (position == 2){
                    startActivity(new Intent(MainActivity.this,LoversRingActivity.class));
                }if (position == 3){
                    startActivity(new Intent(MainActivity.this,OnlineMallActivity.class));
                }if(position == 4){
                    startActivity(new Intent(MainActivity.this,ProprietaryDesignActivity.class));
                }if (position == 5){
                    startActivity(new Intent(MainActivity.this,LoginActivity.class));
                    finish();
                }
            }
        });
        ivOpenDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlMain.openDrawer(Gravity.LEFT);
                ivOpenDrawer.setVisibility(View.GONE);
            }
        });
        imgbnPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,PeopleActivity.class));
            }
        });
        imgbnCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ShopCarActivity.class));
            }
        });
        tvChinese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources resources = getResources();
                DisplayMetrics dm = resources.getDisplayMetrics();
                Configuration config = resources.getConfiguration();
                // 应用用户选择语言
                config.locale = Locale.SIMPLIFIED_CHINESE;
                resources.updateConfiguration(config, dm);
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                showShortToast("中文");

            }
        });
        tvFanti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources resources = getResources();
                DisplayMetrics dm = resources.getDisplayMetrics();
                Configuration config = resources.getConfiguration();
                // 应用用户选择语言
                config.locale = Locale.TAIWAN;
                resources.updateConfiguration(config, dm);
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                showShortToast("繁體");
            }
        });
    }

    private void initdata() {
        menuList.add(getResources().getString(R.string .yxmz));
        menuList.add(getResources().getString(R.string .jxks));
        menuList.add(getResources().getString(R.string .qldj));
        menuList.add(getResources().getString(R.string .zxsc));
        menuList.add(getResources().getString(R.string .zssj));
        menuList.add(getResources().getString(R.string.tcdl));
        MenuAdapter menuAdapter = new MenuAdapter(this, menuList);
        listMenu.setAdapter(menuAdapter);

        mList.add("http://pic1.win4000.com/wallpaper/f/57523a17c02ad.jpg");
        mList.add("http://pic1.win4000.com/wallpaper/c/57fc5f21e8db8.jpg");
        mList.add("http://att.bbs.duowan.com/forum/201309/27/1217450m53d16fo00zm3rk.jpg");
        mList.add("http://pic.3h3.com/up/2016-11/20161125163114985980.jpg");
        mList.add("http://p2.so.qhimgs1.com/t018d6b67924f479052.jpg");




        PagerAdapter adapter = new UltraPagerAdapter(this, mList);
        uvpContent.setScrollMode(UltraViewPager.ScrollMode.VERTICAL);
        uvpContent.setAdapter(adapter);


        //内置indicator初始化
        uvpContent.initIndicator();
        //设置指示器
        uvpContent.getIndicator()
                .setOrientation(UltraViewPager.Orientation.VERTICAL)
                .setNormalResId(R.drawable.icon_page_control_bg)
                .setFocusResId(R.drawable.icon_page_control_current)
                .setGravity(Gravity.RIGHT)
                .setMargin(0, 500, 20, 0)
                .build();

        //设定页面循环播放
        uvpContent.setInfiniteLoop(true);
        //设定页面自动切换  间隔2秒
        uvpContent.setAutoScroll(4000);
        dlMain.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                ivOpenDrawer.setAlpha(1 - slideOffset);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                ivOpenDrawer.setVisibility(View.GONE);
                listMenu.getChildAt(0).setSelected(true);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                ivOpenDrawer.setVisibility(View.VISIBLE);
            }

            @Override
            public void onDrawerStateChanged(int newState) {
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis()-exitTime) > 2000){
                showShortToast("再按一次退出程序");
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
