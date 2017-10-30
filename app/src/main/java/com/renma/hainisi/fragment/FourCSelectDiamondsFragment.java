package com.renma.hainisi.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.renma.hainisi.R;
import com.renma.hainisi.adapter.RecImgAdapter;
import com.renma.hainisi.base.Basefragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by Administrator on 2017/10/28.
 */

public class FourCSelectDiamondsFragment extends Basefragment {


    Unbinder unbinder;
    @BindView(R.id.rec_kl_img)
    RecyclerView recKlImg;
    @BindView(R.id.tv_kl)
    TextView tvKl;
    @BindView(R.id.rec_kl)
    RecyclerView recKl;
    @BindView(R.id.rec_ys_img)
    RecyclerView recYsImg;
    @BindView(R.id.tv_ys)
    TextView tvYs;
    @BindView(R.id.rec_ys)
    RecyclerView recYs;
    @BindView(R.id.rec_jd_img)
    RecyclerView recJdImg;
    @BindView(R.id.tv_jd)
    TextView tvJd;
    @BindView(R.id.rec_jd)
    RecyclerView recJd;
    @BindView(R.id.rec_qg_img)
    RecyclerView recQgImg;
    @BindView(R.id.tv_qg)
    TextView tvQg;
    @BindView(R.id.rec_qg)
    RecyclerView recQg;
    @BindView(R.id.query)
    TextView query;
    private Context mContext;
    private int[] img_kl = new int[]{R.drawable.img_3ct_xdpi,R.drawable.img_2ct_xhdpi, R.drawable.img_1_5ct_xhdpi,R.drawable.img_1ct_xhdpi,  R.drawable.img_08ct_xhdpi, R.drawable.img_07ct_xhdpi, R.drawable.img_06ct_xhpdi, R.drawable.img_05ct_xhdpi, R.drawable.img_04ct_xhdpi,R.drawable.img_03ct_xhdpi};
    public static FourCSelectDiamondsFragment newInstance(Bundle bundle) {
        FourCSelectDiamondsFragment fragment = new FourCSelectDiamondsFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
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
        initDatas();
        LinearLayoutManager manager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        recKlImg.setLayoutManager(manager);
       // recKlImg.setHasFixedSize(true);
        RecImgAdapter recImgAdapter = new RecImgAdapter(img_kl);
        recKlImg.setAdapter(recImgAdapter);
        recImgAdapter.setRecyclerViewOnItemClickListener(new RecImgAdapter.RecyclerViewOnItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                showShortToast(position+"");
            }
        });

    }

    private void initDatas() {

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
