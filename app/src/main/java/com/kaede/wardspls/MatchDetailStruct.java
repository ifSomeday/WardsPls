package com.kaede.wardspls;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Shiro on 3/25/2017.
 */

public class MatchDetailStruct {

    //raw JSON data just in case I want it again
    private JSONObject rawData;

    //fields I care about
    public long match_id;
    public long start_time;
    public int lobby_type;
    public Player Players[] = new Player[10];

    public MatchDetailStruct(){
        this.match_id = -1;
        this.start_time = -1;
        this.lobby_type = -1;
    }

    public MatchDetailStruct(String json) {

        try {
            this.parseJson(new JSONObject(json));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public MatchDetailStruct(JSONObject json) throws JSONException {

        this.parseJson(json);
    }

    private void parseJson(JSONObject json){
        try {
            Log.d("JSON","JSON" + json.toString());
            //this.rawData = new JSONObject(json);
            this.rawData = json;
            this.match_id = this.rawData.optLong("match_id", -1);
            this.start_time = this.rawData.optLong("start_time", -1);
            this.lobby_type = this.rawData.optInt("lobby_type",-1);
            for(int i = 0; i < 10; i++){
                JSONObject playerData = (JSONObject) this.rawData.getJSONArray("players").get(i);
                Players[i] = new  Player(playerData.optString("account_id",""), playerData.optInt("player_slot", -1), playerData.optInt("hero_id",-1));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void updateMatch(String json) {
        try {
            this.parseJson(new JSONObject(json));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
