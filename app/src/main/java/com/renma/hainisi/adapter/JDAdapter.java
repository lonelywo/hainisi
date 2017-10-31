package com.renma.hainisi.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.renma.hainisi.R;
import com.renma.hainisi.bean.JD_checkBean;
import com.renma.hainisi.bean.YS_checkBean;

import java.util.List;

/**
 * Created by Administrator on 2017/10/30.
 */

public class JDAdapter extends RecyclerView.Adapter<JDAdapter.ViewHolder> implements View.OnClickListener{
    private RecyclerViewOnItemClickListener onItemClickListener;

    private List<JD_checkBean> mDatas;

    public JDAdapter(List<JD_checkBean> mDatas) {
        this.mDatas = mDatas;
    }


    @Override
    public JDAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_4c_item_but_jd, parent,false);
        ViewHolder vh = new ViewHolder(root);
        //为Item设置点击事件
        root.setOnClickListener(this);
        return vh;

    }

    @Override
    public void onBindViewHolder(JDAdapter.ViewHolder holder, final int position) {
        holder.itemView.setTag(position);
        JD_checkBean ys_checkBean = mDatas.get(position);
        if(ys_checkBean.isChecked()){
            holder.checkBox.setChecked(true);
        }else {
            holder.checkBox.setChecked(false);
        }
       holder.checkBox.setText(ys_checkBean.getName());
       holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if(isChecked){
                  mDatas.get(position).setChecked(true);
               }else {
                   mDatas.get(position).setChecked(false);
               }

           }
       });


    }

    @Override
    public int getItemCount() {
        return  mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public void onClick(View v) {
        if (onItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            onItemClickListener.onItemClickListener(v, (Integer) v.getTag());
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CheckBox checkBox;
        private View itemView;
        public ViewHolder(View itemView) {
            super(itemView);
           this.itemView=itemView;
            checkBox = (CheckBox) itemView.findViewById(R.id.cbox_4c_jd);
        }
    }
    public interface RecyclerViewOnItemClickListener {

        void onItemClickListener(View view, int position);

    }
    /*设置点击事件*/
    public void setRecyclerViewOnItemClickListener(RecyclerViewOnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
