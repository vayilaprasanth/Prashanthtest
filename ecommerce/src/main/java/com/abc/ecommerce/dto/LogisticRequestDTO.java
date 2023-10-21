package com.abc.ecommerce.dto;

public class LogisticRequestDTO {
    private String originCountry;
    private String originState;
    private String originPostcode;
    private String destinationCountry;
    private String destinationState;
    private String destinationPostcode;
    private int length;
    private int width;
    private int height;
    private int selectedType;
    private int parcelWeight;

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public String getOriginState() {
        return originState;
    }

    public void setOriginState(String originState) {
        this.originState = originState;
    }

    public String getOriginPostcode() {
        return originPostcode;
    }

    public void setOriginPostcode(String originPostcode) {
        this.originPostcode = originPostcode;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public String getDestinationState() {
        return destinationState;
    }

    public void setDestinationState(String destinationState) {
        this.destinationState = destinationState;
    }

    public String getDestinationPostcode() {
        return destinationPostcode;
    }

    public void setDestinationPostcode(String destinationPostcode) {
        this.destinationPostcode = destinationPostcode;
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

    public int getSelectedType() {
        return selectedType;
    }

    public void setSelectedType(int selectedType) {
        this.selectedType = selectedType;
    }

    public int getParcelWeight() {
        return parcelWeight;
    }

    public void setParcelWeight(int parcelWeight) {
        this.parcelWeight = parcelWeight;
    }
}
