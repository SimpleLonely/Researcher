package com.alljedi.bottomnavigationapplication.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alljedi.bottomnavigationapplication.R;
import com.beardedhen.androidbootstrap.BootstrapButton;

import java.util.ArrayList;
import java.util.HashMap;

public class GridAdapter extends BaseAdapter {

    private Context mContext;
    private HashMap<String,Integer> map=new HashMap<>();
    private ArrayList<String> txts=new ArrayList<>();
    private OnItemClickListener mClickListener;

    public interface OnItemClickListener{
        public void onItemClick(View view, int postion);
    }
    public void setOnItemClickListener(GridAdapter.OnItemClickListener listener) {
        this. mClickListener= listener;
    }
    public GridAdapter(Context context,ArrayList<String> list) {
        this.mContext = context;
        init();
        txts.clear();
        txts.addAll(list);
    }

    @Override
    public int getCount() {
        return txts.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_grid, parent, false);
            viewHolder = new ViewHolder(convertView,mClickListener);
            viewHolder.itemImg = (ImageView) convertView.findViewById(R.id.iv_head);
            viewHolder.itemtxt = (TextView) convertView.findViewById(R.id.iv_tail);
            viewHolder.btn=(BootstrapButton)convertView.findViewById(R.id.follow);
            //x.image().bind(viewHolder.itemImg,urls.get(position));
            viewHolder.itemtxt.setText(txts.get(position));
            viewHolder.itemImg.setImageResource(map.get(txts.get(position)));
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        convertView.setTag(viewHolder);
        return convertView;
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView itemImg;
        TextView itemtxt;
        BootstrapButton btn;
        public GridAdapter.OnItemClickListener mListener;// 声明自定义的接口

        public ViewHolder(View v, GridAdapter.OnItemClickListener listener) {
            super(v);
            mListener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.onItemClick(v, getPosition());
        }
    }


    public void init(){
        map.clear();
        map.put("世界有色金属",R.drawable.p1);
        map.put("中国医学装备",R.drawable.p2);
        map.put("中国心理卫生杂志",R.drawable.p3);
        map.put("中国机械工程",R.drawable.p4);
        map.put("中国现代应用药学",R.drawable.p5);
        map.put("信息技术",R.drawable.p6);
        map.put("南水北调与水利科技",R.drawable.p7);
        map.put("四川师范大学电子出版社",R.drawable.p8);
        map.put("山东工业技术",R.drawable.p9);
        map.put("指挥信息系统与技术",R.drawable.p10);
        map.put("新媒体研究",R.drawable.p11);
        map.put("海南大学学报",R.drawable.p12);
        map.put("激光与光电子学进展",R.drawable.p13);
        map.put("现代工业经济和信息化",R.drawable.p14);
        map.put("电子技术与软件工程",R.drawable.p15);
        map.put("经营与管理",R.drawable.p16);
        map.put("绿色环保建材",R.drawable.p17);
        map.put("计算机产品与流通",R.drawable.p18);
        map.put("计算机工程",R.drawable.p19);
        map.put("计算机应用",R.drawable.p20);
        map.put("软件学报",R.drawable.p21);
        map.put("arXiv",R.drawable.p22);
    }
}