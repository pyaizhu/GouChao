package com.qianfeng.adapter;

/**
 * Created by cpoopc on 2015/8/31.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qianfeng.Bean.ChaoNanBean;
import com.qianfeng.Bean.HomeBean;
import com.qianfeng.gouchao.R;

import java.util.List;

/**
 * User: cpoopc
 * Date: 2015-08-31
 * Time: 12:53
 * Ver.: 0.1
 */
public class ChaonanRecyclerAdapter extends RecyclerView.Adapter<ChaonanRecyclerAdapter.SimpleViewHolder> {

    private Context mContext;
    private List<ChaoNanBean.AddDatasBean.ResultlistBean> strList;

    public ChaonanRecyclerAdapter(Context mContext, List<ChaoNanBean.AddDatasBean.ResultlistBean> strList) {
        this.mContext = mContext;
        this.strList = strList;
    }

    @Override
    public ChaonanRecyclerAdapter.SimpleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new SimpleViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_zuixin_recycleview1, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder simpleViewHolder, int position) {
        simpleViewHolder.tvContent
                .setText(strList.get(position).getTitle());
        simpleViewHolder.tvZanNum
                .setText(strList.get(position).getLikeCount() + "");
        simpleViewHolder.tvPLNum
                .setText(strList.get(position).getCommCount() + "");
        //设置图片 小图
        Glide.with(mContext).load(strList.get(position)
                .getSmallPicPath()).into(simpleViewHolder.iv);
    }


    @Override
    public int getItemCount() {
        return strList.size();
    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        View itemView;
        TextView tvTime;
        TextView tvContent;
        TextView tvZanNum;
        TextView tvPLNum;
        ImageView iv;
        int position;

        public SimpleViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            tvTime = (TextView) itemView.findViewById(R.id.tvText);
            tvZanNum = (TextView) itemView.findViewById(R.id.tvZanNum);
            tvPLNum = (TextView) itemView.findViewById(R.id.tvPLNum);
            tvContent = (TextView) itemView.findViewById(R.id.tvContent);
            iv = (ImageView) itemView.findViewById(R.id.iv);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Toast.makeText(v.getContext(), "点击RecycleView item" + position, Toast.LENGTH_SHORT).show();
                }
            });
        }

        //        public void bindData(String txt,int bgcolor,int position) {
        //            this.position = position;
        //            tv.setText(txt);
        //            itemView.setBackgroundColor(bgcolor);
        //        }
    }
}