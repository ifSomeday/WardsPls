package com.kaede.wardspls;
/**
 * Created by Shiro on 3/25/2017.
 */

public class WebApiProcessor {

    public enum requestType {
        GET_MATCH_HISTORY("http://api.steampowered.com/IDOTA2Match_570/GetMatchHistory/v1/?"),
        GET_MATCH_DETAILS("http://api.steampowered.com/IDOTA2Match_570/GetMatchDetails/v1/?"),
        GET_MATCH_HISTORY_BY_SEQUENCE_NUMBER("http://api.steampowered.com/IDOTA2Match_570/GetMatchHistoryBySequenceNum/v1/?"),
        GET_HEROES("http://api.steampowered.com/IEconDOTA2_570/GetHeroes/v1/?"),
        GET_GAME_ITEMS("http://api.steampowered.com/IEconDOTA2_570/GetGameItems/v1/?"),
        GET_LEAGUE_LISTING("http://api.steampowered.com/IDOTA2Match_570/GetLeagueListing/v1/?"),
        GET_LIVE_LEAGUE_GAMES("http://api.steampowered.com/IDOTA2Match_570/GetLiveLeagueGames/v1/?"),
        GET_TEAM_INFO_BY_TEAM_ID("http://api.steampowered.com/IDOTA2Match_570/GetTeamInfoByTeamID/v1/?"),
        GET_PLAYER_SUMMARIES("http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?"),
        GET_SCHEMA("http://api.steampowered.com/IEconItems_570/GetSchema/v0001/?"),
        GET_ITEM_IMAGES("http://cdn.dota2.com/apps/dota2/images/items/"),
        GET_HEROES_IMAGES("http://cdn.dota2.com/apps/dota2/images/heroes/"),
        RESOLVE_VANITY_URL("http://api.steampowered.com/ISteamUser/ResolveVanityURL/v0001/?");

        private final String text;

        private requestType(final String text){
            this.text = text;
        }

        @Override
        public String toString(){
            return(text);
        }
    }

    public enum parameters {
        MATCH_ID("match_id"),
        GAME_MODE("game_mode"),
        PLAYER_NAME("player_name"),
        HERO_ID("hero_id"),
        SKILL("skill"),
        MIN_PLAYERS("min_players"),
        DATE_MIN("date_min"),
        DATE_MAX("date_max"),
        ACCOUNT_ID("account_id"),
        LEAGUE_ID("league_id"),
        START_AT_MATCH_ID("start_at_match_id"),
        MATCHES_REQUESTED("matches_requested"),
        START_AT_MATCH_SEQ_NUM("start_at_match_seq_num"),
        LANGUAGE("language"),
        ITEMIZED_ONLY("itemizedonly"),
        VANITY_URL("vanityurl");

        private final String text;

        private parameters(final String text){
            this.text = text;
        }

        @Override
        public String toString(){
            return(text);
        }
    }


}

