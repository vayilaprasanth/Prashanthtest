package com.abc.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CityLinkData {

    @JsonProperty("rate")
    private double rate;

    @JsonProperty("code")
    private String code;

    @JsonProperty("api_days")
    private int apiDays;

    @JsonProperty("final_days")
    private int finaDays;

    @JsonProperty("dayString")
    private String dayString;

    @JsonProperty("weekendDays")
    private int weekendDays;

    @JsonProperty("message")
    private String message;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getApiDays() {
        return apiDays;
    }

    public void setApiDays(int apiDays) {
        this.apiDays = apiDays;
    }

    public int getFinaDays() {
        return finaDays;
    }

    public void setFinaDays(int finaDays) {
        this.finaDays = finaDays;
    }

    public String getDayString() {
        return dayString;
    }

    public void setDayString(String dayString) {
        this.dayString = dayString;
    }

    public int getWeekendDays() {
        return weekendDays;
    }

    public void setWeekendDays(int weekendDays) {
        this.weekendDays = weekendDays;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
