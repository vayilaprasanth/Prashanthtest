package com.abc.ecommerce.dto;

public class CityLinkReq {

    private CityLinkData data;
    private int status;

    public CityLinkData getData() {
        return data;
    }

    public void setData(CityLinkData data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
