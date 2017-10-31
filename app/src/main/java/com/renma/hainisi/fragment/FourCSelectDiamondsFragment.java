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
import com.renma.hainisi.adapter.KLAdapter;
import com.renma.hainisi.adapter.RecImgAdapter;
import com.renma.hainisi.base.Basefragment;
import com.renma.hainisi.bean.KL_checkBean;

import java.util.ArrayList;
import java.util.List;

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
    private List<KL_checkBean> mlist=new ArrayList<>();
    private int[] img_ys = new int[]{R.drawable.img_d,R.drawable.img_e, R.drawable.img_f,R.drawable.img_g,  R.drawable.img_h, R.drawable.img_i, R.drawable.img_j, R.drawable.img_k,R.drawable.img_l};
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
        recKlImg.setHasFixedSize(true);
        RecImgAdapter recImgAdapter = new RecImgAdapter(img_kl);
        recKlImg.setAdapter(recImgAdapter);
        recImgAdapter.setRecyclerViewOnItemClickListener(new RecImgAdapter.RecyclerViewOnItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                showShortToast(position+"");
            }
        });
        LinearLayoutManager manager1 = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        recKl.setLayoutManager(manager1);
        recKl.setHasFixedSize(true);
        KLAdapter klAdapter = new KLAdapter(mlist);
        recKl.setAdapter(klAdapter);
        LinearLayoutManager manager2 = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        recYsImg.setLayoutManager(manager2);
        recYsImg.setHasFixedSize(true);
        RecImgAdapter recImgAdapter1 = new RecImgAdapter(img_ys);
        recYsImg.setAdapter(recImgAdapter1);
        recImgAdapter.setRecyclerViewOnItemClickListener(new RecImgAdapter.RecyclerViewOnItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                showShortToast(position+"");
            }
        });
    }

    private void initDatas() {
        KL_checkBean kl_checkBean = new KL_checkBean();
        kl_checkBean.setChecked(false);
        kl_checkBean.setName("3ct");
        mlist.add(kl_checkBean);
        KL_checkBean kl_checkBean1 = new KL_checkBean();
        kl_checkBean1.setChecked(false);
        kl_checkBean1.setName("2ct");
        mlist.add(kl_checkBean1);
        KL_checkBean kl_checkBean2 = new KL_checkBean();
        kl_checkBean2.setChecked(false);
        kl_checkBean2.setName("1.5ct");
        mlist.add(kl_checkBean2);
        KL_checkBean kl_checkBean3 = new KL_checkBean();
        kl_checkBean3.setChecked(false);
        kl_checkBean3.setName("1ct");
        mlist.add(kl_checkBean3);
        KL_checkBean kl_checkBean4 = new KL_checkBean();
        kl_checkBean4.setChecked(false);
        kl_checkBean4.setName("0.8ct");
        mlist.add(kl_checkBean4);
        KL_checkBean kl_checkBean5 = new KL_checkBean();
        kl_checkBean5.setChecked(false);
        kl_checkBean5.setName("0.7ct");
        mlist.add(kl_checkBean5);
        KL_checkBean kl_checkBean6 = new KL_checkBean();
        kl_checkBean6.setChecked(false);
        kl_checkBean6.setName("0.6ct");
        mlist.add(kl_checkBean6);
        KL_checkBean kl_checkBean7 = new KL_checkBean();
        kl_checkBean7.setChecked(false);
        kl_checkBean7.setName("0.5ct");
        mlist.add(kl_checkBean7);
        KL_checkBean kl_checkBean8 = new KL_checkBean();
        kl_checkBean8.setChecked(false);
        kl_checkBean8.setName("0.4ct");
        mlist.add(kl_checkBean8);
        KL_checkBean kl_checkBean9 = new KL_checkBean();
        kl_checkBean9.setChecked(false);
        kl_checkBean9.setName("0.3ct");
        mlist.add(kl_checkBean9);
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
