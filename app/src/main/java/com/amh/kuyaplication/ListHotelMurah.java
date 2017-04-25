package com.amh.kuyaplication;

/**
 * Created by aminhasian on 20/04/2017.
 */

public class ListHotelMurah {
    private String name_hotel, thumbnailUrl, id_hotel;
    private int start_from;
    private String state_hotel, city_hotel;


    public ListHotelMurah()
    {
        this.id_hotel = id_hotel;
        this.name_hotel = name_hotel;
        this.thumbnailUrl = thumbnailUrl;
        this.start_from = start_from;
        this.state_hotel = state_hotel;
        this.city_hotel = city_hotel;
    }

    public  String getId_hotel() {return id_hotel; }

    public void setId_hotel(String id_hotel) {this.id_hotel = id_hotel; }

    public String getName_hotel() {
        return name_hotel;
    }

    public void setName_hotel(String name_hotel) {
        this.name_hotel = name_hotel;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public int getStart_from() {
        return start_from;
    }

    public void setStart_from(int start_from) {
        this.start_from = start_from;
    }

    public String getState_hotel() {
        return state_hotel;
    }

    public void setState_hotel(String state_hotel) {
        this.state_hotel = state_hotel;
    }

    public String getCity_hotel() {
        return city_hotel;
    }

    public void setCity_hotel(String city_hotel) {
        this.city_hotel = city_hotel;
    }
}
