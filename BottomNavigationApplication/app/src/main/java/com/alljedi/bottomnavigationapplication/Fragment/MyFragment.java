package com.alljedi.bottomnavigationapplication.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.alljedi.bottomnavigationapplication.R;

import java.util.ArrayList;

public class MyFragment extends Fragment {
    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    public ArrayList<String> urls=new ArrayList<String>();
    public  ArrayList<String> txts=new ArrayList<String>();
    private GridView gridView;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MyFragment() {
        urls.add("http://47.100.107.158:8080/static/marker_radar_g.png");
        urls.add("http://47.100.107.158:8080/static/marker_radar_r.png");
        txts.add("marker_radar_g.png");
        txts.add("marker_radar_r.png");
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static MyFragment newInstance(int columnCount) {
        MyFragment fragment = new MyFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        gridView=view.findViewById(R.id.gridView);
        gridView.setAdapter(new GridAdapter(this.getContext()));
        // Set the adapter

        return view;
    }

    public class GridAdapter extends BaseAdapter {

        private Context mContext;


        public GridAdapter(Context context) {
            this.mContext = context;
        }


        @Override
        public int getCount() {
            return 2;
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
            /*DisplayImageOptions displayImageOptions = new DisplayImageOptions.Builder()
                    .cacheInMemory(true)   //内存缓存
                    .cacheOnDisk(true)    //硬盘缓存
                     .build();
            ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this.mContext)
                    .defaultDisplayImageOptions(displayImageOptions)
                    .build();
            ImageLoader.getInstance().init(config);*/

            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_grid, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.itemImg = (ImageView) convertView.findViewById(R.id.iv_head);
                viewHolder.itemtxt = (TextView) convertView.findViewById(R.id.iv_tail);
                //x.image().bind(viewHolder.itemImg,urls.get(position));
                viewHolder.itemtxt.setText(txts.get(position));
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            //ImageLoader.getInstance().displayImage("http://47.100.107.158/static/marker_radar_g.png",  viewHolder.itemImg);
            convertView.setTag(viewHolder);
            return convertView;
        }


        class ViewHolder {
            ImageView itemImg;
            TextView itemtxt;
        }
    }
}
