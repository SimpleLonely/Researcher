package com.alljedi.bottomnavigationapplication.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alljedi.bottomnavigationapplication.R;
import com.alljedi.bottomnavigationapplication.Fragment.RecommendCardFragment.OnListFragmentInteractionListener;
import com.alljedi.bottomnavigationapplication.Content.RecommendCardContent.RecommendCardItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link RecommendCardItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyRecommendCardRecyclerViewAdapter extends RecyclerView.Adapter<MyRecommendCardRecyclerViewAdapter.ViewHolder> {

    private final List<RecommendCardItem> mValues;
    private final OnListFragmentInteractionListener mListener;
    private ArrayList<Integer> map=new ArrayList<>();
    private ArrayList<Integer> map2=new ArrayList<>();
    public MyRecommendCardRecyclerViewAdapter(List<RecommendCardItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
        init();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_recommandcard, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        //holder.mOriginImage.setImageBitmap();
        try{
            holder.mOriginText.setText(mValues.get(position).originText);
            holder.mTitle.setText(mValues.get(position).title);
            holder.mAuthor.setText(mValues.get(position).author);
            holder.mPhoto.setImageResource(map.get(position));
            holder.mOriginImage.setImageResource(map2.get(position));
        }catch (Exception e){}
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView mOriginImage;
        public final TextView mOriginText;
        public final TextView mTitle;
        public final TextView mAuthor;
        public final ImageView mPhoto;
        public RecommendCardItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mOriginImage=(ImageView) view.findViewById(R.id.originImage);
            mOriginText = (TextView) view.findViewById(R.id.originText);
            mTitle = (TextView) view.findViewById(R.id.title);
            mAuthor = (TextView) view.findViewById(R.id.author);
            mPhoto = (ImageView) view.findViewById(R.id.photo);
        }

        @Override
        public String toString() {
            return "ViewHolder{" +
                    "mView=" + mView +
                    ", mOriginImage=" + mOriginImage +
                    ", mOriginText=" + mOriginText +
                    ", mTitle=" + mTitle +
                    ", mAuthor=" + mAuthor +
                    ", mPhoto=" + mPhoto +
                    ", mItem=" + mItem +
                    ", itemView=" + itemView +
                    '}';
        }
    }
    public void init(){
        map.add(R.drawable.x4);
        map.add(R.drawable.x5);
        map.add(R.drawable.x6);
        map.add(R.drawable.x1);
        map.add(R.drawable.x2);
        map.add(R.drawable.x7);
        map2.add(R.drawable.p1);
        map2.add(R.drawable.p2);
        map2.add(R.drawable.p3);
        map2.add(R.drawable.p4);
        map2.add(R.drawable.p5);
        map2.add(R.drawable.p6);
    }
}
