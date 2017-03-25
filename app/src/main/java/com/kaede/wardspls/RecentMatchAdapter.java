package com.kaede.wardspls;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Shiro on 3/25/2017.
 */

public class RecentMatchAdapter extends RecyclerView.Adapter<RecentMatchAdapter.ViewHolder>{

    private String[] testData = {"One", "Two", "Three", "4", "Five"};

    //reference to all views for data item
    //m,ay need more that one
    //just provide all access points in here
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;
        public LinearLayout mCardView;

        public ViewHolder(TextView tv, LinearLayout cv){
            super(cv);
            mTextView = tv;
            mCardView = cv;
        }
    }

    //constructor
    public RecentMatchAdapter(){

    }

    //create new views
    @Override
    public RecentMatchAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //CardView cv = (CardView)parent.

        LinearLayout cv = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.match_detail_card, parent, false);
        TextView v = (TextView)cv.findViewById(R.id.info_text);
        ViewHolder vh = new ViewHolder(v, cv);
        return vh;
    }

    //replace the contents of a view
    @Override
    public void onBindViewHolder(RecentMatchAdapter.ViewHolder holder, int position) {
        //get element from your dataset at position
        //replace contenst with data from that position
        holder.mTextView.setText(testData[position]);

    }

    //return size of dataset
    @Override
    public int getItemCount() {
        return testData.length;
    }
}
