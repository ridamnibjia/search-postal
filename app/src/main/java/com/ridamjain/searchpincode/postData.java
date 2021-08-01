package com.ridamjain.searchpincode;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class postData {
    @SerializedName("Message")
    @Expose
    private String Message;
    @SerializedName("Status")
    @Expose
    private String Status;
    @SerializedName("PostOffice")
    @Expose
    private ArrayList<PostOffice> postOffices;

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public ArrayList<PostOffice> getPostOffices() {
        return postOffices;
    }

    public void setPostOffices(ArrayList<PostOffice> postOffices) {
        this.postOffices = postOffices;
    }

}
