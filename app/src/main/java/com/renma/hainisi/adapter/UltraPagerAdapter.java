package com.renma.hainisi.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.renma.hainisi.R;


import java.util.List;

/**
 * Created by 人马 2017/9/4.
 */

public class UltraPagerAdapter extends PagerAdapter {
    public Context mContext;
    public List<String> mViewList;

    public UltraPagerAdapter(Context context, List<String> viewList) {
        mContext = context;
        mViewList = viewList;
    }

    @Override
    public int getCount() {
        return mViewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.activity_item_main, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_pager_icon);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        Glide.with(mContext)
                .load(mViewList.get(position))
                .into(imageView);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
