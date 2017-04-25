package com.amh.kuyaplication;

/**
 * Created by aminhasian on 20/04/2017.
 */

public class ListHotelMurahDetail {
    private String name_hotel_detail, thumbnailUrl_detail, id_hotel;
    private int start_from_detail;
    private String street_hotel_detail, state_hotel_detail, city_hotel_detail, postal_code_hotel_detail;
    private String desk_detail;

    public ListHotelMurahDetail(){

        this.id_hotel = id_hotel;
        this.name_hotel_detail = name_hotel_detail;
        this.thumbnailUrl_detail = thumbnailUrl_detail;
        this.start_from_detail = start_from_detail;
        this.street_hotel_detail = street_hotel_detail;
        this.state_hotel_detail = state_hotel_detail;
        this.city_hotel_detail = city_hotel_detail;
        this.postal_code_hotel_detail = postal_code_hotel_detail;
        this.desk_detail = desk_detail;

    }

    public  String getId_hotel() {return id_hotel; }

    public void setId_hotel(String id_hotel) {this.id_hotel = id_hotel; }

    public String getName_hotel_detail() {
        return name_hotel_detail;
    }

    public void setName_hotel_detail(String name_hotel_detail) {
        this.name_hotel_detail = name_hotel_detail;
    }

    public String getThumbnailUrl_detail() {
        return thumbnailUrl_detail;
    }

    public void setThumbnailUrl_detail(String thumbnailUrl_detail) {
        this.thumbnailUrl_detail = thumbnailUrl_detail;
    }

    public int getStart_from_detail() {
        return start_from_detail;
    }

    public void setStart_from_detail(int start_from_detail) {
        this.start_from_detail = start_from_detail;
    }
    public String getStreet_hotel_detail() {
        return street_hotel_detail;
    }

    public void setStreet_hotel_detail(String street_hotel_detail) {
        this.street_hotel_detail = street_hotel_detail;
    }

    public String getState_hotel_detail() {
        return state_hotel_detail;
    }

    public void setState_hotel_detail(String state_hotel_detail) {
        this.state_hotel_detail = state_hotel_detail;
    }
    public String getCity_hotel_detail() {
        return city_hotel_detail;
    }

    public void setCity_hotel_detail(String city_hotel_detail) {
        this.city_hotel_detail = city_hotel_detail;
    }
    public String getPostal_code_hotel_detail() {
        return postal_code_hotel_detail;
    }

    public void setPostal_code_hotel_detail(String postal_code_hotel_detail) {
        this.postal_code_hotel_detail = postal_code_hotel_detail;
    }
    public String getDesk_detail() {
        return desk_detail;
    }

    public void setDesk_detail(String desk_detail) {
        this.desk_detail = desk_detail;
    }
}
