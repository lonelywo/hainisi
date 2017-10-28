package com.renma.hainisi.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.renma.hainisi.R;
import com.renma.hainisi.base.Basefragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/10/28.
 */

public class TraditionalSelectDiamondFragment extends Basefragment {



    Unbinder unbinder;

    public static TraditionalSelectDiamondFragment newInstance(Bundle bundle) {
        TraditionalSelectDiamondFragment fragment = new TraditionalSelectDiamondFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_select_diamond_traditional;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
