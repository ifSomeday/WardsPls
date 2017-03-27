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
import com.loopj.android.http.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * A placeholder fragment containing a simple view.
 */
public class RecentMatchFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecentMatchAdapter mAdapter;
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



        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put(WebApiProcessor.parameters.ACCOUNT_ID.toString(),"76561198123095133");
        params.put("key",Keys.STEAM_KEY);
        client.get(WebApiProcessor.requestType.GET_MATCH_HISTORY.toString(), params, new JsonHttpResponseHandler(){
           @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response){
               ArrayList<MatchDetailStruct> data = new ArrayList<MatchDetailStruct>();
               JSONArray arr =  response.optJSONObject("result").optJSONArray("matches");
               for(int i = 0; i < arr.length(); i++){
                   try {
                       Log.d("matchDetails",arr.optJSONObject(i).toString());
                       data.add(new MatchDetailStruct(arr.optJSONObject(i)));
                   } catch (JSONException e) {
                       e.printStackTrace();
                   }
               }
               mAdapter.updateMatches(data, false);
           }

           @Override
            public void onFailure(int statusCode, Header[] headers, String res, Throwable t){
                Log.e("WardsPls", "Status Code: " + statusCode);
           }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
}