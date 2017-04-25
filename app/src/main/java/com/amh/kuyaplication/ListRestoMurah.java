package com.amh.kuyaplication;

import java.util.ArrayList;

/**
 * Created by aminhasian on 28/02/2017.
 */

public class ListRestoMurah {
    private String name_resto, thumbnailUrl, id_resto;
    private int cost_for_two;
    private String state_resto, city_resto;


    public ListRestoMurah()
    {
        this.id_resto = id_resto;
        this.name_resto = name_resto;
        this.thumbnailUrl = thumbnailUrl;
        this.cost_for_two = cost_for_two;
        this.state_resto = state_resto;
        this.city_resto = city_resto;
    }

    public  String getId_resto() {return id_resto; }

    public void setId_resto(String id_resto) {this.id_resto = id_resto; }

    public String getName_resto() {
        return name_resto;
    }

    public void setName_resto(String name_resto) {
        this.name_resto = name_resto;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public int getCost_for_two() {
        return cost_for_two;
    }

    public void setCost_for_two(int cost_for_two) {
        this.cost_for_two = cost_for_two;
    }

    public String getState_resto() {
        return state_resto;
    }

    public void setState_resto(String state_resto) {
        this.state_resto = state_resto;
    }

    public String getCity_resto() {
        return city_resto;
    }

    public void setCity_resto(String city_resto) {
        this.city_resto = city_resto;
    }

}
