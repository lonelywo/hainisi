package com.renma.hainisi.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
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
    @BindView(R.id.cbox_ys_d)
    CheckBox cboxYsD;
    @BindView(R.id.cbox_ys_e)
    CheckBox cboxYsE;
    @BindView(R.id.cbox_ys_f)
    CheckBox cboxYsF;
    @BindView(R.id.cbox_ys_g)
    CheckBox cboxYsG;
    @BindView(R.id.cbox_ys_h)
    CheckBox cboxYsH;
    @BindView(R.id.cbox_ys_i)
    CheckBox cboxYsI;
    @BindView(R.id.cbox_ys_j)
    CheckBox cboxYsJ;
    @BindView(R.id.cbox_ys_k)
    CheckBox cboxYsK;
    @BindView(R.id.cbox_ys_l)
    CheckBox cboxYsL;
    @BindView(R.id.cbox_jd_if)
    CheckBox cboxJdIf;
    @BindView(R.id.cbox_jd_vvs1)
    CheckBox cboxJdVvs1;
    @BindView(R.id.cbox_jd_vvs2)
    CheckBox cboxJdVvs2;
    @BindView(R.id.cbox_jd_vs1)
    CheckBox cboxJdVs1;
    @BindView(R.id.cbox_jd_vs2)
    CheckBox cboxJdVs2;
    @BindView(R.id.cbox_jd_si1)
    CheckBox cboxJdSi1;
    @BindView(R.id.cbox_jd_si2)
    CheckBox cboxJdSi2;
    @BindView(R.id.ll_qg_ex)
    CheckBox llQgEx;
    @BindView(R.id.ll_qg_vg)
    CheckBox llQgVg;
    @BindView(R.id.ll_qg_gd)
    CheckBox llQgGd;
    @BindView(R.id.ll_qg)
    LinearLayout llQg;
    @BindView(R.id.ll_yg_n)
    CheckBox llYgN;
    @BindView(R.id.ll_yg_f)
    CheckBox llYgF;
    @BindView(R.id.ll_yg_m)
    CheckBox llYgM;
    @BindView(R.id.ll_yg_s)
    CheckBox llYgS;
    @BindView(R.id.ll_yg)
    LinearLayout llYg;
    @BindView(R.id.ll_pg_ex)
    CheckBox llPgEx;
    @BindView(R.id.ll_pg_vg)
    CheckBox llPgVg;
    @BindView(R.id.ll_pg_gd)
    CheckBox llPgGd;
    @BindView(R.id.ll_pg)
    LinearLayout llPg;
    @BindView(R.id.rb_gia)
    RadioButton rbGia;
    @BindView(R.id.rb_3exn)
    RadioButton rb3exn;
    @BindView(R.id.rg_zs)
    RadioGroup rgZs;
    @BindView(R.id.cbox_dc_ex)
    CheckBox cboxDcEx;
    @BindView(R.id.cbox_dc_vg)
    CheckBox cboxDcVg;
    @BindView(R.id.cbox_dc_gd)
    CheckBox cboxDcGd;
    @BindView(R.id.ll_dc)
    LinearLayout llDc;
    @BindView(R.id.rb_gnkc)
    RadioButton rbGnkc;
    @BindView(R.id.rb_hwkc)
    RadioButton rbHwkc;
    @BindView(R.id.rg_szd)
    RadioGroup rgSzd;
    @BindView(R.id.edt_1)
    EditText edt1;
    @BindView(R.id.edt_2)
    EditText edt2;
    @BindView(R.id.sp_zl)
    Spinner spZl;
    @BindView(R.id.edt_num)
    EditText edtNum;
    @BindView(R.id.query)
    TextView query;
    @BindView(R.id.reset)
    TextView reset;
    private Context mContext;

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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       initListen();
    }

    private void initListen() {
        edt1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Double aDouble = Double.valueOf(s.toString());
                if(aDouble<0.1){
                    edt1.setText("0.1");
                }else if(aDouble>20){
                    edt1.setText("20");
                }
            }
        });

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
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
