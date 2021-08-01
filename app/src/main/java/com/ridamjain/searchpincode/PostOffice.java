package com.ridamjain.searchpincode;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostOffice {
    @SerializedName("Name")
    @Expose
    private String Name;
    @SerializedName("District")
    @Expose
    private String District;

    @SerializedName("State")
    @Expose
    private String State;
    @SerializedName("Country")
    @Expose
    private String Country;
    @SerializedName("Pincode")
    @Expose
    private int Pincode;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public int getPincode() {
        return Pincode;
    }

    public void setPincode(int pincode) {
        Pincode = pincode;
    }
}
