package com.alljedi.bottomnavigationapplication.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alljedi.bottomnavigationapplication.R;

import java.util.HashMap;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * TODO: Replace the implementation with code for your data type.
 */
public class JournalAdapter extends RecyclerView.Adapter<JournalAdapter.VH>{
    //② 创建ViewHolder
    private HashMap<String,Integer> map=new HashMap<>();
    public static class VH extends RecyclerView.ViewHolder{
        public final TextView title;
        public ImageView imageView;
        public VH(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.title);
            imageView=(ImageView)v.findViewById(R.id.image);
        }
    }

    private List<String> titlelist;
    public JournalAdapter(List<String> titlelist) {
        init();
        this.titlelist = titlelist;
    }

    //③ 在Adapter中实现3个方法
    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.title.setText(titlelist.get(position));
        try{
            int x=map.get(titlelist.get(position));
            holder.imageView.setImageResource(x);
        }catch (Exception e){

        }
        //holder.imageView.setImageResource(map.get(titlelist.get(position)));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //item 点击事件
            }
        });
    }

    @Override
    public int getItemCount() {
        return titlelist.size();
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        //LayoutInflater.from指定写法
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_journal, parent, false);
        return new VH(v);
    }
    public void init(){
        map.clear();
        map.put("信息",R.drawable.q1);
        map.put("医学",R.drawable.q2);
        map.put("地理",R.drawable.q3);
        map.put("建筑学",R.drawable.q4);
        map.put("心理",R.drawable.q5);
        map.put("新媒体",R.drawable.q6);
        map.put("管理学",R.drawable.q7);
        map.put("机械",R.drawable.q8);
        map.put("自然科学",R.drawable.q9);
        map.put("计算机",R.drawable.q10);
    }
}