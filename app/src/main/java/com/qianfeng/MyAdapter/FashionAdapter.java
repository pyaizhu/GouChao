package com.qianfeng.MyAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qianfeng.bean.Fashion_json;
import com.qianfeng.gouchao.R;

import java.util.List;


/**
 * 底部时尚网红的适配器
 */                                    //改为继承BaseAdapter
public class    FashionAdapter extends RecyclerView.Adapter {
    Context context;
    List<Fashion_json.AddDatasBean.ResultlistBean> list;

    public FashionAdapter(Context context, List<Fashion_json.AddDatasBean.ResultlistBean> list) {
        this.context = context;
        this.list = list;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.redman_bottom,null);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Glide.with(context).load(list.get(position).getPicPath()).into(((MyHolder)holder).imageView);
        ((MyHolder) holder).textView.setText(list.get(position).getStarName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    static class MyHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public MyHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.redman_bottom_iv);
            textView= (TextView) itemView.findViewById(R.id.redman_bottom_tv);

        }
    }

}
