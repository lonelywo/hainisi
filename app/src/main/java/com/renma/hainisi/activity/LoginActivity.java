package com.renma.hainisi.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.renma.hainisi.R;
import com.renma.hainisi.base.BaseActivity;
import com.renma.hainisi.bean.LoginBean;
import com.renma.hainisi.callback.RequestCallback;
import com.renma.hainisi.fragment.ProgressDialogFragment;
import com.renma.hainisi.utils.Constants;
import com.renma.hainisi.utils.DataUtil;
import com.renma.hainisi.utils.GsonUtils;
import com.renma.hainisi.utils.HttpHelper;
import com.renma.hainisi.utils.LogUtil;
import com.renma.hainisi.utils.MD5Util;
import com.renma.hainisi.utils.URLCommon;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity {


    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.ll_Login)
    LinearLayout llLogin;
    @BindView(R.id.iv_finish)
    ImageView ivFinish;
    @BindView(R.id.tv_error_login)
    TextView tvErrorLogin;
    @BindView(R.id.rl_error_login)
    RelativeLayout rlErrorLogin;

    private char[] mPassword;
    private char[] mUsername;
    private ProgressDialogFragment mProgressDialogFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        mProgressDialogFragment = ProgressDialogFragment.newInstance("正在登录,请稍候...");
        initListen();
    }

    private void initListen() {
       tvLogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               mPassword = etPwd.getText().toString().toCharArray();
               mUsername = etUsername.getText().toString().toCharArray();
               if (mPassword.length != 0 && mUsername.length != 0) {
                   String s = (Constants.RM_LOGIN_APPSECRET + "password" + etPwd.getText().toString() + "username" + etUsername.getText().toString() + Constants.RM_LOGIN_APPSECRET).toLowerCase();
                   String sign = MD5Util.getMd5Value(s);
                    HashMap<String, String> request = new HashMap<String, String>();
                   request.put("username", etUsername.getText().toString());
                   request.put("password", etPwd.getText().toString());
                   request.put("sign", sign);
                   showDialogFragment(mProgressDialogFragment);
                 HttpHelper.getInstance().httpPostString(URLCommon.USER_LOGIN_URL, request, LoginActivity.this, new RequestCallback<String>() {
                     @Override
                     public void succeedOnResult(String response) {
                         LogUtil.d(response);
                         hideDialogFragment(mProgressDialogFragment);
                         LoginBean loginBean = GsonUtils.GsonToBean(response, LoginBean.class);

                         if(loginBean.getCode().equals("0002")){
                             //保存token
                             DataUtil. setSharePreferences(Constants.RM_LOGIN_TOKEN,loginBean.getToken());
                             Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                             startActivity(intent);
                             finish();
                         }else {
                             rlErrorLogin.setVisibility(View.VISIBLE);
                             llLogin.setVisibility(View.GONE);
                             tvErrorLogin.setText("登录失败");
                         }

                     }

                     @Override
                     public void errorForCode(int code) {
                         hideDialogFragment(mProgressDialogFragment);
                         switch (code){
                             case 100:
                                 showShortToast("网络异常");
                                 break;
                             case 101:
                                 showShortToast("服务器请求异常");
                                 break;
                         }
                     }
                 });
               } else {
                  showShortToast("账号密码不能为空");

               }
           }
       });
        ivFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rlErrorLogin.setVisibility(View.GONE);
                llLogin.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;

    }
}
