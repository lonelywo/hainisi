package com.haima.hainisi.callback;

import android.support.v4.app.DialogFragment;



public interface InterfaceShowToastAndProgress {
    /**
     * 显示长时间的提示框
     *
     * @param msg 提示信息
     */
    void showLongToast(String msg);

    /**
     * 显示短时间的提示框
     *
     * @param msg 提示信息
     */
    void showShortToast(String msg);


    /**
     * 显示 DialogFragment
     * @param fragment DialogFragment 对象
     */
    void showDialogFragment(DialogFragment fragment);


    void hideDialogFragment(DialogFragment fragment);

}
