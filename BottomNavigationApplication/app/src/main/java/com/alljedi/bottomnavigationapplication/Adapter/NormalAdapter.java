package com.alljedi.bottomnavigationapplication.Adapter;

import android.graphics.Typeface;
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
        public final TextView author;
        public final TextView source;
        public VH(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.tv_title);
            content=(TextView) v.findViewById(R.id.tv_context);
            author=(TextView) v.findViewById(R.id.author);
            source=(TextView) v.findViewById(R.id.source);
        }
    }

    private List<String> titlelist,summarylist,pubtimelist,authorlist,sourcelist;
    public NormalAdapter(List<String> titlelist,List<String> summarylist,List<String> pubtimelist,List<String> authorlist,List<String> sourcelist) {
        this.titlelist = titlelist;
        this.summarylist=summarylist;
        this.authorlist=authorlist;
        this.pubtimelist=pubtimelist;
        this.sourcelist=sourcelist;
    }

    //③ 在Adapter中实现3个方法
    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.title.setText(titlelist.get(position));
        holder.author.setText(authorlist.get(position));
        holder.source.setText(sourcelist.get(position));
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