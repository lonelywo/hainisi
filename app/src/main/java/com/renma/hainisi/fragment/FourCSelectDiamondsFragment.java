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
import com.renma.hainisi.adapter.JDAdapter;
import com.renma.hainisi.adapter.JDRecImgAdapter;
import com.renma.hainisi.adapter.KLAdapter;
import com.renma.hainisi.adapter.QGAdapter;
import com.renma.hainisi.adapter.QGRecImgAdapter;
import com.renma.hainisi.adapter.RecImgAdapter;
import com.renma.hainisi.adapter.YSAdapter;
import com.renma.hainisi.adapter.YSRecImgAdapter;
import com.renma.hainisi.base.Basefragment;
import com.renma.hainisi.bean.JD_checkBean;
import com.renma.hainisi.bean.KL_checkBean;
import com.renma.hainisi.bean.QG_checkBean;
import com.renma.hainisi.bean.YS_checkBean;

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
    private List<YS_checkBean> mlist1=new ArrayList<>();
    private List<JD_checkBean> mlist2=new ArrayList<>();
    private List<QG_checkBean> mlist3=new ArrayList<>();
    private int[] img_ys = new int[]{R.drawable.img_d,R.drawable.img_e, R.drawable.img_f,R.drawable.img_g,  R.drawable.img_h, R.drawable.img_i, R.drawable.img_j, R.drawable.img_k,R.drawable.img_l};
    private int[] img_jd = new int[]{R.drawable.img_if,R.drawable.img_vvs1, R.drawable.img_vvs2,R.drawable.img_vs1,  R.drawable.img_vs2, R.drawable.img_si1, R.drawable.img_si2};
    private int[] img_qg = new int[]{R.drawable.img_ex,R.drawable.img_vg, R.drawable.img_gd};
//`````````````````````````````````````````````````````````````````````````````````````````
    private int[] img_pop_jd_if=new int[]{R.drawable.if_1};
    private int[] img_pop_jd_vvs1=new int[]{R.drawable.vvs1_1};
    private int[] img_pop_jd_vvs2=new int[]{R.drawable.vvs2_1};
    private int[] img_pop_jd_vs1=new int[]{R.drawable.vs1_1,R.drawable.vs1_2,R.drawable.vs1_3};
    private int[] img_pop_jd_vs2=new int[]{R.drawable.vs2_1,R.drawable.vs2_2,R.drawable.vs2_3};
    private int[] img_pop_jd_si1=new int[]{R.drawable.si1_1,R.drawable.si1_2,R.drawable.si1_3};
    private int[] img_pop_jd_si2=new int[]{R.drawable.si2_1,R.drawable.si1_2};

 //````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
    private int[] img_pop_qg_ex=new int[]{R.drawable.ex_1,R.drawable.ex_2};
    private int[] img_pop_qg_vg=new int[]{R.drawable.vg_1,R.drawable.vg_2,R.drawable.vg_3};
    private int[] img_pop_qg_gd=new int[]{R.drawable.gd_1,R.drawable.gd_2,R.drawable.gd_3};


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


        LinearLayoutManager manager1 = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        recKl.setLayoutManager(manager1);
        recKl.setHasFixedSize(true);
        KLAdapter klAdapter = new KLAdapter(mlist);
        recKl.setAdapter(klAdapter);
        //```````````````````````````````````````````````````````````````````````````
        LinearLayoutManager manager2 = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        recYsImg.setLayoutManager(manager2);
        recYsImg.setHasFixedSize(true);
        YSRecImgAdapter ysRecImgAdapter = new YSRecImgAdapter(img_ys);
        recYsImg.setAdapter(ysRecImgAdapter);

        LinearLayoutManager manager3 = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        recYs.setLayoutManager(manager3);
        recYs.setHasFixedSize(true);
        YSAdapter ysAdapter = new YSAdapter(mlist1);
        recYs.setAdapter(ysAdapter);
        //````````````````````````````````````````````````````````````````````````````````````
        LinearLayoutManager manager4 = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        recJdImg.setLayoutManager(manager4);
        recJdImg.setHasFixedSize(true);
        JDRecImgAdapter jdrecImgAdapter = new JDRecImgAdapter(img_jd);
        recJdImg.setAdapter(jdrecImgAdapter);
        jdrecImgAdapter.setRecyclerViewOnItemClickListener(new JDRecImgAdapter.RecyclerViewOnItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                 if(position==0){
                     Bundle bundle=new Bundle();
                     bundle.putIntArray("splits",img_pop_jd_if);
                     showDialogFragment(PopFragment.newInstance(bundle));
                 }if(position==1){
                    Bundle bundle=new Bundle();
                    bundle.putIntArray("splits",img_pop_jd_vvs1);
                    showDialogFragment(PopFragment.newInstance(bundle));
                }if(position==2){
                    Bundle bundle=new Bundle();
                    bundle.putIntArray("splits",img_pop_jd_vvs2);
                    showDialogFragment(PopFragment.newInstance(bundle));
                }if(position==3){
                    Bundle bundle=new Bundle();
                    bundle.putIntArray("splits",img_pop_jd_vs1);
                    showDialogFragment(PopFragment.newInstance(bundle));
                }if(position==4){
                    Bundle bundle=new Bundle();
                    bundle.putIntArray("splits",img_pop_jd_vs2);
                    showDialogFragment(PopFragment.newInstance(bundle));
                }if(position==5){
                    Bundle bundle=new Bundle();
                    bundle.putIntArray("splits",img_pop_jd_si1);
                    showDialogFragment(PopFragment.newInstance(bundle));
                }if(position==6){
                    Bundle bundle=new Bundle();
                    bundle.putIntArray("splits",img_pop_jd_si2);
                    showDialogFragment(PopFragment.newInstance(bundle));
                }

            }
        });
        LinearLayoutManager manager5 = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        recJd.setLayoutManager(manager5);
        recJd.setHasFixedSize(true);
        JDAdapter jdAdapter = new JDAdapter(mlist2);
        recJd.setAdapter(jdAdapter);
        //````````````````````````````````````````````````````````````````````````````````````
        LinearLayoutManager manager6 = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        recQgImg.setLayoutManager(manager6);
        recQgImg.setHasFixedSize(true);
        QGRecImgAdapter qgrecImgAdapter = new QGRecImgAdapter(img_qg);
        recQgImg.setAdapter(qgrecImgAdapter);
        qgrecImgAdapter.setRecyclerViewOnItemClickListener(new QGRecImgAdapter.RecyclerViewOnItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
               if(position==0){
                   Bundle bundle=new Bundle();
                   bundle.putIntArray("splits",img_pop_qg_ex);
                   showDialogFragment(PopFragment.newInstance(bundle));
               }if(position==1){
                    Bundle bundle=new Bundle();
                    bundle.putIntArray("splits",img_pop_qg_vg);
                    showDialogFragment(PopFragment.newInstance(bundle));
                }if(position==2){
                    Bundle bundle=new Bundle();
                    bundle.putIntArray("splits",img_pop_qg_gd);
                    showDialogFragment(PopFragment.newInstance(bundle));
                }
            }
        });
        LinearLayoutManager manager7 = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
        recQg.setLayoutManager(manager7);
        recQg.setHasFixedSize(true);
        QGAdapter qgAdapter = new QGAdapter(mlist3);
        recQg.setAdapter(qgAdapter);
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
   //  ````````````````````````````````````````````````````````````````````
        YS_checkBean ys_checkBean = new YS_checkBean();
        ys_checkBean.setChecked(false);
        ys_checkBean.setName("D");
        mlist1.add(ys_checkBean);
        YS_checkBean ys_checkBean1 = new YS_checkBean();
        ys_checkBean1.setChecked(false);
        ys_checkBean1.setName("E");
        mlist1.add(ys_checkBean1);
        YS_checkBean ys_checkBean2 = new YS_checkBean();
        ys_checkBean2.setChecked(false);
        ys_checkBean2.setName("F");
        mlist1.add(ys_checkBean2);
        YS_checkBean ys_checkBean3 = new YS_checkBean();
        ys_checkBean3.setChecked(false);
        ys_checkBean3.setName("G");
        mlist1.add(ys_checkBean3);
        YS_checkBean ys_checkBean4 = new YS_checkBean();
        ys_checkBean4.setChecked(false);
        ys_checkBean4.setName("H");
        mlist1.add(ys_checkBean4);
        YS_checkBean ys_checkBean5 = new YS_checkBean();
        ys_checkBean5.setChecked(false);
        ys_checkBean5.setName("I");
        mlist1.add(ys_checkBean5);
        YS_checkBean ys_checkBean6 = new YS_checkBean();
        ys_checkBean6.setChecked(false);
        ys_checkBean6.setName("J");
        mlist1.add(ys_checkBean6);
        YS_checkBean ys_checkBean7 = new YS_checkBean();
        ys_checkBean7.setChecked(false);
        ys_checkBean7.setName("K");
        mlist1.add(ys_checkBean7);
        YS_checkBean ys_checkBean8 = new YS_checkBean();
        ys_checkBean8.setChecked(false);
        ys_checkBean8.setName("L");
        mlist1.add(ys_checkBean8);
   //```````````````````````````````````````````````````````````````````````
        JD_checkBean jd_checkBean = new JD_checkBean();
        jd_checkBean.setChecked(false);
        jd_checkBean.setName("IF");
        mlist2.add(jd_checkBean);
        JD_checkBean jd_checkBean1 = new JD_checkBean();
        jd_checkBean1.setChecked(false);
        jd_checkBean1.setName("VVS1");
        mlist2.add(jd_checkBean1);
        JD_checkBean jd_checkBean2 = new JD_checkBean();
        jd_checkBean2.setChecked(false);
        jd_checkBean2.setName("VVS2");
        mlist2.add(jd_checkBean2);
        JD_checkBean jd_checkBean3 = new JD_checkBean();
        jd_checkBean3.setChecked(false);
        jd_checkBean3.setName("VS1");
        mlist2.add(jd_checkBean3);
        JD_checkBean jd_checkBean4 = new JD_checkBean();
        jd_checkBean4.setChecked(false);
        jd_checkBean4.setName("VS2");
        mlist2.add(jd_checkBean4);
        JD_checkBean jd_checkBean5 = new JD_checkBean();
        jd_checkBean5.setChecked(false);
        jd_checkBean5.setName("SI1");
        mlist2.add(jd_checkBean5);
        JD_checkBean jd_checkBean6 = new JD_checkBean();
        jd_checkBean6.setChecked(false);
        jd_checkBean6.setName("SI2");
        mlist2.add(jd_checkBean6);
        //`````````````````````````````````````````````````````````
        QG_checkBean qg_checkBean = new QG_checkBean();
        qg_checkBean.setChecked(false);
        qg_checkBean.setName("IF");
        mlist3.add(qg_checkBean);
        QG_checkBean qg_checkBean1 = new QG_checkBean();
        qg_checkBean1.setChecked(false);
        qg_checkBean1.setName("VVS1");
        mlist3.add(qg_checkBean1);
        QG_checkBean qg_checkBean2 = new QG_checkBean();
        qg_checkBean2.setChecked(false);
        qg_checkBean2.setName("VVS2");
        mlist3.add(qg_checkBean2);
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
