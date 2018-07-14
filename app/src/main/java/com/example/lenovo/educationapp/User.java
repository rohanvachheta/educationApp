
package com.example.lenovo.educationapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("alarm")
    @Expose
    private String alarm;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("photo")
    @Expose
    private String photo;
    @SerializedName("autoPlay")
    @Expose
    private String autoPlay;
    @SerializedName("loop")
    @Expose
    private String loop;
    @SerializedName("Location")
    @Expose
    private String location;
    @SerializedName("random")
    @Expose
    private String random;

    public String getAlarm() {
        return alarm;
    }

    public void setAlarm(String alarm) {
        this.alarm = alarm;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getAutoPlay() {
        return autoPlay;
    }

    public void setAutoPlay(String autoPlay) {
        this.autoPlay = autoPlay;
    }

    public String getLoop() {
        return loop;
    }

    public void setLoop(String loop) {
        this.loop = loop;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRandom() {
        return random;
    }

    public void setRandom(String random) {
        this.random = random;
    }

}
