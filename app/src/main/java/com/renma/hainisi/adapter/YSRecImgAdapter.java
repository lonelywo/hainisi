package com.renma.hainisi.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.renma.hainisi.R;

/**
 * Created by Administrator on 2017/10/30.
 */

public class YSRecImgAdapter extends RecyclerView.Adapter<YSRecImgAdapter.ViewHolder> implements View.OnClickListener{
    private RecyclerViewOnItemClickListener onItemClickListener;

    private  int[] imgs;

    public YSRecImgAdapter(int[] imgs) {
        this.imgs = imgs;
    }


    @Override
    public YSRecImgAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_4c_item_img_ys, parent,false);
        ViewHolder vh = new ViewHolder(root);
        //为Item设置点击事件
        root.setOnClickListener(this);
        return vh;

    }

    @Override
    public void onBindViewHolder(YSRecImgAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(position);
        holder.img_kl.setImageResource(imgs[position]);
    }

    @Override
    public int getItemCount() {
        return  imgs == null ? 0 : imgs.length;
    }

    @Override
    public void onClick(View v) {
        if (onItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            onItemClickListener.onItemClickListener(v, (Integer) v.getTag());
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private   ImageView  img_kl;
        private View itemView;
        public ViewHolder(View itemView) {
            super(itemView);
           this.itemView=itemView;
            img_kl = (ImageView) itemView.findViewById(R.id.img_4c_ys);
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
