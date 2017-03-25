package com.kaede.wardspls;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class RecentMatchFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private Context context;

    public RecentMatchFragment() {

    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.context = getActivity();

        //Attach a handle to our recyclerView
        this.mRecyclerView = (RecyclerView)getView().findViewById(R.id.rmatchview);

        //Supply our recyclerView a linearLayour Manager
        this.mLayoutManager = new LinearLayoutManager(this.context);
        this.mRecyclerView.setLayoutManager(this.mLayoutManager);

        //Supply our recyclerView an adapter
        this.mAdapter = new RecentMatchAdapter();
        this.mRecyclerView.setAdapter(this.mAdapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
}