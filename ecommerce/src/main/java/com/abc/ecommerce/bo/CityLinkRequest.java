package com.abc.ecommerce.bo;

public class CityLinkRequest {
    private String origin_country;
    private String origin_state;
    private String origin_postcode;
    private String destination_country;
    private String destination_state;
    private String destination_postcode;
    private int length;
    private int width;
    private int height;
    private int selected_type;
    private int parcel_weight;

    public String getOrigin_country() {
        return origin_country;
    }

    public void setOrigin_country(String origin_country) {
        this.origin_country = origin_country;
    }

    public String getOrigin_state() {
        return origin_state;
    }

    public void setOrigin_state(String origin_state) {
        this.origin_state = origin_state;
    }

    public String getOrigin_postcode() {
        return origin_postcode;
    }

    public void setOrigin_postcode(String origin_postcode) {
        this.origin_postcode = origin_postcode;
    }

    public String getDestination_country() {
        return destination_country;
    }

    public void setDestination_country(String destination_country) {
        this.destination_country = destination_country;
    }

    public String getDestination_state() {
        return destination_state;
    }

    public void setDestination_state(String destination_state) {
        this.destination_state = destination_state;
    }

    public String getDestination_postcode() {
        return destination_postcode;
    }

    public void setDestination_postcode(String destination_postcode) {
        this.destination_postcode = destination_postcode;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSelected_type() {
        return selected_type;
    }

    public void setSelected_type(int selected_type) {
        this.selected_type = selected_type;
    }

    public int getParcel_weight() {
        return parcel_weight;
    }

    public void setParcel_weight(int parcel_weight) {
        this.parcel_weight = parcel_weight;
    }
}
