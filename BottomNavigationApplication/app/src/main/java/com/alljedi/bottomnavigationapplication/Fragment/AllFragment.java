package com.alljedi.bottomnavigationapplication.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.alljedi.bottomnavigationapplication.Adapter.MyStarRecyclerViewAdapter;
import com.alljedi.bottomnavigationapplication.Adapter.NormalAdapter;
import com.alljedi.bottomnavigationapplication.DetailActivity;
import com.alljedi.bottomnavigationapplication.R;

import org.json.JSONArray;
import org.json.JSONObject;
import com.alljedi.bottomnavigationapplication.Adapter.GridAdapter;
import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AllFragment extends Fragment {
    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    private String srcurl="http://47.103.9.254:3180/periodical/category/get";
    private String posturl="http://47.103.9.254:3180/periodical/addToUser";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private ArrayList<String> txts=new ArrayList<>();
    private ArrayList<Integer> ids=new ArrayList<>();
    private GridView gridView;
    private static final String TAG ="TEST";
    private static final int UPDATE=1;
    private static final int UPDATE_FOLLOW=2;
    private Handler mHandler;
    private GridAdapter adapter;
    private String cate;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public AllFragment() {}

    @SuppressLint("HandlerLeak")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context=getContext();
        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case UPDATE:
                        adapter=new GridAdapter(context,txts);
                        gridView.setAdapter(adapter);
                        adapter.setOnItemClickListener(new GridAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int postion) {
                                unfollow(ids.get(postion)+"");
                            }
                        });
                        break;
                    case UPDATE_FOLLOW:
                        getdata(cate);
                        break;
                    default:
                        break;
                }
            }
        };
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        gridView=view.findViewById(R.id.gridView);
        // Set the adapter
        getdata(cate);
        return view;
    }
    public void unfollow(final String id){
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder().url(posturl+"?username=test&periodicalId="+id).build();
                try {
                    Response response = client.newCall(request).execute();//发送请求
                    sendMessage(UPDATE_FOLLOW);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public void sendMessage(int id){
        if (mHandler != null) {
            Message message = Message.obtain(mHandler, id);
            mHandler.sendMessage(message);
        }
    }
    public void getdata(final String cate){
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder().url(srcurl+"?category="+cate).build();
                try {
                    Response response = client.newCall(request).execute();//发送请求
                    String data = response.body().string();
                    JSONArray res=new JSONArray(data);
                    for(int i=0;i<res.length();i++){
                        JSONObject obj=res.getJSONObject(i);
                        String title=obj.getString("source");
                        Integer id=(Integer) obj.getInt("periodicalId");
                        txts.add(title);
                        ids.add(id);
                    }
                    sendMessage(UPDATE);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
