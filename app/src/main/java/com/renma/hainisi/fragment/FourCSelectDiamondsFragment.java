package com.renma.hainisi.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.renma.hainisi.R;
import com.renma.hainisi.base.Basefragment;


import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by Administrator on 2017/10/28.
 */

public class FourCSelectDiamondsFragment extends Basefragment {



    Unbinder unbinder;

    public static FourCSelectDiamondsFragment newInstance(Bundle bundle) {
        FourCSelectDiamondsFragment fragment = new FourCSelectDiamondsFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_selec_diamond_4c;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
