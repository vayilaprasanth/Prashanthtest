package com.abc.ecommerce.dto;

public class CityLinkResponse {

    private CityLinkReq req;

    private String error;

    public CityLinkReq getReq() {
        return req;
    }

    public void setReq(CityLinkReq req) {
        this.req = req;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
