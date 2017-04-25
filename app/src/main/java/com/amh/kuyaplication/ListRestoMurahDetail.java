package com.amh.kuyaplication;

/**
 * Created by aminhasian on 05/03/2017.
 */

public class ListRestoMurahDetail {
    private String name_resto_detail, thumbnailUrl_detail, id_resto;
    private int cost_for_two_detail;
    private String street_resto_detail;
    private String state_resto_detail;
    private String city_resto_detail;
    private String postal_code_resto_detail;
    private String avg_rating_resto_detail;
    private String desk_detail;

    public ListRestoMurahDetail(){

        this.id_resto = id_resto;
        this.name_resto_detail = name_resto_detail;
        this.thumbnailUrl_detail = thumbnailUrl_detail;
        this.cost_for_two_detail = cost_for_two_detail;
        this.street_resto_detail = street_resto_detail;
        this.state_resto_detail = state_resto_detail;
        this.city_resto_detail = city_resto_detail;
        this.postal_code_resto_detail = postal_code_resto_detail;
        this.desk_detail = desk_detail;
        this.avg_rating_resto_detail = avg_rating_resto_detail;

    }

    public  String getId_resto() {return id_resto; }

    public void setId_resto(String id_resto) {this.id_resto = id_resto; }

    public String getName_resto_detail() {
        return name_resto_detail;
    }

    public void setName_resto_detail(String name_resto_detail) {
        this.name_resto_detail = name_resto_detail;
    }

    public String getThumbnailUrl_detail() {
        return thumbnailUrl_detail;
    }

    public void setThumbnailUrl_detail(String thumbnailUrl_detail) {
        this.thumbnailUrl_detail = thumbnailUrl_detail;
    }

    public int getCost_for_two_detail() {
        return cost_for_two_detail;
    }

    public void setCost_for_two_detail(int cost_for_two_detail) {
        this.cost_for_two_detail = cost_for_two_detail;
    }
    public String getStreet_resto_detail() {
        return street_resto_detail;
    }

    public void setStreet_resto_detail(String street_resto_detail) {
        this.street_resto_detail = street_resto_detail;
    }

    public String getState_resto_detail() {
        return state_resto_detail;
    }

    public void setState_resto_detail(String state_resto_detail) {
        this.state_resto_detail = state_resto_detail;
    }
    public String getCity_resto_detail() {
        return city_resto_detail;
    }

    public void setCity_resto_detail(String city_resto_detail) {
        this.city_resto_detail = city_resto_detail;
    }
    public String getPostal_code_resto_detail() {
        return postal_code_resto_detail;
    }

    public void setPostal_code_resto_detail(String postal_code_resto_detail) {
        this.postal_code_resto_detail = postal_code_resto_detail;
    }
    public String getDesk_detail() {
        return desk_detail;
    }

    public void setDesk_detail(String desk_detail) {
        this.desk_detail = desk_detail;
    }

   public String getAvg_rating_resto_detail() {return avg_rating_resto_detail; }

    public void setAvg_rating_resto_detail(String avg_rating_resto_detail) {
        this.avg_rating_resto_detail = avg_rating_resto_detail;
    }
    /*public int getAvg_rating_resto_detail() {
        return avg_rating_resto_detail;
    }

    public void setAvg_rating_resto_detail(int avg_rating_resto_detail) {
        this.avg_rating_resto_detail = avg_rating_resto_detail;
    }*/

}
