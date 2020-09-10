package com.jacqui.gadsleaderboard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LearningHours {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("hours")
    @Expose
    private Integer hours;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("badgeUrl")
    @Expose
    private String badgeUrl;

//    public LearningHours(String name, int hours, String country, String badgeUrl) {
//        this.name = name;
//        this.hours = hours;
//        this.country = country;
//        this.badgeUrl = badgeUrl;
//    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Integer getHours() {

        return hours;
    }

    public void setHours(Integer hours) {

        this.hours = hours;
    }

    public String getCountry() {

        return country;
    }

    public void setCountry(String country) {

        this.country = country;
    }

    public String getBadgeUrl() {

        return badgeUrl;
    }

    public void setBadgeUrl(String badgeUrl) {

        this.badgeUrl = badgeUrl;
    }
}
