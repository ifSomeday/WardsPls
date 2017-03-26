package com.kaede.wardspls;

/**
 * Created by Shiro on 3/25/2017.
 */

public class Player {

    public String account_id;
    public int player_slot;
    public int hero_id;

    public Player(String account_id, int player_slot, int hero_id){
        this.account_id = account_id;
        this.player_slot = player_slot;
        this.hero_id = hero_id;
    }

}
