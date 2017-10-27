package com.haima.hainisi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.haima.hainisi.R;

import java.util.List;



public class MenuAdapter extends BaseAdapter {

    private Context context;
    private List<String> list;

    public MenuAdapter(Context context, List<String> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_main_menu,parent,false);
            holder.tvMenuItem = (TextView) convertView.findViewById(R.id.tv_menu_item);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvMenuItem.setText(list.get(position));
        return convertView;
    }

    static class ViewHolder{
        TextView tvMenuItem;
    }
}
