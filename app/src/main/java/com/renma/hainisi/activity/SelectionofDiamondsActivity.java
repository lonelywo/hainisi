package com.renma.hainisi.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;


import com.renma.hainisi.R;
import com.renma.hainisi.base.BaseActivity;
import com.renma.hainisi.base.Basefragment;
import com.renma.hainisi.fragment.FourCSelectDiamondsFragment;
import com.renma.hainisi.fragment.TraditionalSelectDiamondFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/10/26.
 */

public class SelectionofDiamondsActivity extends BaseActivity {


    @BindView(R.id.btn_fh)
    Button btnFh;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    private List<Basefragment> mFragmentList = new ArrayList<>();

    private FragmentPagerAdapter mPageAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initPageAdapter();
        initListen();
    }

    private void initListen() {
        btnFh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void initPageAdapter() {
        mFragmentList.add(FourCSelectDiamondsFragment.newInstance(null));
        mFragmentList.add(TraditionalSelectDiamondFragment.newInstance(null));


        mPageAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {

                return mFragmentList.get(position);
            }

            @Override
            public int getCount() {
                return mFragmentList == null ? 0 : mFragmentList.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                CharSequence title = null;

                switch (position) {
                    case 0:
                        title = "4C选钻";
                        break;
                    case 1:
                        title = "传统选钻";
                        break;
                }

                return title;
            }
        };

        viewpager.setAdapter(mPageAdapter);

        viewpager.setOffscreenPageLimit(2);

        tab.setupWithViewPager(viewpager);


    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_jxmz;
    }
}
