package com.hafsalrahman.ssstest.data.remote.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by hafsal on 10/24/17.
 */

public class User {

    @SerializedName("id")
    @Expose
    String id;
    @SerializedName("price_value")
    @Expose
    String price;
    @SerializedName("price_label")
    @Expose
    String price_label;
    @SerializedName("featured")
    @Expose
    String featured;
    @SerializedName("title")
    @Expose
    String title;
    @SerializedName("subject")
    @Expose
    String subject;
    @SerializedName("type")
    @Expose
    String type;
    @SerializedName("thumbnail")
    @Expose
    String imageurl;
    @SerializedName("thumbnail_big")
    @Expose
    String imageurl_big;
    @SerializedName("location")
    @Expose
    String location;
    @SerializedName("bathroom")
    @Expose
    String bathroom;
    @SerializedName("bedroom")
    @Expose
    String bedroom;
    @SerializedName("currency")
    @Expose
    String currency;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice_label() {
        return price_label;
    }

    public void setPrice_label(String price_label) {
        this.price_label = price_label;
    }

    public String getFeatured() {
        return featured;
    }

    public void setFeatured(String featured) {
        this.featured = featured;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBathroom() {
        return bathroom;
    }

    public void setBathroom(String bathroom) {
        this.bathroom = bathroom;
    }

    public String getBedroom() {
        return bedroom;
    }

    public void setBedroom(String bedroom) {
        this.bedroom = bedroom;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImageurl_big() {
        return imageurl_big;
    }

    public void setImageurl_big(String imageurl_big) {
        this.imageurl_big = imageurl_big;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
