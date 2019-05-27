package com.alljedi.bottomnavigationapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alljedi.bottomnavigationapplication.Adapter.MyStarRecyclerViewAdapter;
import com.alljedi.bottomnavigationapplication.Content.StarItemContent;

import org.json.JSONArray;
import org.json.JSONObject;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DetailActivity extends AppCompatActivity {

    final static String starUrl = "http://47.103.9.254:3180/paperList/addPaperToList";

    final static String unStarUrl = "http://47.103.9.254:3180/paperList/deletePaperFromList";
    int id;
    int flag = 0;
    private static final int ChangeToStar = 1;
    private static final int ChangeToUnStar = 2;
    Handler mHandler;

    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Bundle bundle=getIntent().getExtras();
        id=bundle.getInt("id");
        String title = bundle.getString("title");
        String author = bundle.getString("author");
        String summary = bundle.getString("summary");


        TextView titleText=(TextView) findViewById(R.id.title);
        titleText.setText(title);
        TextView authorText=(TextView) findViewById(R.id.author);
        authorText.setText(author);
        TextView summaryText=(TextView) findViewById(R.id.summary);
        summaryText.setText(summary);

        //跳转浏览器
        Button fullText = (Button) findViewById(R.id.full_text);
        fullText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.i("ButtonClick", "点击事件");
                Uri uri = Uri.parse("https://kns.cnki.net/kns/download.aspx?filename=EZTZ2KWRlaMN3MSZXcDlmVt10SFxkanNjWvplc1dXNLtkNQllSvd3cldnZmN0aRFUUhFDVCpGN3l2QnNnTGpGc=0TPnVWdr9EchVTWndzb4RWYzF2azgkd6x0TlxGW1RTdPJXcHdmN2d1TqB1RCdVSMB3ZRF3Uu90MBxUTn9yM1J&tablename=CPFDPREP&dflag=pdfdown\n");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        //Star
        final Button star = (Button) findViewById(R.id.star);
        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("StarText",star.getText().toString());
                if (star.getText().toString().equals("Star")){
                    flag=0;
                    addStar();
                }else{
                    flag = 0;
                    unStar();
                }
            }
        });

        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case ChangeToStar:
                        star.setText("Star");
                        break;
                    case ChangeToUnStar:
                        star.setText("UnStar");
                    default:
                        break;
                }
            }
        };
    }

    /**
     *                     RequestBody requestBody = new FormBody.Builder().add("recordnum",String.valueOf(record.getRecordnum())).add("recordID", String.valueOf(record.getRecordID())).add("deltime",ddate).add("userID",String.valueOf(record.getUserID())).add("username",userName).add("title",tabletitle.getText().toString()).add("context",tablecontent.getText().toString()).add("devicenum",String.valueOf(record.getDevicenum())).build();
     *                     Request request = new Request.Builder().url(addsolutionpath).post(requestBody).build();
     *                     try{
     *                         Response response=client.newCall(request).execute();
     */
    public void unStar(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Log.e("Detail", "unstar");

                Request request = new Request.Builder().url(unStarUrl+"?paperId="+id+"&username=test").build();
                try {
                    Response response = client.newCall(request).execute();//发送请求
                    String data = response.body().string();
                    if (data == null){
                        Log.e("Detail", "Nodata");
                    }
                    else{
                        Log.e("Detail", data.toString());
                    }
                    flag=1;
                    sendMessage(ChangeToStar);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public void addStar(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Log.e("Detail", "star");
                Request request = new Request.Builder().url(starUrl+"?paperId="+id+"&username=test").build();
                try {
                    Response response = client.newCall(request).execute();//发送请求
                    String data = response.body().string();
                    if (data == null){
                        Log.e("Detail", "Nodata");
                    }
                    else{
                        Log.e("Detail", data.toString());
                    }
                    flag=1;
                    sendMessage(ChangeToUnStar);
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
}
