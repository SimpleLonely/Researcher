package com.alljedi.bottomnavigationapplication.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alljedi.bottomnavigationapplication.R;
import com.alljedi.bottomnavigationapplication.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * TODO: Replace the implementation with code for your data type.
 */
public class NormalAdapter extends RecyclerView.Adapter<NormalAdapter.VH>{
    //② 创建ViewHolder
    public static class VH extends RecyclerView.ViewHolder{
        public final TextView title;
        public final TextView content;
        public VH(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.tv_title);
            content=(TextView) v.findViewById(R.id.tv_context);
        }
    }

    private List<String> titlelist,summarylist;
    public NormalAdapter(List<String> titlelist,List<String> summarylist) {
        this.titlelist = titlelist;
        this.summarylist=summarylist;
    }

    //③ 在Adapter中实现3个方法
    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.title.setText(titlelist.get(position));
        holder.content.setText("   "+summarylist.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //item 点击事件
            }
        });
    }

    @Override
    public int getItemCount() {
        return summarylist.size();
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        //LayoutInflater.from指定写法
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_page, parent, false);
        return new VH(v);
    }
}