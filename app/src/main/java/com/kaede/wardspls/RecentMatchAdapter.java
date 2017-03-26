package com.kaede.wardspls;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Shiro on 3/25/2017.
 */

public class RecentMatchAdapter extends RecyclerView.Adapter<RecentMatchAdapter.ViewHolder>{

    //private String[] testData = {"One", "Two", "Three", "4", "Five"};
    public ArrayList<MatchDetailStruct> recentMatchData = new ArrayList<MatchDetailStruct>();

    /**
     * VeiwHolder holds all the UI handles for our list entries
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView matchTimeView;
        public TextView matchIdView;
        public TextView lobbyTypeView;
        public LinearLayout mCardView;

        /**
         * Constructor
         * @param cv Encapsulating layout
         * @param matchTimeView textview holding the match time
         * @param matchIdView textview holding the match id
         * @param lobbyTypeView textview holding the lobby type
         */
        public ViewHolder(LinearLayout cv, TextView matchTimeView, TextView matchIdView, TextView lobbyTypeView){
            super(cv);
            mCardView = cv;
            this.matchTimeView = matchTimeView;
            this.matchIdView = matchIdView;
            this.lobbyTypeView = lobbyTypeView;
        }
    }

    //constructor
    public RecentMatchAdapter(){
        this.recentMatchData.add(new MatchDetailStruct());
    }

    /**
     * issues an update, causing the recycleview to reload and fill with the new data
     * @param matches the new set of matches
     */
    public void updateMatches(ArrayList<MatchDetailStruct> matches, boolean append){
        if(append){
            this.recentMatchData.addAll(matches);
        } else {
            this.recentMatchData.clear();
            this.recentMatchData.addAll(matches);
        }
        notifyDataSetChanged();
    }

    /**
     * Creates a viewholder for an entry in the recycleview
     * @param parent parent fragment that is holding my recycleview
     * @param viewType idk
     * @return the created viewholder
     */
    @Override
    public RecentMatchAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LinearLayout cv = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.match_detail_card, parent, false);
        TextView mtv = (TextView)cv.findViewById(R.id.match_detail_time);
        TextView miv = (TextView)cv.findViewById(R.id.match_detail_id);
        TextView ltv = (TextView)cv.findViewById(R.id.match_detail_lobby);
        ViewHolder vh = new ViewHolder(cv, mtv, miv, ltv);
        return vh;
    }

    /**
     * When the viewholder is bound, fill it with the required data
     * @param holder the viewholder we will be filling
     * @param position the position of the viewholder. Used to determine what data to fill in
     */
    @Override
    public void onBindViewHolder(RecentMatchAdapter.ViewHolder holder, int position) {
        //get element from your dataset at position
        //replace contenst with data from that position
        holder.matchTimeView.setText(String.valueOf(recentMatchData.get(position).start_time));
        holder.matchIdView.setText(String.valueOf(recentMatchData.get(position).match_id));
        holder.lobbyTypeView.setText(String.valueOf(recentMatchData.get(position).lobby_type));

    }

    /**
     * gets the total number of items to display
     * @return total number of data items
     */
    @Override
    public int getItemCount() {
        return recentMatchData.size();
    }

}
