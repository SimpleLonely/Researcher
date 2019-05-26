package com.alljedi.bottomnavigationapplication.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.alljedi.bottomnavigationapplication.MainActivity;
import com.alljedi.bottomnavigationapplication.R;
import com.alljedi.bottomnavigationapplication.View.CustomViewPager;

import java.util.ArrayList;

public class FollowFragment extends Fragment implements ViewPager.OnPageChangeListener{
    private CustomViewPager viewPager;
    private TabLayout tabLayout;
    private MyFragment myFragment=new MyFragment();
    private AllFragment allFragment=new AllFragment();
    public FollowFragment(){
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_follow, container, false);
        viewPager = (CustomViewPager)view.findViewById(R.id.pager);
        viewPager.setScanScroll(true);
        viewPager.addOnPageChangeListener(this);
        tabLayout = (TabLayout) view.findViewById(R.id.tab);
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()){
            @Override
            public Fragment getItem(int position) {
                if(position==0) return myFragment;
                else return allFragment;
            }

            @Override
            public int getCount() {
                return 2;
            }
        });
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("我收藏的");
        tabLayout.getTabAt(1).setText("所有的");
        return view;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}


