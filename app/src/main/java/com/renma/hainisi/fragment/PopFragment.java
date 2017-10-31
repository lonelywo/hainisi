package com.renma.hainisi.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;



import com.renma.hainisi.R;


/**
 * Created by Administrator on 2017/10/31.
 */

public class PopFragment extends DialogFragment {

    private Context mContext;
    private int[] splits;
    private ViewPager vp;

    public static PopFragment newInstance(Bundle bundle) {
        PopFragment fragment = new PopFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.fragment_pop, container);
        vp = (ViewPager) view.findViewById(R.id.pop_vp);
        initData();
        Myadapter myadapter = new Myadapter();
        vp.setAdapter(myadapter);
        return  view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    private void initData() {
        splits = getArguments().getIntArray("splits");
    }



    class Myadapter extends PagerAdapter {


        @Override
        public int getCount() {
            return splits == null ? 0 : splits.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {


            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            //创建Item
            ImageView imageView = new ImageView(mContext);
            imageView.setImageResource(splits[position]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            //   popTv.setText(position+"/"+splits.length);
            Log.d("yanyan", "instantiateItem: "+position);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
